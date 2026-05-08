package menu;
import java.util.Scanner;

import models.*;
import utils.*;

public class Menu {
    
    private final Biblioteca biblioteca;
    private final GestorBiblioteca gestor;

    public Menu(Biblioteca biblioteca, GestorBiblioteca gestor) {
        this.biblioteca = biblioteca;
        this.gestor = gestor;
    }

    private final Opcions opcions = new Opcions();


    
    public void menuPrincipal(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {

        boolean activado = true;
        while (activado) {
            ConsoleUtils.saltarPagina("--Que vols fer?--");
            System.out.println(" A. Menu Llibre");
            System.out.println(" B. Menu Usuari");
            System.out.println(" C. Menu Consulta");
            System.out.println(" D. Menu Prèstec");
            System.out.println(Colors.VERMELL+ " Q. SORTIR" + Colors.RESET);

            System.out.print(Estils.RESPOSTA);
            char opcio = teclado.next().toLowerCase().charAt(0);
            teclado.nextLine();
            System.out.print(Colors.RESET);
            switch (opcio) {
                case 'a' -> menuLlibre(teclado, biblioteca);
                case 'b' -> menuUsuari(teclado, biblioteca);
                case 'c' -> menuConsulta(teclado, biblioteca);
                case 'd' -> menuGestor(teclado, biblioteca, gestor);
                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }
    }

    public void menuUsuari(Scanner teclado, Biblioteca biblioteca) {
        boolean activado = true;
        while (activado) {
            ConsoleUtils.saltarPagina("--- MENU USUARI ---");
            System.out.println(" A. Creació Usuari");
            System.out.println(" B. Modificació Usuari");
            System.out.println(" C. Eliminació Usuari");
            System.out.println(" D. Llistat de Usuaris");
            System.out.println(" E. Cerca de Usuari");
            System.out.println(" Q. TORNAR");

            char opcio = teclado.next().toLowerCase().charAt(0);
            teclado.nextLine();
            switch (opcio) {
                case 'a' -> biblioteca.creadorUsuari(teclado);
                case 'b' -> biblioteca.modificacioUsuari(teclado);
                case 'c' -> biblioteca.eliminacioUsuari(teclado);
                case 'd' -> biblioteca.llistatUsuaris(teclado);
                case 'e' -> biblioteca.cercarUsuari(teclado);

                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }
    }

    public void menuLlibre(Scanner teclado, Biblioteca biblioteca) {
        boolean activado = true;
        while (activado) {
            ConsoleUtils.saltarPagina("--- MENU LLIBRE ---");
            System.out.println(" A. Creació de Llibre");
            System.out.println(" B. Modificació de Llibre");
            System.out.println(" C. Eliminació de Llibre");
            System.out.println(" Q. TORNAR");

            char opcio = teclado.next().toLowerCase().charAt(0);
            teclado.nextLine();
            switch (opcio) {
                case 'a' -> biblioteca.creadorLlibre(teclado);
                case 'b' -> biblioteca.modificacioLlibre(teclado);
                case 'c' -> biblioteca.eliminacioLlibre(teclado);

                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }
    }

    public void menuConsulta(Scanner teclado, Biblioteca biblioteca) {
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
                case 'a' -> opcions.consultarHistorial(teclado, biblioteca);
                case 'b' -> opcions.disponibilitatLlibre(teclado, biblioteca);
                case 'c' -> opcions.gestionarCategoria(teclado);
                case 'd' -> opcions.gestionarEstadistiques(teclado);
                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }

    }

    public void menuGestor(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {
        boolean activado = true;
        while (activado) {
            ConsoleUtils.saltarPagina("--Que vols fer?--");
            System.out.println("A. Prestar Llibre");
            System.out.println("B. Control d'Estoc");
            System.out.println("Q. TORNAR");

            char opcio = teclado.next().toLowerCase().charAt(0);
            teclado.nextLine();
            switch (opcio) {
                case 'a' -> menuPrestec(teclado, biblioteca, gestor);
                case 'b' -> menuStoc(teclado, biblioteca);
                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }
       
    }
    /*------------------------------------------------------------ */


    public void menuStoc(Scanner teclado, Biblioteca biblioteca){
        //TODO: ESTO Controlar l’estoc (si tenim més d’un llibre).
    }

    public void menuPrestec(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor){
         ConsoleUtils.saltarPagina("--- MENU PRÈSTEC ---");
        System.out.println(Estils.PREGUNTA + "Quin usuari vol fer el prèstec?" +Colors.RESET);
        String nom = teclado.nextLine();

        System.out.println(Estils.PREGUNTA + "Quin llibre es?" + Colors.RESET);
        String titol = teclado.nextLine();

        if (nom.isEmpty() || titol.isEmpty()) {
            System.out.println(Colors.VERMELL + "Usuari o titol incorrecte" + Colors.RESET);
            ConsoleUtils.dormirSegons(1.5);
        } else {
            Usuari usuari = biblioteca.buscarUsuari(nom);
            Llibre llibre = biblioteca.buscarLlibre(titol);

            if (usuari != null && llibre != null) {

                gestor.prestarLlibre(usuari, llibre);
                System.out.println(Colors.VERD + "L'usuari " + nom + " te en prèstec el llibre " + titol + Colors.RESET);
                ConsoleUtils.dormirSegons(1.5);

            } else {
                System.out.println(Colors.VERMELL + "Usuari o titol incorrecte" +Colors.RESET);
                ConsoleUtils.dormirSegons(1.5);
            }

        }
    }
}
