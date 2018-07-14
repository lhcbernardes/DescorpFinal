package com.mycompany.descorpv2.ejb.entidades;

/**
 *
 * @author Bernardes
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_MUSICA")
@NamedQueries(
        {
            @NamedQuery(
                    name = Musica.MUSICA_POR_REPUTACAO,
                    query = "SELECT u FROM Musica u WHERE u.reputacao LIKE ?1"
            ),
            @NamedQuery(
                    name = Musica.MUSICA_POR_TITULO,
                    query = "SELECT u FROM Musica u WHERE u.titulo LIKE ?1"
            ),@NamedQuery(
                    name = Musica.MUSICAS,
                    query = "SELECT u FROM Musica u ORDER BY u.titulo"
            )
        }
)
public class Musica extends Entidade implements Serializable {

    public static final String MUSICA_POR_REPUTACAO = "MusicaPorReputacao";
    public static final String MUSICA_POR_TITULO = "MusicaPorTitulo";
    public static final String MUSICAS = "Musicas";

    @NotBlank (message = "Não pode ser vazio")
    @Size(max = 50)
    @Column(name = "TXT_TITULO")
    private String titulo;
    
    @NotNull (message = "Não pode ser null")
    @Column(name = "TXT_DURACAO")
    private float duracao;

    @Size(max = 100)
    @Column(name = "TXT_LINK")
    private String link;

    @Enumerated(EnumType.STRING)
    @Column(name = "TXT_REPUTACAO", nullable = true)
    private Reputacao reputacao;

    @ManyToMany(mappedBy = "musicas", cascade = {CascadeType.PERSIST})
    private List<Artista> artistas;
    
    @ManyToMany(mappedBy = "musicas")
    private List<Playlist> playlists;

    @ManyToMany(mappedBy = "musicas", cascade = {CascadeType.PERSIST})
    private List<Album> albuns;

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public float getDuracao() {
	return duracao;
    }

    public void setDuracao(float duracao) {
	this.duracao = duracao;
    }

    public String getLink() {
	return link;
    }

    public void setLink(String link) {
	this.link = link;
    }

    public List<Artista> getArtistas() {
	return artistas;
    }

    public List setArtistas(List<Artista> artistas) {
	return this.artistas = artistas;
    }
    
    public boolean adicionaArtista(Artista artista) {
        artista.setMusicas(this.setArtistas(artistas));
        return artistas.add(artista);
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public List setAlbuns(List<Album> albuns) {
        return this.albuns = albuns;
    }
    
    public boolean adicionaAlbum(Album album) {
        album.setMusicas(this.setAlbuns(albuns));
        return albuns.add(album);
    }

    public Reputacao getReputacao() {
	return reputacao;
    }

    public void setReputacao(Reputacao reputacao) {
	this.reputacao = reputacao;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

}