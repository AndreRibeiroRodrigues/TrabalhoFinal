package models;

public class Funcionario extends Pessoa {
    private int matricula;
    private double salario;
    private String setor;
    private String dataInicio;
    private String dataFim;

    public Funcionario(int matricula, String nome, int idade, char sexo , double salario, String setor, String dataInicio, String dataFim) {
        super(nome, idade, sexo);
        this.matricula = matricula;
        this.salario = salario;
        this.setor = setor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Funcionario() {
        super();
        this.salario = 0;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void atualizarSalario(double perc) {
        double novoS = this.salario * (1 * perc / 100);
        this.salario = this.salario + novoS;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int anoEmpregado(int ano) {
        if (this.dataFim == null) {
            return 0;
        } else {
            String[] vetDataFim = this.getDataFim().split("/");
            String[] vetDataInicio = this.getDataInicio().split("/");
            String anoInicio = vetDataInicio[2];
            String anoFim = vetDataFim[2];
            int anoEmpregado = Integer.parseInt(anoFim) + Integer.parseInt(anoInicio);
            return anoEmpregado;
        }
    }

    public String toStringListagem() {
        return super.toStringListagem() + " salario: " + salario+ "DataInicio: "+ dataInicio;
    }

    @Override
    public String toString() {
        return matricula + ";" + super.toString() + ";" + salario + ";" + setor + ";" + dataInicio + ";" + dataFim;
    }
}
