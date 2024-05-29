import Graphes.Arcs;
import Graphes.Arc;
import Graphes.Graphe;
import Graphes.GrapheListe;

import java.util.List;

public class BellmanFord {

    Valeur resoudre(Graphe g, String depart) {
        // Création d'un objet valeur qui stockera la valeur du parent associé à chaqe noeud
        Valeur valeur = new Valeur();
        // booleen a vrai si et seulement si il y a eu une modification du point fixe
        boolean modif = false;

        do {
            //initialisation des valeurs de chaque noeuds à +infini
            for (String noeud : g.listeNoeuds()) {
                valeur.setValeur(noeud, Double.MAX_VALUE);
                valeur.setParent(noeud, null);
            }
            // Initialisation de la valeur du noeud e départ à 0.0
            valeur.setValeur(depart, 0.0);

            //Tant qu'il y a encore des modifs
            while (modif) {
                //pour chaque noeuds
                for (String noeud : g.listeNoeuds()) {
                    //pour chaque arc de chaque noeuds
                    for (Arc a : g.suivants(noeud)) {
                        // calcul de la nouvelle valeur estimée pour le noeud de destination
                        double ValeurNDest = valeur.getValeur(noeud) + a.getCout();

                        // Recherche du minimum
                        // si la nouvelle valeur calculée est inférieur à la valeur de destination
                        if (ValeurNDest < valeur.getValeur(a.getDest())) {
                            // Mise à jour de la valeur
                            valeur.setValeur(a.getDest(), ValeurNDest);
                            // Mise à jour du prent du noeud
                            valeur.setParent(a.getDest(), noeud);
                            // Une modif a eu lieu
                            modif = true;
                        }
                    }
                }
            }
        }
        //boucle do {} while car avec un while classique, on est sur un cas de boucle infini
        while (modif);

        return valeur;
    }
}