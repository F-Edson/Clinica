package clinica.servico;

import clinica.modelo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author F70Ed
 */
@Stateless
public class UsuarioServico {

    @PersistenceContext
    EntityManager em;

    public void salvarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    public boolean verificarCredenciais(String login, String senha) {
        // Consulta para verificar se há um usuário com o login e senha fornecidos
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
        query.setParameter("login", login);
        query.setParameter("senha", senha);

        // Obtém o resultado da consulta
        Usuario usuario = null;
        try {
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            // Trate exceções (por exemplo, se nenhum usuário for encontrado)
            e.printStackTrace();
        }

        // Retorna true se um usuário for encontrado, senão false
        return usuario != null;
    }

}
