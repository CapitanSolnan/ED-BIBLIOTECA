import java.time.LocalDate;

//prestec se crea con usuari, llibre y la data del prestec
// la data de retorn son 2 semanes més tard de la data del prestec


public class Prestec {
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;

    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2);
    }
    public Usuari getUsuari() { 
        return usuari; 
    }
    public Llibre getLlibre() { 
        return llibre; 
    }
    public LocalDate getDataRetorn() { 
        return dataRetorn; 
    }
    public LocalDate getDataPrestec() { 
        return dataPrestec; 
    }

}
