/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Base {
Connection co;
Statement st;

public void conectarse(){
    try {
        Class.forName("org.sqlite.JDBC");
     
    
        co=DriverManager.getConnection("jdbc:sqlite:base.db");
        if(co==null){
            System.out.println("NO");
        }
                  st=co.createStatement();
        ResultSet rs=st.executeQuery("select * from a");
      while(rs.next()){
           System.out.println(rs.getString("name"));

     }
    

      } 
    catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public void cerrar(){
    try {
        co.close();
    } catch (SQLException ex) {
        Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void insertar() throws SQLException{

    st.executeUpdate("insert into a values('"+JOptionPane.showInputDialog("Meta dentro de a \n o String")+"')");
    }
public void nuevo() throws SQLException{
   
    st.executeUpdate("update a set name=('"+JOptionPane.showInputDialog("Meta o valor a cambiar")+"' where name=('"+JOptionPane.showInputDialog("Meta o valor cambiado")+"');");
}
public void buscar() throws SQLException{
  st.executeUpdate("select * from a");

} 
public void borrar() throws SQLException{
    st.executeUpdate("delete from a where name=('"+JOptionPane.showInputDialog("Meta o valor a borrar")+"');");
}
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       Base a= new Base();
       a.conectarse();
       a.insertar();
       a.borrar();
    a.cerrar();
   

    }
    
}
