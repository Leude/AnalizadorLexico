package automatas;

public class AutomataIdentificador extends Automata{

    @Override
    public boolean validar(int cod) {
        char ch = (char) cod;

        switch (estado) {
            case 0 -> {
                if ((cod >= 65 && cod <= 90) || (cod >= 97 && cod <= 122) || ch=='$'|ch=='_') {
                    lexema += ch;
                    estado = 1;
                    return true;
                } else {
                    return false;
                }
            }
            case 1 -> {
                if (cod >= 65 && cod <= 90 || cod >= 97 && cod <= 122 || ch=='$'|ch=='_'||cod>=48 && cod<=57){
                    lexema += ch;
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean esFinal() {
        return estado==1;
    }

    @Override
    public String getClasificacion() {
        return "Identificador";
    }
}
