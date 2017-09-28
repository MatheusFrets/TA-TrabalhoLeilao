
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


public class Leilao implements Serializable{
    private Integer id;
    @NotBlank(message = "{leilao.nome.notblank}")
    @Length(max = 40, message = "{leilao.nome.length}")
    private String nome;
    private String telefone;
    private String descricao;
    private Double valorMinimo;
    private Double valorGanho;
    private Calendar validade;
    private String nomePessoa = "";
    private String telefonePessoa = "";
    private Double lance = 0.0;

    public Leilao(Integer id, String nome, String telefone, String descricao, double valorMinimo, double valorGanho, Calendar validade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.valorMinimo = valorMinimo;
        this.valorGanho = valorGanho;
        this.validade = validade;
    }
    
    

    public Leilao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Double getValorGanho() {
        return valorGanho;
    }

    public void setValorGanho(Double valorGanho) {
        this.valorGanho = valorGanho;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public double getLance() {
        return lance;
    }

    public void setLance(double lance) {
        this.lance = lance;
    }

    
}
