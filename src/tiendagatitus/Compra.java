package tiendagatitus;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


import java.util.Date;

@DatabaseTable

public class Compra {

    @DatabaseField (generatedId = true, allowGeneratedIdInsert=true)
    private Long codigocompra;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, columnName = "cedula_id")
    private Cliente cedula;

    @DatabaseField (canBeNull = false, foreign = true, foreignAutoRefresh = true, columnName = "codigo_id")
    private Producto codigo;

    @DatabaseField (canBeNull = false)
    private Date fecha;

    @DatabaseField (canBeNull = false)
    private int cantidad;

    @DatabaseField (canBeNull = false)
    private boolean comprarealizada;

    public Compra(){}


    public Compra(Cliente cedula, Producto codigo, Date fecha, int cantidad, boolean comprarealizada) {
        this.cedula = cedula;
        this.codigo = codigo;
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

    public Cliente getCedula() {
        return cedula;
    }

    public void setCedula(Cliente cedula) {
        this.cedula = cedula;
    }

    public Producto getCodigo() {
        return codigo;
    }

    public void setCodigo(Producto codigo) {
        this.codigo = codigo;
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
