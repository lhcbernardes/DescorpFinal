package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.Album;
import com.mycompany.descorpv2.ejb.entidades.Artista;
import com.mycompany.descorpv2.ejb.entidades.Musica;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import com.mycompany.descorpv2.ejb.servico.AlbumServico;
import com.mycompany.descorpv2.ejb.servico.ArtistaServico;
import com.mycompany.descorpv2.ejb.servico.MusicaServico;
import javax.inject.Named;

/**
 *
 * @author leandro
 */
@SessionScoped
@Named(value = "musicaBean")
public class MusicaBean implements Serializable {
    
    @EJB
    private ArtistaServico artistaServico;
    
    @EJB
    private AlbumServico albumServico;
    
    @EJB
    private MusicaServico musicaServico;
    
    private Musica musica;

    @PostConstruct
    public void inicar() {
        musica = new Musica();
    }
    
    public List<Artista> getArtistas() {
        return artistaServico.getArtistas();
    }

    public List<Album> getAlbums() {
        return albumServico.getAlbuns();
    }

    protected boolean salvar(Musica entidade) {
        musicaServico.salvar(entidade);
        return true;
    }
}
