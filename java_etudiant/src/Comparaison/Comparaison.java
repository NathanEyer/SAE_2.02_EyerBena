package Comparaison;

import Algorithmes.Algorithme;
import Algorithmes.BellmanFord;
import Algorithmes.Dijkstra;
import Graphes.Arcs;
import Graphes.GrapheListe;

import java.io.File;
import java.util.ArrayList;

/**
 * Examen de performances de chaque algorithme
 * (en terme de rapidité)
 */
public class Comparaison {
    /**
     * Classe principale de test de rapidité des deux algorithmes
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Test sur tous les graphes: \n");

        //Accès au dossier Graphes qui contient tous les .txt
            File folder = new File("Graphes");
            File[] listOfFiles = folder.listFiles();

        //Boucle sur tous les fichiers du dossier
        long totalDij = 0, totalBF = 0;
        for(File file : listOfFiles){
            //Lecture du fichier actuel
                LectureFichier fichier = new LectureFichier(file.getPath());
                String[][] tab = fichier.lireFichier();

            //Création des listes vides
                ArrayList<String> lNoeuds = new ArrayList<>();
                ArrayList<Arcs> lArc = new ArrayList<>();

            //Création de tableaux de String des noeuds
                String[] noeudTab = {};

            //Remplissage de la liste de noeuds
                for(String c : noeudTab){
                    lNoeuds.add(c);
                }

            //Création d'un objet GrapheListe
                GrapheListe gr = new GrapheListe(lNoeuds, lArc);

            // Ajout des arcs dans le graphe
                for (String[] arc : tab) {
                    gr.ajouterArc(arc[0], arc[1], Double.parseDouble(arc[2]));
                }

            //Mesure de temps sur BellmanFord
                Algorithme pointFixe = new BellmanFord();
                long tempDBF = System.nanoTime();
                pointFixe.resoudre(gr, "1");
                long tempFBF = System.nanoTime();
                totalBF += (tempFBF - tempDBF);

            //Mesure de temps sur Dijkstra
                Algorithme dijkstra = new Dijkstra();
                long tempDDij = System.nanoTime();
                dijkstra.resoudre(gr, "1");
                long tempFDij = System.nanoTime();
                totalDij += (tempFDij - tempDDij);
        }

        //Affichage des résultats du temps moyen sur chaque graphe et du temps total
        //BellmanFord
            double tempsMoyenBF = (double) totalBF / listOfFiles.length / 1000000000;
            String totalSBF = String.format("%.3f", totalBF / 1000000000.0);
            System.out.println("Temps moyen d'exécution pour chaque graphe avec la méthode BellmanFord: "
                    + tempsMoyenBF + " secondes d'exécution" +
                    " temps total: " + totalSBF + " secondes");

        //Dijkstra
            double tempsMoyenDij = (double) totalDij / listOfFiles.length / 1000000000;
            String totalSDij = String.format("%.3f", totalDij / 1000000000.0);
            System.out.println("Temps moyen d'exécution pour chaque graphe avec la méthode Dijkstra: "
                    + tempsMoyenDij + " secondes d'exécution"+
                    " temps total: " + totalSDij + " secondes");




        //Test sur 10 graphes (51-56)
            System.out.println("\nTest: sur 10 graphes: \n");
            long totalBFDix = 0, totalDijDix = 0;
        for(int i=51;i<56;i++){
            //Ouverture du fichier actuel
                LectureFichier fichier = new LectureFichier("Graphes/Graphe" + i + ".txt");
                String[][] tab = fichier.lireFichier();

            //Création des listes vides
                ArrayList<String> lNoeuds = new ArrayList<>();
                ArrayList<Arcs> lArc = new ArrayList<>();

            //Création de tableaux de String des noeuds
                String[] noeudTab = {};

            //Remplissage de la liste de noeuds
                for(String c : noeudTab){
                    lNoeuds.add(c);
                }

            //Création d'un objet GrapheListe
                GrapheListe gr = new GrapheListe(lNoeuds, lArc);

            // Ajout des arcs dans le graphe
                for (String[] arc : tab) {
                    gr.ajouterArc(arc[0], arc[1], Double.parseDouble(arc[2]));
                }

            //Mesure de temps sur BellmanFord
                Algorithme pointFixe = new BellmanFord();
                long tempDBF = System.nanoTime();
                pointFixe.resoudre(gr, "1");
                long tempFBF = System.nanoTime();
                totalBFDix += (tempFBF - tempDBF);

            //Mesure de temps sur Dijkstra
                Algorithme dijkstra = new Dijkstra();
                long tempDDij = System.nanoTime();
                dijkstra.resoudre(gr, "1");
                long tempFDij = System.nanoTime();
                totalDijDix += (tempFDij - tempDDij);
        }

        //Affichage des résultats
        //BellmanFord
            double tempsMoyenBFDix = (double) totalBFDix / 5 / 1000000000;
            String totalSBFDix = String.format("%.6f", totalBFDix / 1000000000.0);
            System.out.println("Temps moyen d'exécution pour chaque graphe avec la méthode BellmanFord: "
                    + tempsMoyenBFDix + " secondes d'exécution" +
                    " temps total: " + totalSBFDix + " secondes");

        //Dijkstra
            double tempsMoyenDijDix = (double) totalDijDix / 5 / 1000000000;
            String totalSDijDix = String.format("%.6f", totalDijDix / 1000000000.0);
            System.out.println("Temps moyen d'exécution pour chaque graphe avec la méthode Dijkstra: "
                    + tempsMoyenDijDix + " secondes d'exécution"+
                    " temps total: " + totalSDijDix + " secondes");
    }
}
