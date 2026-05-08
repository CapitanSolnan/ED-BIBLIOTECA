package models;
import utils.Colors;

public class Llibre {
    private String titol;
    private String autor;
    private String categoria;
    private boolean prestat;

    public Llibre(String titol, String autor, String categoria) {
        this.titol = titol;
        this.autor = autor;
        this.categoria = comprovarCategoria(categoria);
        this.prestat = false;
    }

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
        }else if (categoria.equalsIgnoreCase("Altres")) {
            return "Altres";            
        }else{
            System.out.println(Colors.VERMELL + "Categoria no vàlida. S'ha assignat la categoria 'Altres' per defecte." + Colors.RESET);
            return "Altres";
        }

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitol() { 
        return titol; 
    }
    public String getAutor() { 
        return autor; 
    }
    public boolean esPrestat() { 
        return prestat; 
    }
    public void prestar() { 
        prestat = true; 
    }
    public void retornar() { 
        prestat = false; 
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    
    @Override
    //toString retorna el titulo, el autor y luego si prestat es true dice en presetec y en false disponible
    public String toString() {
        return titol + " de " + autor + (prestat ? Colors.GROC+" (En préstec)" + Colors.RESET : Colors.VERD +" (Disponible)" + Colors.RESET);
    }
}
