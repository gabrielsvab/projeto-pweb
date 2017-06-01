package com.br.svab.utils;

import com.br.svab.repository.UserRepository;
import com.br.svab.repository.UserRepositoryHibernate;

public class RepositoryUtil 
{
	public static UserRepository criaUsuarioDAO() 
	{
		UserRepositoryHibernate usuarioDAO = new UserRepositoryHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}
