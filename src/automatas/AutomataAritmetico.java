package automatas;

public class AutomataAritmetico extends Automata {


    @Override
    public boolean validar(int codigo) {
        char ch = (char) codigo;
        switch (estado) {
            case 0 -> {
                switch (codigo) {
                    case '+' -> {
                        lexema += ch;
                        estado = 1;
                        return true;
                    }
                    case '-' -> {
                        lexema += ch;
                        estado = 2;
                        return true;
                    }
                    case '/', '*' -> {
                        lexema += ch;
                        estado = 3;
                        return true;
                    }
                    case '=', '^', '%' -> {
                        lexema += ch;
                        estado = 4;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 1 -> {

                if (codigo == '+' || codigo == '=') {
                    lexema += ch;
                    estado = 4;
                    return true;
                } else {
                    return false;
                }
            }
            case 2 -> {
                if (codigo == '-' || codigo == '=') {
                    lexema += ch;
                    estado = 4;
                    return true;
                } else {
                    return false;
                }
            }
            case 3 -> {
                if (codigo == '=') {
                    lexema += ch;
                    estado = 4;
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
        return estado == 1 || estado == 2 || estado == 3 || estado == 4;
    }

    @Override
    public String getClasificacion() {
        return "Símbolo Aritmético";
    }


}
