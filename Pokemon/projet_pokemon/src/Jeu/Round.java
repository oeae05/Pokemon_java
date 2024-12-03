package Jeu;

import ErrorManager.*;
import Joueurs.Humain;
import Joueurs.Joueur;
import Joueurs.Ordinateur;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import console.Affichage;
import console.Input;
import console.Output;
import pouvoirs.nul;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Round {

    Humain m_humain;
    Ordinateur m_IA;
    boolean m_humainJoueur1;
    List<String> m_PokemonDejaJoues;
    List<String> m_PokemonDejaPouvoirs;
    Input input = new Input();
    Output output = new Output();
    GrandTerrain m_terrain;

    public Round(Humain humain, Ordinateur IA, boolean humainJoueur1) {
        m_humainJoueur1 = humainJoueur1;
        m_humain = humain;
        m_IA = IA;
        m_PokemonDejaJoues = new ArrayList<>();
        m_PokemonDejaPouvoirs = new ArrayList<>();
        m_terrain = new GrandTerrain(m_humain.getTerrain(), m_IA.getTerrain());
    }

    public void lancer () {
        Affichage.clear();

        if (!m_humainJoueur1) {
            tourIA();
            placementPokemons();
            demandePouvoirs();
            attaquePokemons();
        }
        else {
            placementPokemons();
            rafraichissementConsole();
            demandePouvoirs();
            attaquePokemons();
            tourIA();
        }

        rafraichissementConsole();
    }

    private void tourIA () {
        m_IA.pioche();
        m_IA.place();
        for (Pokemon p: m_IA.getTerrain().getpokemonPoses()) {
            if (m_humain.getSizeTerrain()==0) return;
            m_IA.usePower(p, m_terrain);
            checkDead(m_humain);
            m_IA.attaque(p, m_humain.getTerrain().getpokemonPoses());
            checkDead(m_humain);
            checkDead(m_IA);
        }
    }



    private void demandePouvoirs() {

        while (m_PokemonDejaPouvoirs.size()<3) {
            rafraichissementConsole();

            output.println("Numéro du Pokemon qui doit utiliser son pouvoir (tapez 'Entrée' pour passer): ");

            try {
                int num = input.getInt();
                Pokemon poke = m_humain.getTerrain().getPokemon(num-1);
                if (m_PokemonDejaPouvoirs.contains(poke.getNom()) )throw new PokemonHasAlreadyUsedPower();

                output.println(poke.getPouvoirs().getQuestions()[0]);
                String reponse = input.getString();
                utilisationPouvoirs(poke, reponse);

            }
            catch (PokemonNotFound | PokemonHasAlreadyUsedPower | PokemonHasNoPower | InputIsNotInCorrectFormat e) {
                System.out.println(e.getMessage());
                Affichage.pause();
            }
            catch (InputIsEmpty e) {
                break;
            }
        }
    }

    private void utilisationPouvoirs(Pokemon poke, String reponse) {

        try {
            poke.usePower(reponse, m_terrain, true);
            m_PokemonDejaPouvoirs.add(poke.getNom());
            checkDead(m_IA);
            checkDead(m_humain);
        } catch (PokemonHasNoPower | PokemonIsTheSame | PokemonNotFound | InputIsNotString e) {
            System.out.println(e.getMessage());
            Affichage.pause();
        }
    }


    private void attaquePokemons() {

        m_humain.pioche();
        while (m_PokemonDejaJoues.size() < 3) {
            rafraichissementConsole();
            String poke;
            output.println("Numéro du pokémon qui doit attaquer (tapez sur entrée pour passer) : ");

            try {
                int num = input.getInt() - 1;
                poke = m_humain.getTerrain().getPokemon(num).getNom();
            } catch (PokemonNotFound | InputIsNotInt e) {
                System.out.println(e.getMessage());
                Affichage.pause();
                continue;
            } catch (InputIsEmpty e) {
                break;
            }

            if (m_PokemonDejaJoues.contains(poke))
            {
                try {
                    throw new PokemonHasAlreadyAttacked();
                }
                catch (PokemonHasAlreadyAttacked e) {
                    System.out.println(e.getMessage());
                    Affichage.pause();
                }
            }
            else {
                output.println("Numéro du pokémon que vous voulez attaquer : ");

                try {
                    int num = input.getInt() - 1;
                    m_humain.attaque(num, num, m_IA.getTerrain());
                } catch (PokemonNotFound | InputIsNotInt | InputIsEmpty e) {
                    System.out.println(e.getMessage());
                    Affichage.pause();
                    continue;
                }
                m_PokemonDejaJoues.add(poke);
                checkDead(m_IA);
            }
        }
    }

    public void placementPokemons() {
        while (m_humain.getSizeTerrain() < 3 && m_humain.getSizeMain()!=0) {
            rafraichissementConsole();
            output.println("Numéro du pokémon qui doit être placé (1 par défaut): ");
            int num;

            try {
                num = input.getInt() - 1;
            }
            catch (InputIsNotInt e) {
                output.println(e.getMessage());
                continue;
            }
            catch (InputIsEmpty e) {
                num = 0;
            }

            try {
                m_humain.place(num);
            }
            catch (PokemonNotFound e) {
                System.out.println(e.getMessage());
                Affichage.pause();
            }

        }
    }

    public void rafraichissementConsole() {
        Affichage.clear();
        Affichage.affichageterrainIA();
        Affichage.afficherPiocheDefausse(m_IA);
        Affichage.afficherPokemon(m_IA.getTerrain());
        Affichage.monTerrain();
        Affichage.afficherPokemon(m_humain.getTerrain());
        Affichage.afficherPiocheDefausse(m_humain);
        Affichage.afficherMain(m_humain.getMain().donneMain());
        System.out.println("");
        System.out.println("");
        Affichage.affiche_description(m_humain.getMain().donneMain(),m_humain.getTerrain().getpokemonPoses(),m_IA.getTerrain().getpokemonPoses());
        System.out.println("");
        System.out.println("");

    }


    private void checkDead (Joueur joueur) {
        List<Pokemon> terrain = joueur.getTerrain().getpokemonPoses();
        for (int i = 0; i < terrain.size(); i++) {
            Pokemon poke = terrain.get(i);


            if (poke.getVie()==0) {
                System.out.println(poke);
                try {
                    joueur.defausse(poke);
                }
                catch (PokemonNotFound ignored) {
                }
            }
        }
    }
}
