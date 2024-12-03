package Jeu;

import Joueurs.Humain;
import Joueurs.Ordinateur;
import console.Affichage;

import java.util.Random;

public class Partie {

    boolean humainJoueur1;
    Humain m_humain;
    Ordinateur m_IA;

    public Partie () {
        Affichage.affichagePokemon();
        Random rnd = new Random();
        humainJoueur1 = rnd.nextBoolean();

        m_humain = new Humain(humainJoueur1);
        m_IA = new Ordinateur(humainJoueur1);

        //Pré-ronde : placement des cartes et pioche
        Round preronde = new Round(m_humain, m_IA, humainJoueur1);
        if (humainJoueur1) {
            System.out.println("Vous êtes le Joueur 1! A vous de jouer en premier...");
            Affichage.pause();
            m_IA.pioche();
            m_IA.place();
            m_humain.pioche();
            preronde.placementPokemons();
        }
        else {
            System.out.println("Vous êtes le Joueur 2! Veuillez placer vos cartes...");
            Affichage.pause();
            m_humain.pioche();
            preronde.placementPokemons();
        }

        while (!finPartie()) {
            Affichage.clear();
            Affichage.affichageRonde();
            Affichage.pause();
            Round r = new Round(m_humain, m_IA, humainJoueur1);
            r.lancer();
        }
        System.out.println("FIN DE PARTIE");
    }





    private boolean finPartie() {
        if (m_humain.getSizeTerrain() == 0 && m_humain.getSizeMain()==0 && m_humain.getSizePioche()==0) {
            Affichage.affichagePerdu(m_humain);
            return true; 
        }
        else if (m_IA.getSizeTerrain() == 0 && m_IA.getSizeMain()==0 && m_IA.getSizePioche()==0) {
            Affichage.affichageGagner(m_humain);
            return true;
        }
        return false;
    }
}
