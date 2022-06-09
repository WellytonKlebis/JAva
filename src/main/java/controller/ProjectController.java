
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
        

/**
 *
 * @author Administrador
 */
public class ProjectController {
    
 public void save (Project project)  {
 
 String sql = "INSERT INTO projects (Name, "
         + "description"
         + "createdAt"
         + "updatedAt)"
         + "VALUES ( ?, ?, ?, ?)";
         // fiquei na duvida qual id usar 
             
 
  Connection  connection = null;
  PreparedStatement statement = null;
  
  try {
      // Cria conexão com o Bano de dados 
      connection = ConnectionFactory.getConnection();
      // Cria um prepareStatement, classe usada para executar a query 
      statement = connection.prepareStatement(sql);
      
      statement.setString(2, project.getName()); 
      statement.setString(3, project.getDescription());
      statement.setDate(4, new Date(project.getCreatedAt().getTime()));
      statement.setDate(5,new Date(project.getUpdatedAt().getTime()) );
      //Executa a sql inserção dos dados 
      statement.execute();
      
      
  } catch (Exeception e) {
    throw  new RuntimeException("Erro ao Salvar projeto", ex); 
  } finally
  {    
      ConnectionFactory.closeConnection(connection, statement);      
  }  
  
 }//class save
    
    
  public void update (Project project)  {
 
 String sql = "UPADATE  projects SET"
         + " Name = ?, "
         + "description = ?"
         + "createdAt = ? "
         + "updatedAt = ?"
         + "WHERE id = ?";
        
             
 
  Connection  connection = null;
  PreparedStatement statement = null;
  
  try {
      // Cria conexão com o Bano de dados 
      connection = ConnectionFactory.getConnection();
      // Cria um prepareStatement, classe usada para executar a query 
      statement = connection.prepareStatement(sql);
      
      statement.setString(1, project.getName()); 
      statement.setString(2, project.getDescription());
      statement.setDate(3, new Date(project.getCreatedAt().getTime()));
      statement.setDate(4,new Date(project.getUpdatedAt().getTime()) );
      statement.setInt (5, project.getId());
      //Executa a sql inserção dos dados 
      statement.execute();
      
      
  } catch (SQLExeception ex) {
    throw  new RuntimeException("Erro ao atualizar projeto", ex); 
  } finally
  {    
      ConnectionFactory.closeConnection(connection, statement);      
  }    
  
  public List<Project> getAll(){
   
      String sql = "SELECT FROM projects";
      
      List<projects> projects  = new ArrayList<>();
      
      
       Connection  connection = null;
       PreparedStatement statement = null;
       
       ResultSet resultSet = null;
        try {
      // Cria conexão com o Bano de dados 
      connection = ConnectionFactory.getConnection();
      // Cria um prepareStatement, classe usada para executar a query 
      statement = connection.prepareStatement(sql);
       resulSet = statement.executeQuery();
       
       // enquanto existir dados no banco de dados, faça 
       
         while(resultSet.next()){
         Project project = new Project();
         project.setId(resultSet.getInt("id"));
         project.setName(resultSet.getString("Name"));
         project.setDescription(resultSet.getString("Description"));
         project.setCreatedAt(resultSet.getString("createdAt"));
         project.setUpdateAt(resultSet.getString("UpdateAt"));
         
      //Executa a sql inserção dos dados 
      projects.add(project);
      
         }
  } catch (SQLExeception ex) {
    throw  new RuntimeException("Erro ao atualizar projeto", ex); 
  } finally
  {    
      ConnectionFactory.closeConnection(connection, statement,  resultSet);      
  }    
       
     return projects; 
  }
   
  
  public void removeByid (IdProject){
      
      
      String sql = "DELETE FROM  projects id = ?";
      
  Connection  connection = null;
  PreparedStatement statement = null;
  
  try {
      // Cria conexão com o Bano de dados 
      connection = ConnectionFactory.getConnection();
      // Cria um prepareStatement, classe usada para executar a query 
      statement = connection.prepareStatement(sql);
      
      statement.setInt(1, idProject()); 
     //Executa a sql remoção dos dados 
      statement.execute();
      
      
  } catch (Exeception e) {
    throw  new RuntimeException("Erro ao Salvar projeto", ex); 
  } finally
  {    
      ConnectionFactory.closeConnection(connection, statement);      
  }  
  
 }

    private int idProject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
  
    
} // final
