package clinica.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author F70Ed
 */
@Entity
@Table(name = "tab_Profissional")
public class Profissional implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_profissional", sequenceName = "seq_profissional")
    @GeneratedValue(generator = "seq_profissional", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String especialidade;
    @Column
    private String contato;
    @Column
    private boolean ativo = true;

    public Profissional() {
    }

    public Profissional(Long id, String nome, String cpf, String especialidade, String contato) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.contato = contato;
    }

    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.especialidade);
        hash = 89 * hash + Objects.hashCode(this.contato);
        hash = 89 * hash + (this.ativo ? 1 : 0);
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
        final Profissional other = (Profissional) obj;
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        if (!Objects.equals(this.contato, other.contato)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
    
    
    
    @Override
    public String toString() {
        return "Profissional{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", especialidade=" + especialidade + ", contato=" + contato + ", ativo=" + ativo + '}';
    }
    
    
    

}
