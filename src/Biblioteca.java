import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Llibre> llibres;
    private List<Usuari> usuaris;
    
    public Biblioteca() {
        this.llibres = new ArrayList<>();
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
    public Usuari buscarUsuari(String nom) {
        for (Usuari usuari : usuaris) {
        if (usuari.getNom().equalsIgnoreCase(nom)) {
            return usuari;
        }
    }
    return null;
    }

    public void crearLlibre(Scanner teclat) {
        String titol = "";
        String autor = "";
        String categoria = "";

        System.out.println("Escriu el títol del llibre: ");
        if (titol != "") {
            titol = teclat.nextLine().trim();
        }
        
        System.out.println("Escriu el nom de l'autor: ");
        if (autor != "") {
            autor = teclat.nextLine().trim();
        }

        System.out.println("Escriu la categoria del llibre: ");
        if (cateogira != "") {
            categoria = teclat.nextLine().trim();
        }

        Llibre nouLlibre = new Llibre(titol, autor, categoria);

        getLlibres().add(nouLlibre);
    }
}
