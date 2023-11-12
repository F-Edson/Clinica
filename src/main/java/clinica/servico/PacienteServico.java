package clinica.servico;

import clinica.modelo.Paciente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author F_Edson
 */
@Stateless
public class PacienteServico {

    @PersistenceContext
    EntityManager em;

    public void salvar(Paciente paciente) {
        em.persist(paciente);

    }

    public void atualizar(Paciente paciente) {
        em.merge(paciente);

    }

    public Paciente find(Long id) {
        return em.find(Paciente.class, id);
    }

    public List<Paciente> findAll() {
        String jpql = "Select p from Paciente p where p.ativo = true";
        TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
        return query.getResultList();
    }

    public void remover(Paciente paciente) {
       paciente.setAtivo(false);

        em.merge(paciente);

    }

}
