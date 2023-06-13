package models;
public class Gerente extends Funcionario {
    private double bonus;

    public Gerente() {
        super();
        this.bonus = 0;
    }

    public Gerente(String nome, int idade, char sexo, double salario, String setor, double bonus) {
        super(nome, idade, sexo, salario, setor);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void atualizarSalario(double perc){
        double novoS = super.getSalario() * (1*perc/100);
        super.setSalario(novoS);
    }

    @Override
    public String toString() {
        return super.toString() + "\nbonus" + bonus;
    }
}
