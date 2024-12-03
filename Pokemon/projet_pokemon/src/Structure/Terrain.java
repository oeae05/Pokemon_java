package Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;

public class Terrain {
    ArrayList<Pokemon> m_pokemonPoses;

    public Terrain() {
        m_pokemonPoses = new ArrayList<>();
    }

    public void poser(Pokemon pokemon) {
        m_pokemonPoses.add(pokemon);
    }

    public Pokemon retirer (Pokemon pokemon) throws PokemonNotFound {
        for (Pokemon p: m_pokemonPoses) {
            if (p.equals(pokemon)) {
                m_pokemonPoses.remove(p);
                return p;
            }

        }
        throw new PokemonNotFound();
    }

    public List<Pokemon> getpokemonPoses() {
        List<Pokemon> ret = new ArrayList<>();
        for (Pokemon p: m_pokemonPoses) {
            ret.add(p);
        }
        return ret;
    }

    public Pokemon getPokemon(int index) throws PokemonNotFound {
        if (index<0 || index>=this.getSize()) throw new PokemonNotFound();
        else return m_pokemonPoses.get(index);
    }

    public Pokemon  getPokemon(String nom) throws PokemonNotFound {
        for (Pokemon p: m_pokemonPoses) {
            if (p.getNom().equals(nom)) return p;
        }
        throw new PokemonNotFound();
    }

    public int getSize() {
        return m_pokemonPoses.size();
    }

    @Override
    public String toString() {
        String texte = "";
        for (int i = 0; i < getpokemonPoses().size()+1; i++) {
            texte = texte + m_pokemonPoses.get(i).toString() + ", ";
        }
        return texte;
    }
}
