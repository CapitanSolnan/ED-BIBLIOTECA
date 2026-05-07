import java.util.Scanner;

public class Llibre {
    private String titol;
    private String autor;
    private String categoria;

    private int totalExemplars;
    private int exemplarsDisponibles;

    // ✔ Constructor antic (no es trenca res)
    public Llibre(String titol, String autor, String categoria) {
        this(titol, autor, categoria, 1); // per defecte 1 exemplar
    }

    // ✔ Constructor nou amb estoc
    public Llibre(String titol, String autor, String categoria, int totalExemplars) {
        this.titol = titol;
        this.autor = autor;
        this.categoria = categoria;

        this.totalExemplars = totalExemplars;
        this.exemplarsDisponibles = totalExemplars;
    }

    public boolean hiHaExemplars() {
        return exemplarsDisponibles > 0;
    }

    public void prestar() {
        exemplarsDisponibles--;
    }

    public void retornar() {
        exemplarsDisponibles++;
    }
    

    public String getTitol() { return titol; }
    public String getAutor() { return autor; }

    @Override
    public String toString() {
        return titol + " de " + autor +
               " | Disponibles: " + exemplarsDisponibles +
               "/" + totalExemplars;
    }
}
