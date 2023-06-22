package vetores;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class Usuarios {
    List<Usuario> usuarios = null;

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
            if (getUser(i).getUsuario().equals(nome)) {
                if (getUser(i).getSenha() == senha) {
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;

    }
}
