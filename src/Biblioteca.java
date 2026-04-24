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

        ConsoleUtils.saltarPagina("---CREACIÓ DE USUARI---");

        System.out.print("Nom:");

        String nom = teclado.nextLine();
        if (nom.isEmpty()) {
            return false;
        } else {
            Usuari comprovarUsuari = buscarUsuari(nom);
            if (comprovarUsuari != null) {
                System.out.println("Nom en us");
                return false;
            } else {
                Usuari usuari = new Usuari(nom);
                afegirUsuari(usuari);
                return true;
            }
        }

    }

    public boolean modificacioUsuari(Scanner teclado) {
        ConsoleUtils.saltarPagina("---MODIFICAR USUARI---");

        System.out.print("Nom Antic:");
        String nomAntic = teclado.nextLine();

        System.out.print("Nom Nou:");
        String nomNou = teclado.nextLine();

        if (nomAntic.isEmpty() || nomNou.isEmpty()) {
            System.out.println("No s'ha trobat cap usuari amb aquest nom.");
            ConsoleUtils.dormirSegons(1.5);
            return false;
        } else {

            Usuari usuari = buscarUsuari(nomAntic);
            if (usuari != null) {

                usuari.setNom(nomNou);
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
        ConsoleUtils.saltarPagina("---ELIMINAR USUARI---");

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

    

}
