package io.spring.save.csv.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Colony {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   private String columnName1; // Replace with your CSV column names
	   private String columnName2;
	   // Add more columns as needed, matching your CSV structure

	   // Constructors, getters, setters
	}