
package clinica.controle;

import clinica.mensagem.Mensagem;
import clinica.modelo.Profissional;
import clinica.servico.ProfissionalServico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author F70Ed
 */
@Named
@ViewScoped
public class ProfissionalControle implements Serializable {

    private List<Profissional> profissionais;
    private Profissional profissional;
    private String resultado;
    private Profissional profissionalSelecionado;

    @EJB
    ProfissionalServico ProfissionalServico;

    @PostConstruct
    public void instaciar() {
        profissional = new Profissional();
        profissionais = new ArrayList<>();
        pesquisaProfissional();
    

    }

    public void instanciarProfisional() {
        profissional = new Profissional();
        profissionalSelecionado = new Profissional();

    }

    public void salvarProfissional() {
        resultado = profissional.getNome();
        profissionais.add(profissional);
        ProfissionalServico.salvar(profissional);
        instanciarProfisional();
        Mensagem.msm("Profissional salvo com sucesso!");
    }

    public void pesquisaProfissional() {
        profissionais = ProfissionalServico.findAll();
    }

    public void excluirProfissional(Profissional p) {
        profissionais.remove(p);
        ProfissionalServico.remover(p);
    }

    public void atualizarDadosDoProfissional() {
      ProfissionalServico.atualizar(this.profissional);
      
      
    }

    public ProfissionalControle() {
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Profissional getProfissionalSelecionado() {
        return profissionalSelecionado;
    }

    public void setProfissionalSelecionado(Profissional profissionalSelecionado) {
        this.profissionalSelecionado = profissionalSelecionado;
    }

    public ProfissionalServico getProfissionalServico() {
        return ProfissionalServico;
    }

    public void setProfissionalServico(ProfissionalServico ProfissionalServico) {
        this.ProfissionalServico = ProfissionalServico;
    }

}
