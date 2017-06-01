package com.br.svab.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.br.svab.model.User;

@ManagedBean(name = "userBean")
@RequestScoped

public class UserBean 
{
	private User usuario = new User(); // propriedade do tipo Usuario
	private String confirmarSenha;

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	// porta de entrada do formulário
	// preparar cadastro novo usuario
	public String novo() {
		this.usuario = new User();
		this.usuario.setAtivo(true);
		return "publico/user"; // tenta exibir usuario.xhtml
	}


	public String salvar() {
		// facescontext adiciona as mensagens de erro que possam ser criadas
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) { // adicionando mensagem ao
													// context
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null; // null nao caira em nenhuma pagina, fica na mesma de
							// origem
		}

		// se deu certo
		UserRN usuarioRN = new UserRN();
		usuarioRN.salvar(this.usuario);
		return "publico/usersuccess"; // tenta abrir pagina /public/usuariosucesso
									// nao colocou o publico mas
		// o contexto de salvar está em /publico
}

}
