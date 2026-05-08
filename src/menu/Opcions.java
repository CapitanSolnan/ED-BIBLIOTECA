package menu;

import java.util.Map;
import java.util.Scanner;

import models.*;
import utils.*;

public class Opcions {
    
        public void consultarHistorial(Scanner teclado, Biblioteca biblioteca) {
        ConsoleUtils.saltarPagina();
        System.out.println(Estils.PREGUNTA + "Que usuari vols buscar?" + Colors.RESET);
        String nom = teclado.nextLine();
        if (nom.isEmpty()) {
            System.out.println(Colors.VERMELL + "No has seleccionat cap usuari" + Colors.RESET);
            ConsoleUtils.dormirSegons(1.5);
        } else {
            Usuari usuari = biblioteca.buscarUsuari(nom);
            if (usuari != null) {

                System.out.println(Estils.NEGRETA + "--- Usuari " + usuari.getNom() + " --- " + Colors.RESET);
            
                ConsoleUtils.dormirSegons(1.5);

            } else {
                System.out.println(Colors.VERMELL +"No s'ha trobat cap usuari amb aquest nom." + Colors.RESET);
                ConsoleUtils.dormirSegons(1.5);

            }
        }

    }

    public void disponibilitatLlibre(Scanner teclado, Biblioteca biblioteca) {
        ConsoleUtils.saltarPagina();
        System.out.println(Estils.PREGUNTA + "Que llibre vols buscar?" + Colors.RESET);
        String titol = teclado.nextLine();

        if (titol.isEmpty()) {
            biblioteca.mostrarDisponibilitat();
             System.out.println();
            System.out.println(Colors.GRIS + "Prem ENTER per TORNAR" + Colors.RESET);
            teclado.nextLine();

        } else {
            Llibre llibre = biblioteca.buscarLlibre(titol);

            if (llibre != null) {
                if (llibre.esPrestat()) {
                    System.out.println("Llibre trobat: " + llibre.getTitol() + " (En préstec)");
                } else {
                    System.out.println("Llibre trobat: " + llibre.getTitol() + " (Disponible)");
                }
            } else {
                System.out.println(Colors.VERMELL + "No s'ha trobat cap llibre amb aquest títol." + Colors.RESET);
            }

            ConsoleUtils.dormirSegons(1.5);
        }
    }

    public void gestionarCategoria(Scanner teclado, Biblioteca biblioteca) {

        ConsoleUtils.saltarPagina("--- Categoríes ---");
        System.out.println("Ficció, Novel·la, Història, Terror, Biografia, Altres");
        System.out.println("Escriu la categoria que vols veure");
        String categoria = teclado.nextLine();

        biblioteca.mostrarCategoria(categoria);


    }

    public void gestionarEstadistiques(Scanner teclado, Biblioteca biblioteca, GestorBiblioteca gestor) {
    ConsoleUtils.saltarPagina("--- ESTADÍSTIQUES ---");

    // Llibres més prestats
    System.out.println(Estils.NEGRETA + "Llibres més prestats:" + Colors.RESET);
    var llibresMesPrestats = gestor.getLlibresMesPrestats();
    if (llibresMesPrestats.isEmpty()) {
        System.out.println(Colors.GRIS + "Cap préstec registrat." + Colors.RESET);
    } else {
        int pos = 1;
        for (var entry : llibresMesPrestats) {
            System.out.println("  " + pos++ + ". " + entry.getKey() + 
                               Colors.GROC + " (" + entry.getValue() + " vegades)" + Colors.RESET);
        }
    }

    System.out.println();

    // Lectors més actius
    System.out.println(Estils.NEGRETA + "Lectors més actius:" + Colors.RESET);
    var lectorsMesActius = gestor.getLectorsMesActius();
    if (lectorsMesActius.isEmpty()) {
        System.out.println(Colors.GRIS + "Cap préstec registrat." + Colors.RESET);
    } else {
        int pos = 1;
        for (var entry : lectorsMesActius) {
            System.out.println("  " + pos++ + ". " + entry.getKey() + 
                               Colors.GROC + " (" + entry.getValue() + " préstecs)" + Colors.RESET);
        }
    }

    System.out.println();

    // Préstecs per categoria
    System.out.println(Estils.NEGRETA + "Préstecs per categoria:" + Colors.RESET);
    var perCategoria = gestor.getPrestecPerCategoria();
    if (perCategoria.isEmpty()) {
        System.out.println(Colors.GRIS + "Cap préstec registrat." + Colors.RESET);
    } else {
        perCategoria.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(e -> System.out.println("  • " + e.getKey() + 
                                             Colors.GROC + ": " + e.getValue() + Colors.RESET));
    }

    System.out.println();
    System.out.println(Colors.GRIS + "Total de préstecs: " + Colors.BLANC + 
                       gestor.getTotalPrestecs() + Colors.RESET);
    System.out.println();
    System.out.println(Colors.GRIS + "Prem ENTER per TORNAR" + Colors.RESET);
    teclado.nextLine();
}
}
