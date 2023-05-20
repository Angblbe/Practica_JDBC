package com.pluralcamp.daw.persistence.daos.impl.jdbc;

import com.pluralcamp.daw.entities.core.Color;
import com.pluralcamp.daw.persistence.daos.contracts.ColorDAO;
import com.pluralcamp.daw.persistence.exceptions.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDAOJDBCImpl implements ColorDAO {
	
    @Override
    public Color getColorById(long id) throws DAOException {
    	
    	Color color = null;
    	
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris", "angel", "angel");
    		 CallableStatement sentSQL = connection.prepareCall("CALL getColorById(?)")){
    		
    		sentSQL.setLong(1, id);
    		
    		try(ResultSet reader = sentSQL.executeQuery()){
	    		if(reader.next()) {
	    			color = new Color(reader.getString("name"),reader.getInt("red"), reader.getInt("green"), reader.getInt("blue"));
	    			color.setId(reader.getLong("id"));
	    			
	    		}
    		}
    	}catch(SQLException ex){
    		throw new DAOException(ex);
    		
    	}


        return color;
    	
    }

    @Override
    public List<Color> getColors() throws DAOException {
        
    	
    	List<Color> colors = new ArrayList<>();
    	
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris", "angel", "angel");
    		 CallableStatement sentSQL = connection.prepareCall("CALL getColors()");
    		 ResultSet reader = sentSQL.executeQuery()){
    		
	    		while(reader.next()) {
	    			var color = new Color(reader.getString("name"),reader.getInt("red"), reader.getInt("green"), reader.getInt("blue"));
	    			color.setId(reader.getLong("id"));
	    			colors.add(color);
	    		}
	    }
    	catch(SQLException ex){
    		throw new DAOException(ex);
    		
    	}

        return colors;
             
    }

    @Override
    public List<Color> getColors(int offset, int count) throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(String searchTerm) throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
        return null;
    }
}
