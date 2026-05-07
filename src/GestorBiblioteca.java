import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//GestorBiblioteca se inicia con una array de los prestados
// se asigna a un usuario y a un llibre  con la funcion prestarLlibre(usuari, llibre)

public class GestorBiblioteca {
    private List<Prestec> prestecs;

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }
    public void prestarLlibre(Usuari usuari, Llibre llibre) {

    if (!usuari.potAgafarMes()) {
        System.out.println("Has arribat al màxim de llibres permesos.");
        return;
    }

    if (llibre.hiHaExemplars()) {
        llibre.prestar();
        Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
        prestecs.add(prestec);
        usuari.afegirLlibre(llibre);
        System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
    } else {
        System.out.println("No queden exemplars disponibles.");
    }
}

    public void retornarLlibre(Usuari usuari, Llibre llibre) {
    llibre.retornar();
    usuari.retornarLlibre(llibre);
    System.out.println("Has retornat un exemplar de: " + llibre.getTitol());
    }



}
