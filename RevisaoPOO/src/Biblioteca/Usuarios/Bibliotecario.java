package Biblioteca.Usuarios;

import Biblioteca.Midia;

public class Bibliotecario extends Funcionario{
    public Bibliotecario(String nome, String usuario, String senha, int matricula, double salario) {
        super(nome, usuario, senha, matricula, salario);
    }
    @Override
    public void cadastrarUsuario(Usuario usuario){
        if(!(usuario instanceof Bibliotecario)) {
            Usuario.addUsuario(usuario);
        }
    }

    @Override
    public void removerUsuario(Usuario usuario) {

    }
//    @Override
//    public void removerUsuario(Usuario usuario) {
//        if(!(usuario instanceof Bibliotecario)) {
//            Usuario.removeUsuario(usuario);
//        }
//    }

    public void cadastrarMidia (Midia midia) {
        Midia.addMidia(midia);
    }
    public void removerMidia (int codigo) {
        Midia.removeMidia(codigo);
    }
}
