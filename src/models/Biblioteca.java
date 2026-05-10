package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.ConsoleUtils;

/**
 * Classe que representa una biblioteca. Gestiona llistes de llibres i usuaris,
 * i proporciona funcionalitats per afegir, modificar, eliminar i consultar-los.
 */
public class Biblioteca {

    private List<Llibre> llibres;
    private List<Usuari> usuaris;

    /**
     * Constructor que inicialitza les llistes de llibres i usuaris.
     */
    public Biblioteca() {
        this.llibres = new ArrayList<>();
        this.usuaris = new ArrayList<>();
    }

    /* ---------------------- FUNCIONS USUARI ---------------------- */

    /**
     * Afegeix un usuari a la biblioteca.
     *
     * @param usuari usuari a afegir
     */
    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    /**
     * Busca un usuari pel seu nom.
     *
     * @param nom nom de l'usuari a buscar
     * @return l'usuari si existeix, o null si no es troba
     */
    public Usuari buscarUsuari(String nom) {
        for (Usuari usuari : usuaris) {
            if (usuari.getNom().equalsIgnoreCase(nom)) {
                return usuari;
            }
        }
        return null;
    }

    /**
     * Retorna la llista d'usuaris registrats.
     *
     * @return llista d'usuaris
     */
    public List<Usuari> getUsuaris() {
        return usuaris;
    }

    /**
     * Crea un nou usuari demanant les dades per teclat.
     *
     * @param teclado Scanner per llegir l'entrada
     * @return true si s'ha creat correctament, false si hi ha errors
     */
    public boolean creadorUsuari(Scanner teclado) {

        ConsoleUtils.saltarPagina("--- CREACIÓ DE USUARI ---");

        System.out.print("Nom: ");

        String nom = teclado.nextLine();
        if (nom.isEmpty()) {
            return false;
        } else {
            Usuari comprovarUsuari = buscarUsuari(nom);
            if (comprovarUsuari != null) {
                System.out.println("Nom en us");
                ConsoleUtils.dormirSegons(1.5);

                return false;
            } else {
                Usuari usuari = new Usuari(nom);
                afegirUsuari(usuari);
                System.out.println("Usuari " + nom + " afegit");
                ConsoleUtils.dormirSegons(1.5);

                return true;
            }
        }

    }

    /**
     * Modifica el nom d'un usuari existent.
     *
     * @param teclado Scanner per llegir l'entrada
     * @return true si s'ha modificat, false si no existeix
     */
    public boolean modificacioUsuari(Scanner teclado) {
        ConsoleUtils.saltarPagina("--- MODIFICAR USUARI ---");

        System.out.print("Nom Antic: ");
        String nomAntic = teclado.nextLine();

        System.out.print("Nom Nou: ");
        String nomNou = teclado.nextLine();

        if (nomAntic.isEmpty() || nomNou.isEmpty()) {
            System.out.println("No s'ha trobat cap usuari amb aquest nom.");
            ConsoleUtils.dormirSegons(1.5);
            return false;
        } else {

            Usuari usuari = buscarUsuari(nomAntic);
            if (usuari != null) {

                usuari.setNom(nomNou);
                System.out.println("S'ha canviat "+ nomAntic + " a " + nomNou);
                ConsoleUtils.dormirSegons(1.5);
                return true;

            } else {
                System.out.println("No s'ha trobat cap usuari amb aquest nom.");
                ConsoleUtils.dormirSegons(1.5);
                return false;
            }

        }

    }

    /**
     * Elimina un usuari existent.
     *
     * @param teclado Scanner per llegir l'entrada
     * @return true si s'ha eliminat, false si no existeix
     */
    public boolean eliminacioUsuari(Scanner teclado) {
        ConsoleUtils.saltarPagina("--- ELIMINAR USUARI ---");

        System.out.print("Nom:");
        String nom = teclado.nextLine();

        if (nom.isEmpty()) {
            System.out.println("No s'ha trobat cap usuari amb aquest nom.");
            ConsoleUtils.dormirSegons(1.5);
            return false;
        } else {

            Usuari usuari = buscarUsuari(nom);
            if (usuari != null) {

                usuaris.remove(usuari);
                System.out.println("Usuari " + nom + " eliminat");
                ConsoleUtils.dormirSegons(1.5);
                return true;

            } else {
                System.out.println("No s'ha trobat cap usuari amb aquest nom.");
                ConsoleUtils.dormirSegons(1.5);
                return false;
            }

        }

    }

    /**
     * Mostra un llistat de tots els usuaris registrats.
     *
     * @param teclado Scanner per esperar l'ENTER final
     */
    public void llistatUsuaris(Scanner teclado){
        boolean comprovador = true;
        ConsoleUtils.saltarPagina("--- Llistat d'Usuaris ---");
        for (Usuari usuari : usuaris) {
            
            System.out.println(usuari);
            comprovador = false;
        }
        if (comprovador) {
            System.out.println("No hi ha usuaris");
        }
        System.out.println();
        System.out.println("Prem ENTER per TORNAR");
        teclado.nextLine();
        
    }

    /**
     * Cerca un usuari pel seu nom i mostra si existeix.
     *
     * @param teclado Scanner per llegir l'entrada
     * @return true si existeix, false si no
     */
    public boolean cercarUsuari(Scanner teclado){
        ConsoleUtils.saltarPagina("--- Cercador d'Usuari ---");
        System.out.print("Nom : ");
        String nom = teclado.nextLine();

        if (nom.isEmpty()) {
            System.out.println("No s'ha trobat cap usuari amb aquest nom.");
            ConsoleUtils.dormirSegons(1.5);
            return false;
        } else {

            Usuari usuari = buscarUsuari(nom);
            if (usuari != null) {
                
                System.out.println("S'ha trobat l'usuari amb el nom de " + nom);
                ConsoleUtils.dormirSegons(1.5);
                return true;

            } else {
                System.out.println("No s'ha trobat cap usuari amb aquest nom.");
                ConsoleUtils.dormirSegons(1.5);
                return false;
            }

        }

    }

    /* ---------------------- FUNCIONS LLIBRE ---------------------- */

    /**
     * Afegeix un llibre a la biblioteca.
     *
     * @param llibre llibre a afegir
     */
    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    /**
     * Busca un llibre pel seu títol, ignorant accents.
     *
     * @param titol títol del llibre
     * @return el llibre si existeix, o null si no es troba
     */
    public Llibre buscarLlibre(String titol) {
        String titolNet = treureAccentTitol(titol);
        for (Llibre llibre : llibres) {
            if (treureAccentTitol(llibre.getTitol()).equalsIgnoreCase(titolNet)) {
                return llibre;
            }
        }
        return null;
    }

    /**
     * Elimina accents d'un text per facilitar la comparació.
     *
     * @param text text original
     * @return text sense accents
     */
    private String treureAccentTitol(String text){
        return text.toLowerCase().replace("á" , "a").replace("à","a" )
                                .replace("é", "e").replace("è", "e")
                                .replace("í", "i").replace("ï", "i")
                                .replace("ó", "o").replace("ò", "o")
                                .replace("ú", "u").replace("ü", "u")
                                .replace("ç", "c");
    }

    /**
     * Retorna la llista de llibres registrats.
     *
     * @return llista de llibres
     */
    public List<Llibre> getLlibres() {
        return llibres;
    }

    /**
     * Mostra els llibres disponibles i els prestats.
     */
    public void mostrarDisponibilitat() {
        boolean disponoble = false;
        boolean prestat = false;

        System.out.println("--- Llibres Disponibles ---");
        for (Llibre llibre : llibres) {
            if (!llibre.esPrestat()) {
                System.out.println(llibre);
                disponoble = true;
            }
        }
        if (!disponoble) {
            System.out.println("No hi ha llibres disponibles");
        }
        System.out.println();
        System.out.println("--- Llibres Prestats ---");
        for (Llibre llibre : llibres) {
            if (llibre.esPrestat()) {
                System.out.println(llibre);
                prestat = true;
            }
        }
        if (!prestat) {
            System.out.println("No hi ha llibres prestats");
        }
    }

    /**
     * Mostra els llibres d'una categoria concreta o totes les categories.
     *
     * @param categoria categoria a consultar
     */
    public void mostrarCategoria(String categoria) {

        if (categoria.equals("todas")) {
            
            boolean comprovador = false;

            ConsoleUtils.saltarPagina("--- Totes les categories ---");
            for (Llibre llibre : llibres) {
                System.out.println(" Categoria: " + llibre.getCategoria() + " ------>  " + llibre);
                comprovador = true;
            }

            if (!comprovador) {
                System.out.println("No hi ha llibres"); 
            }

        } else {

            boolean comprovador = false;

            ConsoleUtils.saltarPagina("--- Llibres de la categoria " + categoria + " ---");
            for (Llibre llibre : llibres) {

                if (llibre.getCategoria().equalsIgnoreCase(categoria)) {
                    System.out.println(llibre);
                    comprovador = true;
                }
            }

            if (!comprovador) {
                System.out.println("No hi ha llibres d'aquesta categoria");
            }
        }
        ConsoleUtils.dormirSegons(2);

    }

    /**
     * Crea un llibre nou demanant les dades per teclat.
     *
     * @param teclado Scanner per llegir l'entrada
     * @return true si s'ha creat correctament, false si ja existeix o hi ha errors
     */
    public boolean creadorLlibre(Scanner teclado) {
        ConsoleUtils.saltarPagina("--- CREACIÓ DE LLIBRE ---");

        System.out.print("Titol: ");
        String titol = teclado.nextLine();

        System.out.print("Autor: ");
        String autor = teclado.nextLine();

        System.out.print("Categoria: ");
        String categoria = teclado.nextLine();
        
        System.out.print("Stock: ");
        int stock = teclado.nextInt();

        if (titol.isEmpty()) {
            return false;
        } else {
            Llibre comprovarLlibre = buscarLlibre(titol);
            if (comprovarLlibre != null) {
                System.out.println("Titol en us");
                ConsoleUtils.dormirSegons(1.5);
                return false;
            } else {
                Llibre llibre = new Llibre(titol, autor, categoria, stock);
                afegirLlibre(llibre);
                System.out.println("Llibre " + titol + " de l'autor " + autor + " s'ha afegita amb la categoria " + llibre.getCategoria());
                ConsoleUtils.dormirSegons(1.5);
                return true;
            }
        }

    }

    /**
     * Modifica les dades d'un llibre existent.
     *
     * @param teclado Scanner per llegir l'entrada
     * @return true si s'ha modificat, false si no existeix
     */
    public boolean modificacioLlibre(Scanner teclado) {
        ConsoleUtils.saltarPagina("--- MODIFICAR DE LLIBRE ---");
        System.out.print("Titol Antic: ");
        String titolAntic = teclado.nextLine();

        System.out.print("Titol Nou: ");
        String titolNou = teclado.nextLine();

        System.out.print("Autor Nou: ");
        String autorNou = teclado.nextLine();

        System.out.print("Categoria Nou: ");
        String categoriaNou = teclado.nextLine();

        System.out.print("Stock: ");
        int stockNou = teclado.nextInt();

        if (titolAntic.isEmpty() || titolNou.isEmpty()) {
            System.out.println("No s'ha trobat cap llibre amb aquest titol.");
            ConsoleUtils.dormirSegons(1.5);
            return false;
        } else {

            Llibre llibre = buscarLlibre(titolAntic);
            if (llibre != null) {

                llibre.setTitol(titolNou);
                llibre.setAutor(autorNou);
                llibre.setCategoria(categoriaNou);
                llibre.setStock(stockNou);
                System.out.println("Titol i autor canviats");
                ConsoleUtils.dormirSegons(1.5);

                return true;

            } else {
                System.out.println("No s'ha trobat cap llibre amb aquest titol.");
                ConsoleUtils.dormirSegons(1.5);
                return false;
            }

        }

    }

    /**
     * Elimina un llibre existent.
     *
     * @param teclado Scanner per llegir l'entrada
     * @return true si s'ha eliminat, false si no existeix
     */
    public boolean eliminacioLlibre(Scanner teclado) {
        ConsoleUtils.saltarPagina("--- ELIMINAR DE LLIBRE ---");

        System.out.print("Titol: ");
        String titol = teclado.nextLine();

        if (titol.isEmpty()) {
            System.out.println("No s'ha trobat cap llibre amb aquest titol.");
            ConsoleUtils.dormirSegons(1.5);
            return false;
        } else {

            Llibre llibre = buscarLlibre(titol);
            if (llibre != null) {

                llibres.remove(llibre);
                System.out.println("Llibre: " + titol + " eliminat");
                ConsoleUtils.dormirSegons(1.5);
                return true;

            } else {
                System.out.println("No s'ha trobat cap llibre amb aquest titol.");
                ConsoleUtils.dormirSegons(1.5);
                return false;
            }

        }

    }

}
