/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.servico;

import com.mycompany.descorpv2.ejb.entidades.Artista;
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
 * @author leandro
 */
@Stateless
public class ArtistaServico extends Servico<Artista> {

    public ArtistaServico() {
        super(Artista.class);
    }

    public boolean existe(@NotNull Artista entidade) {
        EntityManager em = getEntityManager();
        
        TypedQuery<Artista> query = em.createNamedQuery(Artista.ARTISTA_POR_ID, Artista.class);
        query.setParameter(1, entidade.getId());
        return !query.getResultList().isEmpty();
    }

    @TransactionAttribute(SUPPORTS)
    public List<Artista> consultarArtistas(@NotBlank String nome) {
        return getEntidades(Artista.ARTISTA_POR_NOME, new Object[]{nome});
    }

    @TransactionAttribute(SUPPORTS)
    public List<Artista> consultarPorPais(@NotBlank String pais) {
        return getEntidades(Artista.ARTISTA_POR_PAIS, new Object[]{pais});
    }

   @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Artista> getArtistas() {
        return getEntidades(Artista.ARTISTAS, null);
    }
}
