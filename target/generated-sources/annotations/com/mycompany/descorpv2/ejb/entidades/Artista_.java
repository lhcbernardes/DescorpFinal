package com.mycompany.descorpv2.ejb.entidades;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-13T21:20:06")
@StaticMetamodel(Artista.class)
public class Artista_ extends Entidade_ {

    public static volatile ListAttribute<Artista, Musica> musicas;
    public static volatile SingularAttribute<Artista, String> nome;
    public static volatile SingularAttribute<Artista, String> pais;

}