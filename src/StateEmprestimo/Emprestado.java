package StateEmprestimo;

import Livro.Livro;
import Singleton.Biblioteca;

public class Emprestado implements Estado {
    Livro livro;

    public Emprestado(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean verificarDisponibilidade() {
        System.out.println("Livro indisponível.");
        return false;
    }

    @Override
    public void updateToDisponivel(Livro livro) {
        livro.setEstado(new Disponivel(livro));
        Biblioteca.removerEmprestimo(livro);  // Remover dos empréstimos
        System.out.println("Livro '" + livro.getTitulo() + "' devolvido e agora está disponível.");
    }

    @Override
    public void updateToEmprestado(Livro livro) {
        System.out.println("Livro já está emprestado.");
    }
}
