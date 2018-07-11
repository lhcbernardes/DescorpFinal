/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.beans;

import com.mycompany.descorpv2.ejb.entidades.Usuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import servico.UsuarioServico;

/**
 *
 * @author leandro
 */
@RequestScoped
@Named("usuarioBean")
public class UsuarioBean extends Bean<Usuario> implements Serializable {
    public UsuarioBean() {
        this.entidade = new Usuario() {};
    }

    @Inject
    private UsuarioServico usuarioServico;
    private final boolean sucesso = true;

    @Override
    protected void iniciarCampos() {
        if (sucesso) {
            this.entidade = new Usuario() {};
        }
    }

    @Override
    protected boolean salvar(Usuario entidade){
         this.usuarioServico.persistir(entidade);
        return true;
    }
}
