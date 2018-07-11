package com.mycompany.descorpv2.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_CARTAO_CREDITO")
@PrimaryKeyJoinColumn(name = "ID_PREMIUM", referencedColumnName = "ID")
@NamedQueries(
        {
            @NamedQuery(
                    name = CartaoCredito.CARTAO_POR_ID,
                    query = "SELECT c FROM CartaoCredito c WHERE c.id = ?1"
            )
            ,
            @NamedQuery(
                    name = CartaoCredito.CARTAO_POR_BANDEIRA,
                    query = "SELECT c FROM CartaoCredito c WHERE c.bandeira = ?1"
            )
            ,
            @NamedQuery(
                    name = CartaoCredito.CARTAO_POR_NUMERO,
                    query = "SELECT c FROM CartaoCredito c WHERE c.numero = ?1"
            )
        }
)
public class CartaoCredito extends Entidade implements Serializable {

    public static final String CARTAO_POR_ID = "CartaoId";
    public static final String CARTAO_POR_BANDEIRA = "CartaoBandeira";
    public static final String CARTAO_POR_NUMERO = "CartaoNumero";

    @NotNull
    @OneToOne(mappedBy = "cartaoCredito", optional = false)
    private Premium dono;

    @NotBlank
    @Size(max = 15)
    @Column(name = "TXT_BANDEIRA")
    private String bandeira;

    @NotNull
    @CreditCardNumber
    @Column(name = "TXT_NUMERO")
    private String numero;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EXPIRACAO", nullable = false)
    private Date dataExpiracao;

    public Premium getDono() {
        return dono;
    }

    public void setDono(Premium dono) {
        this.dono = dono;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

}
