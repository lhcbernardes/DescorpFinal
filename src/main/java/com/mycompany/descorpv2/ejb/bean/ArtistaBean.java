package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.Artista;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import com.mycompany.descorpv2.ejb.servico.ArtistaServico;
import javax.inject.Named;

/**
 *
 * @author leandro
 */
@Named(value = "artistaBean")
@SessionScoped
public class ArtistaBean implements Serializable {
    
    @EJB
    private ArtistaServico artistaServico;
    
    private Artista artista;
     
    @PostConstruct
    public void inicar(){
        artista = new Artista();
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    public boolean salvar() {
        artistaServico.salvar(artista);
        return true;
    }
}
