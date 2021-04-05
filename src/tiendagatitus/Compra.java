package tiendagatitus;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


import java.util.Date;

@DatabaseTable

public class Compra {

    @DatabaseField (generatedId = true, allowGeneratedIdInsert=true)
    private Long codigocompra;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, columnName = "cedula_id")
    private Cliente cliente;

    @DatabaseField (canBeNull = false, foreign = true, foreignAutoRefresh = true, columnName = "codigo_id")
    private Producto producto;

    @DatabaseField (canBeNull = false)
    private Date fecha;

    @DatabaseField (canBeNull = false)
    private int cantidad;

    @DatabaseField (canBeNull = false)
    private boolean comprarealizada;

    public Compra(){}


    public Compra(Cliente cliente, Producto producto, Date fecha, int cantidad, boolean comprarealizada) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.comprarealizada = comprarealizada;
    }

    public Long getCodigocompra() {
        return codigocompra;
    }

    public void setCodigocompra(Long codigocompra) {
        this.codigocompra = codigocompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isComprarealizada() {
        return comprarealizada;
    }

    public void setComprarealizada(boolean comprarealizada) {
        this.comprarealizada = comprarealizada;
    }
}
