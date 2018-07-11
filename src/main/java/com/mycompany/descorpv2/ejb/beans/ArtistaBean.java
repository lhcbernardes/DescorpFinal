package com.mycompany.descorpv2.ejb.beans;

import com.mycompany.descorpv2.ejb.entidades.Artista;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import servico.ArtistaServico;

/**
 *
 * @author leandro
 */
@ManagedBean(name="artistaBean")
@RequestScoped
public class ArtistaBean extends Bean<Artista> implements Serializable {
    
    private Artista artista;
    
    @EJB
    private ArtistaServico artistaServico;
    
    @PostConstruct
    public void inicarArtista(){
        artista = artistaServico.criar();
    }

    @Override
    protected void iniciarCampos() {
        setEntidade(artistaServico.criar());
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    @Override
    public boolean salvar(Artista entidade) {
        this.artistaServico.persistir(entidade);
        return true;
    }
}
