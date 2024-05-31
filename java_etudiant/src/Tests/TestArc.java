package Tests;
import Graphes.Arc;
import Graphes.Arcs;
import Graphes.GrapheListe;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * La classe de test pour valider la classe Arc
 */
public class TestArc {
    @Test
    public void test_Constructeur_positif() {
        //Initialisation
        Arc arc = new Arc("B", 12.0);

        //Comparaison
        assertEquals("B", arc.getDest());
        assertEquals(12.0, arc.getCout(), 0.001);
    }

    @Test
    public void test_Constructeur_negatif() {
        //Initialisation
        Arc arc = new Arc("B", -12.0);

        //Comparaison
        assertEquals("B", arc.getDest());
        assertEquals(12.0, arc.getCout(), 0.001); //
    }

    @Test
    public void testToString() {
        //Initialisation
        Arc arc = new Arc("B", 12.0);

        //Comparaison
        assertEquals("B(12)", arc.toString());
    }
}
