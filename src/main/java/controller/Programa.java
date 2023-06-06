package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Automovel;
import entities.Marca;
import entities.Modelo;


public class Programa {

	public static void main(String[] args) throws ParseException {
	
System.out.println("\n*** Vers�o 1 - Inicial ***");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividade7");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Automovel bmwX3 = new Automovel(null,2023, 2023, "carro de classe alta", 450.950, 0, 1 );
		Modelo modelo = new Modelo(1, "combina a tecnologia do acionamento elétrico", 292,1);
		Marca marca = new Marca(1, "BMW");
		
		bmwX3.adicionarModelo(modelo);
		
		em.persist(bmwX3);
		em.persist(modelo);
		em.persist(marca);
		
		em.getTransaction().commit();
		
		Query query1 = em.createQuery("SELECT a FROM Automovel a");
		
		List<Automovel> automoveis = query1.getResultList();
		for (Automovel a : automoveis) {
			System.out.println("\n *** [" + a.getIdAutomovel() + " | "+ c.getNomeAutomovel() + "] ***");
			for (Modelo m : a.getAutomoveis()) {
				System.out.println("\tModelo: " + a.getIdModelo() + " | "+ a.getNome() );
			}
			
		}
		
		
		Query query2 = em.createQuery("SELECT m FROM Modelo m");
		
		List<Modelo> modelos = query2.getResultList();
		for (Modelo m : modelos) {
			System.out.println("\n *** [" + a.getIdModelo() + " | "+ a.getNome() + "] ***");
			for (Marca ma: m.getModelos()) {
				System.out.println("\tModelo: " + c.getIdModelo() + " | "+ c.getNomeModelo() );
			}
		}
		
		em.close();
		emf.close();

	}

}
