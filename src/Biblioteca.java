import java.util.ArrayList;
import java.util.List;

//biblioteca inicia con una array de los libros
// se añaden libros con afegirLlibre(llibre)
// se puede ver que libro hay con buscarLlibre

public class Biblioteca {
    private List<Llibre> llibres;
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
}
