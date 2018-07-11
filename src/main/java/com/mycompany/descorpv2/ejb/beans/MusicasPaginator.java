package com.mycompany.descorpv2.ejb.beans;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import servico.MusicaServico;

/**
 *
 * @author leandro
 */
@RequestScoped
@Named("musicasPaginator")
public class MusicasPaginator implements Serializable {

    @EJB
    private MusicaServico musicaServico;

    private List<Musica> musicas;

    public List<Musica> getMusicas() {
        if (musicas == null) {
            musicas = musicaServico.getMusicas();
        }

        return musicas;
    }
}
