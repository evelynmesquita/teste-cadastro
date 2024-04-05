package br.com.registro.factory;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	//definir conexões
    private static final String URL = "jdbc:mysql://localhost:3306/clientes";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection createConnectiontoMySQL() throws Exception {
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	Connection connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
    	
    	return connection;
    }
    
    public static void main(String[] args) throws Exception {
    	Connection con = createConnectiontoMySQL();
    	
    	if(con!=null) {
    		System.out.print("Conexão obtida com sucesso");
    		con.close();
    	}
    }
}
