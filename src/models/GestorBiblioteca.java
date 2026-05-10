package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Colors;

/**
 * Classe encarregada de gestionar els préstecs de la biblioteca.
 * Manté un registre de tots els préstecs realitzats i proporciona
 * funcionalitats per prestar llibres, retornar-los i obtenir estadístiques.
 */
public class GestorBiblioteca {

    private List<Prestec> prestecs;

    /**
     * Constructor que inicialitza la llista de préstecs.
     */
    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    /**
     * Realitza un préstec si el llibre té estoc disponible.
     *
     * @param usuari usuari que agafa el llibre
     * @param llibre llibre a prestar
     */
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        if (!llibre.esPrestat()) {
            llibre.prestar();
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
            prestecs.add(prestec);
            usuari.afegirLlibre(llibre);
            System.out.println(Colors.BLANC + usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol() + Colors.RESET);
        } else {
            System.out.println(Colors.VERMELL + "Aquest llibre ja està prestat (sense estoc)." + Colors.RESET);
        }
    }

    /**
     * Retorna un llibre prestat per un usuari, si realment el tenia en préstec.
     *
     * @param usuari usuari que retorna el llibre
     * @param llibre llibre a retornar
     * @return true si el retorn és correcte, false si l’usuari no tenia el llibre
     */
    public boolean retornarLlibre(Usuari usuari, Llibre llibre) {
        boolean teniaPrestec = false;
        for (Prestec p : prestecs) {
            if (p.getUsuari().equals(usuari) && p.getLlibre().equals(llibre)) {
                teniaPrestec = true;
                break;
            }
        }
        if (!teniaPrestec) {
            System.out.println(Colors.VERMELL + "Aquest usuari no té aquest llibre en préstec." + Colors.RESET);
            return false;
        }
        llibre.retornar();
        usuari.retornarLlibre(llibre);
        System.out.println(Colors.VERD + usuari.getNom() + " ha retornat el llibre: " + llibre.getTitol() + Colors.RESET);
        return true;
    }

    /**
     * Retorna una llista ordenada dels llibres més prestats.
     *
     * @return llista d'entrades (títol, nombre de préstecs)
     */
    public List<Map.Entry<String, Long>> getLlibresMesPrestats() {
        return prestecs.stream()
            .collect(Collectors.groupingBy(p -> p.getLlibre().getTitol(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .toList();
    }

    /**
     * Retorna una llista ordenada dels usuaris que han fet més préstecs.
     *
     * @return llista d'entrades (nom usuari, nombre de préstecs)
     */
    public List<Map.Entry<String, Long>> getLectorsMesActius() {
        return prestecs.stream()
            .collect(Collectors.groupingBy(p -> p.getUsuari().getNom(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .toList();
    }

    /**
     * Retorna un mapa amb el nombre de préstecs agrupats per categoria.
     *
     * @return mapa categoria → nombre de préstecs
     */
    public Map<String, Long> getPrestecPerCategoria() {
        return prestecs.stream()
            .collect(Collectors.groupingBy(p -> p.getLlibre().getCategoria(), Collectors.counting()));
    }

    /**
     * Retorna el nombre total de préstecs registrats.
     *
     * @return total de préstecs
     */
    public int getTotalPrestecs() {
        return prestecs.size();
    }
}
