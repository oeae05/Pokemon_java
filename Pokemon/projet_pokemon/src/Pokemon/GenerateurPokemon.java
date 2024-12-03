package Pokemon;
import affinite.*;
import pouvoirs.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * Classe GenerateurPokemon : classe statique permettant de générer aléatoirement un pokemon
 *
 */
public class GenerateurPokemon {

    private static List<String> m_pokeList = new LinkedList<String>(
            Arrays.asList("Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Jigglypuff",
                    "Snorlax", "Gengar", "Mewtwo", "Eevee", "Magikarp",
                    "Psyduck", "Meowth", "Charizard", "Blastoise", "Venusaur",
                    "Raichu", "Dragonite", "Gyarados", "Gardevoir", "Lugia",
                    "Mew", "Celebi", "Zapdos", "Moltres", "Articuno",
                    "Machamp", "Golem", "Alakazam", "Gengar", "Gyarados",
                    "Rhydon", "Lapras", "Arcanine", "Scyther", "Sandslash",
                    "Nidoking", "Nidoqueen", "Vaporeon", "Jolteon", "Flareon",
                    "Espeon", "Umbreon", "Leafeon", "Glaceon"));
    private static TypePokemon[] m_types = {new TypeTerre(), new TypeEau(), new TypeFeu(), new TypeAir()};
    private static Pouvoirs[] m_Pouvoirs = {new FerveurGuerriere(), new Ether() , new nul() , new Peur() , new Plombs() ,
            new Regeneration(), new SoinTotal() , new Usurpation(), new Kamikaze()};

    /**
     * Méthode statique genPokemon : méthode qui génère aléatoirement un Pokemon avec:
     *  - un nom
     *  - une valeur de vie : comprise entre 100 et 200 et multiple de 10
     *  - une valeur d'attaque : comprise entre 10 et 40 et multiple de 10
     *
     * @return le pokemon généré
     */

    public static Pokemon genPokemon() {

        // Génération d'un nombre aléatoire compris entre 0 et la taille de m_pokeList-1
        // pour le nom de pokemon
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(m_pokeList.size());
        String rndNom = m_pokeList.get(rndIndex);

        m_pokeList.remove(rndIndex);

        // Génération aléatoire de la vie et l'attaque du pokemon
        int rndVie = (rnd.nextInt(11) + 10) * 10;
        int rndAttaque = (rnd.nextInt(4) + 1) * 10;

        // Instanciation et retour du pokemon
        TypePokemon rndType = m_types[rnd.nextInt(m_types.length)];
        Pouvoirs rndPouvoir = m_Pouvoirs[rnd.nextInt(m_Pouvoirs.length)];

        Pokemon poke = new Pokemon(rndNom, rndVie, rndAttaque, rndType, rndPouvoir);
        return poke;
    }
}
