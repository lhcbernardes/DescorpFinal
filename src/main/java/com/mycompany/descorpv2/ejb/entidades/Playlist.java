package com.mycompany.descorpv2.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author leand
 */
@Entity
@Table(name = "TB_PLAYLIST")
@NamedQueries(
        {
            @NamedQuery(
                    name = Playlist.PLAYLIST_POR_TITULO,
                    query = "SELECT p FROM Playlist p WHERE p.titulo like ?1"
            ),
            @NamedQuery(
                    name = Playlist.PLAYLIST_POR_ID,
                    query = "SELECT p FROM Playlist p ORDER BY p.id"
            ),
            @NamedQuery(
                    name = Playlist.TODAS,
                    query = "SELECT p FROM Playlist p ORDER BY p.titulo"
            )
        }
)
public class Playlist extends Entidade implements Serializable {

    public static final String PLAYLIST_POR_TITULO = "PlaylistPorTitulo";
    public static final String PLAYLIST_POR_ID = "PlaylistPorId";
    public static final String TODAS = "Todas";
    
    @NotNull
    @Size(max = 20)
    @Column(name = "TXT_TITULO", nullable = false)
    protected String titulo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_PLAYLIST_MUSICA", joinColumns = {
        @JoinColumn(name = "ID_PLAYLIST")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_MUSICA")})
    private List<Musica> musicas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PREMIUM", referencedColumnName
            = "ID_PREMIUM")
    private Premium premium;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_FREE", referencedColumnName = "ID_FREE")
    private Free free;

    public Free getFree() {
        return free;
    }

    public void setFree(Free free) {
        this.free = free;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public List setMusicas(List<Musica> musicas) {
        return this.musicas = musicas;
    }

    public boolean adicionaMusica(Musica musica) {
        musica.setPlaylists(this.setMusicas(musicas));
        return musicas.add(musica);
    }

    public String getTitulo() {
        return titulo;
    }

    public Premium getPremium() {
        return premium;
    }

    public void setPremium(Premium premium) {
        this.premium = premium;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
