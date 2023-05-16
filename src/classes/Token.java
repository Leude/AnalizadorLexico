package classes;

public class Token {
    public int columna;
    public int fila;
    public String lexema;
    public String nombre;

    public Token(String nombre, String lexema, int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        this.lexema = lexema;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "\n|\t" + lexema +"\t|\t"+nombre + "\t|\t" + fila + "\t|\t" + columna;
    }


}
