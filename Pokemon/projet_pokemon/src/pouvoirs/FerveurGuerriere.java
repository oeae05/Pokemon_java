package pouvoirs;

import ErrorManager.PokemonHasNoPower;
import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public class FerveurGuerriere implements Pouvoirs{
    Pokemon m_pokeAmi;
    public static String[] m_questions = {"Sélectionnez le numéro du Pokemon dont l'attaque doit être augmentée: "};
    String m_nom = "Guerriere";
    String m_description = "Guerriere : les attaques de celui-ci infligent 10 dégâts de plus ";

    public String getNom(){
        return m_nom;
    }

    @Override
    public String[] getQuestions() {
        return m_questions;
    }

    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonNotFound {
        Pokemon vise = terrain.getPokemon(pokemonVise, humain);
        int attaqueInitiale = vise.getAttaque();
        vise.setAttaque(attaqueInitiale+10);
        lanceur.setBoolPouvoir(true);
    }

    @Override
    public String getDescription() {
        return m_description;
    }
}
