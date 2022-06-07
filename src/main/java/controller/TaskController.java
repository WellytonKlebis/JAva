
package controller;

import model.Task;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import util.ConnectionFactory;
import java.sql.Connection;


public class TaskController {
 
 public void save(Task task){
   String sql = "INSERT INTO tasks (idProject "
   + " name,"
   + "description,"      
   + "completed, " 
   + "notes, "
   + "deadline,"
   + "createdAt,"
   + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";         
   
   
   Connection  connection = null;     
   PreparedStatement statement = null;   
   
   try {
       connection = ConnectionFactory.getConnection();
       statement = connection.prepareStatement(sql);
   
   }
   
   
   
 }   
  
 public void update(Task task){
 
  }
 
 public void removeByid( int taskId) throws SQLException{
     String sql = "DELETE FROM tasks WHERE id = ? ";
     
     Connection conn = null;
     PreparedStatement statement = null;
     
     try {
       conn = ConnectionFactory.getConnection();
       statement = conn.prepareStatement(sql); // prepara o comando SQl que vai ser executado no banco de dados 
       statement.setInt(1, taskId);
       statement.execute();
       
     } catch (SQLException e){
       throw new SQLException ("Erro ao deletar a tarefa"); 
     } finally {
      ConnectionFactory.closeConnection(conn);
     
     }
 
 }
 
 public List<Task> getAll (int idProject){
 
 
  return null;
 }
    
}
