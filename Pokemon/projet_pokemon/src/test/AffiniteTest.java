package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import Structure.*;
import pouvoirs.*;
import Pokemon.Pokemon;
import Joueurs.*;
import Jeu.*;
import affinite.*;
public class AffiniteTest {

    @Test
    public void testAffiniteTerreAvecTous() {
        Pokemon pokeTerre = new Pokemon("TerreMon", 100, 20, new TypeTerre(), new nul());
        Pokemon pokeEau = new Pokemon("EauMon", 100, 20, new TypeEau(), new nul());
        Pokemon pokeFeu = new Pokemon("FeuMon", 100, 20, new TypeFeu(), new nul());
        Pokemon pokeAir = new Pokemon("AirMon", 100, 20, new TypeAir(), new nul());
        Pokemon pokeEther = new Pokemon("EtherMon", 100, 20, new pouvoirEther(), new nul());
        Pokemon pokePlombs = new Pokemon("PlombsMon", 100, 20, new pouvoirPlombs(), new nul());

        assertTrue(pokeTerre.getType().aUnAvantageSur(pokeEau.getType()));
        assertFalse(pokeTerre.getType().aUnAvantageSur(pokeFeu.getType()));
        assertFalse(pokeTerre.getType().aUnAvantageSur(pokeAir.getType()));
        assertFalse(pokeTerre.getType().aUnAvantageSur(pokeEther.getType()));
        assertTrue(pokeTerre.getType().aUnAvantageSur(pokePlombs.getType()));


        assertFalse(pokeTerre.getType().aUnDesavantageSur(pokeEau.getType()));
        assertFalse(pokeTerre.getType().aUnDesavantageSur(pokeFeu.getType()));
        assertTrue(pokeTerre.getType().aUnDesavantageSur(pokeAir.getType()));
        assertTrue(pokeTerre.getType().aUnDesavantageSur(pokeEther.getType()));
        assertFalse(pokeTerre.getType().aUnDesavantageSur(pokePlombs.getType()));
    }

    @Test
    public void testAffiniteEauAvecTous() {
        Pokemon pokeTerre = new Pokemon("TerreMon", 100, 20, new TypeTerre(), new nul());
        Pokemon pokeEau = new Pokemon("EauMon", 100, 20, new TypeEau(), new nul());
        Pokemon pokeFeu = new Pokemon("FeuMon", 100, 20, new TypeFeu(), new nul());
        Pokemon pokeAir = new Pokemon("AirMon", 100, 20, new TypeAir(), new nul());
        Pokemon pokeEther = new Pokemon("EtherMon", 100, 20, new pouvoirEther(), new nul());
        Pokemon pokePlombs = new Pokemon("PlombsMon", 100, 20, new pouvoirPlombs(), new nul());

        assertTrue(pokeEau.getType().aUnAvantageSur(pokeFeu.getType()));
        assertFalse(pokeEau.getType().aUnAvantageSur(pokeAir.getType()));
        assertFalse(pokeEau.getType().aUnAvantageSur(pokeTerre.getType()));
        assertFalse(pokeEau.getType().aUnAvantageSur(pokeEther.getType()));
        assertTrue(pokeEau.getType().aUnAvantageSur(pokePlombs.getType()));



        assertFalse(pokeEau.getType().aUnDesavantageSur(pokeFeu.getType()));
        assertFalse(pokeEau.getType().aUnDesavantageSur(pokeAir.getType()));
        assertTrue(pokeEau.getType().aUnDesavantageSur(pokeTerre.getType()));
        assertTrue(pokeEau.getType().aUnDesavantageSur(pokeEther.getType()));
        assertFalse(pokeEau.getType().aUnDesavantageSur(pokePlombs.getType()));
    }

    @Test
    public void testAffiniteFeuAvecTous() {
        Pokemon pokeTerre = new Pokemon("TerreMon", 100, 20, new TypeTerre(), new nul());
        Pokemon pokeEau = new Pokemon("EauMon", 100, 20, new TypeEau(), new nul());
        Pokemon pokeFeu = new Pokemon("FeuMon", 100, 20, new TypeFeu(), new nul());
        Pokemon pokeAir = new Pokemon("AirMon", 100, 20, new TypeAir(), new nul());
        Pokemon pokeEther = new Pokemon("EtherMon", 100, 20, new pouvoirEther(), new nul());
        Pokemon pokePlombs = new Pokemon("PlombsMon", 100, 20, new pouvoirPlombs(), new nul());

        assertTrue(pokeFeu.getType().aUnAvantageSur(pokeAir.getType()));
        assertFalse(pokeFeu.getType().aUnAvantageSur(pokeEau.getType()));
        assertFalse(pokeFeu.getType().aUnAvantageSur(pokeTerre.getType()));
        assertFalse(pokeFeu.getType().aUnAvantageSur(pokeEther.getType()));
        assertTrue(pokeFeu.getType().aUnAvantageSur(pokePlombs.getType()));


        assertFalse(pokeFeu.getType().aUnDesavantageSur(pokeAir.getType()));
        assertTrue(pokeFeu.getType().aUnDesavantageSur(pokeEau.getType()));
        assertFalse(pokeFeu.getType().aUnDesavantageSur(pokeTerre.getType()));
        assertTrue(pokeFeu.getType().aUnDesavantageSur(pokeEther.getType()));
        assertFalse(pokeFeu.getType().aUnDesavantageSur(pokePlombs.getType()));
    }



    @Test
    public void testAffiniteAirAvecTous() {
        Pokemon pokeTerre = new Pokemon("TerreMon", 100, 20, new TypeTerre(), new nul());
        Pokemon pokeEau = new Pokemon("EauMon", 100, 20, new TypeEau(), new nul());
        Pokemon pokeFeu = new Pokemon("FeuMon", 100, 20, new TypeFeu(), new nul());
        Pokemon pokeAir = new Pokemon("AirMon", 100, 20, new TypeAir(), new nul());
        Pokemon pokeEther = new Pokemon("EtherMon", 100, 20, new pouvoirEther(), new nul());
        Pokemon pokePlombs = new Pokemon("PlombsMon", 100, 20, new pouvoirPlombs(), new nul());

        assertTrue(pokeAir.getType().aUnAvantageSur(pokeTerre.getType()));
        assertFalse(pokeAir.getType().aUnAvantageSur(pokeFeu.getType()));
        assertFalse(pokeAir.getType().aUnAvantageSur(pokeEau.getType()));
        assertFalse(pokeAir.getType().aUnAvantageSur(pokeEther.getType()));
        assertTrue(pokeAir.getType().aUnAvantageSur(pokePlombs.getType()));


        assertFalse(pokeAir.getType().aUnDesavantageSur(pokeTerre.getType()));
        assertTrue(pokeAir.getType().aUnDesavantageSur(pokeFeu.getType()));
        assertFalse(pokeAir.getType().aUnDesavantageSur(pokeEau.getType()));
        assertTrue(pokeAir.getType().aUnDesavantageSur(pokeEther.getType()));
        assertFalse(pokeAir.getType().aUnDesavantageSur(pokePlombs.getType()));
    }

    @Test
    public void testAffiniteEtherAvecTous() {
        Pokemon pokeTerre = new Pokemon("TerreMon", 100, 20, new TypeTerre(), new nul());
        Pokemon pokeEau = new Pokemon("EauMon", 100, 20, new TypeEau(), new nul());
        Pokemon pokeFeu = new Pokemon("FeuMon", 100, 20, new TypeFeu(), new nul());
        Pokemon pokeAir = new Pokemon("AirMon", 100, 20, new TypeAir(), new nul());
        Pokemon pokeEther = new Pokemon("EtherMon", 100, 20, new pouvoirEther(), new nul());
        Pokemon pokePlombs = new Pokemon("PlombsMon", 100, 20, new pouvoirPlombs(), new nul());

        assertTrue(pokeEther.getType().aUnAvantageSur(pokeTerre.getType()));
        assertTrue(pokeEther.getType().aUnAvantageSur(pokeEau.getType()));
        assertTrue(pokeEther.getType().aUnAvantageSur(pokeFeu.getType()));
        assertTrue(pokeEther.getType().aUnAvantageSur(pokeAir.getType()));
        assertTrue(pokeEther.getType().aUnAvantageSur(pokePlombs.getType()));


        assertFalse(pokeEther.getType().aUnDesavantageSur(pokeTerre.getType()));
        assertFalse(pokeEther.getType().aUnDesavantageSur(pokeEau.getType()));
        assertFalse(pokeEther.getType().aUnDesavantageSur(pokeFeu.getType()));
        assertFalse(pokeEther.getType().aUnDesavantageSur(pokeAir.getType()));
        assertFalse(pokeEther.getType().aUnDesavantageSur(pokePlombs.getType()));
    }

    @Test
    public void testAffinitePlombsAvecTous() {
        Pokemon pokeTerre = new Pokemon("TerreMon", 100, 20, new TypeTerre(), new nul());
        Pokemon pokeEau = new Pokemon("EauMon", 100, 20, new TypeEau(), new nul());
        Pokemon pokeFeu = new Pokemon("FeuMon", 100, 20, new TypeFeu(), new nul());
        Pokemon pokeAir = new Pokemon("AirMon", 100, 20, new TypeAir(), new nul());
        Pokemon pokeEther = new Pokemon("EtherMon", 100, 20, new pouvoirEther(), new nul());
        Pokemon pokePlombs = new Pokemon("PlombsMon", 100, 20, new pouvoirPlombs(), new nul());

        assertFalse(pokePlombs.getType().aUnAvantageSur(pokeTerre.getType()));
        assertFalse(pokePlombs.getType().aUnAvantageSur(pokeEau.getType()));
        assertFalse(pokePlombs.getType().aUnAvantageSur(pokeFeu.getType()));
        assertFalse(pokePlombs.getType().aUnAvantageSur(pokeAir.getType()));
        assertFalse(pokePlombs.getType().aUnAvantageSur(pokeEther.getType()));


        assertTrue(pokePlombs.getType().aUnDesavantageSur(pokeTerre.getType()));
        assertTrue(pokePlombs.getType().aUnDesavantageSur(pokeEau.getType()));
        assertTrue(pokePlombs.getType().aUnDesavantageSur(pokeFeu.getType()));
        assertTrue(pokePlombs.getType().aUnDesavantageSur(pokeAir.getType()));
        assertTrue(pokePlombs.getType().aUnDesavantageSur(pokeEther.getType()));
    }
}