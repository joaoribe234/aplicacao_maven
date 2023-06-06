package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int potencia;

    @ManyToMany(mappedBy = "modelos")
    private List<Automovel> automoveis = new ArrayList<>();

    public Modelo() {

    }

    public Modelo(Integer id, String descricao, int potencia) {
        this.id = id;
        this.descricao = descricao;
        this.potencia = potencia;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, potencia);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Modelo other = (Modelo) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(descricao, other.descricao)
                && potencia == other.potencia;
    }

    @Override
    public String toString() {
        return "Modelo [id=" + id + ", descricao=" + descricao
                + ", potencia=" + potencia + "]";
    }

}
