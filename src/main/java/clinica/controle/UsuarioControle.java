
import clinica.modelo.Usuario;
import clinica.servico.UsuarioServico;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioControle implements Serializable {

    @EJB
    UsuarioServico usuarioServico;

    private Usuario usuario;

    @PostConstruct
    public void instancia() {
        this.usuario = new Usuario();
    }

    public void instanciaUsuario() {
        this.usuario = new Usuario();
    }

    public void cadastrar() {
        try {
            System.out.println("Iniciando método cadastrar()");
            usuarioServico.salvarUsuario(usuario);

            // Correção: usando o método instanciaUsuario() para reinicializar o objeto
            instanciaUsuario();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar usuário.", null));
        }
    }

    public void realizarLogin() throws IOException {
        System.out.println("Tentativa de login - Usuário: " + usuario.getLogin() + ", Senha: " + usuario.getSenha());

        boolean credenciaisValidas = usuarioServico.verificarCredenciais(usuario.getLogin(), usuario.getSenha());

        if (credenciaisValidas) {
            // Adicione o usuário à sessão se desejar mantê-lo durante a sessão
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario.getLogin());

            // Redirecione para a página desejada após o login bem-sucedido
            FacesContext.getCurrentInstance().getExternalContext().redirect("/clinica/index.xhtml");
        } else {
            // Exiba uma mensagem de erro na tela de login
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciais inválidas", null));
        }
    }

    public UsuarioServico getUsuarioServico() {
        return usuarioServico;
    }

    public void setUsuarioServico(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
