import java.util.Scanner;

import menu.*;
import models.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        Biblioteca biblioteca = new Biblioteca();
        GestorBiblioteca gestor = new GestorBiblioteca();

        Menu menu = new Menu(biblioteca, gestor);

        menu.menuPrincipal(teclado, biblioteca, gestor);

        teclado.close();
    }

    /*
     * Millores:
     * • Gestionar categories (ex. "Novel·la", "Història", "Ciència", etc.).
     * • Gestionar estadístiquees (informes de llibres més prestats, lectors més
     * actius, nombre total de préstecs
     * per categoria...)
     */
}
