package menu;

import java.util.Scanner;

import models.*;
import utils.*;

/**
 * Classe encarregada de gestionar tots els menús del sistema de biblioteca.
 * Permet navegar entre les opcions de gestió de llibres, usuaris, consultes,
 * préstecs i control d'estoc.
 */
public class Menu {

    private final Biblioteca biblioteca;
    private final GestorBiblioteca gestor;

    /**
     * Constructor del menú principal.
     *
     * @param biblioteca instància de la biblioteca
     * @param gestor gestor encarregat dels préstecs i retorns
     */
    public Menu(Biblioteca biblioteca, GestorBiblioteca gestor) {
        this.biblioteca = biblioteca;
        this.gestor = gestor;
    }

    private final Opcions opcions = new Opcions();

    /**
     * Mostra el menú principal i permet accedir als submenús de llibre,
     * usuari, consultes i préstecs.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     * @param gestor instància del gestor de biblioteca
     */
    public void menuPrincipal(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {
        boolean activado = true;
        while (activado) {
            ConsoleUtils.saltarPagina("--Que vols fer?--");
            System.out.println(" A. Menu Llibre");
            System.out.println(" B. Menu Usuari");
            System.out.println(" C. Menu Consulta");
            System.out.println(" D. Menu Prèstec");
            System.out.println(Colors.VERMELL + " Q. SORTIR" + Colors.RESET);

            System.out.print(Estils.RESPOSTA);
            char opcio = teclado.next().toLowerCase().charAt(0);
            teclado.nextLine();
            System.out.print(Colors.RESET);
            switch (opcio) {
                case 'a' -> menuLlibre(teclado, biblioteca);
                case 'b' -> menuUsuari(teclado, biblioteca);
                case 'c' -> menuConsulta(teclado, biblioteca, gestor);
                case 'd' -> menuGestor(teclado, biblioteca, gestor);
                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }
    }

    /**
     * Menú dedicat a la gestió d'usuaris: creació, modificació, eliminació,
     * llistat i cerca.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     */
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

    /**
     * Menú dedicat a la gestió de llibres: creació, modificació i eliminació.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     */
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

    /**
     * Menú de consultes generals: historial, disponibilitat, categories
     * i estadístiques.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     * @param gestor instància del gestor de biblioteca
     */
    public void menuConsulta(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {
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
                case 'c' -> opcions.gestionarCategoria(teclado, biblioteca);
                case 'd' -> opcions.gestionarEstadistiques(teclado, biblioteca, gestor);
                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }
    }

    /**
     * Menú de gestió de préstecs: prestar llibres, retornar-los i consultar l'estoc.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     * @param gestor instància del gestor de biblioteca
     */
    public void menuGestor(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {
        boolean activado = true;
        while (activado) {
            ConsoleUtils.saltarPagina("--Que vols fer?--");
            System.out.println("A. Prestar Llibre");
            System.out.println("B. Retornar Llibre");
            System.out.println("C. Control d'Estoc");
            System.out.println("Q. TORNAR");

            char opcio = teclado.next().toLowerCase().charAt(0);
            teclado.nextLine();
            switch (opcio) {
                case 'a' -> menuPrestec(teclado, biblioteca, gestor);
                case 'b' -> menuRetorn(teclado, biblioteca, gestor);
                case 'c' -> menuStoc(teclado, biblioteca);
                case 'q' -> activado = false;
                default -> {
                    System.out.println(Colors.VERMELL + "Opcio erronia" + Colors.RESET);
                    ConsoleUtils.dormirSegons(1.5);
                }
            }
        }
    }

    /**
     * Mostra l'estat de l'estoc de tots els llibres registrats.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     */
    public void menuStoc(Scanner teclado, Biblioteca biblioteca) {
        ConsoleUtils.saltarPagina("--- CONTROL D'ESTOC ---");

        boolean hiHaLlibres = false;
        for (Llibre llibre : biblioteca.getLlibres()) {
            String estat;
            if (llibre.getStock() == 0) {
                estat = Colors.VERMELL + "ESGOTAT" + Colors.RESET;
            } else if (llibre.getStock() <= 2) {
                estat = Colors.GROC + "BAIX (" + llibre.getStock() + " uds)" + Colors.RESET;
            } else {
                estat = Colors.VERD + "OK (" + llibre.getStock() + " uds)" + Colors.RESET;
            }
            System.out.println(" " + llibre.getTitol() + " — " + estat);
            hiHaLlibres = true;
        }

        if (!hiHaLlibres) {
            System.out.println(Colors.GRIS + "No hi ha llibres registrats." + Colors.RESET);
        }

        System.out.println();
        System.out.println(Colors.GRIS + "Prem ENTER per TORNAR" + Colors.RESET);
        teclado.nextLine();
    }

    /**
     * Menú per gestionar el retorn d'un llibre per part d'un usuari.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     * @param gestor instància del gestor de biblioteca
     */
    public void menuRetorn(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {
        ConsoleUtils.saltarPagina("--- RETORN DE LLIBRE ---");
        System.out.println(Estils.PREGUNTA + "Quin usuari retorna el llibre?" + Colors.RESET);
        String nom = teclado.nextLine();

        System.out.println(Estils.PREGUNTA + "Quin llibre retorna?" + Colors.RESET);
        String titol = teclado.nextLine();

        if (nom.isEmpty() || titol.isEmpty()) {
            System.out.println(Colors.VERMELL + "Usuari o titol incorrecte" + Colors.RESET);
            ConsoleUtils.dormirSegons(1.5);
            return;
        }

        Usuari usuari = biblioteca.buscarUsuari(nom);
        Llibre llibre = biblioteca.buscarLlibre(titol);

        if (usuari == null || llibre == null) {
            System.out.println(Colors.VERMELL + "Usuari o titol no trobat" + Colors.RESET);
        } else {
            gestor.retornarLlibre(usuari, llibre);
        }
        ConsoleUtils.dormirSegons(1.5);
    }

    /**
     * Menú per gestionar un préstec: demana l'usuari i el llibre i
     * executa l'operació si és possible.
     *
     * @param teclado Scanner per llegir l'entrada de l'usuari
     * @param biblioteca instància de la biblioteca
     * @param gestor instància del gestor de biblioteca
     */
    public void menuPrestec(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {
        ConsoleUtils.saltarPagina("--- MENU PRÈSTEC ---");
        System.out.println(Estils.PREGUNTA + "Quin usuari vol fer el prèstec?" + Colors.RESET);
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
                System.out.println(Colors.VERMELL + "Usuari o titol incorrecte" + Colors.RESET);
                ConsoleUtils.dormirSegons(1.5);
            }
        }
    }
}
