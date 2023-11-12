package clinica.controle;

import clinica.mensagem.Mensagem;
import clinica.modelo.Agendamento;
import clinica.modelo.Paciente;
import clinica.modelo.Profissional;

import clinica.servico.AgendamentoServico;
import clinica.servico.PacienteServico;
import clinica.servico.ProfissionalServico;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.view.ViewScoped;

import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author F70Ed
 */
@Named
@ViewScoped
public class AgendamentoControle implements Serializable {

    private List<Agendamento> agendamentos;
    private Agendamento agendamento;
    private String resultado;

    private Paciente paciente;
    private String pacienteSelecionado;
    private List<Paciente> pacientes;

    private Profissional profissinal;
    private String ProfisionalSelecionado;
    private List<Profissional> profissinais;

    private Date dataFiltro;

    private String option;
    private List<String> options;

    @EJB
    AgendamentoServico agendamentoServico;

    @EJB
    PacienteServico pacienteServico;

    @EJB
    ProfissionalServico profissionalServico;

    @PostConstruct
    public void instanciar() {
        agendamento = new Agendamento();
        agendamentos = new ArrayList<>();
        paciente = new Paciente();
        pacientes = new ArrayList<>();

        pacientes = pacienteServico.findAll();
        profissinais = profissionalServico.findAll();
        pesquisarAgendamento();    

    }

    public void instaciarAgendamento() {
        agendamento = new Agendamento();
        pacientes = pacienteServico.findAll();
        profissinais = profissionalServico.findAll();

    }

    ///Ajuda a garantir a consistência dos dados no banco de dados. se você estiver realizando várias operações de leitura/escrita 
    @Transactional
    public void salvarAgendamento() {
        resultado = agendamento.getDescricao();
        agendamentos.add(agendamento);
        agendamentoServico.salvar(agendamento);

        agendamento.setPacienteSelecionado(pacienteSelecionado);
        pacientes = new ArrayList<>();

        agendamento.setProfissionalSelecionado(ProfisionalSelecionado);
        profissinais = new ArrayList<>();

        instaciarAgendamento();
        Mensagem.msm("Agendamento salvo com sucesso!");
    }

    public void removerAgendamento(Agendamento Agen) {
        agendamentos.remove(Agen);
        agendamentoServico.remover(Agen);

    }

    public void pesquisarAgendamento() {
        agendamentos = agendamentoServico.findAll();

    }

    public void atualizarAgendamento(Agendamento Agen) {
    agendamentoServico.atualizar(this.agendamento);


    }

    public void filtrarPorData() {
        if (dataFiltro != null) {
            List<Agendamento> agendamentosFiltrados = new ArrayList<>();
            pesquisarAgendamento();
            for (Agendamento agendament : agendamentos) {
                if (dataFiltro.equals(agendament.getData())) {
                    agendamentosFiltrados.add(agendament);

                }
            }
            agendamentos = agendamentosFiltrados;
        }
    }

    public AgendamentoControle() {
    }

    public Date getDataFiltro() {
        return dataFiltro;
    }

    public void setDataFiltro(Date dataFiltro) {
        this.dataFiltro = dataFiltro;
    }

    public Profissional getProfissinal() {
        return profissinal;
    }

    public void setProfissinal(Profissional profissinal) {
        this.profissinal = profissinal;
    }

    public String getProfisionalSelecionado() {
        return ProfisionalSelecionado;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
    
    
    
    public void setProfisionalSelecionado(String ProfisionalSelecionado) {
        this.ProfisionalSelecionado = ProfisionalSelecionado;
    }

    public List<Profissional> getProfissinais() {
        return profissinais;
    }

    public void setProfissinais(List<Profissional> profissinais) {
        this.profissinais = profissinais;
    }

    public ProfissionalServico getProfissionalServico() {
        return profissionalServico;
    }

    public void setProfissionalServico(ProfissionalServico profissionalServico) {
        this.profissionalServico = profissionalServico;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
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

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public String getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(String pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

    public AgendamentoServico getAgendamentoServico() {
        return agendamentoServico;
    }

    public void setAgendamentoServico(AgendamentoServico agendamentoServico) {
        this.agendamentoServico = agendamentoServico;
    }

    public PacienteServico getPacienteServico() {
        return pacienteServico;
    }

    public void setPacienteServico(PacienteServico pacienteServico) {
        this.pacienteServico = pacienteServico;
    }

}
