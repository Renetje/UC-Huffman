/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_W03_HuffMan_Codering;

/**
 *
 * @author Johan Verhoeven <jrh.verhoeven@student.fontys.nl>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String tekst = "Huffman Coderen is leuk als het eenmaal werkt!";
        
        HuffBoom tree = new HuffBoom(tekst);

        String code = tree.aflezenCode() ;
        System.out.println(tekst + ">" + code + ">" + tree.controleerCode(code));
    }

}
