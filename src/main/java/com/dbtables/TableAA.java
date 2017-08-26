package com.dbtables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * @Entity - indicates that class will be entity for DB so elemenst of this class will be used for mapping
 * @Table indicates which table os DB I am going to map. uniqueConstraints - which column will identify row directly
 * @id - primary key 
 * annotations can be done on fields or getters (never on setters)
 * use getters if I want to add some business logic
 * NOTE> some other libs use only setters and  getters so if I want to use other libs better use Getters
 * DONT MIX FIELD AND GETTERS ANNOTATIONS
 */

@Entity
@Table(name = "db_hibernate")
public class TableAA {

	private String name1;
	private String name2;
	private int val1;
	private int val2;
		
	private int id;
	TableAA(){}
	public TableAA(String name1, String name2, int val1, int val2) {
		this.name1 = name1;
		this.name2 = name2;
		this.val1 = val1;
		this.val2 = val2;
	}
	@Id	
	@Column(name = "id",unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name1")
	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}
	@Column(name = "name2")
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	@Column(name = "val1")
	public int getVal1() {
		return val1;
	}

	public void setVal1(int val1) {
		this.val1 = val1;
	}
	@Column(name = "val2")
	public int getVal2() {
		return val2;
	}

	public void setVal2(int val2) {
		this.val2 = val2;
	}

	

}
