package Biblioteca.Midias;

import Biblioteca.Midia;

public class Jornal extends Midia {

    String edicao;
    public Jornal(int codigo, String edicao) {
        super(codigo);
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return "\nCódigo da mídia:" + getCodigo() + ", edição do Jornal: " + this.edicao;
    }
}
