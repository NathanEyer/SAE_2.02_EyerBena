package Graphes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe Arcs qui génère une liste définissant un ensemble
 * d'arcs partant d'un noeud sous la forme d'un objet de type Arcs
 */
public class Arcs{
    /**
     * Liste d'Arc à gérer
     */
    private List<Arc> arcs;

    /**
     * Construit une liste d'Arc vide
     */
    public Arcs(){
        this.arcs = new ArrayList<>();
    }

    /**
     * Ajoute l’Arc a à la liste d’arcs
     * @param a Arc à rajouter
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


    /**
     * Affichage de manière fluide la liste d'Arcs
     * @return une chaîne de caractères correspondant
     * aux caractéristiques de chaque arc
     */
    public String toString(){
        String arc = "";
        for(Arc a : arcs){
            arc+= a.toString() + " ";
        }
        return arc;
    }
}