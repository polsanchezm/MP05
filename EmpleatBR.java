package UF2.Tasca3.src;

public class EmpleatBR {

    
    /** 
     * @param tipusEmpleat
     * @param importVendes
     * @param horesExtra
     * @return float
     * @throws BRException
     */
    public static float calculSalariBrut(Salari.TipusEmpleat tipusEmpleat, float importVendes, int horesExtra)
            throws BRException {
        float salariBase = 0;
        float prima = 0;
        float salariHoresExtres = 0;

        if (importVendes < 0 || horesExtra < 0) { //control·lem que l'import i les hores extra no siguin valors negatius
            throw new BRException("Valors incorrectes"); 
        }

        if (tipusEmpleat == Salari.TipusEmpleat.VENEDOR) {
            salariBase = 1000;
        } else {
            salariBase = 1500;
        }

        if (importVendes >= 1500) {
            prima = 200;
        } else if (importVendes >= 1000) {
            prima = 100;
        }

        salariHoresExtres = horesExtra * 20;

        return salariBase + prima + salariHoresExtres;
    }

    public static float calculSalariNet(float importVendes) throws BRException {
        if (importVendes < 0) { //control·lem que l'import de vendes sigui un valor negatius
            throw new BRException("L'import de vendes no pot ser negatiu.");
        }
        float retencio = 0.0f;
        if (importVendes >= 1000 && importVendes <= 1500) {
            retencio = 0.16f;
        } else if (importVendes >= 1500) {
            retencio = 0.18f;
        }

        float salariNet = importVendes * (1.0f - retencio);
        return salariNet;
    }

    public static void main(String[] args) {
        try {
            Salari salari = new Salari(); //cridem la funció Salari com a "salari" i inicialitzem 
                                          //les funcions que retornen els valors recollits per consola
            Salari.TipusEmpleat tipusEmpleat = salari.tipusEmpleat(); 
            float importVendes = salari.importVendes();
            int horesExtra = salari.horesExtra();

            float salariBrut = calculSalariBrut(tipusEmpleat, importVendes, horesExtra);
            System.out.println("Salari brut: " + salariBrut);

            float salariNet = calculSalariNet(importVendes);
            System.out.println("Salari net: " + salariNet);
        } catch (BRException e) { //control·lem els errors amb excepcions de java i amb la nostra BRException
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}