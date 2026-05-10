package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa un usuari de la biblioteca.
 * Cada usuari té un nom i una llista de llibres que té actualment en préstec.
 */
public class Usuari {

    private String nom;
    private List<Llibre> llibresPrestats;

    /**
     * Constructor de l'usuari.
     *
     * @param nom nom de l'usuari
     */
    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
    }

    /**
     * Retorna el nom de l'usuari.
     *
     * @return nom de l'usuari
     */
    public String getNom() { 
        return nom; 
    }

    /**
     * Assigna un nou nom a l'usuari.
     *
     * @param nom nou nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retorna la llista de llibres que l'usuari té en préstec.
     *
     * @return llista de llibres prestats
     */
    public List<Llibre> getLlibresPrestats() { 
        return llibresPrestats; 
    }

    /**
     * Afegeix un llibre a la llista de llibres prestats de l'usuari.
     *
     * @param llibre llibre prestat
     */
    public void afegirLlibre(Llibre llibre) { 
        llibresPrestats.add(llibre); 
    }

    /**
     * Elimina un llibre de la llista de llibres prestats de l'usuari.
     *
     * @param llibre llibre retornat
     */
    public void retornarLlibre(Llibre llibre) { 
        llibresPrestats.remove(llibre); 
    }

    /**
     * Retorna una representació en text de l'usuari.
     *
     * @return nom de l'usuari
     */
    @Override
    public String toString() {
        return "Nom: " + nom;
    }

}
