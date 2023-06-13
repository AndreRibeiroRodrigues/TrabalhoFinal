package models;

public class Funcionario extends Pessoa {
    private double salario;
    private String setor;

    public Funcionario(String nome, int idade, char sexo, double salario, String setor) {
        super(nome, idade, sexo);
        this.salario = salario;
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Funcionario() {
        super();
        this.salario = 0;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void atualizarSalario(double perc) {
        double novoS = this.salario * (1 * perc / 100);
        this.salario = novoS;
    }

    @Override
    public String toString() {
        return super.toString() + "\nsalario: " + salario;
    }
}
