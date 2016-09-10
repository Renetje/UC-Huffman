/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_W03_HuffMan_Codering;

import java.util.PriorityQueue;

/**
 *
 * @author Johan Verhoeven <jrh.verhoeven@student.fontys.nl>
 */
public class HuffBoom {

    private String tekst;
    private int[] frequenties;
    PriorityQueue<HuffKnoop> huffKnopen;
    private HuffKnoop huffBoom;

    /**
     * Constructoor die voor opgegeven tekst een Huffman boom bouwt.
     *
     * @throws IllegalArgumentException wanneer tekst een null waarde heeft
     * @throws IllegalArgumentException wanneer een karakter geen ASCII waarde
     *
     * @param tekst voor Huffman boom
     */
    public HuffBoom(String tekst) {
        if (tekst == null) {
            throw new IllegalArgumentException("Tekst mag niet leeg zijn");
        }
        this.tekst = tekst;
        try {
            telFrequenties();
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage());
        }
        sorteerOpFrequentie();
        maakBoom();
    }

    /**
     * Methode om de tekst op te vragen
     *
     * @return waarde van de tekst
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Methode om de Huffboom op te vragen
     *
     * @return waarde van de HuffBoom
     */
    public HuffKnoop getHuffBoom() {
        return huffBoom;
    }

    /**
     * Methode van de tekst te tellen hoevaak een karakter voorkomt in de tekst
     *
     * @throws IllegalArgumentException wanneer een karakter geen ASCII waarde
     */
    private void telFrequenties() {
        frequenties = new int[255];
        for (char c : tekst.toCharArray()) {
            if (c > 255) {
                throw new IllegalArgumentException("Alleen ASCII karaktes "
                        + "0 t/m 225 zijn toegestaan (" + c + ")");
            }
            frequenties[c]++;
        }
    }

    /**
     * Methode de karakters op frequentie te sorteren - Maakt voor elke letter
     * een huffman-knoop - Sorteer de knopen op grond van frequentie door
     * gebruik te maken van PriorityQueue
     */
    private void sorteerOpFrequentie() {
        huffKnopen = new PriorityQueue<>();
        for (int i = 0; i < frequenties.length; i++) {
            if (frequenties[i] > 0) {
                HuffKnoop huffKnoop = new HuffKnoop();
                huffKnoop.frequentie = frequenties[i];
                huffKnoop.karakter = (char) i;
                huffKnopen.add(huffKnoop);
            }
        }
    }

    /**
     * Methode om de Huffman boom te maken - Maakt van de twee knopen met de
     * laagste frequentie een nieuwe knoop aan met deze twee knoppen als
     * kinderen. - De frequentie van de nieuwe knoop is de som van de frequentie
     * van deze kinderen. - Het proces blijft zich herhalen totdat er maar 1
     * knoop over is.
     */
    private void maakBoom() {
        while (huffKnopen.size() > 1) {
            HuffKnoop knoop1 = huffKnopen.poll();
            HuffKnoop knoop2 = huffKnopen.poll();

            HuffKnoop nieuw = new HuffKnoop();
            nieuw.frequentie = knoop1.frequentie + knoop2.frequentie;
            nieuw.leftChild = knoop1;
            nieuw.rightChild = knoop2;
            huffKnopen.add(nieuw);
        }
        huffBoom = huffKnopen.poll();
    }

    /**
     * Methode om de Huffmann code van de opgegeven tekst af te lezen
     *
     * @return gecodeerde gecomprimeerde tekst
     */
    public String aflezenCode() {
        return huffBoom.codeerTekst(tekst);
    }

    /**
     * Methode om te controleren of er uit de opgegeven gecodeerde code ook de
     * tekst kan worden gedecodeerd.
     *
     * @param code gecodeerd gecomprimeerd
     * @return true indine geldig
     */
    public boolean controleerCode(String code) {
        return tekst.equals(huffBoom.decodeerCode(code));
    }
}
