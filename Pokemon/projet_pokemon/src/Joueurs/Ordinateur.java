package Joueurs;

import ErrorManager.InputIsNotString;
import ErrorManager.PokemonHasNoPower;
import ErrorManager.PokemonIsTheSame;
import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ordinateur extends Joueur {

    public Ordinateur(boolean joueur1) {
        super(joueur1);
        place();
    }


    public void place() {
        int nbPokemons = m_terrain.getpokemonPoses().size();
        for (int i = 0; i<3- nbPokemons; i++) {

            m_terrain.poser(m_main.choisir());
        }
    }

    public void usePower(Pokemon p, GrandTerrain terrain) {
        Random rnd = new Random();
        int index = rnd.nextInt(3);
        try {
            p.usePower(Integer.toString(index), terrain, false);
        }
        catch (PokemonNotFound | PokemonIsTheSame e) {
            usePower(p, terrain);
        }
        catch (InputIsNotString | PokemonHasNoPower ignored) {
        }
    }

    public void attaque(Pokemon p, List<Pokemon> pokemonsAdverse) {

        List<Pokemon> pokemonsSusceptibles = new ArrayList<>();

        for (Pokemon p2 : pokemonsAdverse) {
            if (p.getType().aUnAvantageSur(p2.getType())) pokemonsSusceptibles.add(p2);
        }
        if (pokemonsSusceptibles.size() == 1) {
            p.attaque(pokemonsSusceptibles.get(0));
            return;
        }

        Pokemon pFaible;
        if (pokemonsSusceptibles.size() > 1) {
            pFaible = trouverPokemonFaible(pokemonsSusceptibles);
            if (pFaible != null) p.attaque(pFaible);
            else {
                Pokemon pokeRandom = trouverRandom(pokemonsSusceptibles);
                p.attaque(pokeRandom);
            }
        }
        else {

            pFaible = trouverPokemonFaible(pokemonsAdverse);
            if (pFaible != null) p.attaque(pFaible);
            else {
                Pokemon pokeRandom = trouverRandom(pokemonsAdverse);
                p.attaque(pokeRandom);
            }
        }


    }

    private Pokemon trouverRandom(List<Pokemon> listePokemons) {
        Random random = new Random();
        Pokemon p = listePokemons.get(random.nextInt(listePokemons.size()));
        return p;
    }

    private Pokemon trouverPokemonFaible(List<Pokemon> listePokemons) {
        int minVie = listePokemons.get(0).getVie();
        Pokemon  pFaible = listePokemons.get(0);
        boolean unique = false;

        for (Pokemon p2 : listePokemons) {
            if (p2.getVie()<minVie) {
                minVie = p2.getVie();
                pFaible = p2;
            }
            if (p2.getVie() == minVie) unique = false;
            else unique = true;
        }
        if (unique) return pFaible;
        else return null;
    }


}
