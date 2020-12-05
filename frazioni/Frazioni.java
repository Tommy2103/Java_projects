package frazioni;

import java.util.Scanner;

/**
 * <h1>Frazioni</h1>
 * <p>
 * this class is used to work with fraction in an easy way. <br>
 * there are wrapper functions that allow to perform sum, subraction, product and division between fractions. <br>
 * it is also possible to get in input a fraction and semplify it. <br>
 * </p>
 * <p>
 * return an object of a fraction by giving the numerator and the denominator as parameters. <br>
 * return a default object (1/1) by giving no parameters
 * </p>
 */
public class Frazioni {
    private int numeratore; 
    private int denominatore;
    static private Scanner sc = new Scanner(System.in);
    
    /**
     * This constructor is the default one (1/1).
     */
    public Frazioni() {
        this.numeratore = 1;
        this.denominatore = 1;
    }

    /**
     * This constructor set a fractions with numerator and denominator.
     * @param numeratore
     * @param denominatore
     */
    public Frazioni(int numeratore, int denominatore) {
        this.setNumeratore(numeratore);
        this.setDenominatore(denominatore);
        this.semplifica();
    }
    

    /**
     * This function allow to get in input a fraction.
     * @exception IOExecption on input error (wrong format or denominator == 0)
     * @see IOExecption
     */
    public void inputFrazione() {
        
        String fraz = sc.nextLine();
        String[] split = fraz.split("/");
        try {
            this.setNumeratore(Integer.parseInt(split[0]));
            this.setDenominatore(Integer.parseInt(split[1]));
        } catch (Exception e) {
            System.out.println("reinserisci la frazione nel seguente modo: numeratore/denominatore");
            this.inputFrazione();
        }
        this.semplifica();
    }

    /**
     * This function sum two fractions.
     * @param n1
     * @param n2
     * @return Frazioni
     */
    static public Frazioni sommaFrazioni(Frazioni n1, Frazioni n2) {
        int den1 = n1.getDenominatore();
        int num1 = n1.getNumeratore();
        int den2 = n2.getDenominatore();
        int num2 = n2.getNumeratore();

        int mcm = den1 * den2;
        
        int numFinale = (mcm / den1 * num1) + (mcm / den2 * num2); 
        
        Frazioni somma = new Frazioni(numFinale, mcm);
        somma.semplifica();
        return somma;
    }

    /**
     * This function subtracts two fractions.
     * @param n1
     * @param n2
     * @return Frazioni
     */
    static public Frazioni differenzaFrazioni(Frazioni n1, Frazioni n2) { 
        int den1 = n1.getDenominatore();
        int num1 = n1.getNumeratore();
        int den2 = n2.getDenominatore();
        int num2 = n2.getNumeratore();

        int mcm = den1 * den2;
        
        int numFinale = (mcm / den1 * num1) - (mcm / den2 * num2); 
        
        Frazioni somma = new Frazioni(numFinale, mcm);
        somma.semplifica();
        return somma;
    }

    /**
     * This function multiplies two fractions.
     * @param n1
     * @param n2
     * @return Frazioni
     */
    static public Frazioni prodottoFrazioni(Frazioni n1, Frazioni n2) { 
        int den1 = n1.getDenominatore();
        int num1 = n1.getNumeratore();
        int den2 = n2.getDenominatore();
        int num2 = n2.getNumeratore();

        int numeratore = num1 * num2;
        int denominatore = den1 * den2;
        
        Frazioni prodotto = new Frazioni(numeratore, denominatore);
        prodotto.semplifica();
        return prodotto;
    }

    /**
     * This function divides two fractions.
     * @param n1
     * @param n2
     * @return Frazioni
     */
    static public Frazioni divisioneFrazioni(Frazioni n1, Frazioni n2) { 
        int den1 = n1.getDenominatore();
        int num1 = n1.getNumeratore();
        int den2 = n2.getDenominatore();
        int num2 = n2.getNumeratore();

        int numeratore = num1 * den2;
        int denominatore = den1 * num2;
        
        Frazioni prodotto = new Frazioni(numeratore, denominatore);
        prodotto.semplifica();
        return prodotto;
    }

    /**
     * This function semplify the fraction with the help of the mcd function.
     */
    public void semplifica() {
        if (this.numeratore == 0) return;
    
        int mcd = mcd(this.numeratore, this.denominatore);
        this.numeratore /= mcd;
        this.denominatore /= mcd;
    }

    /**
     * This function calculates the mcd between two numbers.
     * @param n1
     * @param n2
     * @return int
     */
    private int mcd(int n1, int n2) {
        if (n1 < n2) {
            return mcd(n1, n2-n1);
        }
        else if (n1 > n2) {
            return mcd(n1-n2, n2);
        }
        else return n1;
    }

    /**
     * This function returns the numerator.
     * @return int
     */
    public int getNumeratore() {
        return numeratore;
    }

    /**
     * This function sets the numerator.
     * @param numeratore
     */
    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
    }

    /**
     * This function returns the denominator.
     * @return int
     */
    public int getDenominatore() {
        return denominatore;
    }

    /**
     * This function sets the denominator.
     * @exception IllegalArgumentException denominator can't be 0
     * @see IllegalArgumentExecption
     * @param denominatore
     */
    public void setDenominatore(int denominatore) {
        if (denominatore == 0) throw new IllegalArgumentException("il denominatore non puo' essere 0");
        this.denominatore = denominatore;
    }

    /**
     * This function return a string in the format numerator/denominator.
     * @return String
     */
    @Override
    public String toString() {
        if (this.numeratore == 0) return "0";
        return this.numeratore + "/" + this.denominatore;
    }
    
    
}