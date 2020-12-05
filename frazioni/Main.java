package frazioni;

public class Main {
    public static void main(String[] args) {
        Frazioni n1 = new Frazioni();
        Frazioni n2 = new Frazioni();

        System.out.println("inserisci la prima frazione nel seguente modo: numeratore/denominatore");
        n1.inputFrazione();
        System.out.println("inserisci la seconda frazione nel seguente modo: numeratore/denominatore");
        n2.inputFrazione();

        Frazioni somma = Frazioni.sommaFrazioni(n1, n2);
        Frazioni differenza = Frazioni.differenzaFrazioni(n1, n2);
        Frazioni prodotto = Frazioni.prodottoFrazioni(n1, n2);
        Frazioni divisione = Frazioni.divisioneFrazioni(n1, n2);

        System.out.println("la somma e'");
        System.out.println(somma.toString());

        System.out.println("la differenza è");
        System.out.println(differenza.toString());

        System.out.println("il prodotto e'");
        System.out.println(prodotto.toString());

        System.out.println("la divisione e'");
        System.out.println(divisione.toString());

    }
}
