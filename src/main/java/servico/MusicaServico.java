package servico;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author lucas
 */
@Stateless(name = "ejb/MusicaServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MusicaServico extends Servico<Musica> {

    @PostConstruct
    public void init() {
        super.setClasse(Musica.class);
    }

    @Override
    public Musica criar() {
        return new Musica();
    }

    @TransactionAttribute(SUPPORTS)
    public List<Musica> consultarTitulos(@NotBlank String titulo) {
        return super.consultarEntidades(new Object[]{titulo}, Musica.MUSICA_POR_TITULO);
    }

    @TransactionAttribute(SUPPORTS)
    public List<Musica> consultarPorReputacao(@NotBlank String reputacao) {
        return super.consultarEntidades(new Object[]{reputacao}, Musica.MUSICA_POR_REPUTACAO);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Musica> getMusicas() {
        return super.consultarEntidades(null, Musica.MUSICAS);
    }
}
