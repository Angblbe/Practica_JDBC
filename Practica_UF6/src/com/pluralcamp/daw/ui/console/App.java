package com.pluralcamp.daw.ui.console;

import com.pluralcamp.daw.entities.core.Color;
import com.pluralcamp.daw.entities.core.Employee;
import com.pluralcamp.daw.entities.core.Event;
import com.pluralcamp.daw.persistence.daos.contracts.ColorDAO;
import com.pluralcamp.daw.persistence.daos.contracts.EventDAO;
import com.pluralcamp.daw.persistence.exceptions.DAOException;

import com.pluralcamp.daw.persistence.daos.impl.jdbc.ColorDAOJDBCImpl;
import com.pluralcamp.daw.persistence.daos.impl.jdbc.EventDAOJDBCImpl;


import java.util.List;
//import java.awt.Color;
import java.util.Scanner;
import com.pluralcamp.daw.persistence.exceptions.DAOException;

@SuppressWarnings("unused")

public class App {
    public static void main(String[] args) {
    	
        System.out.println("Hello JDBC");
        
        Scanner stdin = new Scanner (System.in);
    	
    	ColorDAOJDBCImpl colorDAOJDBC = new ColorDAOJDBCImpl(); //Inicialitzem els nostres DAOs 
    	EventDAOJDBCImpl eventDAOJDBC = new EventDAOJDBCImpl(); //Inicialitzem els nostres DAOs
        
    	
        try {
        	
        	Color c = colorDAOJDBC.getColorById(5);
        	
        	if(c != null) {
        		System.out.println(c.toString());
        	}
        } catch (DAOException ex){
        	System.out.printf("Error:: %s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        
        try {
        	List<Color> colors = colorDAOJDBC.getColors();
        	for (Color c : colors){
        		System.out.println(c.toString());
        	}
        } catch (DAOException ex) {
        	System.out.printf("error:: 5s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        
        try {
        	Event e = eventDAOJDBC.getEventById(5);
        	if (e != null) {
        		System.out.println(e.toString());
        	}
        } catch (DAOException ex) {
        	System.out.printf("error:: 5s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        
        try {
        	List<Event> events = eventDAOJDBC.getEvents();
        	for (Event e : events) {
        		System.out.println(e.toString());
        	}
        } catch (DAOException ex) {
        	System.out.printf("error:: 5s %n", ex.getMessage());
        }
        
        System.out.printf("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        
    }
}
