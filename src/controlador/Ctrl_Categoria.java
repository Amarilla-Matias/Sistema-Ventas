
package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Categoria;

/**
 *
 * @author MATIAS
 */
public class Ctrl_Categoria {

    //Metodo para registrar categoria
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria value(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Guardar la Categoria" + e);
        }
        return respuesta;
    }
    
    
    //Metodo para consultar registro
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '"+ categoria +"'";
        Statement st;        
        
        try {
            Connection cn = conexion.conectar();
            st = cn.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al Consultar la Categoria" + e);
        }
        return respuesta;
    }
//Metodo para actualizar categoria
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(" update tb_categoria set descripcion=? where idcategoria='"+idCategoria+"'");
            consulta.setString(1, objeto.getDescripcion());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Actualizar la Categoria" + e);
        }
        return respuesta;
    }
    //Metodo para eliminar categoria
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("Delete from tb_categoria where idCategoria = '"+idCategoria+"'");
            consulta.executeUpdate();
            

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Eliminar la Categoria" + e);
        }
        return respuesta;
    }
}
