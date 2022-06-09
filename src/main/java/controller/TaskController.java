
package controller;

import model.Task;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;


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
                +"notes = ?, "
                +"completed = ?,"
                +"createdAt = ?"
                +"updateAt = ?"
                + "WHERE id = ?";
     
     Connection connection = null;
     PreparedStatement statement = null;
              // Estabelecendo conexão com o banco de dados        
     try { connection = ConnectionFactory.getConnection();
             // Preparando a query
           Statement = connection.prepareStatement(sql);
            // Setando os valores do statement 
           statement.setInt(1, task.getidProject());
           statement.setString(2, task.getname());
           statement.setString(3, task.getdescription());
           statement.setString(4, task.getNotes());
           statement.setBoolean(5, task.isIsCompleted());
           statement.setDate(6, new Date(task.getDeadline().getTime()));
           statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            // executando Query 
            statement.execute();
         
     } catch (Exception ex){
             throw new RuntimeException ("Erro ao Fazer Update"); 
 
  }
     
 }
            /* METODO removeBYid */
            
 public void removeById( int taskId) 
     throws SQLException{
     String sql = "DELETE FROM tasks WHERE id = ? ";
     
     Connection connection = null;
     PreparedStatement statement = null;
     
     try {
         // Crição conexão banco de dados 
       connection = ConnectionFactory.getConnection();
       // preparando a query 
       statement = connection.prepareStatement(sql); 
       // setando os valores 
       statement.setInt(1, taskId);
       // Executando a query 
       statement.execute();
       
     } catch (Exception ex){
       throw new RuntimeException ("Erro ao deletar a tarefa"); 
     } finally {
      ConnectionFactory.closeConnection(connection, statement);
     
     }
  }        /* METODO LIST 
          Unico metodo que retornara um valor  */ 
 
 public List <Task> getAll (int idProject){
 
      String sql = "SELECT * FROM tasks WHERE idProject = ? ";
      
      Connection connection = null;
      PreparedStatement statement = null;
      // variavel criada para guardar valores rtornado pelo banco de dados 
      ResultSet resultSet = null;     
      
      // Lista de tarefas que será devolvida quando a chamada do metodo acontecer
      List<Task>tasks = new ArrayList<Task>();
      
      try {
          // Criamos a conexão 
         connection = ConnectionFactory.getConnection(); 
         statement = connection.prepareStatement(sql); 
         // setando um valor que corresponde ao filtro de busca 
         statement.setInt (1, idProject);
         // valor retornado pela execução da query 
         resultSet = statement.executeQuery(); 
         
       // Equantto houver valores a serem percorridos no meu resutSet
         while(resultSet.next()){
             
         Task task = new Task();
         task.setId(resultSet.getInt("id"));
         task.setIdProject(resultSet.getInt("idProject"));
         task.setName(resultSet.getString("name"));
         task.setDescription(resultSet.getString("description"));
         task.setNotes(resultSet.getString("notes"));
         task.setIsCompleted(resultSet.getBoolean("completed"));
          task.setDeadline(resultSet.getDate("deadline")); 
         task.setCreatedAt(resultSet.getDate("creatdAt")); 
          task.setUpdatedAt(resultSet.getDate("updatedAt")); 
          tasks.add(task);
          
         
         }
         
        // tratar qualquer exceção que ocorra 
      }catch (Exception ex){ 
         throw new RuntimeException("Erro ao inserir tarefas"
                 + ex.getMessage(), ex);
   }finally{
       ConnectionFactory.closeConnection(connection, statement, resultSet); 
   }
  
      // ista de tarefas que foi criada e recebida pelo banco de dados 
  return tasks;    
      
}
 
}