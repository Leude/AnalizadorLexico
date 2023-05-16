package automatas;

public class AutomataEntero extends Automata {

    @Override
    public boolean validar(int codigo) {
        char ch = (char)codigo;
        switch (estado) {
            case 0 -> {
                if (codigo == '0') {
                    lexema+=ch;
                    estado = 1;
                    return true;
                } else if (codigo >= 49 && codigo <= 57) {
                    lexema+=ch;
                    estado = 4;
                    return true;
                }else{
                    return false;
                }
            }
            case 1 -> {
                if (codigo == 'x') {
                    lexema+=ch;
                    estado = 2;
                    return true;
                } else {
                    return false;
                }
            }
            case 2, 3 -> {
                if (codigo >= 65 && codigo <= 70 || codigo >= 97 && codigo <= 102 || codigo >= 48 && codigo <= 57) {
                    lexema+=ch;
                    estado = 3;
                    return true;
                } else {
                    return false;
                }
            }
            case 4 -> {
                if (codigo >= 48 && codigo <= 57) {
                    lexema+=ch;
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
        return estado == 1||estado==4||estado==3;
    }

    @Override
    public String getClasificacion() {
        return "Entero";
    }
}
