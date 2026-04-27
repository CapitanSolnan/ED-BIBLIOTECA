import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utils.Colors;

//GestorBiblioteca se inicia con una array de los prestados
// se asigna a un usuario y a un llibre  con la funcion prestarLlibre(usuari, llibre)

public class GestorBiblioteca {
    private List<Prestec> prestecs;

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        if (!llibre.esPrestat()) {
            llibre.prestar();
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
            prestecs.add(prestec);
            usuari.afegirLlibre(llibre);
            System.out.println(Colors.BLANC + usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol() + Colors.RESET);
        } else {
            System.out.println(Colors.VERMELL + "Aquest llibre ja està prestat." + Colors.RESET);
        }
    }


}
