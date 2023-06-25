package vetores;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Usuario;

public class Usuarios {
    List<Usuario> usuarios;

    public Usuario getUser(int index) {
        return usuarios.get(index);
    }

    public void setUsuarios(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public Usuarios() {
        usuarios = new ArrayList<>();
    }

    public boolean login(String nome, int senha) {
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).getUsuario().equals(nome)) {
                if (getUser(i).getSenha() == senha) {
                    return true;
                }
            }
        }
        return false;

    }

    public void escreverArquivo() {
        PrintWriter pw = null;
        try {
            FileWriter out = new FileWriter("usuarios.csv");
            pw = new PrintWriter(out);
            for (int i = 0; i < usuarios.size(); i++) {
                pw.println(this.usuarios.get(i).toString());
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
                Usuario usuario = new Usuario(linha[0],Integer.parseInt(linha[1]));
                setUsuarios(usuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            arquivoProfessorR.close();
        }
    }
}
