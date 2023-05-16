package automatas;

public class AutomataFlotante extends Automata {

    public boolean validar(int codigo) {
        char ch = (char) codigo;
        switch (estado) {
            case 0 -> {
                if (codigo >= 49 && codigo <= 57) {
                    lexema += ch;
                    estado = 2;
                    return true;
                } else if (codigo == 48) {
                    lexema += ch;
                    estado = 1;
                    return true;
                } else {
                    return false;
                }
            }
            case 1 -> {
                if (codigo == 46) {
                    lexema += ch;
                    estado = 3;
                    return true;
                } else {
                    return false;
                }
            }
            case 2 -> {
                if (codigo >= 48 && codigo <= 57) {
                    lexema += ch;
                    return true;
                } else if (codigo == 46) {
                    lexema += ch;
                    estado = 3;
                    return true;
                } else {
                    return false;
                }
            }
            case 3, 4 -> {
                if (codigo >= 48 && codigo <= 57) {
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
        return "Flotante";
    }
}
