package Singleton;

import java.util.ArrayList;
import java.util.List;
import Livro.Livro;
import StateEmprestimo.Disponivel;
import TemplateMethod.Usuario;
import Emprestimo.Emprestimo;


public class Biblioteca {
    private static Biblioteca instancia;
    private List<Livro> livros;
    private static List<Emprestimo> emprestimos;

    private Biblioteca() {
        livros = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public static Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro '" + livro.getTitulo() + "' adicionado ao acervo.");
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Livros disponíveis para empréstimo:");
        for (Livro livro : livros) {
            if (livro.getEstado() instanceof Disponivel) {
                System.out.println("Título: " + livro.getTitulo() + ", ISBN: " + livro.getIsbn());
            }
        }
    }

    public Livro buscarLivroPorISBN(String isbn) {
        return livros.stream().filter(l -> l.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

//    public static void adicionarEmprestimo(Livro livro) {
//        if (!emprestimos.contains(livro)) {
//            emprestimos.add(livro);
//            System.out.println("Livro '" + livro.getTitulo() + "' adicionado aos empréstimos.");
//        }
//    }

//    public static void removerEmprestimo(Livro livro) {
//        if (emprestimos.remove(livro)) {
//            System.out.println("Livro '" + livro.getTitulo() + "' removido dos empréstimos.");
//        } else {
//            System.out.println("Erro: Livro não encontrado nos empréstimos.");
//        }
//    }

    public static void registrarEmprestimo(Usuario usuario, Livro livro) {
        emprestimos.add(new Emprestimo(usuario, livro));
    }

    public static void removerEmprestimo(Livro livro) {
        emprestimos.removeIf(e -> e.getLivro().equals(livro));
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos registrados.");
        } else {
            System.out.println("Lista de Empréstimos:");
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(emprestimo);
            }
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
