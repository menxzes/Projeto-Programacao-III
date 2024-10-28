package TemplateMethod;

public class Professor extends Usuario {
    public Professor(String nome, String id) {
        super(nome, id);
    }

    @Override
    protected double getValorPorDia() {
        return 2.0;
    }

    @Override
    protected double aplicarDesconto(double valorBase) {
        return valorBase * 0.5; // 50% de desconto
    }
}
