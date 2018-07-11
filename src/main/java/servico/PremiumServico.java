/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import com.mycompany.descorpv2.ejb.entidades.Premium;
import com.mycompany.descorpv2.ejb.entidades.Usuario;
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
@Stateless(name = "ejb/PremiumServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class PremiumServico extends Servico<Premium> {

    @PostConstruct
    public void init() {
        super.setClasse(Premium.class);
    }

    @Override
    public Premium criar() {
        return new Premium();
    }

//    @Override
//    public boolean existe(@NotNull Premium entidade) {
//        TypedQuery<Premium> query
//                = entityManager.createNamedQuery(Premium.PREMIUM_POR_ID, classe);
//        query.setParameter(1, entidade.getId());
//        return query.getResultList().isEmpty();
//    }

    @TransactionAttribute(SUPPORTS)
    public List<Premium> consultarPremiumscartao(@NotBlank String cartao) {
        return super.consultarEntidades(new Object[]{cartao}, Premium.PREMIUM_POR_CARTAO);
    }

//    @TransactionAttribute(SUPPORTS)
//    public Premium consultarPorid(@NotBlank String id) {
//        return super.consultarEntidade(new Object[] {id}, Premium.PREMIUM_POR_ID);
//    } 
    
    @TransactionAttribute(SUPPORTS)
    public Premium consultarPorNome(@NotBlank String nome) {
        return super.consultarEntidade(new Object[] {nome}, Premium.PREMIUM_POR_NOME);
    }
}

