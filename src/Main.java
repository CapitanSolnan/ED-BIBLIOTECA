import java.util.Scanner;
import menu.*;
import models.*;

/**
 * Classe principal del programa. Inicialitza la biblioteca, el gestor
 * i el menú principal, i inicia l'execució de l'aplicació.
 */
public class Main {

    /**
     * Punt d'entrada del programa. Crea les instàncies principals i
     * executa el menú principal de la biblioteca.
     *
     * @param args arguments de línia de comandes (no utilitzats)
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        Biblioteca biblioteca = new Biblioteca();
        GestorBiblioteca gestor = new GestorBiblioteca();

        Menu menu = new Menu(biblioteca, gestor);

        menu.menuPrincipal(teclado, biblioteca, gestor);

        teclado.close();
    }

}

