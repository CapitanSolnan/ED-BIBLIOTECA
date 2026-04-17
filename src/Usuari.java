import java.util.ArrayList;
import java.util.List;
// usuari se crea con el nom
// llibresPrestats utiliza una arraylist al empezar

//se puede añadir con afegirLlibre(llibre) y retornarLlibre(llibre)
public class Usuari {
    private String nom;
    private List<Llibre> llibresPrestats;

    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
    }
    public String getNom() { 
        return nom; 
    }
    public List<Llibre> getLlibresPrestats() { 
        return llibresPrestats; 
    }
    public void afegirLlibre(Llibre llibre) { 
        llibresPrestats.add(llibre); 
    }
    public void retornarLlibre(Llibre llibre) { 
        llibresPrestats.remove(llibre); 
    }
}