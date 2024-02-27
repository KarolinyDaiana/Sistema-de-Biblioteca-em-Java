package Biblioteca.Usuarios;

public class Atendente extends Funcionario{

    public Atendente(String nome, String usuario, String senha, int matricula, double salario) {
        super(nome, usuario, senha, matricula, salario);
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        if(usuario instanceof Cliente){
            Usuario.addUsuario((usuario));
        }
    }

    @Override
    public void removerUsuario(Usuario usuario) {

    }
//    @Override
//    public void removerUsuario(Usuario usuario) {
//        if(usuario instanceof Cliente){
//            Usuario.removeUsuario((usuario));
//        }
//    }
}
