package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Midia {

    //diferença abstract para interface => a interface é mais focada em métodos, é como se fosse um
    // contrato onde é obrigado a seguir as declarações etc dos métodos
    private static final ArrayList<Midia> midias = new ArrayList<>();

    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    private boolean emprestado;

    public static List<Midia> getMidias(){
        return Collections.unmodifiableList(midias);
    }

    public static void addMidia (Midia midia) {
        midias.add(midia);
    }
    public static void removeMidia (int codigo) {
        for (Midia midia : midias) {
            if(midia.codigo == codigo) {
                midias.remove(midia);
                break;
            }
        }
    }
    public static Midia procurarMidia (int codigo) {
        for (Midia midia: midias) {
            if(midia.codigo == codigo) {
                return midia;
            }
        }
        return null;
    }

    public boolean isEmprestado() {
        return emprestado;
    }
    public void alterarEmprestimo(int codigo){
        for (Midia midia: midias) {
            if(midia.codigo == codigo) {
                this.emprestado = !this.emprestado;
            }
        }
    }

    @Override
    public String toString() {
        return "\nCódigo da mídia:" + codigo + ", emprestado: " + emprestado;
    }
    public Midia (int codigo){
        this.codigo = codigo;
    }

}
