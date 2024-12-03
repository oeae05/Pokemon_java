package Joueurs;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.Terrain;

public class Humain extends Joueur {

    public Humain(boolean joueur1) {
        super(joueur1);
    }

    public void attaque(int pokemon, int pokemonAdverse, Terrain terrainAdverse) throws PokemonNotFound {
        Pokemon poke = m_terrain.getPokemon(pokemon);
        Pokemon pokeAdverse = terrainAdverse.getPokemon(pokemonAdverse);
        poke.attaque(pokeAdverse);
    }

    public void place(int index) throws PokemonNotFound {
        Pokemon poke = m_main.choisir(index);
        m_terrain.poser(poke);
    }
}
