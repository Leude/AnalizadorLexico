package automatas;

public abstract class Automata {
    protected int estado = 0;
    protected boolean activo = true;

    protected String lexema="";

    public abstract boolean validar(int codigo);

    public abstract boolean esFinal();

    public void reiniciar() {
        estado = 0;
        activo=true;
        lexema="";
    }

    public boolean estaActivo(){
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getLexema() {
        return lexema;
    }

    @Override
    public String toString() {
        return "Automata{" +
                "estado=" + estado +
                ", activo=" + activo +
                ", lexema='" + lexema + '\'' +
                '}';
    }

    public abstract String getClasificacion() ;


}
