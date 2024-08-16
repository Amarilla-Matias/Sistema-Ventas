
package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Producto;

/**
 *
 * @author MATIAS
 */
public class Ctrl_Producto {
     //Metodo para registrar producto
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_productos values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getCatidad());
            consulta.setBigDecimal(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeIva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Guardar el Producto" + e);
        }
        return respuesta;
    }
    
    
    //Metodo para consultar registro
    public boolean existeProducto(String producto) {
        boolean respuesta = false;
        String sql = "select nombre from tb_productos where descripcion = '"+ producto +"'";
        Statement st;        
        
        try {
            Connection cn = conexion.conectar();
            st = cn.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al Consultar la Producto" + e);
        }
        return respuesta;
    }
}
