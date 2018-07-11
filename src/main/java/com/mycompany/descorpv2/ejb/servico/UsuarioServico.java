/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.servico;

import servico.*;
import com.mycompany.descorpv2.ejb.entidades.CartaoCredito;
import com.mycompany.descorpv2.ejb.entidades.Free;
import com.mycompany.descorpv2.ejb.entidades.Premium;
import com.mycompany.descorpv2.ejb.entidades.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import javax.ejb.TransactionManagement;
import static javax.ejb.TransactionManagementType.CONTAINER;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author lucas
 */
@Stateless
public class UsuarioServico extends Servico<Usuario> {

    public UsuarioServico() {
        super(Usuario.class);
    }
    
    public Premium tornarPremium(Usuario usuario, CartaoCredito cartaoCredito) {
        Premium premium = (Premium) usuario;
        premium.setCartaoCredito(cartaoCredito);
        
        if(consultarPorId(usuario.getId()) != null){
            atualizar(premium);
        } else {
            salvar(premium);
        }
        
        return premium;
        
    }
    
    public Free tornarFree(Usuario usuario) {
        Free free = (Free) usuario;
        
        if(consultarPorId(usuario.getId()) != null){
            atualizar(free);
        } else {
            salvar(free);
        }
        
        return free;
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean isPremium(@NotBlank Usuario usuario) {
        EntityManager em = getEntityManager();
        
        TypedQuery<Premium> query = em.createNamedQuery(Premium.PREMIUM_POR_ID, Premium.class);
        query.setParameter(1, usuario.getId());
        return !query.getResultList().isEmpty();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public boolean isFree(@NotBlank Usuario usuario) {
        EntityManager em = getEntityManager();
        
        return !em.find(Free.class, usuario).equals(usuario);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Usuario consultarPorId(@NotBlank Long id) {
        return getEntidade(Premium.PREMIUM_POR_ID, new Object[] {id});
    }    

//    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
//    public List<Premium> consultarPremiumsPorBandeira(EnumBandeiraCC bandeiras){
//        CartaoServico cartao = new CartaoServico();
//       return cartao.usuariosPorBandeira(bandeiras);
//    }
    
}
