package Graphes;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestGrapheListe {

    @Test
    public void testGetIndice() {
        //Initialisation
        //Création d'un graphe avec 3 noeuds
            ArrayList<String> noeuds = new ArrayList<>();
            noeuds.add("A");
            noeuds.add("B");
            noeuds.add("C");
            ArrayList<Arcs> adjacence = new ArrayList<>();
            GrapheListe testGraphe = new GrapheListe(noeuds, adjacence);

        //Vérification
            assertEquals(0, testGraphe.getIndice("A"));
            assertEquals(1, testGraphe.getIndice("B"));
            assertEquals(2, testGraphe.getIndice("C"));
    }
    
    @Test
    public void testAjouterArc(){
        //Initialisation
        //Création des listes vides
            ArrayList<String> lNoeuds = new ArrayList<>();
            ArrayList<Arcs> lArc = new ArrayList<>();

        //Création de tableaux de String des noeuds
            String[] noeudTab = {"A", "B", "C"};
            String[][] arcsTab = {
                    {"A", "B", "12"}, {"A", "D", "87"},
                    {"B", "E", "11"}, {"C", "A", "19"},
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

        //Vérification
            assertEquals(5, gr.listeNoeuds().size());
    }

    @Test
    public void testSuivants(){
        //Initialisation
        //Création des listes vides
            ArrayList<String> lNoeuds = new ArrayList<>();
            ArrayList<Arcs> lArc = new ArrayList<>();

        //Création de tableaux de String des noeuds
            String[] noeudTab = {"A", "B", "C"};
            String[][] arcsTab = {
                    {"A", "B", "12"}, {"A", "D", "87"},
                    {"B", "E", "11"}, {"C", "A", "19"},
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

        //Attendu
            ArrayList<Arc> attendu = new ArrayList<>();
            attendu.add(new Arc("B", 12));
            attendu.add(new Arc("D", 87));

        //Vérification
            assertEquals(attendu, gr.suivants("A"));
    }
}
