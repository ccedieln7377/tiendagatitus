package tiendagatitus;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.logger.LocalLog;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws SQLException, IOException {
        System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");

        String tecla = null;

        Scanner teclado = new Scanner(System.in);

        JdbcPooledConnectionSource con =
                new JdbcPooledConnectionSource("jdbc:sqlite:tiendagatitus.db");

        Dao<Producto, Integer> tablaProductos =
                DaoManager.createDao(con, Producto.class);

        Dao<Cliente, Long> tablaCliente =
                DaoManager.createDao(con, Cliente.class);

        Dao<Compra, Long> tablaCompra =
                DaoManager.createDao(con, Compra.class);

        int opcion = 0;
        int codigo;
        String nombreproducto;
        int cantidad;
        double precio;
        long cedula;
        String nombre;
        long telefono;
        String direccion;

        do {
            System.out.println("1. Crear cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Ver lista de clientes");
            System.out.println("4. Crear un producto");
            System.out.println("5. Editar nombre de un producto");
            System.out.println("6. Editar precio de un producto");
            System.out.println("7. Ver catálogo");
            System.out.println("8. Aumentar inventario");
            System.out.println("9. Eliminar producto");
            System.out.println("10. Crear compra");
            System.out.println("11. Finalizar compra");
            System.out.println("12. Ver compras de un cliente");
            System.out.print("Entre su opcion => ");
            opcion = teclado.nextInt();

            switch (opcion){

                case 1://Crear cliente

                    System.out.print("Cédula: ");
                    cedula = teclado.nextLong();

                    Cliente nuevocl = tablaCliente.queryForId(cedula);
                    if (nuevocl == null){
                        teclado.nextLine();
                        System.out.println("Nombre del cliente: ");
                        nombre = teclado.nextLine();
                        System.out.print("Teléfono: ");
                        telefono = teclado.nextLong();
                        teclado.nextLine();
                        System.out.print("Dirección: ");
                        direccion = teclado.nextLine();
                        Cliente cl = new Cliente(cedula, nombre, telefono, direccion);
                        System.out.println("Cliente " + nombre + " ha sido creado");
                        tablaCliente.create(cl);
                    }
                    else {
                        System.out.println("El cliente ya existe");
                    }

                    break;

                case 2://Eliminar cliente

                    System.out.println("Cédula del cliente a eliminar: ");
                    cedula = teclado.nextLong();
                    Cliente elimcl = tablaCliente.queryForId(cedula);
                    if (elimcl != null){
                    teclado.nextLine();
                    tablaCliente.deleteById(cedula);
                    System.out.println("Cliente ha sido eliminado");
                    }
                    else {
                        System.out.println("El cliente no existe");
                    }


                    break;

                case 3://Lista clientes
                    for (Cliente cliente : tablaCliente){
                        System.out.println(cliente.getCedula() + " - " + cliente.getNombrecliente() + " - " + cliente.getTelefono() + " - " + cliente.getDireccion());
                    }
                    break;


                case 4://Crear producto
                    System.out.print("Código ");
                    codigo = teclado.nextInt();
                    Producto nuevoprod = tablaProductos.queryForId(codigo);
                    if (nuevoprod == null){
                        teclado.nextLine();
                        System.out.println("Nombre del producto: ");
                        nombreproducto = teclado.nextLine();
                        System.out.print("Cantidad: ");
                        cantidad = teclado.nextInt();
                        System.out.print("Precio: ");
                        precio = teclado.nextDouble();
                        Producto p = new Producto(codigo, nombreproducto, cantidad, precio);
                        System.out.println(nombreproducto + " ha sido creado como nuevo producto");
                        tablaProductos.create(p);
                    }
                    else {
                        System.out.println("El producto ya existe");
                    }

                    break;

                case 5://Editar nombre producto

                    System.out.println("Código de producto para cambiar el nombre ");
                    codigo = teclado.nextInt();
                    Producto prnom = tablaProductos.queryForId(codigo);
                    if (prnom != null){

                    System.out.print("Ingresa el nuevo nombre: ");
                    nombreproducto = teclado.nextLine();
                    prnom.setNombreproducto(teclado.nextLine());
                    System.out.println("Ahora el nombre del producto es " + prnom.getNombreproducto());
                    tablaProductos.update(prnom);

                    }
                    else{
                        System.out.println("El código del producto no existe");}
                    break;


                case 6://Editar precio producto
                    System.out.println("Código de producto para cambiar el precio ");
                    codigo = teclado.nextInt();
                    Producto prprecio = tablaProductos.queryForId(codigo);
                    if (prprecio != null){
                        System.out.print("Ingresa el nuevo precio: ");
                        precio = teclado.nextDouble();
                        prprecio.setPrecio(precio);
                        System.out.println("Ahora el precio del producto es " + prprecio.getPrecio() );
                        tablaProductos.update(prprecio);

                    }
                    else{
                        System.out.println("El código del producto no existe");}
                    break;


                case 7://Catálogo
                    for (Producto prod : tablaProductos){
                        System.out.println(prod.getCodigo() + " - " + prod.getNombreproducto() + " - " + prod.getCantidad() + " - " + prod.getPrecio());
                    }
                    break;


                case 8:
                    System.out.println("Código de producto para incrementar inventario ");
                    codigo = teclado.nextInt();
                    Producto pr = tablaProductos.queryForId(codigo);
                    if (pr != null){
                        System.out.print("¿Cuántos productos agregarás al inventario? ");
                        cantidad = teclado.nextInt();
                        pr.setCantidad(pr.getCantidad() + cantidad);
                        System.out.println("Ahora el inventario de "+ pr.getNombreproducto() + " es de " + pr.getCantidad());
                        tablaProductos.update(pr);

                    }
                    else{
                        System.out.println("El código del producto no existe");}
                    break;

                case 9://Eliminar producto
                    System.out.println("Código del producto a eliminar");
                    codigo = teclado.nextInt();
                    Producto prel = tablaProductos.queryForId(codigo);
                    if (prel != null){
                        tablaProductos.deleteById(codigo);
                        System.out.println("Producto eliminado");
                    }
                    else{
                        System.out.println("El código del producto no existe");}

                    break;

                case 10://Crear compra
                    System.out.print("Cédula: ");
                    cedula = teclado.nextLong();
                    teclado.nextLine();

                    Cliente buscado = tablaCliente.queryForId(cedula);

                    if (buscado != null){
                        for (Producto prod : tablaProductos){
                            System.out.println(prod.getCodigo() + " - " + prod.getNombreproducto() + " - " + prod.getCantidad() + " - " + prod.getPrecio());
                        }
                        System.out.println("\nBasado en la tabla de inventario que muestra código, nombre, cantidad disponible y precio del producto, por favor ingrese el código del producto que desea comprar:\n");

                        codigo = teclado.nextInt();
                        Producto comprado = tablaProductos.queryForId(codigo);
                        if (comprado != null){
                            System.out.println("Cantidad de productos: ");
                            cantidad = teclado.nextInt();

                            Compra comp = new Compra(buscado, comprado, new Date(), cantidad, false);
                            tablaCompra.create(comp);
                        }
                        else{
                            System.out.println("El código del producto no existe");}
                    }

                    else{
                        System.out.println("El cliente no existe");
                        }



                    break;

                case 11://Finalizar compra

                    System.out.print("Cédula: ");
                    cedula = teclado.nextLong();
                    teclado.nextLine();

                    Cliente comprador = tablaCliente.queryForId(cedula);
                    List<Compra> comprados = tablaCompra.queryForEq("cedula_id", comprador);

                    double subtotalcompra = 0;

                    for (int i = 0; i < comprados.size(); i++){
                        Compra total = comprados.get(i);
                        if (! total.isComprarealizada()) {
                            Producto subtotal = total.getCodigo();
                            subtotalcompra = subtotalcompra + subtotal.getPrecio() * total.getCantidad();

                            subtotal.setCantidad(subtotal.getCantidad() - total.getCantidad());
                            tablaProductos.update(subtotal);

                            total.setComprarealizada(true);
                            tablaCompra.update(total);
                        }

                    }

                    System.out.println("El valor total es " + subtotalcompra);

                    break;


                case 12: // Ver compras de un cliente
                    System.out.print("Cédula del cliente: ");
                    cedula = teclado.nextLong();
                    teclado.nextLine();

                    for (Compra compracliente : tablaCompra){
                        if (compracliente.isComprarealizada())
                            System.out.println(compracliente.getCedula() + " - " + compracliente.getCodigo() + " - " + compracliente.getFecha());
                        else
                            System.out.println("El cliente seleccionado no ha realizado compras");


                    }


                    break;

            }

            System.out.print("\nSi desea seguir utilizando el programa, presione S. De lo contrario, presione N.\n");
            tecla = new Scanner(System.in).nextLine();

            } while(tecla.equals("s") || tecla.equals("S"));

        con.close();
    }

}
