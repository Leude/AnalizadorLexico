package automatas;

public class AutomataComentarios extends Automata {

    @Override
    public boolean validar(int codigo) {
        char ch = (char)codigo;
        switch (estado) {
            case 0 -> {
                if (codigo == '/') {
                    lexema+=ch;
                    estado = 1;
                    return true;
                } else {
                    return false;
                }
            }
            case 1 -> {
                if (codigo == '*') {
                    lexema+=ch;
                    estado = 4;
                    return true;
                } else if (codigo == '/') {
                    lexema+=ch;
                    estado = 3;
                    return true;
                } else {
                    return false;
                }
            }
            case 2 -> {
                if (codigo == '/') {
                    lexema+=ch;
                    estado = 5;
                    return true;
                } else {
                    return false;
                }
            }
            case 3 -> {
                if (codigo >= 0 && codigo <= 255 && codigo != 10) {
                    lexema+=ch;
                    return true;/**/
                } else if (codigo == 10) {
                    lexema+=ch;
                    estado = 5;
                    return true;
                } else {
                    return false;
                }
            }
            case 4 -> {
                if (codigo >= 0 && codigo <= 255 && codigo != '*') {
                    lexema+=ch;
                    return true;
                } else if (codigo == '*') {
                    lexema+=ch;
                    estado = 2;
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
        return estado == 5;
    }

    @Override
    public String getClasificacion() {
        return "Comentario";
    }
}
