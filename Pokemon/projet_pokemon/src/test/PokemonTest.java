package test;
import org.junit.Test;

import Pokemon.*;
import affinite.*;

import pouvoirs.*;

import static org.junit.Assert.assertEquals;



public class PokemonTest {

    @Test
    public void testGetters() {
        Pokemon poke = new Pokemon("Pikachu", 100, 50, new TypeFeu(), new Ether());

        assertEquals("Pikachu", poke.getNom());
        assertEquals(100, poke.getVie());
        assertEquals(50, poke.getAttaque());
        assertEquals(new TypeFeu().getClass(), poke.getType().getClass());
        assertEquals(false, poke.getAUtiliserPouvoir());
    }

    @Test
    public void testSetters() {
        Pokemon poke = new Pokemon("Pikachu", 100, 50, new TypeFeu(), new  Peur());

        poke.setAttaque(60);
        assertEquals(60, poke.getAttaque());

        poke.setVie(90);
        assertEquals(90, poke.getVie());

        poke.setBoolPouvoir(true);
        assertEquals(true, poke.getAUtiliserPouvoir());
    }

    @Test
    public void testToString() {
        Pokemon poke = new Pokemon("Pikachu", 100, 50, new TypeFeu(), new Regeneration());
        String expectedString = "Pikachu: <100, 50,Feu>";

        assertEquals(expectedString, poke.toString());
    }
}

