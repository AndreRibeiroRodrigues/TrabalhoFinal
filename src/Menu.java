
import java.util.Scanner;

import models.Funcionario;
import models.Usuario;
import vetores.Funcionarios;
import vetores.Usuarios;

public class Menu {
    private static Funcionarios funcionarios = new Funcionarios();
    private static Funcionario funcionario = new Funcionario();
    private static Usuario usuario = new Usuario();
    private static Usuarios usuarios = new Usuarios();
    private static Scanner scanner = new Scanner(System.in);
    static boolean status = false;
    static int opcao;

    public static void main(String[] args) {
        usuarios.lerArquivo("usuarios.csv");
        funcionarios.lerArquivo("funcionarios.csv");
        exibirMenu();
    }

    private static void exibirMenu() {
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar/demitir Funcionário");
            System.out.println("2. Listas funcionários");
            System.out.println("3. Atualizar salário");
            System.out.println("4. Adicionar Usuário");
            System.out.println("5. Login");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (status == true) {
                        adicionarFuncionario();
                        exibirMenu();
                    } else {
                        System.out.println("Voce precisa estar logado para utilozar esta função");
                        exibirMenu();
                    }
                    break;
                case 2:
                    if (status == true) {
                        Funcionarios();
                        exibirMenu();
                    } else {
                        System.out.println("Voce precisa estar logado para utilozar esta função");
                        exibirMenu();
                    }
                    break;
                case 3:
                    if (status == true) {
                        atualizarSalarioFuncionario();
                        exibirMenu();
                    } else {
                        System.out.println("Voce precisa estar logado para utilozar esta função");
                        exibirMenu();
                    }
                    break;
                case 4:
                    if (status == true) {
                        adicionarUsuario();
                        exibirMenu();
                    } else {
                        System.out.println("Voce precisa estar logado para utilozar esta função");
                        exibirMenu();
                    }
                    break;
                case 5:
                    logar();
                    exibirMenu();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    usuarios.escreverArquivo();
                    funcionarios.escreverArquivo();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 6);
    }

    private static void logar() {
        System.out.print("Digite o usuario: ");
        String usuario = scanner.next();
        System.out.print("Digite a senha: ");
        int senha = scanner.nextInt();
        if (usuarios.login(usuario, senha)) {
            status = usuarios.login(usuario, senha);
            System.out.println("logado");
            System.out.println(usuarios.login(usuario, senha));
        } else {
            System.err.println("Usuario ou senha errado");
        }
    }

    private static void atualizarSalarioFuncionario() {
        System.out.println("=== Atualizar Salário de um Funcionário ===");
        System.out.print("Digite a matricula do funcionário: ");
        int matricula = scanner.nextInt();
        if (funcionarios.getFuncionarios(matricula) != null) {
            System.out.print("Digite o percentual de aumento: ");
            int percentual = scanner.nextInt();
            funcionarios.getFuncionarios(matricula).atualizarSalario(percentual);
            System.out.println("Salário atualizado com sucesso!\n");
            exibirMenu();
        }
    }

    private static void Funcionarios() {
        System.out.println("==Escolha a opção==");
        System.out.println("1. Listar todos funcionarios");
        System.out.println("2. Listar funcionarios por setor");
        System.out.println("3. Listar funcionario por matricula");
        System.out.println("4. Listar funcionario acima da media");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                funcionarios.listartodosFuncionarios();
                break;
            case 2:
                System.out.print("Digite o setor: ");
                scanner.nextLine();
                String setor = scanner.nextLine();
                funcionarios.listarPorSetor(setor);
                break;
            case 3:
                System.out.print("Digite a Matricula do Funcionario: ");
                int matricula = scanner.nextInt();
                funcionarios.listarPorMatricula(matricula);
                break;
            case 4:
            break;
            default:
                break;
        }

    }

    private static void adicionarFuncionario() {
        System.out.println("Voce deseja contratar ou demitir?");
        System.out.println("1.Demitir \n2.contratar");
        opcao = scanner.nextInt();
        if (opcao == 1) {
            System.out.print("Digite a matricula do funcionario: ");
            int mat = scanner.nextInt();
            System.out.println("Digite a data de demição:");
            System.out.println("Formato: dd/mm/aaaa");
            String datafim = scanner.next();
            funcionarios.demitirFuncionario(mat, datafim);
        } else if (opcao == 2) {
            System.out.println("=== Adicionar Funcionário ===");
            System.out.print("matricula: ");
            funcionario.setMatricula(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Nome: ");
            funcionario.setNome(scanner.nextLine());
            System.out.print("Idade: ");
            funcionario.setIdade(scanner.nextInt());
            System.out.print("Sexo: ");
            funcionario.setSexo(scanner.next().toUpperCase().charAt(0));
            scanner.nextLine();
            System.out.print("Salário: ");
            funcionario.setSalario(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Setor: ");
            funcionario.setSetor(scanner.nextLine());
            System.out.println("Data de Inicio");
            System.out.println("Digite dd/mm/aaaa");
            funcionario.setDataInicio(scanner.next());
            funcionarios.setFuncionario(funcionario);
            System.out.println("Funcionário adicionado com sucesso!\n");
        }

    }

    private static void adicionarUsuario() {
        System.out.println("=== Adicionar Usuário ===");
        System.out.print("Usuário: ");
        usuario.setUsuario(scanner.next());
        System.out.print("Senha: ");
        usuario.setSenha(scanner.nextInt());
        usuarios.setUsuarios(usuario);
        System.out.println("Usuário adicionado com sucesso!\n");
    }
}
