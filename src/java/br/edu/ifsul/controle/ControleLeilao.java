package br.edu.ifsul.controle;

import br.edu.ifsul.bean.LeilaoBean;
import br.edu.ifsul.modelo.Leilao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ControleLeilao")
@SessionScoped
public class ControleLeilao implements Serializable {

    @EJB
    private LeilaoBean leilaoBean;
    private Leilao objeto;
    private Boolean editando;
    private String nome;
    private String telefone;
    private Double valor;

    public ControleLeilao() {
    }

    public String listar() {
        editando = false;
        return "/leilao/listar?faces-redirect=true";
    }

    public String lance(Leilao obj) {
        objeto = obj;
        editando = true;
        return "/listar?faces-redirect=true";
    }

    public void novo() {
        editando = true;
        objeto = new Leilao();
    }

    public void alterar(Leilao obj) {
        objeto = obj;
        editando = true;
    }

    public void remover(Leilao obj) {
        leilaoBean.getLista().remove(obj);
    }

    public void salvar() {
        if (objeto.getId() == null) {
            objeto.setId(leilaoBean.getLista().size() + 1);
            leilaoBean.getLista().add(objeto);
        }
        editando = false;

        FacesMessage msg = new FacesMessage(Util.getMensagemInternacionaliza("sucesso.salvar"));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void salvar2() {
        if (valor >= objeto.getValorMinimo() && valor > objeto.getLance()) {
            objeto.setNomePessoa(nome);
            objeto.setTelefonePessoa(telefone);
            objeto.setLance(valor);
            if (valor >= objeto.getValorGanho()) {
                objeto.setId(leilaoBean.getListaFinalizado().size() + 1);
                leilaoBean.getListaFinalizado().add(objeto);
                leilaoBean.getLista().remove(objeto);
            }
            FacesMessage msg = new FacesMessage(Util.getMensagemInternacionaliza("sucesso.salvar"));
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            objeto.setNomePessoa(objeto.getNomePessoa());
            objeto.setTelefonePessoa(objeto.getTelefonePessoa());
            objeto.setLance(objeto.getLance());
            FacesMessage msg = new FacesMessage(Util.getMensagemInternacionaliza("falha.valoMinimo"));
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        editando = false;

    }

    public Leilao getObjeto() {
        return objeto;
    }

    public void setObjeto(Leilao objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LeilaoBean getLeilaoBean() {
        return leilaoBean;
    }

    public void setLeilaoBean(LeilaoBean leilaoBean) {
        this.leilaoBean = leilaoBean;
    }

}
