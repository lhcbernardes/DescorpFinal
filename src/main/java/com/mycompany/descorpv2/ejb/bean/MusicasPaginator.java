package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import com.mycompany.descorpv2.ejb.servico.MusicaServico;

/**
 *
 * @author leandro
 */
@RequestScoped
@Named(value = "musicasPaginator")
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
