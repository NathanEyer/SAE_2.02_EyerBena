package Graphes;

import java.util.List;

/**
 * Classe Graphes.Graphe fondé sur le TAD graphe
 */
public interface Graphe{
    /**
     * @return tous les nœuds du graphe
     */
    public List<String> listeNoeuds();

    /**
     * @param n noeud
     * @return la liste des arcs partant de n
     */
    public List<Arc> suivants(String n);


}