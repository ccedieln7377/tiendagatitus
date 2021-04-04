package tiendagatitus;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable
public class Cliente {
    @DatabaseField (id = true)
    private long cedula;

    @DatabaseField(canBeNull = false)
    private String nombrecliente;

    @DatabaseField(canBeNull = false)
    private long telefono;

    @DatabaseField(canBeNull = false)
    private String direccion;

    public Cliente(){}

    public Cliente(long cedula, String nombrecliente, long telefono, String direccion) {
        this.cedula = cedula;
        this.nombrecliente = nombrecliente;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
