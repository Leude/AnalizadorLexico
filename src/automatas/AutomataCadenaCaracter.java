package automatas;

public class AutomataCadenaCaracter extends Automata {

    @Override
    public boolean validar(int codigo) {
        char ch = (char) codigo;
        switch (estado) {
            case 0 -> {
                switch (codigo) {
                    case 34 -> {
                        lexema += ch;
                        estado = 3;
                        return true;
                    }
                    case 39 -> {
                        lexema += ch;
                        estado = 1;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 1 -> {
                if (codigo >= 0 && codigo <= 255 && codigo != 39 && codigo != 34) {
                    lexema += ch;
                    estado = 2;
                    return true;
                } else if (codigo == 34) {
                    lexema += ch;
                    estado = 3;
                    return true;
                } else if (codigo == 39) {
                    lexema += ch;
                    return true;
                } else {
                    estado = 0;
                    return false;
                }
            }
            case 2 -> {
                if (codigo == 39) {
                    lexema += ch;
                    estado = 4;
                    return true;
                } else {
                    return false;
                }
            }
            case 3 -> {
                if (codigo >= 0 && codigo <= 255 && codigo != 34) {
                    lexema += ch;
                    return true;
                } else if (codigo == 34) {
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
        return estado == 4;
    }

    @Override
    public String getClasificacion() {
        return "Caracter o Cadena";
    }
}
