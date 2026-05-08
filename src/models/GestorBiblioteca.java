package models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Colors;

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
            System.out.println(Colors.VERMELL + "Aquest llibre ja està prestat (sense estoc)." + Colors.RESET);
        }
    }

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

    public List<Map.Entry<String, Long>> getLlibresMesPrestats() {
        return prestecs.stream()
            .collect(Collectors.groupingBy(p -> p.getLlibre().getTitol(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .toList();
    }

    public List<Map.Entry<String, Long>> getLectorsMesActius() {
        return prestecs.stream()
            .collect(Collectors.groupingBy(p -> p.getUsuari().getNom(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .toList();
    }

    public Map<String, Long> getPrestecPerCategoria() {
        return prestecs.stream()
            .collect(Collectors.groupingBy(p -> p.getLlibre().getCategoria(), Collectors.counting()));
    }

    public int getTotalPrestecs() {
        return prestecs.size();
    }
}