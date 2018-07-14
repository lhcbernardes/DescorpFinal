/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.servico;

import com.mycompany.descorpv2.ejb.entidades.Artista;
import com.mycompany.descorpv2.ejb.entidades.CartaoCredito;
import com.mycompany.descorpv2.ejb.entidades.Premium;
import com.mycompany.descorpv2.ejb.enums.EnumBandeiraCC;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author bernardes
 */
@Stateless
public class CartaoServico extends Servico<CartaoCredito> {

    public CartaoServico() {
         super(CartaoCredito.class);
    }

     public boolean existe(@NotNull CartaoCredito entidade) {
        EntityManager em = getEntityManager();
        
        TypedQuery<CartaoCredito> query = em.createNamedQuery(CartaoCredito.CARTAO_POR_ID, CartaoCredito.class);
        query.setParameter(1, entidade.getId());
        return !query.getResultList().isEmpty();
    }

    @TransactionAttribute(SUPPORTS)
    public List<CartaoCredito> CartaoNumero(@NotBlank String numero) {
        return getEntidades(CartaoCredito.CARTAO_POR_NUMERO, new Object[]{numero});
    }
    
     @TransactionAttribute(SUPPORTS)
    public List<CartaoCredito> CartaoBandeira(@NotBlank String bandeira) {
        return getEntidades(CartaoCredito.CARTAO_POR_BANDEIRA, new Object[]{bandeira});
    }
    
    
}
