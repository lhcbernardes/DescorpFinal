package com.mycompany.descorpv2.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author bernardes
 */
@Entity
@Table(name = "TB_PREMIUM")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name = "ID_PREMIUM", referencedColumnName = "ID")
@NamedQueries(
        {
            @NamedQuery(
                    name = Premium.PREMIUM_POR_ID,
                    query = "SELECT c FROM Premium c WHERE c.id = ?1"
            )
            ,
            @NamedQuery(
                    name = Premium.PREMIUM_POR_CARTAO,
                    query = "SELECT c FROM Premium c WHERE c.cartaoCredito IS NOT NULL AND c.cartaoCredito.bandeira LIKE ?1"
            ),
            @NamedQuery(
                    name = Premium.PREMIUM_POR_NOME,
                    query = "SELECT c FROM Premium c WHERE c.nome = ?1"
            )
        }
)
public class Premium extends Usuario implements Serializable {

    public static final String PREMIUM_POR_ID = "PremiumPorId";
    public static final String PREMIUM_POR_CARTAO = "PremiumPorCartao";
        public static final String PREMIUM_POR_NOME = "PremiumPorNome";

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            optional = true)
    @JoinColumn(name = "ID_CARTAO_CREDITO", referencedColumnName = "ID")
    private CartaoCredito cartaoCredito;

    @OneToMany(mappedBy = "premium", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlists;

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public CartaoCredito criarCartaoCredito() {
        setCartaoCredito(new CartaoCredito());
        return this.getCartaoCredito();
    }
    
    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
        this.cartaoCredito.setDono(this);
    }
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public boolean adicionaPlaylist(Playlist playlist) {
        playlist.setPremium(this);
        return playlists.add(playlist);
    }

}
