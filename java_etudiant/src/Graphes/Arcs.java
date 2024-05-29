package Graphes;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Graphes.Arcs qui génère une liste définissant un ensemble
 * d'arcs partant d'un noeud sous la forme d'un objet de type Graphes.Arcs
 */
public class Arcs{

    private List<Arc> arcs; //liste d'arcs à gérer

    /**
     * Construit une liste d'arcs vide.
     */
    public Arcs(){
        this.arcs = new ArrayList<>();
    }

    /**
     * Ajoute l’arc a `a la liste d’arcs
     * @param a arc à rajouter
     */
    public void ajouterArc(Arc a){
        this.arcs.add(a);
    }

    /**
     * retourne l'attribut arcs
     * @return arcs
     */
    public List<Arc> getArcs() {
        return this.arcs;
    }

    public String toString(){
        String arc = "";
        for(Arc a : arcs){
            arc+= a.toString() + " ";
        }
        return arc;
    }

}