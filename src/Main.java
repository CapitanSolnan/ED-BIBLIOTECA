import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        Llibre llibre1 = new Llibre("1984", "George Orwell");
        Llibre llibre2 = new Llibre("El petit príncep", "Antoine de Saint-Exupéry");
        biblioteca.afegirLlibre(llibre1);
        biblioteca.afegirLlibre(llibre2);

        GestorBiblioteca gestor = new GestorBiblioteca();

        
        menuPrincipal(teclado, biblioteca);



        teclado.close();
    }
public static void menuPrincipal(Scanner teclado, Biblioteca biblioteca){

    boolean activado = true;
    while (activado) {
        ConsoleUtils.saltarPagina("--Que vols fer?--");
        System.out.println("A. Menu Llibre");
        System.out.println("B. Menu Usuari");
        System.out.println("C. Menu Consulta");
        System.out.println("Q. SORTIR");

        char opcio = teclado.next().toLowerCase().charAt(0);
        teclado.nextLine();
        switch (opcio) {
            case 'a' -> menuLlibre(teclado, biblioteca);
            case 'b' -> menuUsuari(teclado, biblioteca);
            case 'c' -> menuConsulta(teclado, biblioteca);
            case 'q' -> activado = false;
            default -> {
                        System.out.println("Opcio erronia");
                        ConsoleUtils.dormirSegons(1.5);
                    }
        }
    }
}

public static void menuUsuari(Scanner teclado, Biblioteca biblioteca){
    boolean activado = true;
    while (activado) {
        ConsoleUtils.saltarPagina("--- MENU USUARI ---");
        System.out.println("A. Creació Usuari");
        System.out.println("B. Modificació Usuari");
        System.out.println("C. Eliminació Usuari");
        System.out.println("Q. TORNAR");

        char opcio = teclado.next().toLowerCase().charAt(0);
        teclado.nextLine();
        switch (opcio) {
            case 'a' -> biblioteca.creadorUsuari(teclado);
            case 'b' -> biblioteca.modificacioUsuari(teclado);
            case 'c' -> biblioteca.eliminacioUsuari(teclado);

            case 'q' -> activado = false;
            default -> {
                        System.out.println("Opcio erronia");
                        ConsoleUtils.dormirSegons(1.5);
                    }
        }
    }
}


public static void menuLlibre(Scanner teclado, Biblioteca biblioteca){
    boolean activado = true;
    while (activado) {
        ConsoleUtils.saltarPagina("--- MENU LLIBRE ---");
        System.out.println("A. Creació de Llibre");
        System.out.println("B. Modificació de Llibre");
        System.out.println("C. Eliminació de Llibre");
        System.out.println("Q. TORNAR");

        char opcio = teclado.next().toLowerCase().charAt(0);
        teclado.nextLine();
        switch (opcio) {
         //   case 'a' -> biblioteca.creadorLlibre(teclado);
         //   case 'b' -> biblioteca.modificacioLlibre(teclado);
         //   case 'c' -> biblioteca.eliminacioLlibre(teclado);

            case 'q' -> activado = false;
            default -> {
                        System.out.println("Opcio erronia");
                        ConsoleUtils.dormirSegons(1.5);
                    }
        }
    }
}

public static void menuConsulta(Scanner teclado, Biblioteca biblioteca) {
    boolean activado = true;
    while (activado) {
        ConsoleUtils.saltarPagina("--Que vols fer?--");
        System.out.println("A. Consultar el historial");
        System.out.println("B. Consultat disponibiliat del Llibre");
        System.out.println("C. Gestionar les categories");
        System.out.println("D. Consultar les estadistiques");
        System.out.println("Q. TORNAR");

        char opcio = teclado.next().toLowerCase().charAt(0);
        teclado.nextLine();
        switch (opcio) {
            case 'a' -> consultarHistorial(teclado, biblioteca);
            case 'b' -> disponibilitatLlibre(teclado, biblioteca);
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


/*------------------------------------------------------------ */


public static void consultarHistorial(Scanner teclado, Biblioteca biblioteca) {
      ConsoleUtils.saltarPagina();
        System.out.println("Que usuari vols buscar?");
        String nom = teclado.nextLine();
        if(nom.isEmpty()){
            System.out.println("No has seleccionat cap usuari");
            ConsoleUtils.dormirSegons(1.5);
        }else{
            Usuari usuari = biblioteca.buscarUsuari(nom);
            if (usuari != null) {
                
                System.out.println("--- Usuari " + usuari.getNom() + " --- ");
                

                ConsoleUtils.dormirSegons(1.5);


            }else{
                System.out.println("No s'ha trobat cap usuari amb aquest nom.");
                ConsoleUtils.dormirSegons(1.5);

            }
        }

}

public static void disponibilitatLlibre(Scanner teclado, Biblioteca biblioteca) {
    ConsoleUtils.saltarPagina();
    System.out.println("Que llibre vols buscar?");
    String titol = teclado.nextLine();

    if (titol.isEmpty()) {
        biblioteca.mostrarDisponibilitat();
        ConsoleUtils.dormirSegons(3);

    } else {
        Llibre llibre = biblioteca.buscarLlibre(titol);

        if (llibre != null) {
            if (llibre.esPrestat()) {
                System.out.println("Llibre trobat: " + llibre.getTitol() + " (En préstec)");
            } else {
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
