/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import com.mycompany.descorpv2.ejb.entidades.Artista;
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
 * @author leandro
 */
@Stateless(name = "ejb/ArtistaServico")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ValidateOnExecution(type = ExecutableType.ALL)
public class ArtistaServico extends Servico<Artista> {

    @PostConstruct
    public void init() {
        super.setClasse(Artista.class);
    }

    @Override
    public Artista criar() {
        return new Artista();
    }

    @Override
    public boolean existe(@NotNull Artista entidade) {
        TypedQuery<Artista> query
                = entityManager.createNamedQuery(Artista.ARTISTA_POR_ID, classe);
        query.setParameter(1, entidade.getId());
        return !query.getResultList().isEmpty();
    }

    @TransactionAttribute(SUPPORTS)
    public List<Artista> consultarArtistas(@NotBlank String nome) {
        return super.consultarEntidades(new Object[]{nome}, Artista.ARTISTA_POR_NOME);
    }

    @TransactionAttribute(SUPPORTS)
    public List<Artista> consultarPorPais(@NotBlank String pais) {
        return super.consultarEntidades(new Object[]{pais}, Artista.ARTISTA_POR_PAIS);
    }

   @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Artista> getArtistas() {
        return super.consultarEntidades(null, Artista.ARTISTAS);
    }
}
