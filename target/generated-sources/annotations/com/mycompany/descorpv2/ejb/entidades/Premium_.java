package com.mycompany.descorpv2.ejb.entidades;

import com.mycompany.descorpv2.ejb.entidades.CartaoCredito;
import com.mycompany.descorpv2.ejb.entidades.Playlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-07-10T22:25:50")
@StaticMetamodel(Premium.class)
public class Premium_ extends Usuario_ {

    public static volatile ListAttribute<Premium, Playlist> playlists;
    public static volatile SingularAttribute<Premium, CartaoCredito> cartaoCredito;

}