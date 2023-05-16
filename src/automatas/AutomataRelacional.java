package automatas;

public class AutomataRelacional extends Automata {


    public boolean validar(int codigo) {

        char ch = (char) codigo;

        switch (estado) {
            case 0 -> {
                switch (codigo) {
                    case 60 -> {
                        lexema += ch;
                        estado = 1;
                        return true;
                    }
                    case 61 -> {
                        lexema += ch;
                        estado = 2;
                        return true;
                    }
                    case 62 -> {
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
                if (codigo == 61) {
                    lexema += ch;
                    estado = 3;
                    return true;
                } else {
                    return false;
                }
            }
            case 2 -> {
                if (codigo == 61 || codigo == 62) {
                    lexema += ch;
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
        return estado == 1 || estado == 3;
    }

    @Override
    public String getClasificacion() {
        return "Símbolos Relacionales";
    }
}
