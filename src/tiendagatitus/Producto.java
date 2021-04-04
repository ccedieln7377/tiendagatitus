package tiendagatitus;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable

public class Producto {
    @DatabaseField(id = true)
    private int codigo;

    @DatabaseField(canBeNull = false)
    private String nombreproducto;

    @DatabaseField(canBeNull = false)
    private int cantidad;

    @DatabaseField(canBeNull = false)
    private double precio;

    public Producto(){}

    public Producto(int codigo, String nombreproducto, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    }
