package automatas;

public class AutomataOtros extends Automata {

    @Override
    public boolean validar(int codigo) {
        char ch = (char) codigo;
        if (estado == 0) {
            switch (codigo) {
                case 40, 41, 44, 59, 91, 93, 123, 125 -> {
                    lexema += ch;
                    estado = 1;
                    return true;
                }
                default -> {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean esFinal() {
        return estado == 1;
    }

    @Override
    public String getClasificacion() {
        return "Otros Simbolos";
    }
}
