/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_W03_HuffMan_Codering;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johan Verhoeven <jrh.verhoeven@student.fontys.nl>
 */
public class HuffBoomTest {

    public HuffBoomTest() {
    }

    /**
     * Test of aflezenCode method, of class HuffBoom.
     */
    @Test
    public void testAflezenCode() {
        try {
            System.out.println("aflezenCode");
            HuffBoom instance = new HuffBoom("Bananen");
            String expResult = "1001101101010";
            String result = instance.aflezenCode();
            assertEquals("Geldige code expected", expResult, result);
        } catch (Exception ex) {
            fail("Tekst wordt niet goed gecodeeerd");
        }
        try {
            System.out.println("aflezenCode");
            HuffBoom instance = new HuffBoom(null);
            fail("Waarde null is niet toegestaan");
        } catch (IllegalArgumentException iae) {
            // Expected
        } catch (Exception ex) {
            fail("Waarde null wordt niet gecontroleerd");
        }
        try {
            System.out.println("aflezenCode");
            HuffBoom instance = new HuffBoom("Dit is een € teken");
            fail("€ teken is een ongeldige karakter");
        } catch (IllegalArgumentException iae) {
            // Expected
        } catch (Exception ex) {
            fail("Ongeldige waardes wordt niet gecontroleerd");
        }
    }

    /**
     * Test of controleerCode method, of class HuffBoom.
     */
    @Test
    public void testControleerCode() {
        try {
            System.out.println("controleerCode");
            String code = "1001101101010";
            HuffBoom instance = new HuffBoom("Bananen");;
            boolean expResult = true;
            boolean result = instance.controleerCode(code);
            assertTrue("Code levert niet de juiste tekst op", result);
        } catch (Exception ex) {
            fail("Tekst wordt niet goed gecodeeerd");
        }
        try {
            System.out.println("controleerCode");
            String code = "01001101101010";
            HuffBoom instance = new HuffBoom("Bananen");
            boolean expResult = false;
            boolean result = instance.controleerCode(code);
            assertFalse("Code levert de juiste tekst op", result);
        } catch (Exception ex) {
            fail("Tekst wordt niet goed gecodeeerd");
        }
    }

    @Test
    public void testGetTekst() {
        try {
            System.out.println("getTekst");
            HuffBoom instance = new HuffBoom("L.vis");
            String result = instance.getTekst();
            String expResult = "L.vis";
            assertEquals("Onverwacht tekst ontvangen", expResult, result);
        } catch (Exception ex) {
            fail("Tekst wordt niet goed gecodeeerd");
        }
    }
}
