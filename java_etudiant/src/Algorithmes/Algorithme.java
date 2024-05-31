package Algorithmes;
import Graphes.Graphe;
import Main.Valeur;

/**
 * Interface Algorithme qui regroupe toutes les classes correspondantes
 */
public interface Algorithme {
    public Valeur resoudre(Graphe g, String depart);
}
