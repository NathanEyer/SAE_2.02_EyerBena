import Graphes.Arc;
import Graphes.Graphe;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    // Entrées :
    // G un graphe orienté avec une pondération positive des arcs (coût ou poids)
    // A un sommet (départ) de G
    // Début
    // Q <- {} // utilisation d’une liste de noeuds à traiter
    // Pour chaque sommet v de G faire
    //    v.valeur <- Infini
    //    v.parent <- Indéfini
    //    Q <- Q U {v} // ajouter le sommet v à la liste Q
    // Fin Pour
    // A.valeur <- 0
    // Tant que Q est un ensemble non vide faire
    //    u <- un sommet de Q telle que u.valeur est minimal
    //    // enlever le sommet u de la liste Q
    //    Q <- Q \ {u}
    //    Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
    //       d <- u.valeur + poids(u,v)
    //       Si d < v.valeur
    //          // le chemin est plus intéressant
    //          Alors v.valeur <- d
    //          v.parent <- u
    //       Fin Si
    //    Fin Pour
    // Fin Tant que

    /**
     * Algorithme de Dijska
     * @param g Graphe étudié
     * @param depart noeud de départ
     * @return val
     */
    public Valeur resoudre(Graphe g, String depart){
        //Création d'une liste vide et d'un objet Valeur
            List<String> lNoeuds = new ArrayList<>();
            Valeur val = new Valeur();

        //Boucle pour tous les noeuds
        for(String ind : g.listeNoeuds()){
            //Affectation de la valeur à l'infini
                val.setValeur(ind, Double.MAX_VALUE);
            //Affectation des parents à null
                val.setParent(ind, null);
            //Remplissage de la liste
                lNoeuds.add(ind);
        }
        //Affectation de la valeur de départ à 0
            val.setValeur(depart, 0);

        //Boucle tant que la liste n'est pas vide
        while(!lNoeuds.isEmpty()){
            // Initialisation du noeud à traiter
                String noeud = null;
            // Initialisation de la valeur minimale à +infini
                double min = Double.MAX_VALUE;

            //Boucle pour tous les noeuds
            for(String ind : lNoeuds){
                double valeur = val.getValeur(ind);
                //Si la valeur est inférieur, réajustement du minimum
                if(valeur < min){
                    min = valeur;
                    noeud = ind;
                }
            }

            //Retrait du noeud de la liste
                lNoeuds.remove(noeud);

            //Boucle tous les Arc
            for(Arc arc : g.suivants(noeud)){
                String dest = arc.getDest();

                //Vérification que v est dans la liste
                if(lNoeuds.contains(dest)){
                    //Calcul de la distance
                    double d = val.getValeur(noeud) + arc.getCout();

                    //Si la distance calculée < distance actuelle du sommet v,
                    if(d < val.getValeur(dest)){
                        val.setValeur(dest, d);
                        val.setParent(dest, noeud);
                    }
                }
            }
        }
        return val;
    }
}
