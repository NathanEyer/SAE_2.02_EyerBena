package Tests;
import Graphes.Arcs;
import Algorithmes.*;
import Main.*;
import Graphes.GrapheListe;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
public class TestDijkstra {
    @Test
    public void test_resoudre(){

        //Initialisation
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
        GrapheListe graphe = new GrapheListe(lNoeuds, lArc);

        // Ajout des arcs dans le graphe
        for (String[] arc : arcsTab) {
            graphe.ajouterArc(arc[0], arc[1], Double.parseDouble(arc[2]));
        }

        Dijkstra dijkstra = new Dijkstra();
        Valeur resultat = dijkstra.resoudre(graphe, "A");

        //Comparaison
        // Vérification des distances minimales attendues
        // le paramètre delta représente la marge d'erreur du résultat
        assertEquals(0.0, resultat.getValeur("A"), 0.001);
        assertEquals(12.0, resultat.getValeur("B"), 0.001);
        assertEquals(76.0, resultat.getValeur("C"), 0.001);
        assertEquals(66.0, resultat.getValeur("D"), 0.001);
        assertEquals(23.0, resultat.getValeur("E"), 0.001);

        // Vérification des parents attendus
        // Le noeud A n'a pas de parents
        assertNull(resultat.getParent("A"));
        //Vérifications des parents des autres noeuds
        assertEquals("A", resultat.getParent("B"));
        assertEquals("D", resultat.getParent("C"));
        assertEquals("E", resultat.getParent("D"));
        assertEquals("B", resultat.getParent("E"));
    }
}

