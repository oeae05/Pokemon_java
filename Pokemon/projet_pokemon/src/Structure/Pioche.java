package Structure;

import java.util.Stack;
import Pokemon.*;


/**
 * Classe Pioche : classe représentant la pioche d'un joueur
 *
 */
public class Pioche {
    private Stack<Pokemon> m_pioche;

    public Pioche(int nbPokemon) {
        m_pioche = new Stack<>();
        for (int i = 0; i < nbPokemon; i++) {
            m_pioche.add(GenerateurPokemon.genPokemon());
        }
    }

    public Pokemon piocher () {
        return m_pioche.pop();
    }

    @Override
    public String toString() {
        String texte = "";
        for (int i = 0; i < m_pioche.size(); i++) {
            texte = texte + m_pioche.get(i).toString() + ", ";
        }
        return texte;
    }

    public int getSize() {
        return m_pioche.size();
    }
}
