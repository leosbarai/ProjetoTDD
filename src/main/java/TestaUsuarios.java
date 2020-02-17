import Entity.Usuario;
import Service.UsuarioService;

public class TestaUsuarios {

    public static void main(String[] args){

            Usuario user1 = new Usuario("João", "joao@yahoo.com");
            Usuario user2 = new Usuario();

            UsuarioService usuarioService = new UsuarioService();

            System.out.println("Parte 1 - sucesso");
            //usuarioService.adicionaUsuarioSvc(user1);
            System.out.println(usuarioService.retonaTamanhoListaSvc());
            System.out.println(usuarioService.retornaListaUsuariosSvc());

            System.out.println("Testando validações");
            //usuarioService.adicionaUsuarioSvc(user2);

            user2.setNome("Zuão Rodrigues");
            //usuarioService.adicionaUsuarioSvc(user2);

            user2.setEmail("joao@email.com");
            //usuarioService.adicionaUsuarioSvc(user2);

            user2.setEmail("joao@yahoo.com");
            //usuarioService.adicionaUsuarioSvc(user2);
            System.out.println(usuarioService.retonaTamanhoListaSvc());
            System.out.println(usuarioService.retornaListaUsuariosSvc());

    }
}
