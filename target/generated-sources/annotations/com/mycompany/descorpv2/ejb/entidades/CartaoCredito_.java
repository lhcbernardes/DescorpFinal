package com.mycompany.descorpv2.ejb.entidades;

import com.mycompany.descorpv2.ejb.entidades.Premium;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-12T21:24:44")
@StaticMetamodel(CartaoCredito.class)
public class CartaoCredito_ extends Entidade_ {

    public static volatile SingularAttribute<CartaoCredito, Date> dataExpiracao;
    public static volatile SingularAttribute<CartaoCredito, Premium> dono;
    public static volatile SingularAttribute<CartaoCredito, String> numero;
    public static volatile SingularAttribute<CartaoCredito, String> bandeira;

}