package clinica.controle;

import clinica.mensagem.Mensagem;
import clinica.modelo.Endereco;
import clinica.modelo.Paciente;
import clinica.servico.PacienteServico;
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
public class PacienteControle implements Serializable {

    private List<Paciente> pacientes;
    private Paciente paciente;
    private String resultado;

    @EJB
    PacienteServico pacienteServico;

    @PostConstruct
    public void instanciar() {
        paciente = new Paciente();
        paciente.setEndereco(new Endereco());
        pacientes = new ArrayList<>();
        pesquisarPaciente();


    }

    public void instanciarPaciente() {
        paciente = new Paciente();
        paciente.setEndereco(new Endereco());

    }

        public void salvarPaciente() {
            resultado = paciente.getNome();
            pacientes.add(paciente);
            pacienteServico.salvar(paciente);
            instanciarPaciente();
            Mensagem.msm("Paciente salvo com sucesso!");

        }

    public void pesquisarPaciente() {
        pacientes = pacienteServico.findAll();

    }

    public void atualizarPaciente() {
     pacienteServico.atualizar(this.paciente);


    
    }

    public void removerPaciente(Paciente p) {
        pacienteServico.remover(p);
        pacientes.remove(p);
        Mensagem.msm("Paciente salvo com sucesso!");
    }

    public PacienteControle() {
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteServico getPacienteServico() {
        return pacienteServico;
    }

    public void setPacienteServico(PacienteServico pacienteServico) {
        this.pacienteServico = pacienteServico;
    }

}
