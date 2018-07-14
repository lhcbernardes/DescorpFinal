package com.mycompany.descorpv2.ejb.servico;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import com.mycompany.descorpv2.ejb.entidades.Playlist;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author lucas
 */
@Stateless
public class PlaylistServico extends Servico<Playlist> {

    public PlaylistServico(){
        super(Playlist.class);
    }
    
    @TransactionAttribute(SUPPORTS)
    public List<Playlist> consultarTitulos(@NotBlank String titulo) {
        return getEntidades(Playlist.PLAYLIST_POR_TITULO, new Object[]{titulo});
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Playlist> getPlaylists() {
        return getEntidades(Playlist.TODAS);
    }
}
