package models;
public class Pessoa {
    private String nome;
    private int idade;
    private char sexo;
   

    public Pessoa(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Pessoa() {
        this.nome = "";
        this.idade = 0;
        this.sexo = ' ';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade + "\n Sexo: " + sexo;
    }
}