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
import java.util.ArrayList;
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
    private List<Musica> musicas;
    private List<Album> albuns;

    @PostConstruct
    public void inicar() {
        musica = new Musica();
        albuns = new ArrayList<>();
        musicas = new ArrayList<>();
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }
    
    public List<Artista> getArtistas() {
        return artistaServico.getArtistas();
    }

    public List<Album> getAlbums() {
        return albumServico.getAlbuns();
    }
    
    public void setMusicas(List<Musica> musicas){
        this.musicas = musicas;
    }
    
    public List<Musica> getMusicas() {
        if(!this.musicas.isEmpty()){
            return this.musicas;
        }
        return this.musicas = musicaServico.getMusicas();
    }

    public boolean salvar() {
        musicaServico.salvar(musica);
        return true;
    }
}
