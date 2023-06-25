package models;

public class Usuario{
    private String usuario;
    private int senha;

    public Usuario(String usuario, int senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    public Usuario() {
        this.usuario = "";
        this.senha = 0;
    }

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
        return usuario + ";" + senha;
    }

}
