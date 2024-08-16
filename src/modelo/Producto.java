package modelo;

import java.math.BigDecimal;

/**
 *
 * @author MATIAS
 */
public class Producto {

   private int idProducto;
   private String nombre;
   private int catidad;
   private BigDecimal precio;  // Cambiado a BigDecimal
   private String descripcion;
   private int porcentajeIva;
   private int idCategoria;
   private int estado;

   public Producto(){
       this.idProducto = 0;
       this.nombre = "";
       this.catidad = 0;
       this.precio = BigDecimal.ZERO;  // Inicializado como BigDecimal
       this.descripcion = "";
       this.porcentajeIva = 0;
       this.idCategoria = 0;
       this.estado = 0;
   }

    public Producto(int idProducto, String nombre, int catidad, BigDecimal precio, String descripcion, int porcentajeIva, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.catidad = catidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIva = porcentajeIva;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
