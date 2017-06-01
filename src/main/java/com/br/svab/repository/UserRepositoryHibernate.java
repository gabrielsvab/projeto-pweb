package com.br.svab.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.br.svab.model.User;

public class UserRepositoryHibernate implements UserRepository
{
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(User usuario) {
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(usuario);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o contato. Erro: " + e.getMessage());
		}
	}

	public void atualizar(User usuario) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.update(usuario);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar o contato. Erro: " + e.getMessage());
		}
	}

	public void excluir(User usuario) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.delete(usuario);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir o contato. Erro: " + e.getMessage());
		}
	}

	// como se fosse o select, busca pela chave, se nao existir retorna null
	// se usar load ao inves de get será gerada uma excecao

	public User carregar(Integer codigo) {
		this.session.getSessionFactory().openSession();
		session.beginTransaction();
		return (User) this.session.get(User.class, codigo);
	}

	// select sem criterio

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> listar() {
		this.session.getSessionFactory().openSession();
		session.beginTransaction();
		return this.session.createCriteria(User.class).list();
	}

	// usando hibernate query sql (parecida com sql)
	// busca outros campos

	@SuppressWarnings("deprecation")
	public User buscarPorLogin(String login) {
		this.session.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "select u from Usuario u where u.login=:login";
		Query<?> consulta = this.session.createQuery(hql);
		consulta.setString("login", login); // parametro
		return (User) consulta.uniqueResult(); // como sabe-se que login é
													// chave naturam, entao
													// chama-se uniqueresult
													// senao usava
													// consulta.list()
}

}
