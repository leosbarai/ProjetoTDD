package repository;

import entity.Usuario;

public class UsuarioRepository extends RepositoryBase<Usuario> {

    public String retornaListaUsuarios() {
        return entities.toString();
    }

}
