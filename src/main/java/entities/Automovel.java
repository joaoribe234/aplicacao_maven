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
public class Automovel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int anoFabricacao;

    @Column(nullable = false)
    private int anoModelo;

    @Column(nullable = true)
    private String observacoes;

    @Column(nullable = false)
    private float preco;

    @Column(nullable = false)
    private int kilometragem;

    @ManyToMany
    private List<Modelo> modelos = new ArrayList<>();

    public Automovel() {

    }

    public Automovel(Integer id, int anoFabricacao, int anoModelo, String observacoes, float preco, int kilometragem) {
        this.id = id;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.observacoes = observacoes;
        this.preco = preco;
        this.kilometragem = kilometragem;
    }

    public void adicionarModelo(Modelo m) {
        this.modelos.add(m);
        m.getAutomoveis().add(this);
    }

    public void removerModelo(Modelo m) {
        this.modelos.remove(m);
        m.getAutomoveis().remove(this);
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anoFabricacao, anoModelo, observacoes, preco, kilometragem);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Automovel other = (Automovel) obj;
        return Objects.equals(id, other.id)
                && anoFabricacao == other.anoFabricacao
                && anoModelo == other.anoModelo
                && Objects.equals(observacoes, other.observacoes)
                && preco == other.preco
                && kilometragem == other.kilometragem;
    }

    @Override
    public String toString() {
        return "Automovel [id=" + id + ", anoFabricacao=" + anoFabricacao
                + ", anoModelo=" + anoModelo + ", observacoes=" + observacoes
                + ", preco=" + preco + ", kilometragem=" + kilometragem + "]";
    }

}
