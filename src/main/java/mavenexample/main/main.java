package mavenexample.main;

import javax.persistence.*;

import mavenexample.Banco;
import mavenexample.db.Conn;;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = Conn.getInstancia().getFactory().createEntityManager();
		
		Banco bancoSaga = new Banco();
		bancoSaga.setBancoNombre("Saga");
		
		em.getTransaction().begin();
		em.persist(bancoSaga);
		em.getTransaction().commit();
		
		System.out.println("Se creo un nuevo banco");
	}

}
