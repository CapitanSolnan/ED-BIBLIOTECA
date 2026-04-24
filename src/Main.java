import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        Llibre llibre1 = new Llibre("1984", "George Orwell");
        Llibre llibre2 = new Llibre("El petit príncep", "Antoine de Saint-Exupéry");
        biblioteca.afegirLlibre(llibre1);
        biblioteca.afegirLlibre(llibre2);
        Usuari usuari = new Usuari("Carla");

        GestorBiblioteca gestor = new GestorBiblioteca();


        gestor.prestarLlibre(usuari, llibre2);
        gestor.prestarLlibre(usuari, llibre1);

        
        menu(teclado, usuari, biblioteca);

        teclado.close();
    }

public static void menu(Scanner teclado, Usuari usuari, Biblioteca biblioteca) {
    boolean activado = true;
    while (activado) {
        ConsoleUtils.saltarPagina("--Que vols fer?--");
        System.out.println("A. Consultar el historial");
        System.out.println("B. Consultat disponibiliat del Llibre");
        System.out.println("C. Gestionar les categories");
        System.out.println("D. Consultar les estadistiques");
        System.out.println("Q. SORTIR");

        char opcio = teclado.next().toLowerCase().charAt(0);
        teclado.nextLine();
        switch (opcio) {
            case 'a' -> consultarHistorial(teclado, biblioteca);
            case 'b' -> disponibilitatLlibre(teclado, usuari, biblioteca);
            case 'c' -> gestionarCategoria(teclado);
            case 'd' -> gestionarEstadistiques(teclado);
            case 'q' -> activado = false;
            default -> {
                        System.out.println("Opcio erronia");
                        ConsoleUtils.dormirSegons(1.5);
                    }
        }
    }

}

public static void consultarHistorial(Scanner teclado, Biblioteca biblioteca) {
  
}

public static void disponibilitatLlibre(Scanner teclado, Usuari usuari, Biblioteca biblioteca) {
    ConsoleUtils.saltarPagina();
    System.out.println("Que llibre vols buscar?");
    String titol = teclado.nextLine();
    if (titol.isEmpty()) {
        usuari.disponibilitatLlibre();
        ConsoleUtils.dormirSegons(3);

    } else {
        Llibre llibre = biblioteca.buscarLlibre(titol);

        if (llibre != null) {
            if (llibre.esPrestat()) {
                System.out.println("Llibre trobat: " + llibre.getTitol() + " (En préstec)");

            }else{
                System.out.println("Llibre trobat: " + llibre.getTitol() + " (Disponible)");
            }
        } else {
            System.out.println("No s'ha trobat cap llibre amb aquest títol.");
        }
        ConsoleUtils.dormirSegons(1.5);

    }

}

// Hay que crear la categoria dentro del llibre
public static void gestionarCategoria(Scanner teclado) {

}

public static void gestionarEstadistiques(Scanner teclado) {

}
/*
 * Millores:
 * • Consultar l'historial de préstecs d'un lector.
 * • Comprovar la disponibilitat del llibre.
 * • Gestionar categories (ex. "Novel·la", "Història", "Ciència", etc.).
 * • Gestionar estadístiquees (informes de llibres més prestats, lectors més
 * actius, nombre total de préstecs
 * per categoria...)
 */
}
