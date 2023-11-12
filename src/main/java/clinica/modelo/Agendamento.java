package clinica.modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_Agendamento")
public class Agendamento implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_agendamento", sequenceName = "seq_agendamento")
    @GeneratedValue(generator = "seq_agendamento", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalTime hora;
    @Column
    private Date data;
    @Column
    private String descricao;
    @Column
    private  boolean ativo = true;
    
    private String pacienteSelecionado;

    @Column
    private String profissionalSelecionado;

    @OneToOne(cascade = CascadeType.ALL)
    private Profissional profissional;

    @OneToOne(cascade = CascadeType.ALL)
    private Paciente paciente;

    public Agendamento() {
        
    }

    public Agendamento(Long id, LocalTime hora, Date data, String descricao, String pacienteSelecionado, String profissionalSelecionado, Profissional profissional, Paciente paciente) {
        this.id = id;
        this.hora = hora;
        this.data = data;
        this.descricao = descricao;
        this.pacienteSelecionado = pacienteSelecionado;
        this.profissionalSelecionado = profissionalSelecionado;
        this.profissional = profissional;
        this.paciente = paciente;
    }
    
    
    

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    

    public String getProfissionalSelecionado() {
        return profissionalSelecionado;
    }

    public void setProfissionalSelecionado(String profissionalSelecionado) {
        this.profissionalSelecionado = profissionalSelecionado;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(String pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.hora);
        hash = 59 * hash + Objects.hashCode(this.data);
        hash = 59 * hash + Objects.hashCode(this.descricao);
        hash = 59 * hash + (this.ativo ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.pacienteSelecionado);
        hash = 59 * hash + Objects.hashCode(this.profissionalSelecionado);
        hash = 59 * hash + Objects.hashCode(this.profissional);
        hash = 59 * hash + Objects.hashCode(this.paciente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.pacienteSelecionado, other.pacienteSelecionado)) {
            return false;
        }
        if (!Objects.equals(this.profissionalSelecionado, other.profissionalSelecionado)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.profissional, other.profissional)) {
            return false;
        }
        return Objects.equals(this.paciente, other.paciente);
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", hora=" + hora + ", data=" + data + ", descricao=" + descricao + ", ativo=" + ativo + ", pacienteSelecionado=" + pacienteSelecionado + ", profissionalSelecionado=" + profissionalSelecionado + ", profissional=" + profissional + ", paciente=" + paciente + '}';
    }

    
    
    
    
}
