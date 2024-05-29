package Graphes;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
}
