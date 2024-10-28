package Livro;

import StateEmprestimo.Disponivel;
import StateEmprestimo.Emprestado;
import StateEmprestimo.Estado;
import Singleton.Biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private Estado estado;
    private Estado disponivel;
    private Estado emprestado;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = new Disponivel(this); // Inicia como Disponível.
        this.emprestado = new Emprestado(this);
        this.disponivel = new Disponivel(this);
    }

    public void emprestar() {
        estado.updateToEmprestado(this);
    }

    public void devolver() {
        estado.updateToDisponivel(this);
    }

    public void setEstado(Estado novoEstado) {
        this.estado = novoEstado;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (ISBN: " + isbn + ")";
    }
}
