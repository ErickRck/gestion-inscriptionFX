# gestion-inscriptionFX

BD configuration:

--
-- Base de données :  `inscrit`
--

-- --------------------------------------------------------

--
-- Structure de la table `rapport`
--

CREATE TABLE IF NOT EXISTS `rapport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `faculte` varchar(30) NOT NULL,
  `option` varchar(30) NOT NULL,
  `promotion` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `postnom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `lieuxdatedenaissance` varchar(100) NOT NULL,
  `sexe` varchar(4) NOT NULL,
  `telephon` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `tuteur` varchar(50) NOT NULL,
  `teltuteur` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'secretaire',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;
