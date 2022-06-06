
package util;


public class ConnectionFactory {
  
 public static final String DRIVER = "com.mysql.jdbd.Driver" ;
 public static final String URL = "jbdc:mysql://localhost:3306/todoApp";// endereço do meu banco de dados 
 public static final String USER = "root";
 public static final String PASS = ""; 
 
 
 public static Connection getConnection(){
 
 try {
       Class.forName(Driver);
       return DriverManager.getConnection(URL, USER, PASS):
 } catch (Exeption ex){
     throw new RuntimeException("Erro na conexão com o bqnco de dados ",ex ); 
 
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

