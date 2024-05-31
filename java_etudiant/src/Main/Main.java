package Main;

import Graphes.Arcs;
import Graphes.GrapheListe;
import Algorithmes.*;
import java.util.ArrayList;

public class Main {
    /**
     * Main de la classe
     * @param args
     */
    public static void main(String[] args) {
        //Création des listes vides
            ArrayList<String> lNoeuds = new ArrayList<>();
            ArrayList<Arcs> lArc = new ArrayList<>();

        //Création de tableaux de String des noeuds
            String[] noeudTab = {"A", "B", "C", "D", "E"};
            String[][] arcsTab = {
                    {"A", "B", "12"}, {"A", "D", "87"},
                    {"B", "E", "11"}, {"C", "A", "19"},
                    {"D", "C", "10"}, {"D", "B", "23"},
                    {"E", "D", "43"}
            };

        //Remplissage de la liste de noeuds
            for(String c : noeudTab){
                lNoeuds.add(c);
            }

        //Création d'un objet GrapheListe
            GrapheListe gr = new GrapheListe(lNoeuds, lArc);

        // Ajout des arcs dans le graphe
            for (String[] arc : arcsTab) {
                gr.ajouterArc(arc[0], arc[1], Double.parseDouble(arc[2]));
            }

        //Affichage
        System.out.println("Liste des noeuds suivis de leur successeurs: \n" + gr);

        Algorithme pointFixe = new BellmanFord();
        System.out.println("Méthode BellmanFord: \n" + pointFixe.resoudre(gr, "A"));

        Valeur valeur = new Valeur();
        System.out.println(valeur.calculerChemin("D"));
    }
}
