package Biblioteca.Midias;

import Biblioteca.Midia;

public class Revista extends Midia {
    String titulo;
    public Revista(int codigo, String titulo) {
        super(codigo);
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "\nCódigo da mídia:" + getCodigo() + ", titulo da revista: " + this.titulo;
    }
}
