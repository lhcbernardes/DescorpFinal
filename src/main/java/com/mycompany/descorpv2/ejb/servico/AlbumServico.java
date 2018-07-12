/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.servico;

import com.mycompany.descorpv2.ejb.entidades.Album;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author lucas
 */
@Stateless
public class AlbumServico extends Servico<Album> {

    public AlbumServico(){
        super(Album.class);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Album> getAlbuns() {
        return getEntidades(Album.ALBUM_POR_TITULO, null);
    }

    public boolean existe(@NotNull Album entidade) {
        EntityManager em = getEntityManager();
        
        TypedQuery<Album> query = em.createNamedQuery(Album.ALBUM_POR_ID, Album.class);
        
        query.setParameter(1, entidade.getId());
        return !query.getResultList().isEmpty();
    }

    @TransactionAttribute(SUPPORTS)
    public List<Album> consultarAlbuns(@NotBlank String titulo) {
        return getEntidades(Album.ALBUM_POR_TITULO, new Object[]{titulo});
    }

    @TransactionAttribute(SUPPORTS)
    public Album consultarPorGenero(@NotBlank String genero) {
        return getEntidade(Album.ALBUM_POR_GENERO, new Object[]{genero});
    }

}
