package Structure;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;

public class GrandTerrain {

    Terrain m_terrainHumain;
    Terrain m_terrainIA;

    public GrandTerrain(Terrain terrainHumain, Terrain terrainIA) {
        m_terrainHumain = terrainHumain;
        m_terrainIA = terrainIA;
    }

    public Pokemon getPokemon(String pokemon, boolean terrainHumain) throws PokemonNotFound {
        Terrain terrain;
        if (terrainHumain) {terrain = m_terrainHumain;
        }
        else {terrain = m_terrainIA;
        }

        return terrain.getPokemon(Integer.parseInt(pokemon)-1);
    }

    public Pokemon getPokemon(String pokemon) throws PokemonNotFound {


        try {
            return m_terrainHumain.getPokemon(pokemon);
        } catch (PokemonNotFound e) {
            return m_terrainIA.getPokemon(pokemon);
        }
    }
}
