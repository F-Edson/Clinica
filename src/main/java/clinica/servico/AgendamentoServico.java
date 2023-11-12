package clinica.servico;

import clinica.modelo.Agendamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author F70Ed
 */
@Stateless
public class AgendamentoServico {

    @PersistenceContext
    EntityManager ag;

    public void salvar(Agendamento agendamento) {
        ag.persist(agendamento);

    }

    public void atualizar(Agendamento agendamento) {
        ag.merge(agendamento);

    }

    public Agendamento find(Long id) {
        return ag.find(Agendamento.class, id);
    }

    public List<Agendamento> findAll() {
        String jpql = "SELECT Agen FROM Agendamento Agen  WHERE Agen.ativo = true";
        Query query = ag.createQuery(jpql);
        return query.getResultList();
    }

    public void remover(Agendamento agendamento) {
        agendamento.setAtivo(false);
            ag.merge(agendamento);
      
    }
}
