package Tests;

import Graphes.Arc;
import Graphes.Arcs;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * La classe de test pour valider la classe Arcs
 */
public class TestArcs {

    @Test
    public void test_Constructeur_valide() {
        //Initialisation
        Arcs arcs = new Arcs();

        //Comparaison
        //La liste doit être vide
        assertNull(arcs.getArcs());
        assertTrue(arcs.getArcs().isEmpty());
    }

    @Test
    public void test_AjouterArc() {
        //Initialisation
        Arcs arcs = new Arcs();

        //Remplissage
        arcs.ajouterArc(new Arc("B", 12.0));
        arcs.ajouterArc(new Arc("C", 19.0));

        //Comparaison
        assertEquals("B(12) C(19)", arcs.toString());
    }

    @Test
    public void test_toString_vide() {
        //Initialisation
        Arcs arcs = new Arcs();
        //Comparaison
        assertEquals("", arcs.toString());
    }

    @Test
    public void test_ToString_1_Arc() {
        //Initialisation
        Arcs arcs = new Arcs();

        //Remplissage
        arcs.ajouterArc(new Arc("D", 7.0));

        //Comparaison
        assertEquals("D(7) ", arcs.toString());
    }

    @Test
    public void test_ToString_plusieurs_arcs() {
        //Initialisation
        Arcs arcs = new Arcs();

        //Remplissage
        arcs.ajouterArc(new Arc("A", 10.0));
        arcs.ajouterArc(new Arc("B", 12.0));
        arcs.ajouterArc(new Arc("C", 19.0));

        //Comparaison
        assertEquals("A(10) B(12) C(19) ", arcs.toString());
    }
}
