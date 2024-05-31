package Algorithmes;
import Graphes.Graphe;
import Main.Valeur;

/**
 * Interface Algorithme qui regroupe toutes les classes correspondantes:
 * BellmanFord.java et Dijsktra.java.
 */
public interface Algorithme {
    /**
     * Méthode résoudre qui applique les algorithmes
     * @param g Graphe étudié
     * @param depart noeud de départ
     * @return objet Valeur
     */
    public Valeur resoudre(Graphe g, String depart);
}
