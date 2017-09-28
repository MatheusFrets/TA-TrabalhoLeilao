
package br.edu.ifsul.bean;

import br.edu.ifsul.modelo.Leilao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;


@Singleton
public class LeilaoBean {

   
    private List<Leilao> lista = new ArrayList<>();
   
    private List<Leilao> listaFinalizado = new ArrayList<>();
    private Leilao l = new Leilao();
    private Calendar c;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Schedule(minute = "*/1", hour = "*")
    public void zeraContador() {
        
        for ( int x = 0; x < lista.size(); x++){
            
            l = lista.get(x);
            if(sdf.format(l.getValidade().getTime())==sdf.format(c.getInstance().getTime())){
                listaFinalizado.add(l);
                lista.remove(l);
            }
        }
    }
    
    public List<Leilao> getLista() {
        return lista;
    }

    public void setLista(List<Leilao> lista) {
        this.lista = lista;
    }

    public List<Leilao> getListaFinalizado() {
        return listaFinalizado;
    }

    public void setListaFinalizado(List<Leilao> listaFinalizado) {
        this.listaFinalizado = listaFinalizado;
    }

    public Leilao getL() {
        return l;
    }

    public void setL(Leilao l) {
        this.l = l;
    }

    public Calendar getC() {
        return c;
    }

    public void setC(Calendar c) {
        this.c = c;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    
}
