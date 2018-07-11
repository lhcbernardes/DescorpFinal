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
@Table(name = "TB_ARTISTA")
@NamedQueries(
        {
            @NamedQuery(
                    name = Artista.ARTISTA_POR_PAIS,
                    query = "SELECT a FROM Artista a WHERE a.pais like ?1"
            )
            ,
            @NamedQuery(
                    name = Artista.ARTISTA_POR_NOME,
                    query = "SELECT a FROM Artista a WHERE a.nome like ?1"
            )
            ,
            @NamedQuery(
                    name = Artista.ARTISTA_POR_ID,
                    query = "SELECT a FROM Artista a WHERE a.id like ?1"
            ),
            @NamedQuery(
                    name = Artista.ARTISTAS,
                    query = "SELECT a FROM Artista a ORDER BY a.nome"
            )
        }
)
public class Artista extends Entidade implements Serializable {

    public static final String ARTISTA_POR_PAIS = "ArtistaPorPais";
    public static final String ARTISTA_POR_NOME = "ArtistaPorNome";
    public static final String ARTISTA_POR_ID = "ArtistaPorId";
    public static final String ARTISTAS = "Artistas";
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_MUSICA_ARTISTA",
            joinColumns = @JoinColumn(name = "ID_ARTISTA"),
            inverseJoinColumns = @JoinColumn(name = "ID_MUSICA")
    )
    private List<Musica> musicas;

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @NotBlank
    @Size(max = 50)
    @Column(name = "TXT_NOME")
    private String nome;

    @NotBlank
    @Size(max = 100)
    @ValidaPais
    @Column(name = "TXT_PAIS")
    private String pais; //criar tabela de país e entidade país

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
