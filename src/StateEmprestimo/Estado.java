package StateEmprestimo;

import Livro.Livro;

public interface Estado {
    public boolean verificarDisponibilidade();
    public void updateToDisponivel(Livro livro);
    public void updateToEmprestado(Livro livro);
}
