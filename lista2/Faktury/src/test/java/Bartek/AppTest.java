package Bartek;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void Artnettobrutto() {
        Artykul art = new Artykul("Piłła","a4_001","szt.",0.23,39.90);
        //sprawdzam czy dziala round
        assertTrue(art.cena_brutto > art.cena_netto && art.cena_brutto == 49.08);
    }



}
