package utils;

/**
 * Classe utilitària que conté estils i formats de text per a la consola,
 * com títols, preguntes, respostes i estils com negreta o subratllat.
 * Aquesta classe només proporciona constants i no es pot instanciar.
 */
public class Estils {

    /* ---------------------- SECCIONS ---------------------- */

    /**
     * Estil per mostrar títols destacats amb fons gris, text cian i negreta.
     */
    public static final String TITOL = "\u001B[48;5;236m" + Colors.CIAN + Estils.NEGRETA;

    /**
     * Prefix estilitzat per mostrar preguntes a la consola.
     * Inclou una fletxa ❯ en cian i text en negreta.
     */
    public static final String PREGUNTA = Colors.CIAN + "❯ " + Colors.RESET + Estils.NEGRETA;

    /**
     * Prefix per indicar l'espai on l'usuari ha d'escriure la resposta.
     */
    public static final String RESPOSTA = Colors.BLANC + "┃ " + Colors.RESET;

    /* ---------------------- ESTILS DE TEXT ---------------------- */

    /**
     * Estil de text en negreta.
     */
    public static final String NEGRETA = "\u001B[1m";

    /**
     * Estil de text subratllat.
     */
    public static final String SUBRATLLAT = "\u001B[4m";
}
