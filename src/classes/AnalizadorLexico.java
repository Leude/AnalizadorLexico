package classes;

import automatas.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class AnalizadorLexico {

    public static File archivo_lectura;
    public static File archivo_tokens;
    public static AnalizadorLexico lexico;

    ArrayList<Token> tokenArrayList = new ArrayList<>();

    Stack<Automata> pila = new Stack<>();

    AutomataIdentificador automataIdentificador = new AutomataIdentificador();
    AutomataAritmetico automataAritmetico = new AutomataAritmetico();
    AutomataEntero automataEntero = new AutomataEntero();
    AutomataCadenaCaracter automataCaracter = new AutomataCadenaCaracter();
    AutomataFlotante automataFlotante = new AutomataFlotante();
    AutomataComentarios automataComentarios = new AutomataComentarios();
    AutomataPalabras automataPalabras = new AutomataPalabras();
    AutomataLogico automataLogico = new AutomataLogico();
    AutomataOtros automataOtros = new AutomataOtros();
    AutomataRelacional automataRelacional = new AutomataRelacional();


    public void iniciar(int codigo, int fila, int columna) {
        //comprobar si el codigo entra en un automata
        //'
        if (estanActivos()) {
            encontrarAutomata(codigo);
            if (!estanActivos()) {
                System.out.println((char) codigo);
                if (!pila.isEmpty()) {
                    Automata automata = pila.pop();
                    if (!(automata instanceof AutomataComentarios)) {
                        tokenArrayList.add(new Token(automata.getClasificacion(), automata.getLexema(), fila, columna));
                    }
                }
                reiniciarAutomatas();
                encontrarAutomata(codigo);
                if (estanActivos()) {
                    reiniciarAutomatas();
                    iniciar(codigo, fila, columna);
                } else {
                    reiniciarAutomatas();
                    System.out.println("El codigo no entra inicio: " + codigo);
                }
            }
        } else {
            if (!pila.isEmpty()) {
                Automata automata = pila.pop();

                tokenArrayList.add(new Token(automata.getClasificacion(), automata.getLexema(), fila, columna));
            }

            reiniciarAutomatas();

            encontrarAutomata(codigo);

            if (estanActivos()) {
                reiniciarAutomatas();
            }
        }
    }

    public void condicion(Automata automata, int codigo) {
        if (automata.estaActivo()) {
            if (!automata.validar(codigo)) {
                automata.setActivo(false);
                if (automata.esFinal()) {
                    System.out.println(automata);
                    pila.push(automata);
                }
            }
        }
    }

    public void reiniciarAutomatas() {
        automataAritmetico.reiniciar();
        automataEntero.reiniciar();
        automataCaracter.reiniciar();
        automataFlotante.reiniciar();
        automataLogico.reiniciar();
        automataOtros.reiniciar();
        automataRelacional.reiniciar();
        automataIdentificador.reiniciar();
        automataPalabras.reiniciar();
        automataComentarios.reiniciar();
        pila.clear();
    }

    public void imprimirTokens() {
        for (Token token1 : tokenArrayList) {
            System.out.println(token1);
        }
    }

    public ArrayList<Token> getTokenArrayList() {
        return tokenArrayList;
    }

    public boolean estanActivos() {
        return automataAritmetico.estaActivo() || automataEntero.estaActivo() ||
                automataCaracter.estaActivo() || automataFlotante.estaActivo() ||
                automataComentarios.estaActivo() || automataPalabras.estaActivo() ||
                automataLogico.estaActivo() || automataOtros.estaActivo() ||
                automataRelacional.estaActivo() || automataIdentificador.estaActivo();
    }


    public void encontrarAutomata(int codigo) {
        condicion(automataIdentificador, codigo);
        condicion(automataAritmetico, codigo);
        condicion(automataEntero, codigo);
        condicion(automataFlotante, codigo);
        condicion(automataLogico, codigo);
        condicion(automataOtros, codigo);
        condicion(automataRelacional, codigo);
        condicion(automataPalabras, codigo);
        condicion(automataCaracter, codigo);
        condicion(automataComentarios, codigo);
    }


    public static void cargarArchivo() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Archivo de Texto", "txt");
        chooser.setFileFilter(filter);
        try {
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                archivo_lectura = chooser.getSelectedFile();
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo");
        }
    }

    public static boolean analizadorLexico() {
        int codigo;
        int fila = 1;
        int columna = 0;
        lexico = new AnalizadorLexico();

        FileReader reader;
        try {
            reader = new FileReader(archivo_lectura);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el archivo");
            return false;
        }

        do {
            try {
                codigo = reader.read();
            } catch (IOException e) {
                System.out.println("No se puede leer el archivo por caracter");
                return false;
            }

            columna += 1;
            if (codigo == 10) {
                fila += 1;
                columna = 0;
            }

            lexico.iniciar(codigo, fila, columna);
        } while (codigo != -1);

        lexico.imprimirTokens();
        return true;

    }


    public static boolean crearArchivoTokens() {
        archivo_tokens = new File(archivo_lectura.getParent(),
                "Tokens_" + archivo_lectura.getName());

        try {
            archivo_tokens.createNewFile();
            return true;
        } catch (IOException e) {
            System.out.println("No se puede crear el archivo");
            return false;
        }
    }

    public static boolean escribirArchivoTokens() {
        try {
            PrintWriter writer = new PrintWriter(archivo_tokens);
            writer.write("");
            for (Token token : lexico.getTokenArrayList()) {
                writer.write(token.toString());
                writer.write("\n");
            }
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
