/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.descorpv2.ejb.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author leandro
 */
@RequestScoped
@Named(value = "loginBean")
public class LoginBean implements Serializable {

    @NotBlank
    private String usuario;
    
    @NotBlank
    private String senha;
    
    @Inject
    private FacesContext facesContext;

    private HttpServletRequest getRequest() {
        return (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }
//QUalquer coisa é aqui

    public String login() {
        try {

            getRequest().login(usuario, senha);
            facesContext.getExternalContext().getSession(true);

        } catch (ServletException ex) {
            setUsuario(null);
            adicionarMensagem("Senha ou usuário inválidos!");
            return "falha";
        }

        return "sucesso";
    }

    private void adicionarMensagem(String mensagem) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
        facesContext.addMessage(null, message);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
