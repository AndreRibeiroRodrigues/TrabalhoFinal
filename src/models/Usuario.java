package models;

public class Usuario extends Pessoa {
    private String usuario;
    private int senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + usuario + ";" + senha;
    }

}
