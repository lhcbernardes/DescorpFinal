package com.mycompany.descorpv2.ejb.entidades;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-11T17:58:29")
@StaticMetamodel(Album.class)
public class Album_ extends Entidade_ {

    public static volatile ListAttribute<Album, Musica> musicas;
    public static volatile SingularAttribute<Album, String> genero;
    public static volatile SingularAttribute<Album, String> titulo;

}