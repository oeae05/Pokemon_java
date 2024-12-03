package pouvoirs;

import ErrorManager.PokemonIsTheSame;
import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public class Regeneration implements Pouvoirs{

    public static String[] m_questions = {"Sélectionnez le numéro du Pokemon dont le sort sera réactive: "};
    String m_nom = "Regeneration";
    String m_description= "Regeneration : si le Pokémon choisi a déjà utilisé un pouvoir à utilisation unique, il peut alors l'utiliser une seconde fois.";

    public String getNom(){
        return m_nom;
    }

    @Override
    public String[] getQuestions() {
        return m_questions;
    }

    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonIsTheSame, PokemonNotFound {
        Pokemon vise = terrain.getPokemon(pokemonVise, humain);
        if (vise == lanceur) throw new PokemonIsTheSame();
        vise.setBoolPouvoir(false);
        lanceur.setBoolPouvoir(true);
    }


    @Override
    public String getDescription() {

        return m_description;
    }
}
