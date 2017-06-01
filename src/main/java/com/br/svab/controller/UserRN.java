package com.br.svab.controller;

import java.util.List;

import com.br.svab.model.User;
import com.br.svab.repository.UserRepository;
import com.br.svab.utils.RepositoryUtil;

public class UserRN 
{
	// padrão formal criar essa propriedade e a instanciacao usando DAOFactory
	private UserRepository usuarioDAO;

	public UserRN() {
		this.usuarioDAO = RepositoryUtil.criaUsuarioDAO();
	}

	// carrega uma instancia
	public User carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	  // faz repasse metodo na classe DAO
	public User buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	// se nao existe salva, caso contrario atualiza
	public void salvar(User usuario) {
		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(User usuario) {
		this.usuarioDAO.excluir(usuario);
	}	

	public List<User> listar() {
		return this.usuarioDAO.listar();
	}

}
