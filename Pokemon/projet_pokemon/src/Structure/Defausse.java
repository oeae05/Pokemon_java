package Structure;

import java.util.Stack;
import Pokemon.Pokemon;

/**
 * Classe Defausse : classe permettant de gérer la défausse d'un joueur
 *
 */
public class Defausse {
    private final Stack<Pokemon> m_pokemonDefausses;

    /**
     * Defausse : Constructeur de la classe Defausse.
     *
     */
    public Defausse() {
        m_pokemonDefausses = new Stack<>();
    }


    /**
     * Constructeur de la classe Pokemon.
     *
     * @param pokemon Pokemon à placer dans la pile de défausse.
     *
     */
    public void defaussser(Pokemon pokemon) {
        m_pokemonDefausses.add(pokemon);
    }

    public int getSize(){
        return m_pokemonDefausses.size();
    }

    /**
     * Méthode toString
     *
     * @return String des infos de l'instance.
     */
    @Override
    public String toString() {
        String texte = "";
        for (int i = 0; i < m_pokemonDefausses.size(); i++) {
            texte = texte + m_pokemonDefausses.get(i).toString() + ", ";
        }
        return texte;
    }
}
