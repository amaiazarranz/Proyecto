package sqlite;

import usuarios.Estudiante;
import usuarios.Trabajador;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectData
{
    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private static Connection connect()
    {
        // SQLite connection string
        String name = "UniversidadDeusto4.db";
        String url = "jdbc:sqlite:" + name;
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public static ArrayList<Trabajador> selectAllTrabajadores()
    {

        ArrayList <Trabajador> diccionarioTrabajadores= new ArrayList <>();
        String sql = "SELECT dni, nombre, apellido1, apellido2, user, password, email, iban, tipopersona, salario  FROM trabajador";

        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql) //nueva clase. Es otro set de results. Es como un arraylist
                )
        {

            // loop through the result set
            while (rs.next()) //mientras tenga más contenido
            {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String user = rs.getString("user");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String iban = rs.getString("iban");
                String tipopersona = rs.getString("tipopersona");
                double salario = rs.getDouble("salario");

                Trabajador trabajador = new Trabajador(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona, salario);
                diccionarioTrabajadores.add(trabajador);

            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return diccionarioTrabajadores;

    }

    public static ArrayList<Estudiante> selectAllEstudiantes()
    {

        ArrayList <Estudiante> diccionarioEstudiantes= new ArrayList <>();
        String sql = "SELECT dni, nombre, apellido1, apellido2, user, password, email, iban, tipopersona, " +
                "notamedia, faltaleve, faltagrave  FROM estudiante";

        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql) //nueva clase. Es otro set de results. Es como un arraylist
                )
        {

            // loop through the result set
            while (rs.next()) //mientras tenga más contenido
            {

                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String user = rs.getString("user");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String iban = rs.getString("iban");
                String tipopersona = rs.getString("tipopersona");
                double notamedia = rs.getDouble("notamedia");
                int faltaleve=rs.getInt("faltaleve");
                int faltagrave=rs.getInt("faltagrave");

                Estudiante estudiante = new Estudiante(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona, notamedia, faltaleve, faltagrave);
                diccionarioEstudiantes.add(estudiante);

            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return diccionarioEstudiantes;

    }
    
    public static void actualizarFaltaLeve(String user, int faltaleve) throws SQLException{

    	String sql = "UPDATE estudiante SET faltaleve = ? WHERE user = ?";
		
		try
		(
		   Connection conn = connect();
		   PreparedStatement pstmt = conn.prepareStatement(sql) //
		)
		
		{
			pstmt.setInt(1, faltaleve);
            pstmt.setString(2, user);

            // update
            pstmt.executeUpdate();
            
		
		}
		catch (SQLException e)
		{
		System.out.println(e.getMessage());
		}
	}
    
    public static void actualizarFaltaGrave(String user, int faltagrave) throws SQLException{

    	String sql = "UPDATE estudiante SET faltagrave = ? WHERE user = ?";
		
		try
		(
		   Connection conn = connect();
		   PreparedStatement pstmt = conn.prepareStatement(sql) //
		)
		
		{
			pstmt.setInt(1, faltagrave);
            pstmt.setString(2, user);

            // update
            pstmt.executeUpdate();
            
		
		}
		catch (SQLException e)
		{
		System.out.println(e.getMessage());
		}
	}
    
    public static void delete(String user)
    {
        String sql = "DELETE FROM estudiante WHERE user = ?";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            // set the corresponding param
            pstmt.setString(1, user);

            // execute the delete statement
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    


}

