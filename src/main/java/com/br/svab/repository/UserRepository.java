package com.br.svab.repository;

import java.util.List;

import com.br.svab.model.User;

public interface UserRepository 
{
	public void salvar(User usuario);
	public void atualizar(User usuario);	
	public void excluir(User usuario);
	public User carregar(Integer codigo);
	public User buscarPorLogin(String login);
	public List<User> listar();

}
