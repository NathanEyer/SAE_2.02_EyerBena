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
     * retourne l'équivalent alphabétique d'un chiffre
     * @param nb chiffre
     * @return lettre de l'alphabet
     */
    public String nbVersAlpha(int nb){
        //Vérification que bien dans l'alphabet puis traduction
        if(nb < 1 || nb > 26){
            return "Invalid input. Please enter a number between 1 and 26.";
        } else {
            char c = (char)(nb + 64);
            return String.valueOf(c);
        }
    }

    /**
     * lit un fichier et retourne un tableau à double entrée
     * @return String[][]
     */
    public String[][] lireFichier(){
        File gFile = new File(this.nom);
        String[] elements;
        String ligne;
        String[][] graphe;
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(gFile));

            //On compte le nombre de lignes
                int nbLignes = 0;
                while(buffer.readLine() != null){
                    nbLignes++;
                }
                buffer.close();


                BufferedReader fichier = new BufferedReader(new FileReader(gFile));

            //Tableau de la bonne taille
                graphe = new String[nbLignes][];
                for(int i=0;i<nbLignes;i++){
                    ligne = fichier.readLine();
                    elements = ligne.split("\t");
                    graphe[i][0] = nbVersAlpha(Integer.parseInt(elements[0]));
                    graphe[i][1] = nbVersAlpha(Integer.parseInt(elements[1]));
                    graphe[i][2] = elements[2];
                }

                return graphe;

        }catch (FileNotFoundException e){
            throw new Error("Fichier " + nom + " inexistant");
        }catch (IOException e){
            throw new Error();
        }
    }
}

