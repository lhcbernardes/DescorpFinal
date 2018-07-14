package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.Album;
import com.mycompany.descorpv2.ejb.entidades.Artista;
import com.mycompany.descorpv2.ejb.entidades.Musica;
import com.mycompany.descorpv2.ejb.entidades.Playlist;
import com.mycompany.descorpv2.ejb.entidades.Reputacao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import com.mycompany.descorpv2.ejb.servico.AlbumServico;
import com.mycompany.descorpv2.ejb.servico.ArtistaServico;
import com.mycompany.descorpv2.ejb.servico.MusicaServico;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.eclipse.persistence.jpa.jpql.Assert;

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
    private Album album;
    private Artista artista;
    private List<Artista> artistas;
    private List<Musica> musicas;
    private List<Album> albuns;
    private List<Playlist> playlists;

    @PostConstruct
    public void inicar() {
        musica = new Musica();
        artista = new Artista();
        album = new Album();
        albuns = new ArrayList<>();
        musicas = new ArrayList<>();
        artistas = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }
    
    public void setArtistas(List<Artista> artistas){
        this.artistas = artistas;
    }
    
    public List<Artista> getArtistas() {
        return this.artistas;
    }

    public List<Album> getAlbums() {
        return albumServico.getAlbuns();
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
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
        
        try{
            albuns.add(album);
            musica.setAlbuns(albuns);

            artistas.add(artista);
            musica.setArtistas(artistas);

            musica.setPlaylists(playlists);

            musicas.add(musica);
            album.setMusicas(musicas);

            musica.setReputacao(Reputacao.BOM);

            musicaServico.salvar(musica);
            albumServico.salvar(album);
            artistaServico.salvar(artista);
            
        } catch (EJBException e) {
            @SuppressWarnings("ThrowableResultIgnored")
            Exception cause = e.getCausedByException();
            if (cause instanceof ConstraintViolationException) {
                @SuppressWarnings("ThrowableResultIgnored")
                ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
                for (Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation<? extends Object> v = it.next();
                    System.err.println(v);
                    System.err.println("==>>"+v.getMessage());
                }
            }
            Assert.fail("ejb exception");
        }
        
        return true;
    }
}
