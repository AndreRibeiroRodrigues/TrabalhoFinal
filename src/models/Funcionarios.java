package models;

import java.util.ArrayList;
import java.util.List;

public class Funcionarios {
    private List<Funcionario> funcionarios;

    Funcionarios() {
        this.funcionarios = new ArrayList<Funcionario>();

    }

    public Funcionario getPessoas(int indice) {
        return this.funcionarios.get(indice);
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
                this.funcionarios.get(i).toString();
            }
        }

    }

}
