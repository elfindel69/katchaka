 # 1 - requête HQL listant tous les personnes de la ville donnée en paramètre
 FROM Personne WHERE ville.nom = 'Lyon'

 # 2 - requête HQL donnant les personnes nées entre deux dates données en paramètre
 FROM Personne WHERE dateDeNaissance BETWEEN '2021/09/01' AND '2021/09/30'

 # 3 - requête HQL donnant les villes où il n’y a pas d’inscrits
 FROM Ville v WHERE v.personnes IS EMPTY

 # 4 - requête HQL listant les femmes célibataires de Lyon
 FROM Personne p WHERE p.genre = 'femme' AND p.ville = 'Lyon'

 # 5 - requête HQL listant les personnes triées sur leur nombre d’intérêts
 FROM Personne p ORDER BY p.interets.size DESC

 # 6 - requête HQL listant les messages triés par date d’envoi (du plus récent au plus ancien)
 FROM Message ORDER BY dateEnvoi DESC

 # 7 - requête HQL listant les personnes de plus de 30 ans et dont le pseudo débute par T
 FROM Personne p WHERE (current_date - p.dateDeNaissance) > 30 AND p.pseudo LIKE 'T%'

 # 8 - requête HQL listant les invitations déclinées
 FROM Invitation i WHERE i.estAccepte = false

 # 9 -  requête HQL donnant le nombre d’inscrits par ville
 SELECT v.nom, v.personnes.size FROM Ville v GROUP BY v.nom

 # 10 - requête HQL donnant le nombre de vies communes par mois
 SELECT count(v) AS nb_vies_communes, month(v.dateDebut) AS mois FROM VieCommune v GROUP BY mois