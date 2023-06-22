package vetores;

import java.util.ArrayList;
import java.util.List;

import models.Funcionario;

public class Funcionarios {
    private List<Funcionario> funcionarios;

    public Funcionarios() {
        this.funcionarios = new ArrayList<Funcionario>();

    }

    public Funcionario getFuncionarios(int matricula) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getMatricula() == matricula) {

                return this.funcionarios.get(i);
            }
        }
        return null;
    }

    public void setPessoas(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public double media() {
        double media;
        double soma = 0;
        for (int i = 0; i < this.funcionarios.size(); i++) {
            soma += this.funcionarios.get(i).getSalario();
        }
        media = soma / this.funcionarios.size();
        return media;
    }

    public void listarSalarios() {

        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getSalario() == this.media()) {
                this.funcionarios.get(i).toString();
            }
        }

    }

    public void listarPorSetor(String setor) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getSetor().equals(setor)) {
                this.funcionarios.get(i).toStringListagem();
            }
        }
    }

    public void listarPorMatricula(int matricula) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getMatricula() == matricula) {
                this.funcionarios.get(i).toStringListagem();
            }
        }
    }

    public void listartodosFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println(funcionarios.get(i).toStringListagem());
        }
    }

}
