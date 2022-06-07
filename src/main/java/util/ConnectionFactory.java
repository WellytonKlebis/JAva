
package util;

import java.sql.Connection;
import java.sql.DriverManager;




public class ConnectionFactory {
    
    // Parametros para acesso ao meu banco de dados.
 public static final String DRIVER = "com.mysql.jdbd.Driver" ;
 public static final String URL = "jbdc:mysql://localhost:3306/todoApp";
 public static final String USER = "root";
 public static final String PASS = ""; 
 
     /* Metodo retorna uma conexão,
     é estatico não preciso criar um objeto para usar essa função */
 public static Connection getConnection(){

     try {        
          Class.forName(DRIVER);// carrega o Driver 
          return DriverManager.getConnection(URL, USER, PASS); //  estipula a conexão com banco de dados 
        }    
         catch (Exception ex){
         throw new RuntimeException("Erro na conexão com o banco de dados ",ex ); 
         }
 
 }
 
 public static void closeConnection (Connection connection){
     try {  
        if(connection != null){
           connection.close();
       } 
     } 
       catch (Exception ex){
       throw new RuntimeException("Erro ao fechar a conexão com o banco de dados");
 
 
 
 }  
 
 
 
 
 
 
 
 
 
 
 }
 
 
 
 
}

