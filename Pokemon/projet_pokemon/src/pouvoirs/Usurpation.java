package pouvoirs;

import ErrorManager.InputIsNotString;
import ErrorManager.PokemonIsTheSame;
import ErrorManager.PokemonNotFound;
import ErrorManager.TerrainNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public class Usurpation implements Pouvoirs{

    public static String[] m_questions = {"Entrez le nom du Pokemon dont vous voulez voler le pouvoir: "};
    String m_nom = "Usurpation";
    String m_description = "Usurpation : Vole le pouvoir du pokémon choisit.";


    public String getNom(){
        return m_nom;
    }

    @Override
    public String[] getQuestions() {
        return m_questions;
    }

    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonIsTheSame, PokemonNotFound, InputIsNotString {
        if (pokemonVise.length()==1) throw new InputIsNotString();
        Pokemon vise = terrain.getPokemon(pokemonVise);
        if (lanceur == vise) throw new PokemonIsTheSame();
        lanceur.setPouvoir(vise.getPouvoirs());
    }

    @Override
    public String getDescription() {
        return m_description;
    }

}