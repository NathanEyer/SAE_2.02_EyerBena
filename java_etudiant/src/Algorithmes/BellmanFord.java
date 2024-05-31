package Algorithmes;
import Graphes.Arcs;
import Graphes.Arc;
import Graphes.Graphe;
import Graphes.GrapheListe;
import Main.*;
import java.util.List;

/**
 * Algorithme BellFord qui permet de rechercher
 * le chemin le plus court sur un graphe orienté
 */
public class BellmanFord implements Algorithme{

    /**
     * @param g graphe sur lequel la fonction va calculer le point fixe
     * @param depart noeud de départ du graphe orienté
     * @return un objet Valeur
     */
    public Valeur resoudre(Graphe g, String depart) {
        // Création d'un objet valeur qui stockera la valeur du parent associé à chaque noeud
        Valeur valeur = new Valeur();

        // initialisation du boolean, vrai si et seulement si
        // il y a une modification durant la boucle do while
        boolean modif = true;

        //initialisation des valeurs de chaque noeuds à max_value
        for (String noeud : g.listeNoeuds()) {
            valeur.setValeur(noeud, Double.MAX_VALUE);
            valeur.setParent(noeud, null);
        }

        //Initialisation de la valeur du noeud de départ
        valeur.setValeur(depart, 0.0);

        do {
            modif = false;
            //pour chaque noeuds
            for (String n : g.listeNoeuds()) {
                //pour chaque arc de chaque noeud
                    List<Arc> suivant = g.suivants(n);
                for (Arc a : suivant) {
                    // calcul de la nouvelle valeur estimée pour le noeud de destination
                        double ValeurNDest = valeur.getValeur(n) + a.getCout();

                    // Recherche du minimum
                    // si la nouvelle valeur calculée est inférieur à la valeur de destination
                    if (ValeurNDest < valeur.getValeur(a.getDest())) {
                        // Mise à jour de la valeur
                            valeur.setValeur(a.getDest(), ValeurNDest);
                        // Mise à jour du parent du noeud
                            valeur.setParent(a.getDest(), n);
                        // Une modif a eu lieu
                            modif = true;
                    }
                }
            }

        }
        //boucle do {} while car avec un while classique, on est sur un cas de boucle infini
        while (modif);
        return valeur;
    }
}