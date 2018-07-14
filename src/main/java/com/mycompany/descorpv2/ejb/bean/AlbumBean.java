package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.Album;
import com.mycompany.descorpv2.ejb.servico.AlbumServico;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author leandro
 */
@Named(value = "albumBean")
@SessionScoped
public class AlbumBean implements Serializable {

    @EJB
    private AlbumServico albumServico;

    private Album album;

    @PostConstruct
    public void inicar() {
        album = new Album();
    }

    public boolean salvar() {
        albumServico.salvar(album);
        return true;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
