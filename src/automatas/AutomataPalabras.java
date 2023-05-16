package automatas;

public class AutomataPalabras extends Automata {
    @Override
    public boolean validar(int codigo) {
        char ch = (char) codigo;
        switch (estado) {
            case 0 -> {
                switch (codigo) {
                    case 'r' -> {
                        lexema += ch;
                        estado = 1;
                        return true;
                    }
                    case 'b' -> {
                        lexema += ch;
                        estado = 6;
                        return true;
                    }
                    case 'f' -> {
                        lexema += ch;
                        estado = 10;
                        return true;
                    }
                    case 'e' -> {
                        lexema += ch;
                        estado = 18;
                        return true;
                    }
                    case 'i' -> {
                        lexema += ch;
                        estado = 21;
                        return true;
                    }
                    case 'd' -> {
                        lexema += ch;
                        estado = 23;
                        return true;
                    }
                    case 't' -> {
                        lexema += ch;
                        estado = 24;
                        return true;
                    }
                    case 'v' -> {
                        lexema += ch;
                        estado = 27;
                        return true;
                    }
                    case 'c' -> {
                        lexema += ch;
                        estado = 30;
                        return true;
                    }
                    case 'w' -> {
                        lexema += ch;
                        estado = 35;
                        return true;
                    }
                    case 's' -> {
                        lexema += ch;
                        estado = 39;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 1 -> {
                if (codigo == 'e') {
                    lexema += ch;
                    estado = 2;
                    return true;
                }
                return false;
            }
            case 2 -> {
                if (codigo == 't') {
                    lexema += ch;
                    estado = 3;
                    return true;
                }
                return false;
            }
            case 3 -> {
                if (codigo == 'u') {
                    lexema += ch;
                    estado = 4;
                    return true;
                }
                return false;
            }
            case 4 -> {
                if (codigo == 'r') {
                    lexema += ch;
                    estado = 5;
                    return true;
                }
                return false;
            }
            case 5 -> {
                if (codigo == 'n') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 6 -> {
                if (codigo == 'r') {
                    lexema += ch;
                    estado = 7;
                    return true;
                }
                return false;
            }
            case 7 -> {
                if (codigo == 'e') {
                    lexema += ch;
                    estado = 8;
                    return true;
                }
                return false;
            }
            case 8 -> {
                if (codigo == 'a') {
                    lexema += ch;
                    estado = 9;
                    return true;
                }
                return false;
            }
            case 9 -> {
                if (codigo == 'k') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 10 -> {
                switch (codigo) {
                    case 'a' -> {
                        lexema += ch;
                        estado = 11;
                        return true;
                    }
                    case 'l' -> {
                        lexema += ch;
                        estado = 14;
                        return true;
                    }
                    case 'o' -> {
                        lexema += ch;
                        estado = 17;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 11 -> {
                if (codigo == 'l') {
                    lexema += ch;
                    estado = 12;
                    return true;
                }
                return false;
            }
            case 12 -> {
                if (codigo == 's') {
                    lexema += ch;
                    estado = 13;
                    return true;
                }
                return false;
            }
            case 13, 20 -> {
                if (codigo == 'e') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 14 -> {
                if (codigo == 'o') {
                    lexema += ch;
                    estado = 15;
                    return true;
                }
                return false;
            }
            case 15 -> {
                if (codigo == 'a') {
                    lexema += ch;
                    estado = 16;
                    return true;
                }
                return false;
            }
            case 16 -> {
                if (codigo == 't') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 17 -> {
                if (codigo == 'r') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 18 -> {
                if (codigo == 'l') {
                    lexema += ch;
                    estado = 19;
                    return true;
                }
                return false;
            }
            case 19 -> {
                if (codigo == 's') {
                    lexema += ch;
                    estado = 20;
                    return true;
                }
                return false;
            }
            case 21 -> {
                switch (codigo) {
                    case 'n' -> {
                        lexema += ch;
                        estado = 22;
                        return true;
                    }
                    case 'f' -> {
                        lexema += ch;
                        estado = 48;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 22 -> {
                if (codigo == 't') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 23 -> {
                if (codigo == 'o') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 24 -> {
                if (codigo == 'r') {
                    lexema += ch;
                    estado = 25;
                    return true;
                }
                return false;
            }
            case 25 -> {
                if (codigo == 'u') {
                    lexema += ch;
                    estado = 26;
                    return true;
                }
                return false;
            }
            case 26, 38, 32 -> {
                if (codigo == 'e') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 27 -> {
                if (codigo == 'o') {
                    lexema += ch;
                    estado = 28;
                    return true;
                }
                return false;
            }
            case 28 -> {
                if (codigo == 'i') {
                    lexema += ch;
                    estado = 29;
                    return true;
                }
                return false;
            }
            case 29 -> {
                if (codigo == 'd') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 30 -> {
                switch (codigo) {
                    case 'a' -> {
                        lexema += ch;
                        estado = 31;
                        return true;
                    }
                    case 'h' -> {
                        lexema += ch;
                        estado = 33;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 31 -> {
                if (codigo == 's') {
                    lexema += ch;
                    estado = 32;
                    return true;
                }
                return false;
            }
            case 33 -> {
                if (codigo == 'a') {
                    lexema += ch;
                    estado = 34;
                    return true;
                }
                return false;
            }
            case 34 -> {
                if (codigo == 'r') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 35 -> {
                if (codigo == 'h') {
                    lexema += ch;
                    estado = 36;
                    return true;
                }
                return false;
            }
            case 36 -> {
                if (codigo == 'i') {
                    lexema += ch;
                    estado = 37;
                    return true;
                }
                return false;
            }
            case 37 -> {
                if (codigo == 'l') {
                    lexema += ch;
                    estado = 38;
                    return true;
                }
                return false;
            }
            case 39 -> {
                switch (codigo) {
                    case 't' -> {
                        lexema += ch;
                        estado = 40;
                        return true;
                    }
                    case 'w' -> {
                        lexema += ch;
                        estado = 44;
                        return true;
                    }
                    default -> {
                        return false;
                    }
                }
            }
            case 40 -> {
                if (codigo == 'r') {
                    lexema += ch;
                    estado = 41;
                    return true;
                }
                return false;
            }
            case 41 -> {
                if (codigo == 'i') {
                    lexema += ch;
                    estado = 42;
                    return true;
                }
                return false;
            }
            case 42 -> {
                if (codigo == 'n') {
                    lexema += ch;
                    estado = 43;
                    return true;
                }
                return false;
            }
            case 43 -> {
                if (codigo == 'g') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
            case 44 -> {
                if (codigo == 'i') {
                    lexema += ch;
                    estado = 45;
                    return true;
                }
                return false;
            }
            case 45 -> {
                if (codigo == 't') {
                    lexema += ch;
                    estado = 46;
                    return true;
                }
                return false;
            }
            case 46 -> {
                if (codigo == 'c') {
                    lexema += ch;
                    estado = 47;
                    return true;
                }
                return false;
            }
            case 47 -> {
                if (codigo == 'h') {
                    lexema += ch;
                    estado = 48;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean esFinal() {
        return estado == 48;
    }

    @Override
    public String getClasificacion() {
        return "Palabras Clave";
    }
}
