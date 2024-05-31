package Graphes;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Graphes.GrapheListe permettant de construire un graphe orienté composé de noeuds et d'arcs
 */
public class GrapheListe implements Graphe{
    /**
     * Liste de String pour les noeuds
     */
    private ArrayList<String> noeuds;

    /**
     * Liste des Arcs partant de chaque noeud du graphe
     */
    private ArrayList<Arcs> adjacence;

    /**
     * crée un objet grapheListe
     * @param noeuds liste noeuds du graphe
     * @param adjacence liste noeud adjacent à chaque noeud du graphe
     */
    public GrapheListe(ArrayList<String> noeuds, ArrayList<Arcs> adjacence) {
        //Initialisation des attributs
            this.noeuds = noeuds;
            this.adjacence = adjacence;

        // remplissage de l'attribut adjacence
        // un objets Arcs pour chaque noeud dans la liste de noeuds
            for(int i=0;i<noeuds.size();i++){
                this.adjacence.add(new Arcs());
            }
    }

    /**
     * retourne l'indice de n dans noeuds
     * @param n noeud recherché
     * @return indice n
     */
    public int getIndice(String n){
        return noeuds.indexOf(n);
    }

    /**
     * retourne la liste des noeuds
     * @return noeuds
     */
    public List<String> listeNoeuds(){
        return noeuds;
    }

    /**
     * retourne tous les arcs successeurs à n
     * @param n noeud recherché
     * @return List<Arc>
     */
    public List<Arc> suivants(String n){
        //Recherche de l'indice de n
            int ind = this.getIndice(n);

        //retourne la liste des noeuds suivants n
            return adjacence.get(ind).getArcs();
    }

    /**
     * Ajouter des noeuds et
     * des arcs a un objet de type GrapheListe
     * @param depart
     * @param destination
     * @param cout
     */
    public void ajouterArc(String depart, String destination, double cout){
        //vérification de l'existence du noeud de départ
            int dep = this.getIndice(depart);
            if(dep == -1){
                noeuds.add(depart);
                dep = this.getIndice(depart);
            }

        //vérification de l'existence du noeud de destination
            int dest = this.getIndice(destination);
            if(dest == -1){
                noeuds.add(destination);
            }

        //Création de l'objet Arcs à ajouter
            Arcs arcsDepart = adjacence.get(dep);

        //Ajout de l'arc à l'indice dep
            arcsDepart.ajouterArc(new Arc(destination, cout));
    }

    /**
     * affichage concis du grapheListe
     * @return affichage
     */
    public String toString(){
        String graphe = "";
        try{
            for(int i=0;i<noeuds.size();i++){
                graphe += noeuds.get(i) + " -> " + adjacence.get(i) + "\n";
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Ajout d'un nouveau noeud: \n" + listeNoeuds() + "\n");
        }
        return graphe;
    }

}