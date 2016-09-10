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
public class HuffKnoop
        implements Comparable<HuffKnoop> {

    private static StringBuffer stringBuffer;
    private static StringBuffer tekstBuffer;
    private static boolean gevonden;

    public char karakter;
    public int frequentie;
    public HuffKnoop leftChild, rightChild;

    /**
     * Levert het resultaat van een preorder wandeling af in een string
     *
     * @return resultaat van een preorder wandeling
     */
    public String preOrderToString() {
        stringBuffer = new StringBuffer();
        preOrder();
        return stringBuffer.toString();
    }

    private void preOrder() {
        if (leftChild != null) {
            stringBuffer.append("0");
            leftChild.preOrder();
        }
        if (rightChild != null) {
            stringBuffer.append("1");
            rightChild.preOrder();
        }
    }

    /**
     * Levert het resultaat van een postorder wandeling af in een string
     *
     * @return resultaat van een postorder wandeling
     */
    public String postOrderToString() {
        stringBuffer = new StringBuffer();
        postOrder();
        return stringBuffer.toString();
    }

    private void postOrder() {
        if (leftChild != null) {
            leftChild.postOrder();
            stringBuffer.append("0");
        }
        if (rightChild != null) {
            rightChild.postOrder();
            stringBuffer.append("1");
        }
    }

    public String codeerTekst(String tekst) {
        String result = "";
        for (int i = 0; i < tekst.length(); i++) {
            result += codeerKarakter(tekst.charAt(i));
        }
        return result;
    }

    String codeerKarakter(char zoekKarakter) {
        stringBuffer = new StringBuffer();
        gevonden = false;
        codeer(zoekKarakter);
        return stringBuffer.toString();
    }

    private void codeer(char zoekKarakter) {
        if (equalsTo(zoekKarakter)) {
            gevonden = true;
        }
        if (!equalsTo(zoekKarakter)) {
            if (leftChild != null) {
                if (!gevonden) {
                    stringBuffer.append("0");
                }
                leftChild.codeer(zoekKarakter);
                if (!gevonden) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            }
            if (rightChild != null) {
                if (!gevonden) {
                    stringBuffer.append("1");
                }
                rightChild.codeer(zoekKarakter);

                if (!gevonden) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            }
        }
    }

    public String decodeerCode(String code) {
        stringBuffer = new StringBuffer();
        stringBuffer.append(code);
        tekstBuffer = new StringBuffer();
        gevonden = false;
        while (stringBuffer.length() > 0) {
            decodeer();
        }
        return tekstBuffer.toString();
    }

    private void decodeer() {
        if (!equalsTo('\u0000')) {
            gevonden = true;
            tekstBuffer.append(karakter);
        }
        if (equalsTo('\u0000')) {
            int richting = Integer.valueOf(String.valueOf(stringBuffer.charAt(0)));
            stringBuffer.deleteCharAt(0);
            if (richting == 0) {
                leftChild.decodeer();
            }
            if (richting == 1) {
                rightChild.decodeer();
            }
        }
    }

    @Override
    public int compareTo(HuffKnoop o) {
        int result = 0;
        if (frequentie != o.frequentie) {
            if (frequentie > o.frequentie) {
                result = 1;
            } else {
                result = -1;
            }
        } else if (karakter == '\u0000' || o.karakter > karakter) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }

    /**
     * Methode om een char te vergelijken
     *
     * @param c character te vergelijken
     * @return True indien gelijk aan te vergelijken character
     */
    public boolean equalsTo(char c) {
        return ((Character) karakter).equals((Character) c);
    }
}
