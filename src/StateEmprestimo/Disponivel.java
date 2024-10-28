package StateEmprestimo;

import Livro.Livro;
import Singleton.Biblioteca;
import TemplateMethod.Usuario;

public class Disponivel implements Estado {
    Livro livro;
    Usuario usuario;

    public Disponivel(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean verificarDisponibilidade() {
        System.out.println("Livro disponível para empréstimo");
        return true;
    }

    @Override
    public void updateToDisponivel(Livro livro) {
        System.out.println("O livro já está disponível.");
    }

    @Override
    public void updateToEmprestado(Livro livro) {
        livro.setEstado(new Emprestado(livro));
        Biblioteca.registrarEmprestimo(usuario, livro);  // Adicionar aos empréstimos
        System.out.println("Livro '" + livro.getTitulo() + "' emprestado com sucesso.");
    }
}
