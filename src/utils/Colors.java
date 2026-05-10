package utils;

/**
 * Classe utilitària que conté constants ANSI per aplicar colors
 * al text i al fons de la consola. No es pot instanciar.
 */
public final class Colors {

    /**
     * Constructor privat per evitar la instanciació de la classe.
     */
    private Colors() {
    }

    /** Reinicia el color per defecte de la consola. */
    public static final String RESET = "\u001B[0m";

    /* ---------------------- COLORS DE TEXT ---------------------- */

    /** Color negre intens. */
    public static final String NEGRE = "\u001B[38;5;235m";

    /** Color vermell vibrant. */
    public static final String VERMELL = "\u001B[38;5;196m";

    /** Color verd neó. */
    public static final String VERD = "\u001B[38;5;82m";

    /** Color groc pur. */
    public static final String GROC = "\u001B[38;5;226m";

    /** Color taronja elèctric. */
    public static final String TARONJA = "\u001B[38;5;208m";

    /** Color blau intens. */
    public static final String BLAU = "\u001B[38;5;33m";

    /** Color magenta/fúcsia. */
    public static final String MAGENTA = "\u001B[38;5;201m";

    /** Color cian brillant. */
    public static final String CIAN = "\u001B[38;5;51m";

    /** Color blanc pur. */
    public static final String BLANC = "\u001B[38;5;255m";

    /** Color gris. */
    public static final String GRIS = "\u001B[90m";

    /* ---------------------- COLORS DE FONS ---------------------- */

    /** Fons negre. */
    public static final String FONS_NEGRE = "\u001B[40m";

    /** Fons vermell granat. */
    public static final String FONS_VERMELL = "\u001B[48;5;88m";

    /** Fons verd fosc. */
    public static final String FONS_VERD = "\u001B[48;5;22m";

    /** Fons groc daurat. */
    public static final String FONS_GROC = "\u001B[48;5;136m";

    /** Fons blau marí. */
    public static final String FONS_BLAU = "\u001B[48;5;18m";

    /** Fons magenta fosc. */
    public static final String FONS_MAGENTA = "\u001B[48;5;89m";

    /** Fons cian petroli. */
    public static final String FONS_CIAN = "\u001B[48;5;24m";

    /** Fons blanc. */
    public static final String FONS_BLANC = "\u001B[47m";
}
