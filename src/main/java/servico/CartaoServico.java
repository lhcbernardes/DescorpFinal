/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import com.mycompany.descorpv2.ejb.entidades.CartaoCredito;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author leandro
 */
@Stateless(name = "ejb/CartaoServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class CartaoServico extends Servico<CartaoCredito> {

    @PostConstruct
    public void init() {
        super.setClasse(CartaoCredito.class);
    }

    @Override
    public CartaoCredito criar() {
        return new CartaoCredito();
    }

    @Override
    public boolean existe(@NotNull CartaoCredito entidade) {
        TypedQuery<CartaoCredito> query
                = entityManager.createNamedQuery(CartaoCredito.CARTAO_POR_ID, classe);
        query.setParameter(1, entidade.getId());
        return query.getResultList().isEmpty();
    }

    @TransactionAttribute(SUPPORTS)
    public List<CartaoCredito> consultarCartoesBandeira(@NotBlank String bandeira) {
        return super.consultarEntidades(new Object[] {bandeira}, CartaoCredito.CARTAO_POR_BANDEIRA);
    }
    
    @TransactionAttribute(SUPPORTS)
    public List<CartaoCredito> consultarCartoesNumero(@NotBlank String numero) {
        return super.consultarEntidades(new Object[] {numero}, CartaoCredito.CARTAO_POR_NUMERO);
    }
    
    @TransactionAttribute(SUPPORTS)
    public CartaoCredito consultarCartaoPorId(@NotBlank long id) {
        return super.consultarEntidade(new Object[] {id}, CartaoCredito.CARTAO_POR_ID);
    }    
}
