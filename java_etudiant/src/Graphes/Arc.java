package Graphes;

import java.util.Objects;

/**
 * Classe Graphes.Arc qui représente un arc portant un noeud
 */
public class Arc{
    private String dest; //nom du nœud destination de l’arc
    private double cout; //cout ou poids de l’arc

    /**
     * Constructeur de la classe
     * @param dest noeud de destination
     * @param cout cout de l'arc créé
     */
    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = cout;
    }

    /**
     * Redéfinit pour ne pas avoir d'erreur de test
     * @param o objet
     * @return true si égal
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Arc arc = (Arc) o;
        return Double.compare(arc.cout, cout) == 0 && Objects.equals(dest, arc.dest);
    }

    public String toString(){
        return dest + "(" + cout + ")";
    }

    public String getDest() {
        return dest;
    }

    public double getCout() {
        return cout;
    }
}