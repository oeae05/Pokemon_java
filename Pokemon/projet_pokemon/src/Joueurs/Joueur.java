package Joueurs;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.Defausse;
import Structure.MainJoueur;
import Structure.Pioche;
import Structure.Terrain;

import java.util.List;

public abstract class Joueur {
    protected Pioche m_pioche;
    protected Terrain m_terrain;
    protected Defausse m_defausse;
    protected MainJoueur m_main;

    public Joueur(boolean joueur1) {
        if (joueur1) m_pioche = new Pioche(20);
        else m_pioche = new Pioche(21);
        m_terrain = new Terrain();
        m_defausse = new Defausse();
        m_main = new MainJoueur();
        pioche();
    }



    public void pioche() {
        m_main.remplir(m_pioche);
    }

    public void defausse(Pokemon poke) throws PokemonNotFound {
        Pokemon pokemon = m_terrain.retirer(poke);
        m_defausse.defaussser(pokemon);
    }


    public Terrain getTerrain() {
        return m_terrain;
    }

    public MainJoueur getMain() {
        return m_main;
    }

    public int getSizeTerrain() {
        return m_terrain.getSize();
    }

    public int getSizeMain() {
        return m_main.getSize();
    }

    public int getSizePioche() {
        return m_pioche.getSize();
    }

    public int getSizeDefausse(){
        return m_defausse.getSize();
    }

    @Override
    public String toString() {
        String text = m_main.toString() + "\n" + m_pioche + "\n" + m_terrain + "\n" + m_defausse;
        return text;
    }
}
