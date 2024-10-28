package TemplateMethod;

public abstract class Usuario {
    protected String nome;
    protected String id;

    public Usuario(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected abstract double getValorPorDia();
    protected abstract double aplicarDesconto(double valorBase);

    public double calcularMulta(int diasAtraso) {
        double valorBase = diasAtraso * getValorPorDia();
        return aplicarDesconto(valorBase);
    }
}
