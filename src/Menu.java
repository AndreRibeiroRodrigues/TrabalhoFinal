
import java.util.Scanner;

import models.Funcionario;
import models.Funcionarios;
import models.Usuario;
import models.Usuarios;

public class Menu {
    private static Funcionarios funcionarios = new Funcionarios();
    private static Funcionario funcionario = new Funcionario();
    private static Usuario usuario = new Usuario();
    private static Usuarios usuarios = new Usuarios();
    private static Scanner scanner = new Scanner(System.in);
    static boolean status = true;

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Calcular Média de Salários");
            System.out.println("3. Listar Funcionários por Setor");
            System.out.println("4. Atualizar Salário de um Funcionário");
            System.out.println("5. Adicionar Usuário");
            System.out.println("6. Login");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (status == true) {
                        adicionarFuncionario();
                    }
                    break;
                case 2:
                    if (status == true) {
                        calcularMediaSalarios();
                    }
                    break;
                case 3:
                    if (status == true) {
                        listarFuncionariosPorSetor();
                    }
                    break;
                case 4:
                    if (status == true) {
                        atualizarSalarioFuncionario();
                    }
                    break;
                case 5:
                    if (status == true) {
                        adicionarUsuario();
                    }
                    break;
                case 6:
                    logar();
                case 7:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void logar() {
        System.out.print("Digite o usuario: ");
        String usuario = scanner.next();
        System.out.print("Digite a senha: ");
        int senha = scanner.nextInt();
        if(usuarios.login(usuario, senha)){
            status = usuarios.login(usuario, senha);
        }else{
            System.err.println("Usuario ou senha errado");
        }
    }

    private static void atualizarSalarioFuncionario() {
    }

    private static void listarFuncionariosPorSetor() {
    }

    private static void calcularMediaSalarios() {
    }

    private static void adicionarFuncionario() {
        System.out.println("=== Adicionar Funcionário ===");
        System.out.println("Nome: ");
        funcionario.setNome(scanner.nextLine());
        System.out.println("Idade: ");
        funcionario.setIdade(scanner.nextInt());
        System.out.println("Sexo: ");
        funcionario.setSexo(scanner.next().charAt(0));
        scanner.nextLine();
        System.out.println("Salário: ");
        funcionario.setSalario(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Setor: ");
        funcionario.setSetor(scanner.nextLine());
        System.out.println("Data de Inicio");
        System.out.println("Digite dd/mm/aaaa");
        funcionario.setDataInicio(scanner.next());
        funcionarios.setPessoas(funcionario);
        System.out.println("Funcionário adicionado com sucesso!\n");
        exibirMenu();
    }

    private static void adicionarUsuario() {
        System.out.println("=== Adicionar Usuário ===");
        System.out.println("Nome: ");
        usuario.setNome(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Idade: ");
        usuario.setIdade(scanner.nextInt());
        System.out.println("Sexo: ");
        usuario.setSexo(scanner.next().charAt(0));
        System.out.println("Usuário: ");
        usuario.setUsuario(scanner.nextLine());
        System.out.println("Senha: ");
        usuario.setSenha(scanner.nextLine());
        System.out.println("Usuário adicionado com sucesso!\n");
        exibirMenu();
    }
}
