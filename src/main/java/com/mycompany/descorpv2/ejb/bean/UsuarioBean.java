/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.bean;

import com.mycompany.descorpv2.ejb.entidades.Free;
import com.mycompany.descorpv2.ejb.entidades.Usuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import com.mycompany.descorpv2.ejb.servico.UsuarioServico;

/**
 *
 * @author leandro
 */
@RequestScoped
@Named(value = "usuarioBean")
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioServico usuarioServico;
    
    private Usuario usuario;

    @PostConstruct
    public void iniciar(){
        usuario = new Free();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    protected boolean salvar(Usuario entidade){
        usuarioServico.salvar(entidade);
        return true;
    }
}
