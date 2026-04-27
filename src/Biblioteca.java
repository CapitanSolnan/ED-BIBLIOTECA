import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Llibre> llibres;
    private List<Usuari> usuaris;

    public Biblioteca() {
        this.llibres = new ArrayList<>();
        this.usuaris = new ArrayList<>();

    }


    /*FUNCIONES USUARI------------------------------------------------------ */

    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    public Usuari buscarUsuari(String nom) {
        for (Usuari usuari : usuaris) {
            if (usuari.getNom().equalsIgnoreCase(nom)) {
                return usuari;
            }
        }
        return null;
    }

    public List<Usuari> getUsuaris() {
        return usuaris;
    }

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

    /*FUNCIONES LIBRO------------------------------------------------------ */

    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public Llibre buscarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equalsIgnoreCase(titol)) {
                return llibre;
            }
        }
        return null;
    }

    public List<Llibre> getLlibres() {
        return llibres;
    }

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

    public boolean creadorLlibre(Scanner teclado) {
        ConsoleUtils.saltarPagina("--- CREACIÓ DE LLIBRE ---");

        System.out.print("Titol: ");
        String titol = teclado.nextLine();

        System.out.print("Autor: ");
        String autor = teclado.nextLine();

        if (titol.isEmpty()) {
            return false;
        } else {
            Llibre comprovarLlibre = buscarLlibre(titol);
            if (comprovarLlibre != null) {
                System.out.println("Titol en us");
                ConsoleUtils.dormirSegons(1.5);
                return false;
            } else {
                Llibre llibre = new Llibre(titol, autor);
                afegirLlibre(llibre);
                System.out.println("Llibre " + titol + " de l'autor " + autor + " s'ha afegit");
                ConsoleUtils.dormirSegons(1.5);
                return true;
            }
        }

    }

    public boolean modificacioLlibre(Scanner teclado) {
            ConsoleUtils.saltarPagina("--- MODIFICAR DE LLIBRE ---");
            System.out.print("Titol Antic: ");
        String titolAntic = teclado.nextLine();

        System.out.print("Titol Nou: ");
        String titolNou = teclado.nextLine();

        System.out.print("Autor Nou: ");
        String autorNou = teclado.nextLine();

        if (titolAntic.isEmpty() || titolNou.isEmpty()) {
            System.out.println("No s'ha trobat cap llibre amb aquest titol.");
            ConsoleUtils.dormirSegons(1.5);
            return false;
        } else {

            Llibre llibre = buscarLlibre(titolAntic);
            if (llibre != null) {

                llibre.setTitol(titolNou);
                llibre.setAutor(autorNou);

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
