package fr.humanbooster.fx.katchaka.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import fr.humanbooster.fx.katchaka.business.*;
import fr.humanbooster.fx.katchaka.service.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


// On indique à Spring que cette classe fait partie de la couche contrôleur
@Controller
public class KatchakaController {

    // Le contrôleur a besoin de services
    // autrement dit il délègue des traitements à un ou plusieurs services
    private final VilleService villeService;

    private final StatutService statutService;

    private final InteretService interetService;

    private final GenreService genreService;

    private final PersonneService personneService;

    private final HttpSession httpSession;
    private InvitationService invitationService;

    // Ce constructeur va provoquer l'injection de dépendances
    public KatchakaController(VilleService villeService, StatutService statutService,
                              InteretService interetService, GenreService genreService,
                              PersonneService personneService,HttpSession httpSession,
                              InvitationService invitationService) {
        super();
        this.villeService = villeService;
        this.statutService = statutService;
        this.interetService = interetService;
        this.genreService = genreService;
        this.personneService = personneService;
        this.invitationService = invitationService;
        this.httpSession = httpSession;
    }
    @GetMapping("/ville")
    public ModelAndView villeGet() {
        return new ModelAndView("ville");
    }

    @PostMapping("ville")
    public ModelAndView villePost(@RequestParam("VILLE") String ville) {
        villeService.ajouterVille(ville);
        return new ModelAndView("redirect:villes");
    }

    @GetMapping({"/","index"})
    public ModelAndView accueil(){
        return new ModelAndView("connexion");
    }

    @GetMapping("connexion")
    public ModelAndView connexionGet(){
        return new ModelAndView("connexion");
    }
    @PostMapping("connexion")
    public ModelAndView connexionPost(@RequestParam("email")String email,@RequestParam("password") String password){
        Personne personne = personneService.recupererPersonne(email,password);
        if(personne != null){
            System.out.println("test");
            httpSession.setAttribute("personne",personne);
            ModelAndView mav = new ModelAndView("redirect:tableauDeBord");

            return mav;
        }else{

            return new ModelAndView("connexion");
        }
    }
    @GetMapping({"tableauDeBord"})
    public ModelAndView tableauDeBord(){
        System.out.println("test2 ");
        ModelAndView mav = new ModelAndView("tableauDeBord");

        return mav;
    }
    @GetMapping({"administration"})
    public ModelAndView administration(){
        return new ModelAndView("index");
    }

    @GetMapping({"deconnexion"})
    public ModelAndView deconnexion(){
        httpSession.invalidate();
        return new ModelAndView("redirect:connexion");
    }

    @GetMapping("villes")
    public ModelAndView villesGet(@RequestParam(defaultValue = "", name="filtre") String filtre) {
        List<Ville> villes = villeService.recupererVilles(filtre);

        ModelAndView mav = new ModelAndView("villes");
        mav.addObject("villes",villes);
        mav.addObject("filtre",filtre);

        return mav;
    }

    @GetMapping("interets")
    public ModelAndView interetsGet(@RequestParam(defaultValue = "", name="filtre" ,required = false) String filtre) {
        List<Interet> interets = interetService.recupererInterets(filtre);

        ModelAndView mav = new ModelAndView("interets");
        mav.addObject("interets",interets);
        mav.addObject("filtre",  filtre);

        return mav;
    }

    @GetMapping("personnes")
    public ModelAndView personnesGet(@RequestParam(defaultValue = "", name="filtre" ,required = false) String filtre,
                                     @PageableDefault(size=10,page=0,sort="pseudo") Pageable pageable) {
        Page<Personne> personnes = personneService.recupererPersonnesParPseudoFilter(filtre,pageable);

        ModelAndView mav = new ModelAndView("personnes");
        mav.addObject("pagePersonnes",personnes);
        mav.addObject("msFin",new Date().getTime());

        return mav;
    }

    @GetMapping("/interet")
    public ModelAndView interetGet() {
        return new ModelAndView("interet");
    }

    @PostMapping("interet")
    public ModelAndView interetPost(@RequestParam("INTERET") String interet) {

        interetService.ajouterInteret(interet);
        return new ModelAndView("redirect:interets");
    }

    @GetMapping("statut")
    public ModelAndView statutGet(@RequestParam("id") Long id){
        ModelAndView mav= new ModelAndView("statut");
        Statut statut = statutService.recupererStatut(id);
        if(statut != null){
            mav.addObject("statut",statut);

        }else{
           mav.setViewName("redirect:index");
        }
        return mav;
    }

    @GetMapping("statuts")
    public ModelAndView statutsGet(){
        ModelAndView mav= new ModelAndView("statuts");
        List<Statut> statuts = statutService.recupererStatuts();

        mav.addObject("statuts",statuts);
        return mav;
    }

    @GetMapping("/personne")
    public ModelAndView personneGet(@RequestParam(defaultValue = "0", name="id" ,required = false) Long id) {
        Personne personne;
        if(id >0){
            personne = personneService.recupererPersonneParId(id);
        }else{
            personne = new Personne();
        }
        ModelAndView mav = new ModelAndView("personne");
        mav.addObject("personne",personne);
        mav.addObject("villes",villeService.recupererVilles());
        mav.addObject("genres",genreService.recupererGenres());
        mav.addObject("interets",interetService.recupererInterets());
        mav.addObject("statuts",statutService.recupererStatuts());
        return mav;
    }
    @PostMapping("/personne")
    public ModelAndView personnePost(@Valid @ModelAttribute Personne personne, BindingResult result) {

        if(result.hasErrors()){
            ModelAndView mav = personneGet(personne.getId());
            mav.addObject("personne", personne);
            return mav;
        }else{
            System.out.println(personne);
            personneService.enregisterPersonne(personne);
            return new ModelAndView("redirect:personnes");
        }
    }
    @GetMapping("/deletePersonne")
    public ModelAndView deletePersonneGet(@RequestParam(name="id") Long id) {
       personneService.supprimerPersonne(id);
        return new ModelAndView("redirect:personnes");
    }

    @GetMapping("invitation")
    public ModelAndView invitationGet(@RequestParam(name="id") Long id) {
        Personne expediteur = (Personne) httpSession.getAttribute("personne");
        if(expediteur == null){
            return new ModelAndView("redirect:connexion");
        }else{
            expediteur.getInvitationsEnvoyees().add(invitationService.inviter(expediteur.getId(),id));
            return new ModelAndView("redirect:tableauDeBord");
        }

    }
    @GetMapping("/accepterInvitation")
    public ModelAndView accepterInvitationGet(@RequestParam(name="id") Long id) {
        Personne personne = (Personne) httpSession.getAttribute("personne");
        int cpt=0;
        for(Invitation invitation : personne.getInvitationsRecues()){
            if(invitation.getId() == id){
                personne.getInvitationsRecues().set(cpt, invitationService.accepterInvitation(id));
                break;
            }
            cpt++;
        }

        return new ModelAndView("redirect:tableauDeBord");
    }

    @GetMapping("/declinerInvitation")
    public ModelAndView declinerInvitationGet(@RequestParam(name="id") Long id) {
        Personne personne = (Personne) httpSession.getAttribute("personne");
        int cpt=0;
        for(Invitation invitation : personne.getInvitationsRecues()){
            if(invitation.getId() == id){
                personne.getInvitationsRecues().set(cpt,  invitationService.declinerInvitation(id));
                break;
            }
            cpt++;
        }


        return new ModelAndView("redirect:tableauDeBord");
    }
    // Cette méthode sera invoquée dès que Spring a injecté tous les objets
    @PostConstruct
    private void init() throws ParseException {
        if (villeService.recupererVilles().isEmpty()) {
            villeService.ajouterVille("Lyon");
            villeService.ajouterVille("Macon");
            villeService.ajouterVille("Grenoble");
            villeService.ajouterVille("Annecy");
            villeService.ajouterVille("Melun");
            villeService.ajouterVille("Autun");
            villeService.ajouterVille("Paris");
        }

        if (statutService.recupererStatuts().isEmpty()){
            statutService.ajouterStatut("Célibataire");
            statutService.ajouterStatut("Séparé(e)");
            statutService.ajouterStatut("Divorcé(e)");
            statutService.ajouterStatut("Veuf/veuve");
        }

        if (interetService.recupererInterets().isEmpty()) {
            interetService.ajouterInteret("Moto GP");
            interetService.ajouterInteret("Formule 1");
            interetService.ajouterInteret("Manga");
            interetService.ajouterInteret("Escalade");
            interetService.ajouterInteret("Guitare électrique");
            interetService.ajouterInteret("Musculation");
            interetService.ajouterInteret("Course");
            interetService.ajouterInteret("Boxe thaïe");
            interetService.ajouterInteret("Histoire");
            interetService.ajouterInteret("Oenologie");
            interetService.ajouterInteret("Jeux vidéo");
            interetService.ajouterInteret("Poney");
            interetService.ajouterInteret("Jardinage");
            interetService.ajouterInteret("Astro-physique");
        }

        if (genreService.recupererGenres().isEmpty()){
            genreService.ajouterGenre("Homme");
            genreService.ajouterGenre("Femme");
            genreService.ajouterGenre("Autre");
        }
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date dateDebut;
        Date dateFin;
        if(personneService.recupererPersonnes().isEmpty()){
            Personne toto = new Personne();
            toto.setPseudo("toto");
            toto.setVille(villeService.recupererVilleParNom("Lyon"));
            toto.setStatut(statutService.recupererStatut("Célibataire"));
            toto.setGenre(genreService.recupererGenre("Homme"));
            toto.setGenreRecherche(genreService.recupererGenre("Femme"));
            Interet poney = interetService.recupererInteret("Poney");
            List<Interet> interets = new ArrayList<>();
            interets.add(poney);
            toto.setInterets(interets);
            toto.setDateDeNaissance(formater.parse("1950-01-01"));
            personneService.enregisterPersonne(toto);
            Personne carla = new Personne();
            carla.setPseudo("carla");
            carla.setVille(villeService.recupererVilleParNom("Lyon"));
            carla.setStatut(statutService.recupererStatut("Célibataire"));
            carla.setGenre(genreService.recupererGenre("Femme"));
            carla.setGenreRecherche(genreService.recupererGenre("Homme"));
            carla.setInterets(interets);
            carla.setDateDeNaissance(formater.parse("1991-01-01"));
            personneService.enregisterPersonne(carla);

            Personne evan = new Personne();
            evan.setPseudo("evan");
            evan.setGenre(genreService.recupererGenre("Homme"));
            evan.setGenreRecherche(genreService.recupererGenre("Femme"));
            evan.setVille(villeService.recupererVilleParNom("Macon"));
            evan.setStatut(statutService.recupererStatut("Célibataire"));
            List<Interet> interetsEvan = new ArrayList<>();
            interetsEvan.add(interetService.recupererInteret("Moto GP"));
            interetsEvan.add(interetService.recupererInteret("Formule 1"));
            evan.setInterets(interetsEvan);
            evan.setDateDeNaissance(formater.parse("1987-09-26"));
            personneService.enregisterPersonne(evan);

            Personne tomate = new Personne();
            tomate.setPseudo("tomate");
            tomate.setGenre(genreService.recupererGenre("Femme"));
            tomate.setGenreRecherche(genreService.recupererGenre("Homme"));
            tomate.setVille(villeService.recupererVilleParNom("Macon"));
            tomate.setStatut(statutService.recupererStatut("Célibataire"));
            List<Interet> interetsTomate = new ArrayList<>();
            interetsTomate.add(interetService.recupererInteret("Musculation"));
            tomate.setInterets(interetsTomate);
            tomate.setDateDeNaissance(formater.parse("1991-01-01"));
            personneService.enregisterPersonne(tomate);

            Personne jean = new Personne();
            jean.setPseudo("jean");
            jean.setGenre(genreService.recupererGenre("Homme"));
            jean.setGenreRecherche(genreService.recupererGenre("Femme"));
            jean.setVille(villeService.recupererVilleParNom("Grenoble"));
            jean.setStatut(statutService.recupererStatut("Divorcé(e)"));
            List<Interet> interetsJean = new ArrayList<>();
            interetsJean.add(interetService.recupererInteret("Escalade"));
            jean.setInterets(interetsJean);
            jean.setDateDeNaissance(formater.parse("1980-07-01"));
            personneService.enregisterPersonne(jean);

            for(int i=0;i<100;i++){
                System.out.println("test");
                Personne personne = new Personne();
                personne.setPseudo("toto"+(i+1));
                personne.setEmail("toto"+(i+1)+"@totomail.fr");
                personne.setDateDeNaissance(formater.parse("1980-01-01"));
                List<Interet> interetsPersonne = new ArrayList<>();
                interetsPersonne.add(interetService.recupererInteret("Poney"));
                personne.setInterets(interetsPersonne);
                personne.setVille(villeService.recupererVilleParNom("Lyon"));
                personne.setStatut(statutService.recupererStatut("Célibataire"));
                if(i%2 == 0){
                    personne.setGenre(genreService.recupererGenre("Homme"));
                    personne.setGenreRecherche(genreService.recupererGenre("Femme"));
                }else{
                    personne.setGenre(genreService.recupererGenre("Femme"));
                    personne.setGenreRecherche(genreService.recupererGenre("Homme"));
                }
                personneService.enregisterPersonne(personne);
            }
        }

        List<Personne> personnesByVille = personneService.recupererPersonnesParVille(villeService.recupererVilleParNom("Lyon"));
        List<Personne> femmesCelibatairesDeMacon = personneService.recupererPersonnes(
                villeService.recupererVilleParNom("Macon"),
                genreService.recupererGenre("Femme"),
                statutService.recupererStatut("Célibataire"));

        System.out.println(personnesByVille);
        System.out.println(femmesCelibatairesDeMacon);


        calendar.add(Calendar.YEAR, -39);
        dateDebut = calendar.getTime();
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -30);
        dateFin = calendar.getTime();
        List<Personne> femmesTrentenairesDeMacon = personneService.recupererPersonnes(
                villeService.recupererVilleParNom("Macon"),
                genreService.recupererGenre("Femme"),
                statutService.recupererStatut("Célibataire"),
                dateDebut,
                dateFin);

        System.out.println(femmesTrentenairesDeMacon);

        List <Personne> personnesParPseudo = personneService.recupererPersonnesParPseudo("evan");

        System.out.println(personnesParPseudo);
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -49);
        dateDebut = calendar.getTime();
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -40);
        dateFin = calendar.getTime();
        List <Ville> villes = new ArrayList<>();
        villes.add(villeService.recupererVilleParNom("Grenoble"));
        villes.add(villeService.recupererVilleParNom("Paris"));
        List <Personne> divorcesQuadraEscalade = personneService.recupererPersonnes(
                villes,
                genreService.recupererGenre("Homme"),
                statutService.recupererStatut("Divorcé(e)"),
                dateDebut,
                dateFin,
                interetService.recupererInteret("Escalade"));

        System.out.println(divorcesQuadraEscalade);

        List<Personne> personnesParInteretsDesc = personneService.recupererPersonnesParInteretDesc();

        System.out.println("personnes triées par intérêts");
        for (Personne personne:personnesParInteretsDesc) {
            System.out.println(personne);
        }
        String villeString = "Lyon";
        List <Personne> personnesParVille = personneService.recupererPersonnes(villeService.recupererVilleParNom(villeString));

        System.out.println("personnes habitant "+villeString);
        for (Personne personne: personnesParVille) {
            System.out.println(personne);
        }
    }

}
