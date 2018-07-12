package com.mycompany.descorpv2.ejb.servico;

import com.mycompany.descorpv2.ejb.entidades.Musica;
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
public class MusicaServico extends Servico<Musica> {

    public MusicaServico(){
        super(Musica.class);
    }
    
    @TransactionAttribute(SUPPORTS)
    public List<Musica> consultarTitulos(@NotBlank String titulo) {
        return getEntidades(Musica.MUSICA_POR_TITULO, new Object[]{titulo});
    }

    @TransactionAttribute(SUPPORTS)
    public List<Musica> consultarPorReputacao(@NotBlank String reputacao) {
        return getEntidades(Musica.MUSICA_POR_REPUTACAO, new Object[]{reputacao});
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Musica> getMusicas() {
        return getEntidades(Musica.MUSICAS, null);
    }
}
