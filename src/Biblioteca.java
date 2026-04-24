import java.util.ArrayList;
import java.util.List;

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
}
