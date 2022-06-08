
package controller;

import model.Task;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;


public class TaskController {
 
    /* METODO SAVE */
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
       statement.setInt(1, task.getIdProject());
       statement.setString(2, task.getName());
       statement.setString(3, task.getDescription());
       statement.setBoolean(4, task.isIsCompleted());
       statement.setString(5, task.getNotes);
       statement.setDate(6, new Date(task.getDeadline().getTime()));
       statement.setDate(7, new Date (task.getCreatedAt().getTime()));
       statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
       statement.execute();
       
   }catch (Exception ex){ // tratar qualquer exeção que ocorra
         throw new RuntimeException("Erro ao Salvar Tarefa"
                 + ex.getMessage(), ex);
   }finally{
       ConnectionFactory.closeConnection(connection, statement); 
   }
 }   
     /* METODO UPDATE */
 public void update(Task task){
  
     String sql ="UPDATE tasks SET"
                + "idProject = ?"
                +" name =?,"
                + "description =?,"
                +"status = ?,"
                +"notes = ?, "
                +"completed = ?,"
                +"createdAt = ?"
                +"updateAt = ?"
                + "WHERE id = ?";
     
     Connection connection = null;
     PreparedStatement statement = null;
     
     try { connection = ConnectionFactory.getConnection();
           Statement = connection
         
     } catch (Exception ex){
     
 
  }
            /* METODO removeBYid */
 public void removeById( int taskId) throws SQLException{
     String sql = "DELETE FROM tasks WHERE id = ? ";
     
     Connection connection = null;
     PreparedStatement statement = null;
     
     try {
       connection = ConnectionFactory.getConnection();
       statement = connection.prepareStatement(sql); // prepara o comando SQl que vai ser executado no banco de dados 
       statement.setInt(1, taskId);
       statement.execute();
       
     } catch (Exception ex){
       throw new RuntimeException ("Erro ao deletar a tarefa"); 
     } finally {
      ConnectionFactory.closeConnection(connection);
     
     }
 
 }
        /* METODO LIST */ 
 public List<Task> getAll (int idProject){
 
 
  return null;
 }
    
}