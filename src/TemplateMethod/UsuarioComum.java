package TemplateMethod;

public class UsuarioComum extends Usuario {
    public UsuarioComum(String nome, String id) {
        super(nome, id);
    }

    @Override
    protected double getValorPorDia() {
        return 2.0;
    }

    @Override
    protected double aplicarDesconto(double valorBase) {
        return valorBase; // Sem desconto
    }
}
