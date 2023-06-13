package models;
public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario() {
        super();
        this.salario = 0;
    }

    public Funcionario(String nome, int idade, char sexo, double salario) {
        super(nome, idade, sexo);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void atualizarSalario(double perc){
        double novoS = this.salario * (1*perc/100);
        this.salario = novoS;
    }
@Override
public String toString(){
    return super.toString() + "\nsalario: "+salario;
}
}
