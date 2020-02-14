import Entity.Usuario;
import Repository.UsuarioRepository;
import Service.UsuarioService;

public class TestaUsuarios {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("João", "joao@email.com");
//        Usuario user2 = new Usuario();
//        Usuario user3 = new Usuario();

        UsuarioService usuarioService = new UsuarioService();

        System.out.println("Parte 1 - sucesso");
        usuarioService.adicionaUsuarioSvc(user1);
        System.out.println(usuarioService.retonaTamanhoListaSvc());
        System.out.println(usuarioService.retornaListaUsuariosSvc());

//        System.out.println("Parte 2 - erro nome");
//        usuarioService.adicionaUsuarioSvc(user2);
//        System.out.println(usuarioService.retonaTamanhoListaSvc());
//        System.out.println(usuarioService.retornaListaUsuariosSvc());
//
//        System.out.println("Parte 3 - erro email");
//        user3.setNome("José da Silva");
//        usuarioService.adicionaUsuarioSvc(user3);
//        System.out.println(usuarioService.retonaTamanhoListaSvc());
//        System.out.println(usuarioService.retornaListaUsuariosSvc());

        System.out.println("Parte 4 - remove usuário");
        usuarioService.removeUsuarioSvc(user1);
        System.out.println(usuarioService.retonaTamanhoListaSvc());
        System.out.println(usuarioService.retornaListaUsuariosSvc());

        System.out.println("Parte 5 - exception");
        usuarioService.removeUsuarioSvc(user1);
        System.out.println(usuarioService.retonaTamanhoListaSvc());
        System.out.println(usuarioService.retornaListaUsuariosSvc());

    }
}
