package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contacto;
import dao.HibernateUtil;


public class ContactoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion (HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException ("Error en la capa de acceso a datos", he);
	}
	
	public int agregar(Contacto objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer. parseInt ( session .save(objeto).toString());
			tx .commit();
		} 
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} 
		finally {
			session .close();
		}
		return id;
		}
	
	public void modificar(Contacto objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);			
			tx.commit();
			
			//TODO checkar esto!! verificar si esta bien
		} 
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;			
		} 
		finally {
			session.close();
		}
	}

	public void eliminar(Contacto objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} 
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} 
		finally {
			session.close();
		}
	}
}
