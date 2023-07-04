/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;



import interfaces.GestorBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class MySql extends Gestor implements GestorBD {
    private static final String url ="jdbc:mysql://localhost:3306/ventas";
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private  Connection con;
   
    
    
    public void insertar( String tabla, String columnas){
        try {
            
            
            Statement st = con.createStatement();
            st.executeUpdate("insert into "+tabla+" set "+columnas);
        } catch (SQLException ex) {
            
        }
    }
    
    
    public void seleccionar(){
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement("");
            rs = ps.executeQuery();
            
           
            
            
            while(rs.next())
            {
                System.out.println(rs.getString("codigo")+" "+ rs.getString("nombre"));
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }

    @Override
    public Connection conectarMysql(String usuario,String clave) {
         con=null;
        super.setUser(usuario);
        super.setClave(clave);
        try
        {
            Class.forName(driver);
            con = (Connection)DriverManager.getConnection(url, super.getUser(), super.getClave());
            if(con!=null)
            {
                System.out.println("se conexto");
            }
            else
            {
                System.out.println("no se conecto");
            }
        }
        catch(Exception e){
            System.out.println(e); 
        }
        return con;
    }

    @Override
    public ResultSet seleccionarProvincias() {
       PreparedStatement ps = null;
       ResultSet rs=null;
        try {
            
            
            ps = con.prepareStatement("select * from provincias where codigo = ?");
            ps.setString(1, "T01");
            rs = ps.executeQuery();
            
            /*Statement st = con.createStatement();
            st.executeQuery("select * from provincias where codigo = 'T02'");*/
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
   
    
}
