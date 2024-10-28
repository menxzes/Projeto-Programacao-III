import Singleton.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstancia();
        Menu menu = new Menu(biblioteca);
        menu.iniciar();
    }
}
