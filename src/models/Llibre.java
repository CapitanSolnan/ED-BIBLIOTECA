package models;

import utils.Colors;

/**
 * Classe que representa un llibre dins la biblioteca.
 * Conté informació del títol, autor, categoria i estoc disponible.
 * També gestiona les operacions de préstec i retorn.
 */
public class Llibre {

    private String titol;
    private String autor;
    private String categoria;
    private boolean prestat;
    private int stock;

    /**
     * Constructor del llibre.
     *
     * @param titol     títol del llibre
     * @param autor     autor del llibre
     * @param categoria categoria del llibre (es valida automàticament)
     * @param stock     nombre d'exemplars disponibles
     */
    public Llibre(String titol, String autor, String categoria, int stock) {
        this.titol = titol;
        this.autor = autor;
        this.categoria = comprovarCategoria(categoria);
        this.prestat = false;
        this.stock = stock;
    }

    /**
     * Comprova si la categoria introduïda és vàlida i retorna la forma correcta.
     * Si no és vàlida, assigna "Altres".
     *
     * @param categoria categoria introduïda
     * @return categoria validada
     */
    public String comprovarCategoria(String categoria) {
        if (categoria.equalsIgnoreCase("Ficcio") || categoria.equalsIgnoreCase("Ficció")) {
            return "Ficció";
        } else if (categoria.equalsIgnoreCase("Novella") || categoria.equalsIgnoreCase("Novel·la")) {
            return "Novel·la";
        } else if (categoria.equalsIgnoreCase("Historia") || categoria.equalsIgnoreCase("Història")) {
            return "Història";
        } else if (categoria.equalsIgnoreCase("Terror")) {
            return "Terror";
        } else if (categoria.equalsIgnoreCase("Biografia")) {
            return "Biografia";            
        } else if (categoria.equalsIgnoreCase("Altres")) {
            return "Altres";            
        } else {
            System.out.println(Colors.VERMELL + "Categoria no vàlida. S'ha assignat la categoria 'Altres' per defecte." + Colors.RESET);
            return "Altres";
        }
    }

    /**
     * Indica si hi ha estoc disponible del llibre.
     *
     * @return true si hi ha estoc, false si està esgotat
     */
    public boolean hiHaEstoc() {
        return stock > 0;
    }

    /**
     * Incrementa l'estoc del llibre quan es retorna.
     */
    public void retornar() {
        this.stock++;
    }

    /**
     * Redueix l'estoc del llibre quan es presta.
     * Si no hi ha estoc, mostra un missatge d'error.
     */
    public void prestar() { 
        if (hiHaEstoc()) {
            this.stock--;
        } else {
            System.out.println("no hi ha stock");
        }
    }

    /**
     * Retorna l'estoc actual del llibre.
     *
     * @return nombre d'exemplars disponibles
     */
    public int getStock() {
        return stock;
    }

    /**
     * Retorna la categoria del llibre.
     *
     * @return categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Assigna una nova categoria al llibre.
     *
     * @param categoria nova categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna el títol del llibre.
     *
     * @return títol
     */
    public String getTitol() { 
        return titol; 
    }

    /**
     * Retorna l'autor del llibre.
     *
     * @return autor
     */
    public String getAutor() { 
        return autor; 
    }

    /**
     * Indica si el llibre està prestat (sense estoc).
     *
     * @return true si no hi ha estoc, false si està disponible
     */
    public boolean esPrestat() { 
        return !hiHaEstoc();
    }

    /**
     * Assigna un nou títol al llibre.
     *
     * @param titol nou títol
     */
    public void setTitol(String titol) {
        this.titol = titol;
    }

    /**
     * Assigna un nou autor al llibre.
     *
     * @param autor nou autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Assigna un nou valor d'estoc al llibre.
     *
     * @param stock nou estoc
     */
    public void setStock(int stock){
        this.stock = stock;
    }

    /**
     * Retorna una representació en text del llibre,
     * incloent títol, autor i estat de disponibilitat.
     *
     * @return informació del llibre en format text
     */
    @Override
    public String toString() {
        String infoEstoc = (stock > 0) 
        ? Colors.VERD + " (Disponible: " + stock + " uds)" + Colors.RESET 
        : Colors.VERMELL + " (Esgotat) " + Colors.RESET;

        return titol + " de " + autor + (prestat ? Colors.GROC+" (En préstec)" + Colors.RESET : Colors.VERD + infoEstoc + Colors.RESET);
    }
}
