package tiendagatitus;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class CrearBD {
    public static void main(String[] args) throws SQLException, IOException {
        //conectarse con el driver de sqlite
        JdbcPooledConnectionSource con =
                new JdbcPooledConnectionSource("jdbc:sqlite:tiendagatitus.db");

        TableUtils.createTableIfNotExists(con, Producto.class);
        System.out.println("Tabla Producto creada con éxito");

        TableUtils.createTableIfNotExists(con, Cliente.class);
        System.out.println("Tabla Cliente creada con éxito");

        TableUtils.createTableIfNotExists(con, Compra.class);
        System.out.println("Tabla Compra creada con éxito");

        con.close();
    }
}
