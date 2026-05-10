package utils;

/**
 * Classe utilitària amb funcions per gestionar la consola:
 * netejar la pantalla, mostrar títols i pausar l'execució.
 */
public class ConsoleUtils {

    /**
     * Neteja completament la pantalla de la consola.
     * Utilitza codis ANSI per fer un "clear screen".
     */
    public static void saltarPagina() {
        // for (int i = 0; i < 50; i++) {
        // System.out.println();
        // }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Neteja la pantalla i mostra un títol destacat.
     *
     * @param titol text que es mostrarà com a títol
     */
    public static void saltarPagina(String titol) {
        // for (int i = 0; i < 50; i++) {
        // System.out.println();
        // }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(Estils.TITOL + titol + Colors.RESET);
    }

    /**
     * Pausa l'execució durant un nombre determinat de segons.
     *
     * @param segons temps en segons que el programa ha de dormir
     */
    public static void dormirSegons(double segons) {
        try {
            Thread.sleep((long) (segons * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
