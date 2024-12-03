package pouvoirs;

import ErrorManager.*;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public interface Pouvoirs {
    public abstract void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonHasNoPower, PokemonIsTheSame, PokemonNotFound, InputIsNotString;
    public abstract String getNom();
    public abstract String getDescription();

    public abstract String[] getQuestions() throws PokemonHasNoPower;
}
