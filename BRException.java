package UF2.Tasca3.src;

public class BRException extends Exception {
    public BRException(String message) { //quan surti l'excepció, imprimirà el missatge que llença cada error
        super(message);
    }
}