package com.myMain;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbtables.*;
import com.hibernateutil.MySessionFactory;

public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Logger MMlog = LoggerFactory.getLogger(MyMain.class);
		/*
		 * Testing configuration
		
		TableXML txml = new TableXML("java2", "hibernateA3A", 1, 2);

		Session session = MySessionFactory.getXMLsessionInstance().openSession();
		session.beginTransaction();
		session.save(txml);
		session.getTransaction().commit();
		MMlog.info("changes commited");
		session.close();
		MMlog.info("session closed");
		// MySessionFactory.getAAsessionInstace().close();
		MMlog.info("data sucesfully saved");
		// System.out.println("SAVED");

		TableAA txmla = new TableAA("java22", "hibernateA33A", 1, 2);

		Session session = MySessionFactory.getAAsessionInstace().openSession();
		session.beginTransaction();
		session.save(txmla);
		session.getTransaction().commit();
		MMlog.info("changes commited");
		session.close();
		MMlog.info("session closed");
		// MySessionFactory.getAAsessionInstace().close();
		MMlog.info("data sucesfully saved");
		//ADD SESSIONFACTORY DESTROY!!!!!!!!!!!!!!!!!!!!!!
		*/
		
		
	}

}
