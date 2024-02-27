package Biblioteca;

import Biblioteca.Midias.DVD;
import Biblioteca.Midias.Jornal;
import Biblioteca.Midias.Livro;
import Biblioteca.Midias.Revista;
import Biblioteca.Usuarios.*;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static  Usuario usuarioLogado;
    private static Funcionario bibliotecario = new Bibliotecario("Joana", "Joana", "senha", 123, 1234.0);

    public static void main(String[] args) {

        Usuario.addUsuario(bibliotecario);
        Usuario atendente1 = new Atendente("Paolo", "Paolo", "senha", 720, 2764);
        Usuario.addUsuario(atendente1);
        Usuario cliente1 = new Cliente("Karol", "Karol", "senha");
        Usuario.addUsuario(cliente1);

        Midia dvd1 = new DVD(123, "DVD");
        Midia.addMidia(dvd1);
        Midia jornal1 = new Jornal(456, "Edicao 1");
        Midia.addMidia(jornal1);
        Midia livro1 = new Livro(789, "Livro");
        Midia.addMidia(livro1);
        Midia revista1 = new Revista(101112, "Revista");
        Midia.addMidia(revista1);

        inicio();
    }

    public static void inicio() {
        System.out.printf("Bem vindo à Biblioteca \n\n");
        System.out.printf("""
                1- Cadastro
                2- Login
                3- Sair
                """);
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> cadastroUsuario();
            case 2 -> login();
            case 3 -> logout();
        }
    }

    private static void cadastroUsuario() {
        System.out.printf("\nNovo cadastro \nDigite o seu nome: ");
        String nome = sc.next();
        System.out.println("Digite seu nome de usuário: ");
        String nomeUsuario = sc.next();
        System.out.println("Digite sua senha: ");
        String senha = sc.next();

        Usuario usuario = new Cliente(nome, nomeUsuario, senha);
        Usuario.addUsuario(usuario);
        menuUsuario(usuario);
    }

    private static void logout() {
        usuarioLogado = null;
        System.exit(0);
    }

    private static void login() {
        do {
            System.out.printf("\nUsuário: ");
            String usuario = sc.next();
            System.out.printf("Senha: ");
            String senha = sc.next();
            usuarioLogado = Usuario.login(usuario, senha);

        } while (usuarioLogado == null);
        menuUsuario(usuarioLogado);
    }

    private static void menuUsuario(Usuario usuario) {
        do {
            opcoesUsuario();

            System.out.printf("0-  Logout\n");
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1 -> alterarNome();
                case 2 -> alterarSenha();
                case 3 -> verEmprestimos();
                case 4 -> System.out.println(usuarioLogado.toString());
                case 5 -> consultarMidia();
                case 0 -> inicio();
                case 6 -> cadastrarCliente();
                case 7 -> removerUsuario();
                case 8 -> emprestarMidia(); //n ta pronto
                // case 9 é devolver-
                case 10 -> System.out.println(Midia.getMidias());
                case 11 -> cadastrarMidia();
                case 12 -> removerMidia();
                case 13 -> cadastrarAtendente();
                case 14 -> removerUsuario();
                case 15 -> verClientes();
            }

        } while (usuarioLogado != null);

    }

    private static void consultarMidia() {
        System.out.println("Digite o código da mídia: ");
        int codigo = sc.nextInt();
        System.out.println(Midia.procurarMidia(codigo));
    }

    private static void removerMidia() {
        System.out.println("Digite o codigo da midia: ");
        int codigo = sc.nextInt();
        Midia.removeMidia(codigo);
    }

    private static void removerUsuario() {
        System.out.println("Digite o nome do usuario: ");
        String nome = sc.next();

        Usuario.removeUsuario(nome);
    }

    public static void opcoesUsuario() {
        System.out.printf("""
                1-  Alterar nome
                2-  Alterar senha
                3-  Ver emprestimos
                4-  Ver perfil
                5-  Consultar disponibilidade de mídia
                """);
        if (usuarioLogado instanceof Funcionario){
            opcoesFucionario();
        }
    }

    public static void opcoesFucionario() {
        System.out.printf("""
                    6-  Cadastrar cliente 
                    7-  Remover cliente
                    8-  Emprestar mídia
                    9-  Devolver midia
                    10- Ver midias
                    """);
        if (usuarioLogado instanceof Bibliotecario){
            opcoesBibliotecario();
        }
    }

    public static void opcoesBibliotecario() {
        System.out.printf("""
                        11- Cadastrar midias
                        12- Remover midia
                        13- Cadastrar atendente
                        14- Remover atendente
                        15- Ver Clientes
                        """);
}
    public static void alterarNome() {
        System.out.println("\nNovo nome: ");
        String novoNome = sc.next();
        usuarioLogado.alterarNome(novoNome);
    }

    public static void alterarSenha() {
        System.out.println("\nNova senha: ");
        String novaSenha = sc.next();
        usuarioLogado.alterarSenha(novaSenha);
    }

    public static void verEmprestimos() {
        System.out.println("\nEmpréstimos: ");
        System.out.println(usuarioLogado.getEmprestimos());
    }

    public static void cadastrarCliente() {
        System.out.println("\nNome do cliente: ");
        String nome = sc.next();
        System.out.println("Nome de usuário do cliente: ");
        String nomeUsuario = sc.next();
        System.out.println("Senha do cliente: ");
        String senha = sc.next();
        Usuario cliente = new Cliente(nome, nomeUsuario, senha);
        Cliente.addUsuario(cliente);
        System.out.println("Cliente cadastrado: \n" + cliente.toString());
    }

    public static void emprestarMidia() {
        System.out.println("Digite o código da mídia: ");
        int codigo = sc.nextInt();
    }

    public static void cadastrarMidia() {
        System.out.println("""
                           \nQual a mídia a ser cadastrada?
                           1- DVD
                           2- Jornal
                           3- Livro
                           4- Revista
                           """);
        int escolha = sc.nextInt();
        System.out.println("\nDigite o código da mídia: ");
        int codigo = sc.nextInt();

        switch (escolha) {
            case 1: {
                System.out.println("Nome do DVD: ");
                String nome = sc.next();
                Midia midia = new DVD(codigo, nome);
                Midia.addMidia(midia);
                break;
            }
            case 2: {
                System.out.println("Edição do jornal: ");
                String edicao = sc.next();
                Midia midia = new Jornal(codigo, edicao);
                Midia.addMidia(midia);
                break;
            }
            case 3: {
                System.out.println("Título do livro: ");
                String titulo = sc.next();
                Midia midia = new Livro (codigo, titulo);
                Midia.addMidia(midia);
                break;
            }
            case 4: {
                System.out.println("Título da Revista: ");
                String titulo = sc.next();
                Midia midia = new Revista (codigo, titulo);
                Midia.addMidia(midia);
                break;
            }
        }
    }

    private static void cadastrarAtendente() {
        System.out.println("\nNome do atendente: ");
        String nome = sc.next();
        System.out.println("\nNome de usuário: ");
        String nomeUsuario = sc.next();
        System.out.println("\nSenha: ");
        String senha = sc.next();
        System.out.println("\nMatrícula: ");
        int matricula = sc.nextInt();
        System.out.println("\nSalário: ");
        double salario = Double.parseDouble(sc.next());

        Usuario atendente = new Atendente(nome, nomeUsuario, senha, matricula, salario);
        Usuario.addUsuario(atendente);
    }

    private static void verClientes() {
        for (Usuario usuario : Usuario.getUsuarios()) {
            if(usuario instanceof Cliente) {
                System.out.println(usuario);
            }
        }
    }
}