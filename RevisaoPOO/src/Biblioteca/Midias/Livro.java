package Biblioteca.Midias;

import Biblioteca.Midia;

public class Livro extends Midia {
    String titulo;
    public Livro(int codigo, String titulo) {
        super(codigo);
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        return "\nCódigo da mídia:" + getCodigo() + ", titulo do livro: " + this.titulo;
    }
}
