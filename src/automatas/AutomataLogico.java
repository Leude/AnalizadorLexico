package automatas;

public class AutomataLogico extends Automata {


    public boolean validar(int codigo) {

        char ch = (char) codigo;

        switch (estado) {
            case 0 -> {
                switch (codigo) {
                    case 38 -> {
                        lexema += ch;
                        estado = 1;
                        return true;
                    }
                    case 124 -> {
                        lexema += ch;
                        estado = 2;
                        return true;
                    }
                    case 33 -> {
                        lexema += ch;
                        estado = 3;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 1 -> {
                if (codigo == 38) {
                    lexema += lexema;
                    estado = 3;
                    return true;
                } else {
                    return false;
                }
            }
            case 2 -> {
                if (codigo == 124) {
                    lexema += lexema;
                    estado = 3;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean esFinal() {
        return estado == 3;
    }

    @Override
    public String getClasificacion() {
        return "Simbolos Logicos";
    }
}
