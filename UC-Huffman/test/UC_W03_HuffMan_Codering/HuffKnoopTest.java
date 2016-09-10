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
public class HuffKnoopTest {

    private HuffBoom huffBoom = new HuffBoom("Huffman codering");

    public HuffKnoopTest() {
    }

    /**
     * Test of preOrderToString method, of class HuffKnoop.
     */
    @Test
    public void testPreOrderToString() {
        try {
            System.out.println("preOrderToString");
            HuffKnoop instance = huffBoom.getHuffBoom();
            String expResult = "00001101100110110011001101";
            String result = instance.preOrderToString();
            assertEquals("Onverwacht resultaat", expResult, result);
        } catch (Exception ex) {
            fail("Onverwacht fout");
        }
    }

    /**
     * Test of postOrderToString method, of class HuffKnoop.
     */
    @Test
    public void testPostOrderToString() {
        try {
            System.out.println("postOrderToString");
            HuffKnoop instance = huffBoom.getHuffBoom();
            String expResult = "01001100100111001001001111";
            String result = instance.postOrderToString();
            assertEquals(expResult, result);
            assertEquals("Onverwacht resultaat", expResult, result);
        } catch (Exception ex) {
            fail("Onverwacht fout");
        }
    }

    /**
     * Test of codeerTekst method, of class HuffKnoop.
     */
    @Test
    public void testCodeerTekst() {
        try {
            System.out.println("codeerTekst");
            String tekst = "Fontys Hogescholen";
            HuffKnoop instance = huffBoom.getHuffBoom();
            String expResult = "011110100100011011111000001111101110001101";
            String result = instance.codeerTekst(tekst);
            assertEquals("Onverwacht resultaat", expResult, result);
        } catch (Exception ex) {
            fail("Onverwacht fout");
        }
    }

    /**
     * Test of codeerKarakter method, of class HuffKnoop.
     */
    @Test
    public void testCodeerKarakter() {
        try {
            System.out.println("codeerKarakter");
            char zoekKarakter = 'f';
            HuffKnoop instance = huffBoom.getHuffBoom();
            String expResult = "100";
            String result = instance.codeerKarakter(zoekKarakter);
            assertEquals("Onverwacht resultaat", expResult, result);
        } catch (Exception ex) {
            fail("Onverwacht fout");
        }
    }

    /**
     * Test of decodeerCode method, of class HuffKnoop.
     */
    @Test
    public void testDecodeerCode() {
        try {
            System.out.println("decodeerCode");
            String code = "001101011001000110111010100101111011100000001010011011011100";
            HuffKnoop instance = huffBoom.getHuffBoom();
            String expResult = "Huffman codering";
            String result = instance.decodeerCode(code);
            assertEquals("Onverwacht resultaat", expResult, result);
        } catch (Exception ex) {
            fail("Onverwacht fout");
        }
    }

    /**
     * Test of compareTo method, of class HuffKnoop.
     */
    @Test
    public void testCompareTo() {
        try {
            System.out.println("compareTo");
            HuffKnoop o = new HuffKnoop();
            o.frequentie = 3;
            o.karakter = 'a';
            HuffKnoop instance = new HuffKnoop();
            o.frequentie = 5;
            instance.karakter = 'b';
            int expResult = -1;
            int result = instance.compareTo(o);
            assertEquals("Onverwacht resultaat", expResult, result);
        } catch (Exception ex) {
            fail("Onverwacht fout");
        }
    }

    /**
     * Test of equalsTo method, of class HuffKnoop.
     */
    @Test
    public void testEqualsTo() {
        try {
            System.out.println("equalsTo");
            char c = 'e';
            HuffKnoop instance = new HuffKnoop();
            instance.karakter = 'e';
            boolean expResult = true;
            boolean result = instance.equalsTo(c);
            assertEquals("Onverwacht resultaat", expResult, result);
        } catch (Exception ex) {
            fail("Onverwacht fout");
        }
    }

}
