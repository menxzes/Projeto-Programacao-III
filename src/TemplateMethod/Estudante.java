package TemplateMethod;

public class Estudante extends Usuario {
    public Estudante(String nome, String id) {
        super(nome, id);
    }

    @Override
    protected double getValorPorDia() {
        return 2.0;
    }

    @Override
    protected double aplicarDesconto(double valorBase) {
        return valorBase * 0.8; // 20% de desconto
    }
}
