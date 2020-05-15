package repository;

import entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> listaUsuario = new ArrayList<Usuario>();

    public Usuario addUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
        return usuario;
    }

    public void removeUsuario(Usuario usuario) {
        if (listaUsuario.contains(usuario)) {
            listaUsuario.remove(usuario);
        } else {
            System.out.println("Usuário não consta na lista!");
        }
    }

    public Integer retonaTamanhoLista() {
        return listaUsuario.size();
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public String retornaListaUsuarios() {
        return listaUsuario.toString();
    }

}
