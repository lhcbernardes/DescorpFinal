package com.mycompany.descorpv2.ejb.beans;

import com.mycompany.descorpv2.ejb.entidades.Album;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import servico.AlbumServico;

/**
 *
 * @author leandro
 */
@RequestScoped
@Named
public class AlbumBean extends Bean<Album> implements Serializable {

    private Album album;

    @EJB
    private AlbumServico albumServico;

    @PostConstruct
    public void inicarArtista() {
        album = albumServico.criar();
    }

    @Override
    public void iniciarCampos() {
        setEntidade(albumServico.criar());
    }

    @Override
    public boolean salvar(Album entidade) {
        this.albumServico.persistir(entidade);
        return true;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
