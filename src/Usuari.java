import java.util.ArrayList;
import java.util.List;
// usuari se crea con el nom
// llibresPrestats utiliza una arraylist al empezar

public class Usuari {
    private static final int MAX_LLIBRES = 3;
    private String nom;
    private List<Llibre> llibresPrestats;

    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
    }

    public boolean potAgafarMes() {
        return llibresPrestats.size() < MAX_LLIBRES;
        
    }
    public String getNom() { 
        return nom; 
    }
    public List<Llibre> getllibresPrestats() { 
        return llibresPrestats; 
    }
    public void afegirLlibre(Llibre llibre) { 
        llibresPrestats.add(llibre); 
    }
    public void retornarLlibre(Llibre llibre) { 
        llibresPrestats.remove(llibre); 
    }

    public void disponibilitatLlibre(){

        System.out.println("--- Llibres Disponibles ---");
        for (Llibre llibre : llibresPrestats) {
            if (!llibre.hiHaExemplars()) {
                System.out.println(llibre);

            }else{
                System.out.println("No hi ha llibres disponibles");
            }
        }
        System.out.println("--- Llibres Prestats ---");

        for (Llibre llibre : llibresPrestats) {
            if (llibre.hiHaExemplars()) {
                System.out.println(llibre);

            }else{
                System.out.println("No hi ha llibres prestats");
            }
        }
    }
}