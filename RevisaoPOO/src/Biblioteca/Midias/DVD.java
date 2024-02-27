package Biblioteca.Midias;

import Biblioteca.Midia;

public class DVD extends Midia {

    String nome;
    public DVD(int codigo, String nome) {
        super(codigo);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nCódigo da mídia:" + getCodigo() + ", nome do DVD: " + this.nome;
    }
}
