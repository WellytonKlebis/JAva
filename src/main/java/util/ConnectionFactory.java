
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class ConnectionFactory {
  
 public static final String DRIVER = "com.mysql.jdbd.Driver" ;
 public static final String URL = "jbdc:mysql://localhost:3306/todoApp";// endereço do meu banco de dados 
 public static final String USER = "root";
 public static final String PASS = ""; 
 
 
 public static Connection getConnection(){ // Metodo retorna uma conexão,é estatico não preciso criar um objeto para usar essa função
 /* Dentro do tray coloco o codigo que pode gerar erro */
      try { // forma de pegar erros que possam acontecer e fazer um tratamento.
        Class.forName(DRIVER);// carrega o Driver 
        return DriverManager.getConnection(URL, USER, PASS); //  extipula a conexão com banco de dados 
     } catch (Exception ex){
        throw new RuntimeException("Erro na conexão com o banco de dados ",ex ); 
 
  }
 
 }
 
 public static void closeConnection (Connection connection){
 try { 
     
     if(connection !=null){
        connection.close();
       
     }
     
 }  catch (Exception ex){
 
 
 
 }  
 
 
 
 
 
 
 
 
 
 
 }
 
 
 
 
}

