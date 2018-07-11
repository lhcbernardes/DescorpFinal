/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import com.mycompany.descorpv2.ejb.entidades.Album;
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
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author lucas
 */
@Stateless(name = "ejb/AlbumServico")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ValidateOnExecution(type = ExecutableType.ALL)
public class AlbumServico extends Servico<Album> {
    
    @Override
    public Album criar() {
        return new Album();
    }

    @PostConstruct
    public void init() {
        super.setClasse(Album.class);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Album> getAlbuns() {
        return super.consultarEntidades(null, Album.ALBUM_POR_TITULO);
    }

    @Override
    public boolean existe(@NotNull Album entidade) {
        TypedQuery<Album> query
                = entityManager.createNamedQuery(Album.ALBUM_POR_ID, classe);
        query.setParameter(1, entidade.getId());
        return !query.getResultList().isEmpty();
    }

    @TransactionAttribute(SUPPORTS)
    public List<Album> consultarAlbuns(@NotBlank String titulo) {
        return super.consultarEntidades(new Object[]{titulo}, Album.ALBUM_POR_TITULO);
    }

    @TransactionAttribute(SUPPORTS)
    public Album consultarPorGenero(@NotBlank String genero) {
        return super.consultarEntidade(new Object[]{genero}, Album.ALBUM_POR_GENERO);
    }

}
