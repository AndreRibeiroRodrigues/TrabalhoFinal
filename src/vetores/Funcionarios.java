package vetores;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void setFuncionario(Funcionario funcionario) {
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

    public void demitirFuncionario(int matricula, String dataFim) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula() == matricula) {
                this.funcionarios.get(i).setDataFim(dataFim);
            }
        }

    }

    public void listarSalarios() {

        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getSalario() >= media()
                    && this.funcionarios.get(i).getDataFim() != null) {
                System.out.println(this.funcionarios.get(i).toStringListagem());
            }
        }

    }

    public void listarPorSetor(String setor) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getSetor().equals(setor) && this.funcionarios.get(i).getDataFim() == null) {
                System.out.println(this.funcionarios.get(i).toStringListagem());
            }
        }
    }

    public void listarPorMatricula(int matricula) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getMatricula() == matricula && this.funcionarios.get(i).getDataFim() == null) {
                System.out.println(this.funcionarios.get(i).toStringListagem());
            } else if (this.funcionarios.get(i).getMatricula() == matricula
                    && this.funcionarios.get(i).getDataFim() != null) {
                System.out.println("O funcionario nao trabalha mais na empresa.");
            }
        }
    }

    public void listartodosFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println(this.funcionarios.get(i).toStringListagem());
        }
    }

    public void escreverArquivo() {
        PrintWriter pw = null;
        try {
            FileWriter out = new FileWriter("funcionarios.csv");
            pw = new PrintWriter(out);
            for (int i = 0; i < funcionarios.size(); i++) {
                pw.println(this.funcionarios.get(i).toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pw.close();
        }

    }

    public void lerArquivo(String path) {
        Scanner arquivoProfessorR = null;
        try {
            FileReader nomeArq = new FileReader(path);
            arquivoProfessorR = new Scanner(nomeArq);

            while (arquivoProfessorR.hasNext()) {
                String linha[] = arquivoProfessorR.nextLine().split(";");
                Funcionario funcionario = new Funcionario(Integer.parseInt(linha[0]), linha[1],
                        Integer.parseInt(linha[2]), linha[3].charAt(0), Double.parseDouble(linha[4]), linha[5],
                        linha[6], linha[7]);
                setFuncionario(funcionario);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            arquivoProfessorR.close();
        }
    }

}
