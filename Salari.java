package UF2.Tasca3.src;

import java.util.Scanner;

public class Salari {
    public enum TipusEmpleat {
        VENEDOR, ENCARREGAT
    };

    private TipusEmpleat tipusEmpleat;
    private float importVendes;
    private int horesExtra;

    public Salari() throws IllegalArgumentException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Inserti tipus empleat (0.Venedor, 1.Encarregat): ");
            int tipus = sc.nextInt();
            if (tipus == 0) {
                tipusEmpleat = TipusEmpleat.VENEDOR;
            } else if (tipus == 1) {
                tipusEmpleat = TipusEmpleat.ENCARREGAT;
            } else {
                throw new IllegalArgumentException("Tipus d'empleat incorrecte");
            }
            System.out.print("Import de vendes mes: ");
            importVendes = sc.nextFloat();
            if (importVendes < 0) { //llença error si l'import és un valor negatiu
                throw new IllegalArgumentException("L'import de vendes no pot ser negatiu");
            }
            System.out.print("Hores extra mes: ");
            horesExtra = sc.nextInt();
            if (horesExtra < 0) { //llença error si les hores extra son un valor negatiu
                throw new IllegalArgumentException("Les hores extra no poden ser negatives");
            }
        } catch (java.util.InputMismatchException e) { //si introduïm un valor que no és vàlid imprimirà aquest error
            throw new IllegalArgumentException("Valor introduït no vàlid", e);
        }
    }

    
    /** 
     * @param importVendes(
     * @return TipusEmpleat
     */
    public TipusEmpleat tipusEmpleat() { //funcions que retornen els valors recollits per consola
        return tipusEmpleat;
    }

    public float importVendes() {
        return importVendes;
    }

    public int horesExtra() {
        return horesExtra;
    }
}