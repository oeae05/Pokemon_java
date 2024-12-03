package Structure;

import java.util.ArrayList;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;


/**
 * Classe MainJoueur : classe modélisant la main d'un joueur.
 *
 */
public class MainJoueur {
    private ArrayList<Pokemon> m_main;

    /**
     * MainJoueur : Constructeur de la classe MainJoueur.
     *
     */
    public MainJoueur() {
        m_main = new ArrayList<>();
    }

    /**
     * Méthode remplir : remplit la main du joueur jusqu'à ce qu'il ait 5 pokemons en main
     *
     * @param deck : Pioche du joueur à partir de laquelle il faut piocher
     */
    public void remplir (Pioche deck) {
        while (m_main.size() < 5 && deck.getSize()>0) {
            m_main.add(deck.piocher());
        }
    }

    public Pokemon choisir() {
        Pokemon poke = m_main.get(0);
        m_main.remove(0);
        return poke;
    }


    /**
     * Méthode choisir : sélectionne un Pokemon dans la main.
     *
     * @param index : index du Pokemon à sélectionner.
     * @return le Pokemon.
     */
    public Pokemon choisir(int index) throws PokemonNotFound {
        if (index >= this.getSize() || index < 0) throw new PokemonNotFound();
        else {
            return m_main.remove(index);
        }
    }

    public int getSize () {
        return m_main.size();
    }

    public ArrayList<Pokemon> donneMain(){
        return m_main;
    }


    /**
     * Méthode toString
     *
     * @return String des infos de l'instance.
     */
    @Override
    public String toString() {
        String texte = "";
        for (int i = 0; i < m_main.size(); i++) {
            texte = texte + m_main.get(i).toString() + ", ";
        }
        return texte;
    }
}
