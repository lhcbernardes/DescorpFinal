package com.mycompany.descorpv2.ejb.beans;

import com.mycompany.descorpv2.ejb.entidades.Album;
import com.mycompany.descorpv2.ejb.entidades.Artista;
import com.mycompany.descorpv2.ejb.entidades.Musica;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import servico.AlbumServico;
import servico.ArtistaServico;
import servico.MusicaServico;

/**
 *
 * @author leandro
 */
@SessionScoped
@Named
public class MusicaBean extends Bean<Musica> implements Serializable {
    
    @EJB
    private ArtistaServico artistaServico;
    @EJB
    private AlbumServico albumServico;
    @EJB
    private MusicaServico musicaServico;

    @Override
    protected void iniciarCampos() {
        setEntidade(musicaServico.criar());
    }

    public List<Artista> getArtistas() {
        return artistaServico.getArtistas();
    }

    public List<Album> getAlbums() {
        return albumServico.getAlbuns();
    }

    @Override
    protected boolean salvar(Musica entidade) {
        this.musicaServico.persistir(entidade);
        return true;
    }
}
