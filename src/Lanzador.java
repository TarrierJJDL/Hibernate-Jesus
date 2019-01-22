
import java.util.Scanner;

import org.hibernate.Session;
public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		int n;
		
		
		Session session = HibernataUtilities.getSessionFactory().openSession();
		
		System.out.println("1- Para intro empresa 2-Para intro item 3-Para intro pedido");
		System.out.println("4- Para mostrar empresa 5-Para mostrar item 6-Para mostrar pedido");
			n=teclado.nextInt();
		
			
		if (n==1) {
			session.beginTransaction();
			
			empresa e = new empresa();
			e.setCif("98898929H");
			e.setNombre("Manolo");
			e.setEmpleados(30);
			e.setDireccion("100");
			
			session.save(e);
			
			session.getTransaction().commit();
			session.close();	
			HibernataUtilities.getSessionFactory().close();
			
		}
		if(n==4) {	
		
		session.beginTransaction();
		
		empresa e = session.get(empresa.class, "98898929H");
		System.out.println("Hemos recuperado "+e.getCif()+" "+e.getNombre()+" "+
		e.getEmpleados()+" "+e.getDireccion());
		
		session.getTransaction().commit();
		session.close();	
		HibernataUtilities.getSessionFactory().close();
		
		}
		if (n==2) {
			session.beginTransaction();
			
			item e = new item();
			e.setId(32);
			e.setNombre("Manolo");
			e.setCantidad(30);
			
			
			session.save(e);
			
			session.getTransaction().commit();
			session.close();	
			HibernataUtilities.getSessionFactory().close();
			
		}
		if(n==5) {	
		
		session.beginTransaction();
		
		item e = session.get(item.class, 2);
		System.out.println("Hemos recuperado "+e.getId()+" "+e.getNombre()+" "+
		e.getCantidad());
		
		session.getTransaction().commit();
		session.close();	
		HibernataUtilities.getSessionFactory().close();
		
		}
		if (n==3) {
			session.beginTransaction();
			
			pedido e = new pedido();
			e.setId(43);
			e.setFecha("14/9/2018");
			
			
			session.save(e);
			
			session.getTransaction().commit();
			session.close();	
			HibernataUtilities.getSessionFactory().close();
			
		}
		if(n==6) {	
		
		session.beginTransaction();
		
		pedido e = session.get(pedido.class, 3);
		System.out.println("Hemos recuperado "+e.getId()+" "+e.getFecha());
		
		session.getTransaction().commit();
		session.close();	
		HibernataUtilities.getSessionFactory().close();
		
		}
		
		
		

	}

}
