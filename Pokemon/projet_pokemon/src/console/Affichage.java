package console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Joueurs.Joueur;
import Pokemon.*;
import Structure.MainJoueur;
import Structure.Terrain;
import pouvoirs.Pouvoirs;

public class Affichage {

    public static void affichagePokemon(){
        String nom =
        "              | |                                  \n" +
        "_ __     ___  | | __  ___  _ __ ___    ___   _ __   \n" +
        "|  _ \\  / _ \\ | |/ / / _ \\| '_ ` _ \\  / _ \\ | '_ \\  \n" +
        "| |_) || (_) ||   < |  __/| | | | | || (_) || | | | \n" +
        "| .__/  \\___/ |_|\\_\\ \\___||_| |_| |_| \\___/ |_| |_|  \n" +
        "| | \n" +
        "|_|";


        System.out.println(nom);

    }

    public static void affichageRonde(){
        String ronde =
                "__________                   .___      \n" +
                "\\______   \\ ____   ____    __| _/____  \n" +
                " |       _//  _ \\ /    \\  / __ |/ __ \\ \n" +
                " |    |   (  <_> )   |  \\/ /_/ \\  ___/ \n" +
                " |____|_  /\\____/|___|  /\\____ |\\___  >\n" +
                "        \\/            \\/      \\/    \\/ \n" +
                "                                       \n" +
                "                                       \n" +
                "                                       \n" +
                "                                       \n" +
                "                                       \n" +
                "                                       \n";
        System.out.println(ronde);

    }

   

    public static void monTerrain() {
        String monterrain =
        "\n"+ "+--------------------------------------------    Votre Terrain    -------------------------------------------+";
        System.out.printf(monterrain + "\n");
    }


    public static void affichageterrainIA() {
        String terrainIA = "\n"+"+--------------------------------------------    Terrain IA    --------------------------------------------+";
        
        
        System.out.println(terrainIA + "\n");
    }

    public static void afficherPokemon(Terrain terrain) {

        List<Pokemon> listePokemon = terrain.getpokemonPoses();

        System.out.println("\n");

        int nb_poke = 1;
    
        for (int j = 0; j < listePokemon.size(); j += 3) {
            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);
    
                System.out.print("       +--------");
                for (int i = 0; i <= pokemon.getNom().length(); i++) {
                    System.out.print("-");
                }
                System.out.print("--------+    ");
            }
            System.out.println();
    
            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);
    
                System.out.printf("       |        " + pokemon.getNom() + "         |    ");
            }
            System.out.println();
            
            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);
                int taille_complet = 16 + pokemon.getNom().length();
                int taille = 10;
    
                System.out.printf("       |Pokemon  " + nb_poke);
                nb_poke++;
                for (int i = 0; i <= taille_complet - taille; i++) {
                    System.out.print(" ");
                }
                System.out.print("|    ");
            }
            System.out.println();


    
            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);
                int taille_complet = 16 + pokemon.getNom().length();
                int taille = 9 + pokemon.getType().getNom().length();
    
                System.out.printf("       |Affinite " + pokemon.getType().getNom());
    
                for (int i = 0; i <= taille_complet - taille; i++) {
                    System.out.print(" ");
                }
                System.out.print("|    ");
            }
            System.out.println();



            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);
                
                if (pokemon.getAUtiliserPouvoir() == false){
                int taille_complet = 16 + pokemon.getNom().length();
                int taille = 8 + pokemon.getPouvoirs().getNom().length();
    
                System.out.printf("       |Pouvoir " + pokemon.getPouvoirs().getNom());
    
                for (int i = 0; i <= taille_complet - taille; i++) {
                    System.out.print(" ");
                }
                System.out.print("|    ");
                }
                else{
                    System.out.printf("       |Pouvoir utilisé");
                    int taille_complet = 16 + pokemon.getNom().length();
                    int taille = 15;
                    for (int i = 0; i <= taille_complet - taille; i++) {
                        System.out.print(" ");
                    }
                    System.out.print("|    ");
                }
            }
            System.out.println();


            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);
                int taille_complet = 16 + pokemon.getNom().length();
                int taille = 12;
    

                if (pokemon.getVie()>=100){
                System.out.printf("       |Vie " + pokemon.getVie() +"/"+ pokemon.getVieInitial());
    
                for (int i = 0; i <= taille_complet - taille; i++) {
                    System.out.print(" ");
                }
                }
                else if (10<=pokemon.getVie() && pokemon.getVie()<100){
                    System.out.printf("       |Vie " + pokemon.getVie() +"/"+ pokemon.getVieInitial());
        
                    for (int i = 0; i <= taille_complet - taille +1; i++) {
                        System.out.print(" ");
                    }
                }
                else if (pokemon.getVie()<10){
                    System.out.printf("       |Vie " + pokemon.getVie() +"/"+ pokemon.getVieInitial());
        
                    for (int i = 0; i <= taille_complet - taille +2; i++) {
                        System.out.print(" ");
                    }
                }
                
               


                System.out.print(" |    ");
            }
            System.out.println();


            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);

                if (pokemon.getAttaque()>=10){
                int taille_complet = 16 + pokemon.getNom().length();
                int taille = 11;
    
                System.out.printf("       |Attaque " + pokemon.getAttaque());
    
                for (int i = 0; i <= taille_complet - taille; i++) {
                    System.out.print(" ");
                }
                System.out.print(" |    ");
                }
                else{
                    int taille_complet = 16 + pokemon.getNom().length();
                int taille = 10;
    
                System.out.printf("       |Attaque " + pokemon.getAttaque());
    
                for (int i = 0; i <= taille_complet - taille; i++) {
                    System.out.print(" ");
                }
                System.out.print(" |    ");
                }



            }
            System.out.println();
    

            for (int k = j; k < Math.min(j + 3, listePokemon.size()); k++) {
                Pokemon pokemon = listePokemon.get(k);
    
                System.out.print("       +--------");
    
                for (int i = 0; i <= pokemon.getNom().length(); i++) {
                    System.out.print("-");
                }
    
                System.out.print("--------+    ");
            }
            System.out.println();
    
            // Si ce n'est pas le dernier groupe de trois Pokémon, ajoutez un retour à la ligne
            if (j + 3 < listePokemon.size()) {
                System.out.println();
            }
        }

    }


    public static void clear() {
        try {
            // Détecter le système d'exploitation
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Pour Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Pour Linux et macOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        
        }
    }

    public static void pause() {
        Scanner s = new Scanner(System.in);
        System.out.print("Appuyez sur la touche Entrée pour continuer...");
        s.nextLine();
    }

    public static void afficherMain(List<Pokemon> pokemons) {
        System.out.println("    +-----------------------------------   POKEMON DANS VOTRE MAIN  ------------------------------------------+");
        System.out.println("    |n° | Nom du Pokemon   | Affinité du pokemon   | Point de vie   | Point d'attaque   | Pouvoir du pokemeon |");
        int indice = 1;
        for (Pokemon pokemon : pokemons) {
            
            System.out.print("    | "+ indice+" | "+pokemon.getNom());
            indice+=1;
            for (int i = pokemon.getNom().length()+1; i< 18 ; i++ ){
                System.out.print(" ");
            }

            System.out.print("| "+pokemon.getType().getNom());

            for ( int i = pokemon.getType().getNom().length()+1; i<23 ; i++){
                System.out.print(" ");
            }

            System.out.print("| "+pokemon.getVie());

            int nb= 4;

            if (pokemon.getVie()>=10 && pokemon.getVie()<100 ){ nb = 3;}
            if (pokemon.getVie()<10 ){ nb = 2;}

            for (int i =nb ; i<16 ; i++){
                System.out.print(" ");
            }

            System.out.print("| "+ pokemon.getAttaque());

            for (int i =3 ; i<19 ; i++){
                System.out.print(" ");
            }
            System.out.print("| "+ pokemon.getPouvoirs().getNom());

            for (int i = pokemon.getPouvoirs().getNom().length() ; i<20 ; i++){
                System.out.print(" ");
            }

            System.out.println("|");


        }
        System.out.println("    +---------------------------------------------------------------------------------------------------------+");

    }

    public static void afficherPiocheDefausse( Joueur joueur){
        System.out.println("                             +-------------------+          +------------------+");
       
        System.out.print("                             | Pioche: "+joueur.getSizePioche());

        if(joueur.getSizePioche()>= 10){
            for (int i = 11 ; i<19 ; i++){
                System.out.print(" ");
            }
        }
        else{
            for (int i = 10 ; i<19 ; i++){
                System.out.print(" ");
            }
        }
         System.out.print("|          | Defausse : "+ joueur.getSizeDefausse());

        if (joueur.getSizeDefausse()>=10){
            for (int i = 14 ; i<18 ; i++){
                System.out.print(" ");
            }
        }
        else{
            for (int i = 13 ; i<18 ; i++){
                System.out.print(" ");
            }
        }

        System.out.println("|");
        
        System.out.println("                             +-------------------+          +------------------+");
        System.out.println("");
    }

    public static void affichagePerdu(Joueur joueur_moi){
        String message = 
       "  ____              _        \n" +
       " |  _ \\ ___ _ __ __| |_   _ \n" +
       " | |_) / _ \\ '__/ _` | | | | \n" +
       " |  __/  __/ | | (_| | |_| | \n" +
       " |_|   \\___|_|  \\__,_|\\__,_| \n";

       System.out.println(message);
       System.out.println("Il te reste"+ joueur_moi.getSizeMain()+ " cartes" );
                                           
    }

    public static void affichageGagner(Joueur joueur_moi){
        String message = 
    "    ____                     __   \n" +
    "    / ___| __ _  __ _ _ __   /_/   \n" +
    "   | |  _ / _` |/ _` | '_ \\ / _ \\   \n" +
    "   | |_| | (_| | (_| | | | |  __/   \n" +
    "    \\____|\\__,_|\\__, |_| |_|\\___|  \n" +
    "                |___/            \n" ;

       System.out.println(message);
       System.out.println("Il te reste"+ joueur_moi.getSizeMain()+ " cartes" );
                                           
    }

    public static void affiche_description(List<Pokemon> pokemons1 , List<Pokemon> pokemons2 , List<Pokemon> main){
        List<Pouvoirs> nom = new ArrayList<>();

        for (Pokemon pokemon : pokemons1) {
            if(!nom.contains(pokemon.getPouvoirs())){
                nom.add(pokemon.getPouvoirs());
                System.out.println(pokemon.getPouvoirs().getDescription());
            }
        }
        for (Pokemon pokemon : pokemons2) {
            if(!nom.contains(pokemon.getPouvoirs())){
                nom.add(pokemon.getPouvoirs());
                System.out.println(pokemon.getPouvoirs().getDescription());
            }
        }
        for (Pokemon pokemon : main) {
            if(!nom.contains(pokemon.getPouvoirs())){
                nom.add(pokemon.getPouvoirs());
                System.out.println(pokemon.getPouvoirs().getDescription());
            }
        }

        nom.clear();
    }
}
