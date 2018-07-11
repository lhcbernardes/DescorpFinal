package com.mycompany.descorpv2.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author leandro
 */
@Entity
@Table(name = "TB_ALBUM")
@NamedQueries(
        {
            @NamedQuery(
                    name = Album.ALBUM_POR_GENERO,
                    query = "SELECT a FROM Album a WHERE a.genero = ?1"
            )
            ,
            @NamedQuery(
                    name = Album.ALBUM_POR_TITULO,
                    query = "SELECT a FROM Album a WHERE a.titulo = ?1"
            )
            ,
            @NamedQuery(
                    name = Album.ALBUM_POR_ID,
                    query = "SELECT a FROM Album a WHERE a.id = ?1"
            )
        }
)
public class Album extends Entidade implements Serializable {
public static final String ALBUM_POR_GENERO = "AlbumPorPais";
    public static final String ALBUM_POR_TITULO = "AlbumPorNome";
    public static final String ALBUM_POR_ID = "AlbumPorId";
    
    @NotBlank
    @Size(max = 100)
    @Column(name = "TXT_TITULO")
    private String titulo;

    @NotBlank
    @Size(max = 100)
    @Column(name = "TXT_GENERO")
    private String genero;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_ALBUM_MUSICA", 
            joinColumns = @JoinColumn(name = "ID_ALBUM"),
            inverseJoinColumns = @JoinColumn(name = "ID_MUSICA")
    ) 
    private List<Musica> musicas;

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public String getGenero() {
	return genero;
    }

    public void setGenero(String genero) {
	this.genero = genero;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas; //corrigir
    }
}
