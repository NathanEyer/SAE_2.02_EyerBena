package Graphes;

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

    public String toString(){
        return dest + "(" + cout + ")";
    }
}