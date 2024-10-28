import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Livro.Livro;
import Singleton.Biblioteca;
import StateEmprestimo.Disponivel;
import TemplateMethod.Usuario;

public class Menu {
    private final Biblioteca biblioteca;
    private final Scanner scanner;

    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = -1;

        do {
            try {
                exibirMenu();
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1 -> adicionarLivro();
                    case 2 -> emprestarLivro();
                    case 3 -> devolverLivro();
                    case 4 -> biblioteca.listarLivrosDisponiveis();
                    case 5 -> biblioteca.listarEmprestimos();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.nextLine(); // Limpa a entrada inválida
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);

        System.out.println("Programa finalizado.");
    }

    private void exibirMenu() {
        System.out.println("\n---- Menu Biblioteca ----");
        System.out.println("1 - Adicionar Livro");
        System.out.println("2 - Emprestar Livro");
        System.out.println("3 - Devolver Livro");
        System.out.println("4 - Listar Livros Disponíveis");
        System.out.println("5 - Listar Empréstimos Realizados");
        System.out.println("0 - Sair");
    }

    private void adicionarLivro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Livro livro = new Livro(titulo, autor, isbn);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro adicionado!");
    }

    private void emprestarLivro() {
        Usuario usuario = CadastroUsuario.cadastrarUsuario();

        biblioteca.listarLivrosDisponiveis();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ISBN do livro para emprestar: ");
        String isbn = scanner.nextLine();

        Livro livro = biblioteca.buscarLivroPorISBN(isbn);
        if (livro != null && livro.getEstado() instanceof Disponivel) {
            livro.emprestar();
            Biblioteca.registrarEmprestimo(usuario, livro);
            System.out.println("Empréstimo realizado para " + usuario.getNome() + ".");
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }

    private void devolverLivro() {
        System.out.print("ISBN do livro: ");
        String isbn = scanner.nextLine();

        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            livro.devolver();
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void listarLivrosAcervo() {
        System.out.println("\n--- Livros no Acervo ---");
        if (biblioteca.getLivros().isEmpty()) {
            System.out.println("Nenhum livro no acervo.");
        } else {
            biblioteca.getLivros().forEach(livro -> System.out.println("- " + livro.getTitulo() + " | " + livro.getIsbn()));
        }
    }

//    private void listarEmprestimos() {
//        System.out.println("\n--- Empréstimos Realizados ---");
//        if (biblioteca.getEmprestimos().isEmpty()) {
//            System.out.println("Nenhum empréstimo realizado.");
//        } else {
//            biblioteca.getEmprestimos().forEach(livro -> System.out.println("- " + livro.getTitulo() + " | " + livro.getIsbn()));
//        }
//    }

    private Livro buscarLivro(String isbn) {
        for (Livro livro : biblioteca.getLivros()) {
            if (livro.toString().contains(isbn)) {
                return livro;
            }
        }
        return null;
    }
}
