package Graphes;

import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{
    //liste des noeuds du graphe
    private ArrayList<String> noeuds;

    //liste des Graphes.Arcs partant de chaque noeud du graphe
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
     * @param g graphe étudié
     * @param n noeud recherché
     * @return List<Arc>
     */
    public List<Arc> suivants(Graphe g, String n){
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
        for(int i=0;i<noeuds.size();i++){
            graphe += noeuds.get(i) + " -> " + adjacence.get(i).toString() + "\n";
        }
        return graphe;
    }

    /**
     * Main de la classe
     * @param args
     */
    public static void main(String[] args) {
        //Création des listes vides
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
            GrapheListe gr = new GrapheListe(lNoeuds, lArc);

        // Ajout des arcs dans le graphe
            for (String[] arc : arcsTab) {
                gr.ajouterArc(arc[0], arc[1], Double.parseDouble(arc[2]));
            }

        System.out.println(gr.toString());
    }
}