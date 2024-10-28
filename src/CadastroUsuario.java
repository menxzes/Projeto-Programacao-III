import TemplateMethod.Estudante;
import TemplateMethod.Professor;
import TemplateMethod.Usuario;
import TemplateMethod.UsuarioComum;

import java.util.Scanner;

public class CadastroUsuario {
    public static Usuario cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o ID do usuário: ");
        String id = scanner.nextLine();

        System.out.print("O usuário é: (1) Estudante, (2) Professor, (3) Comum: ");
        int tipo = scanner.nextInt();

        switch (tipo) {
            case 1 -> {
                return new Estudante(nome, id);
            }
            case 2 -> {
                return new Professor(nome, id);
            }
            default -> {
                return new UsuarioComum(nome, id);
            }
        }
    }
}
