/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.CartaoCredito;
import com.mycompany.descorpv2.ejb.entidades.Premium;
import com.mycompany.descorpv2.ejb.entidades.Usuario;
import com.mycompany.descorpv2.ejb.servico.CartaoServico;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import com.mycompany.descorpv2.ejb.servico.UsuarioServico;

/**
 *
 * @author leandro
 */
@SessionScoped
@Named(value = "usuarioBean")
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioServico usuarioServico;
    
    @EJB
    private CartaoServico cartaoServico;
    
    private CartaoCredito cartao;
    private Premium usuario;

    @PostConstruct
    public void iniciar(){
        usuario = new Premium();
        cartao = new CartaoCredito();
    }

    public CartaoCredito getCartao() {
        return cartao;
    }

    public void setCartao(CartaoCredito cartao) {
        this.cartao = cartao;
    }

    public Premium getUsuario() {
        return usuario;
    }

    public void setUsuario(Premium usuario) {
        this.usuario = usuario;
    }
    
    public boolean salvar(){
        try{
            
            usuario.setCartaoCredito(cartao);
            
            usuarioServico.salvar(usuario);
            cartaoServico.salvar(cartao);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
}
