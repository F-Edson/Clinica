package clinica.servico;

import clinica.modelo.Profissional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author F70Ed
 */
@Stateless
public class ProfissionalServico {

    @PersistenceContext
    EntityManager em;

    public void salvar(Profissional profissional) {
        em.persist(profissional);

    }

    public void atualizar(Profissional profissional) {
        em.merge(profissional);

    }

    public Profissional find(Long id) {
        return em.find(Profissional.class, id);
    }

    public List<Profissional> findAll() {
        String jpql = "SELECT p FROM Profissional p where p.ativo = true";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    public void remover(Profissional profissional) {
        profissional.setAtivo(false);
        em.merge(profissional);

    }

}
