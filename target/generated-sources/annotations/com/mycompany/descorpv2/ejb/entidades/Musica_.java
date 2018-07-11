package com.mycompany.descorpv2.ejb.entidades;

import com.mycompany.descorpv2.ejb.entidades.Album;
import com.mycompany.descorpv2.ejb.entidades.Artista;
import com.mycompany.descorpv2.ejb.entidades.Playlist;
import com.mycompany.descorpv2.ejb.entidades.Reputacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-07-10T22:25:50")
@StaticMetamodel(Musica.class)
public class Musica_ extends Entidade_ {

    public static volatile ListAttribute<Musica, Artista> artistas;
    public static volatile ListAttribute<Musica, Album> albuns;
    public static volatile SingularAttribute<Musica, String> link;
    public static volatile ListAttribute<Musica, Playlist> playlists;
    public static volatile SingularAttribute<Musica, String> titulo;
    public static volatile SingularAttribute<Musica, Float> duracao;
    public static volatile SingularAttribute<Musica, Reputacao> reputacao;

}