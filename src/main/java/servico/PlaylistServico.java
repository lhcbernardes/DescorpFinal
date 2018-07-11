/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import com.mycompany.descorpv2.ejb.entidades.Playlist;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.TypedQuery;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author leandro
 */
@Stateless(name = "ejb/PlaylistServico")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ValidateOnExecution(type = ExecutableType.ALL)

public class PlaylistServico extends Servico<Playlist> {

    @PostConstruct
    public void init() {
        super.setClasse(Playlist.class);
    }

    @Override
    public Playlist criar() {
        return new Playlist();
    }

    @TransactionAttribute(SUPPORTS)
    public List<Playlist> consultarPlaylists(@NotBlank String titulo) {
        return super.consultarEntidades(new Object[]{titulo}, Playlist.PLAYLIST_POR_TITULO);
    }
    
    @TransactionAttribute(SUPPORTS)
    public List<Playlist> pegarPlayLists(){
        TypedQuery<Playlist> query = entityManager.createNamedQuery(Playlist.TODAS, Playlist.class);
        
        return query.getResultList();
    }

}
