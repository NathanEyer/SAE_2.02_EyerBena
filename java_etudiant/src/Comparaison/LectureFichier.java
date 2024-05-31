package Comparaison;

import java.io.*;

public class LectureFichier {
    /**
     * Nom du fichier à charger
     */
        String nom;

    /**
     * Constructeur
     * @param nom nom du fichier
     */
        public LectureFichier(String nom) {
            this.nom = nom;
        }


    /**
     * Lit un fichier et retourne un tableau à double entrée
     * @return String[][]
     */
    public String[][] lireFichier(){
        //Initialisations
            File gFile = new File(this.nom);
            String[] elements;
            String ligne;
            String[][] graphe;
        try{
            //Ouverture du fichier
                BufferedReader buffer = new BufferedReader(new FileReader(gFile));

            //On compte le nombre de lignes
                int nbLignes = 0;
                String nb = buffer.readLine();
                while(nb != null){
                    nb = buffer.readLine();
                    nbLignes++;
                }

            //Réouverture du fichier pour repartir à 0
                buffer.close();
                BufferedReader fichier = new BufferedReader(new FileReader(gFile));

            //Récupération des valeurs
                graphe = new String[nbLignes][];
                for(int i=0;i<nbLignes;i++){
                    ligne = fichier.readLine();
                    elements = ligne.split("\t");
                    graphe[i] = new String[3];
                    graphe[i][0] = elements[0];
                    graphe[i][1] = elements[1];
                    graphe[i][2] = elements[2];
                }
                return graphe;

        //Récupération des erreurs
        }catch (FileNotFoundException e){
            throw new Error("Fichier " + nom + " inexistant");
        }catch (IOException e){
            throw new Error();
        }
    }
}

