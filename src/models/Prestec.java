package models;

import java.time.LocalDate;

/**
 * Classe que representa un préstec d'un llibre a un usuari.
 * Conté la informació del llibre prestat, l'usuari que el rep,
 * la data del préstec i la data prevista de retorn (2 setmanes després).
 */
public class Prestec {

    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;

    /**
     * Constructor del préstec.
     * La data de retorn es calcula automàticament sumant 2 setmanes
     * a la data del préstec.
     *
     * @param usuari      usuari que rep el llibre
     * @param llibre      llibre prestat
     * @param dataPrestec data en què es realitza el préstec
     */
    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2);
    }

    /**
     * Retorna l'usuari que ha agafat el llibre.
     *
     * @return usuari del préstec
     */
    public Usuari getUsuari() { 
        return usuari; 
    }

    /**
     * Retorna el llibre prestat.
     *
     * @return llibre del préstec
     */
    public Llibre getLlibre() { 
        return llibre; 
    }

    /**
     * Retorna la data prevista de retorn del llibre.
     *
     * @return data de retorn
     */
    public LocalDate getDataRetorn() { 
        return dataRetorn; 
    }

    /**
     * Retorna la data en què es va fer el préstec.
     *
     * @return data del préstec
     */
    public LocalDate getDataPrestec() { 
        return dataPrestec; 
    }

}
