package com.hibernateutil;
/*
 * this class is to get session factory objet to work with MySQL database
 * session factory object is thread-safe, and there is one object for one database
 * it is used to get session instance 
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionFactory {

	private static SessionFactory xmlSessionFactory = null;
	private static SessionFactory aaSessionFactory = null;

	private static StandardServiceRegistry standardRegistry;
	private static StandardServiceRegistry standardRegistryaa;

	private static final Logger MSFlog = LoggerFactory.getLogger(MySessionFactory.class);

	public static SessionFactory getXMLsessionInstance() {
		// method to create or get XML based configured session factory object
		if (xmlSessionFactory == null) {
			/*
			 * creating session factory object based on cfg.xml file
			 */
			try {
				MSFlog.info("attemting to create XMLsessionFactory object");
				standardRegistry = new StandardServiceRegistryBuilder().configure("hibernatexml.cfg.xml").build();
				MSFlog.info("service registry created!");
				MSFlog.info("configuration loaded");
				Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				xmlSessionFactory = metaData.getSessionFactoryBuilder().build();
				MSFlog.info("xml session factory instace created!");
				return xmlSessionFactory;
			} catch (Throwable e) {
				// TODO: handle exception
				MSFlog.info("FAILD to create xml session factory instace!!!");
				throw new ExceptionInInitializerError(e);
			}

		} else {
			MSFlog.info("xmlSessionFactory instance returned");
			return xmlSessionFactory;

		}
	}

	public static SessionFactory getAAsessionInstace() {
		// method to create or get annotation based configured session factory
		// object
		if (aaSessionFactory == null) {
			/*
			 * creating session factory object based on cfg.xml file
			 */
			try {
				MSFlog.info("attemting to create XMLsessionFactory object");
				standardRegistryaa = new StandardServiceRegistryBuilder().configure("hibernateaa.cfg.xml").build();
				MSFlog.info("service registry created!");
				MSFlog.info("configuration loaded");
				Metadata metaData = new MetadataSources(standardRegistryaa).getMetadataBuilder().build();
				aaSessionFactory = metaData.getSessionFactoryBuilder().build();
				MSFlog.info("AA session factory instace created!");
				return aaSessionFactory;
			} catch (Throwable e) {
				// TODO: handle exception
				MSFlog.info("FAILD to create AA session factory instace!!!");
				throw new ExceptionInInitializerError(e);
			}

		} else {
			MSFlog.info("AA session instance returned");
			return aaSessionFactory;
		}
	}

	public static void destroySessionFactory() {
		if (standardRegistry != null) {
			StandardServiceRegistryBuilder.destroy(standardRegistry);
			MSFlog.info("XML session factory destroyed");
		}
		if (standardRegistryaa != null) {
			StandardServiceRegistryBuilder.destroy(standardRegistryaa);
			MSFlog.info("AA session factory destroyed");
		}
	}

}
