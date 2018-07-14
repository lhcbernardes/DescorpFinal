package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import com.mycompany.descorpv2.ejb.entidades.Playlist;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import com.mycompany.descorpv2.ejb.servico.MusicaServico;
import com.mycompany.descorpv2.ejb.servico.PlaylistServico;
import java.util.ArrayList;
import javax.inject.Named;

/**
 *
 * @author leandro
 */
@SessionScoped
@Named(value = "playlistBean")
public class PlaylistBean implements Serializable {
    
    @EJB
    private PlaylistServico playlistServico;
    
    @EJB
    private MusicaServico musicaServico;
    
    private Playlist playlist;
    private List<Playlist> playlists;
    private Musica musica;
    private List<Musica> musicas;

    @PostConstruct
    public void inicar() {
        musica = new Musica();
        playlist = new Playlist();
        musicas = new ArrayList<>();
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
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
        playlistServico.salvar(playlist);
        return true;
    }
}
