package com.mycompany.imovelproject;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_imovel")
@NamedQuery(name = "Imovel.listarTodos",
              query= "SELECT e FROM Imovel e")
public class Imovel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status_imovel", nullable = false)
    private boolean status;
    
    @Column(name = "logradouro_imovel", length = 150, nullable = false)
    private String logradouro;

    @Column(name = "numero_imovel", nullable = false)
    private String numero;

    @Column(name = "complemento_imovel", length = 30, nullable = true)
    private String complemento;
    
    @Column(name = "cep_imovel", length = 10, nullable = false)
    private String cep;

    @Column(name = "capa_imovel")
    private String capa;


    @Enumerated(EnumType.STRING)
    @Column(name="tipoimovel", nullable = false)
    private TipoImovel tipoImovel;
    
    @ManyToOne
    @JoinColumn(name = "usuario_imovel_fk")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "imovel", targetEntity = Queixa.class, fetch = FetchType.LAZY,
     cascade = CascadeType.ALL)
    private List<Queixa> queixas;
    
    @Column(name="cidade")
    private String cidade;
    
    @Column(name="bairro")
    private String bairro;
    
    @Enumerated(EnumType.STRING)
    @Column(name="uf", nullable = false)
    private UF uf;
    
    @OneToMany (mappedBy = "imovel", targetEntity = Imagem.class, fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL)
    private List<Imagem> imagens;
    
    @Column(name = "descricao_imovel", nullable = false)
    private String descricao;
    
    @Column(name = "caracteristicas_imovel", nullable = false)
    private String caracteristicas;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isStatus() {
        return status;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public List<Queixa> getQueixas() {
        return queixas;
    }

    public void setQueixas(List<Queixa> queixas) {
        this.queixas = queixas;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }


    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean disponivel) {
        this.status = disponivel;
    }

     public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String avatar) {
        this.capa = avatar;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void getTipoImovel(TipoImovel tipoImovel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
}