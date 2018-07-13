package com.mycompany.descorpv2.ejb.entidades;

import com.mycompany.descorpv2.ejb.entidades.Free;
import com.mycompany.descorpv2.ejb.entidades.Musica;
import com.mycompany.descorpv2.ejb.entidades.Premium;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-12T21:24:44")
@StaticMetamodel(Playlist.class)
public class Playlist_ extends Entidade_ {

    public static volatile ListAttribute<Playlist, Musica> musicas;
    public static volatile SingularAttribute<Playlist, Premium> premium;
    public static volatile SingularAttribute<Playlist, String> titulo;
    public static volatile SingularAttribute<Playlist, Free> free;

}