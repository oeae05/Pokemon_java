package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import Structure.*;
import pouvoirs.*;
import Pokemon.*;
import Joueurs.*;
import Jeu.*;
import affinite.*;


public class PouvoirsTest {

    @Test
    public void testEtherUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 100, 20, new TypeFeu(), new Ether());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1 = new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain2.poser(poke2);

        assertDoesNotThrow(() -> poke1.usePower("1", terrain, true)); // Le pouvoir Ether est utilisé sans exception
        assertEquals("Ether", poke1.getType().getNom()); // Le type de Pikachu est changé en Ether
    }

    @Test
    public void testFerveurGuerriereUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 100, 20, new TypeFeu(), new FerveurGuerriere());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1 = new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain1.poser(poke2);

        assertDoesNotThrow(() -> poke1.usePower("2", terrain, true)); // Le pouvoir Ferveur Guerrière est utilisé sans exception
        assertEquals(25, poke2.getAttaque()); // L'attaque de Bulbizarre est augmentée de 10 points
    }

    @Test
    public void testKamikazeUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 100, 20, new TypeFeu(), new Kamikaze());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1 = new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain2.poser(poke2);

        assertDoesNotThrow(() -> poke1.usePower("1", terrain, true)); // Le pouvoir Kamikaze est utilisé sans exception
        assertEquals(0, poke1.getVie()); // La vie de Pikachu est réduite à 0
        assertEquals(0, poke2.getVie()); // La vie de Bulbizarre est réduite à 0
    }

    @Test
    public void testPeurUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 100, 20, new TypeFeu(), new Peur());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1 = new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain2.poser(poke2);

        assertDoesNotThrow(() -> poke1.usePower("1", terrain, true)); // Le pouvoir Peur est utilisé sans exception
        assertEquals(5, poke2.getAttaque()); // L'attaque de Bulbizarre est réduite de 10 points
    }

    @Test
    public void testPlombsUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 100, 20, new TypeFeu(), new Plombs());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1 = new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain2.poser(poke2);

        assertDoesNotThrow(() -> poke1.usePower("1", terrain, true)); // Le pouvoir Plombs est utilisé sans exception
        assertEquals(" Plombs", poke2.getType().getNom()); // Le type de Bulbizarre est changé en Plombs
    }

    @Test
    public void testRegenerationUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 100, 20, new TypeFeu(), new Regeneration());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1 = new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain1.poser(poke2);

        poke2.setBoolPouvoir(false); // Réinitialisation du pouvoir de Bulbizarre

        assertDoesNotThrow(() -> poke1.usePower("2", terrain, true)); // Le pouvoir Régénération est utilisé sans exception
        assertTrue(poke1.getAUtiliserPouvoir()); // Pikachu a utilisé son pouvoir
        assertFalse(poke2.getAUtiliserPouvoir()); // Bulbizarre n'a pas utilisé son pouvoir
    }

    @Test
    public void testSoinTotalUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 50, 20, new TypeFeu(), new SoinTotal());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1 = new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain2.poser(poke2);
        poke2.attaque(poke1);       //Test si attaque fonctionne correctement

        assertEquals(35, poke1.getVie()); 
        assertDoesNotThrow(() -> poke1.usePower("1", terrain, true)); // Le pouvoir Soin Total est utilisé sans exception
        assertEquals(50, poke1.getVie()); // Pikachu a récupéré toute sa vie
    }



    @Test
    public void testUsurpationUse() {
        Pokemon poke1 = new Pokemon("Pikachu", 100, 20, new TypeFeu(), new Usurpation());
        Pokemon poke2 = new Pokemon("Bulbizarre", 100, 15, new TypeTerre(), new Plombs());
        Terrain terrain1= new Terrain();
        Terrain terrain2 = new Terrain();
        GrandTerrain terrain = new GrandTerrain(terrain1, terrain2);
        terrain1.poser(poke1);
        terrain2.poser(poke2);

        assertDoesNotThrow(() -> poke1.usePower("Bulbizarre", terrain, true)); // Le pouvoir Usurpation est utilisé sans exception
        assertEquals(poke2.getPouvoirs(), poke1.getPouvoirs()); // Pikachu a maintenant le même pouvoir que Bulbizarre
    }
}
