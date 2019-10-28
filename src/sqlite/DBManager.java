package sqlite;

import java.sql.*;

/**
 * Es el gestor de la base de datos
 * @author Alumno Amaia y Olatz
 *
 */

public class DBManager {

    private Connection conn;
    private String BDname;
    private final String URL = "jdbc:sqlite:";

    
    /**
     * Es el constructor
     * @param BDname el nombre de la base de datos
     */
	    public DBManager(String BDname)
	    {
	        this.BDname = this.URL + BDname;
	
	    }
	    
	    /**
	     * Lanza el gestor
	     * @param args args
	     */
	    
	    public static void main (String [] args)
	    {
	        DBManager myDBManager;
	  

	        try
	        {
	            // Step 1 - Instantiate the manager
	            myDBManager= new DBManager("UniversidadDeusto4.db");

	            // Step 2 - Create database
	            myDBManager.createLink();

	            // Step 3 - Create table
	            myDBManager.createNewTableEstudiante();
	            myDBManager.createNewTableTrabajador();
	            
	            insertTrabajador("72608821Y", "Olatz", "Gonzalez" , "Santiago" , "program.profesor1", "Profesor1" , "program.profesor1@gmail.com", "ES0000000000000000000000", "profesor", 2000.0);
	            
	   
	            
	            // Last step - Close connection
	            myDBManager.closeLink();
	        }
	        catch (SQLException e)
	        {
	            System.out.println("Process terminated with errors");
	        }
	        finally
	        {
	            System.out.println("Process terminated successfully");
	        }
	    }
	    

	/**
	 * Sirve para crear la conexión con la base de datos
	 * @throws SQLException si no se puede realizar salta la excepción sqlexception
	 */
	
	    public void createLink() throws SQLException
	    {
	        try
	        {
	            this.conn = DriverManager.getConnection(this.BDname);
	        }
	        catch (SQLException e)
	        {
	            System.out.println("BadAss error creating connection. " + e.getMessage());
	        }
	    }
	    
	    /**
	     * Sirve para crear una nueva tabla de estudiante
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	
	        public void createNewTableEstudiante() throws SQLException
	    {
	
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS estudiante (\n"
	                + "    dni text PRIMARY KEY,\n"
	                + "    nombre text NOT NULL,\n"
	                + "    apellido1 text NOT NULL,\n"
	                + "    apellido2 text NOT NULL,\n"
	                + "    user text NOT NULL,\n"
	                + "    password text NOT NULL,\n"
	                + "    email text NOT NULL,\n"
	                + "    iban text NOT NULL,\n"
	                + "    tipopersona text NOT NULL,\n"
	                + "    notamedia real NOT NULL,\n"
	                + "    faltaleve integer NOT NULL,\n"
	                + "    faltagrave integer NOT NULL\n"
	                + ");";
	
	        try
	                (
	                        Statement stmt = this.conn.createStatement()
	                )
	        {
	            //create a table
	
	            stmt.execute(sql);
	
	        } catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table" + e.getMessage());
	            System.out.println(sql);
	        }
	    }
	        
        /**
         * Sirve para crear una nueva tabla de trabajador
         * @throws SQLException si no se puede realizar salta la excepción sqlexception
         */
	
	    public void createNewTableTrabajador() throws SQLException
	    {
	
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS trabajador (\n"
	                + "    dni text PRIMARY KEY,\n"
	                + "    nombre text NOT NULL,\n"
	                + "    apellido1 text NOT NULL,\n"
	                + "    apellido2 text NOT NULL,\n"
	                + "    user text NOT NULL,\n"
	                + "    password text NOT NULL,\n"
	                + "    email text NOT NULL,\n"
	                + "    iban text NOT NULL,\n"
	                + "    tipopersona text NOT NULL,\n"
	                + "    salario real NOT NULL check(salario>=0)\n"
	                + ");";
	
	        try
	                (
	                        Statement stmt = this.conn.createStatement()
	                )
	        {
	
	            boolean result=stmt.execute(sql);
	
	        } catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table "+e.getMessage());
	            System.out.println(sql);
	        }
	    }
	    
	    /**
	     * Sirve para insertar un estudiante
	     * @param dni el dni del estudiante
	     * @param nombre el nombre del estudiante
	     * @param apellido1 el primer apellido del estudiante
	     * @param apellido2 el segundo apellido del estudiante
	     * @param user el user del estudiante
	     * @param password el password del estudiante
	     * @param email el correo del estudiante
	     * @param iban el iban del estudiante
	     * @param tipopersona sirve para saber que es un estudiante
	     * @param notamedia la nota media del estudiante
	     * @param faltaleve las faltas leves que tiene el estudiante
	     * @param faltagrave las faltas graves que tiene el estudiante
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	
	    public static void insertEstudiante(String dni, String nombre, String apellido1, String apellido2,
	                                 String user, String password, String email, String iban, String tipopersona,
	                                 double notamedia, int faltaleve, int faltagrave) throws SQLException{
	
	        String sql = "INSERT INTO estudiante(dni,nombre, apellido1, apellido2, user, password, email," +
	                "iban, tipopersona, notamedia, faltaleve, faltagrave) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	        try
	                (
	                        Connection conn = connect();
	                        PreparedStatement pstmt = conn.prepareStatement(sql) //
	                )
	        {
	            pstmt.setString(1, dni);
	            pstmt.setString(2, nombre);
	            pstmt.setString(3, apellido1);
	            pstmt.setString(4, apellido2);
	            pstmt.setString(5, user);
	            pstmt.setString(6, password);
	            pstmt.setString(7, email);
	            pstmt.setString(8, iban);
	            pstmt.setString(9, tipopersona);
	            pstmt.setDouble(10, notamedia);
	            pstmt.setInt(11, faltaleve);
	            pstmt.setInt(12, faltagrave);
	
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    /**
	     * Sirve par insertar un trabajador
	     * @param dni el dni del trabajador
	     * @param nombre el nombre del trabajador
	     * @param apellido1 el primer apellido del trabajador
	     * @param apellido2 el segundo apellido del trabajador
	     * @param user el user del trabajador
	     * @param password el password del trabajador
	     * @param email el correo del trabjador
	     * @param iban el iban del trabajador
	     * @param tipopersona demuestra que es un trabajador: un profesor secretari@
	     * @param salario el salrio del trabajador
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	
	
	    public static void insertTrabajador(String dni, String nombre, String apellido1, String apellido2,
	                                        String user, String password, String email, String iban, String tipopersona,
	                                        double salario) throws SQLException{
	
	        String sql = "INSERT INTO trabajador(dni,nombre, apellido1, apellido2, user, password, email," +
	                "iban, tipopersona, salario) VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	        try
	                (
	                        Connection conn = connect();
	                        PreparedStatement pstmt = conn.prepareStatement(sql) //
	                )
	        {
	            pstmt.setString(1, dni);
	            pstmt.setString(2, nombre);
	            pstmt.setString(3, apellido1);
	            pstmt.setString(4, apellido2);
	            pstmt.setString(5, user);
	            pstmt.setString(6, password);
	            pstmt.setString(7, email);
	            pstmt.setString(8, iban);
	            pstmt.setString(9, tipopersona);
	            pstmt.setDouble(10, salario);
	
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    /**
	     * Sirve para cerrar la conexión
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	    
	    public void closeLink()throws SQLException{
	
	        try{
	
	            if(this.conn != null){
	
	                this.conn.close();
	            }
	        }
	        catch (SQLException ex){
	
	            System.out.println("BadAss error closing connection" +ex.getMessage());
	
	        }
	
	
	    }
	    
	    /**
	     * Sirve para realizar la conexión
	     * @return
	     */
	
	
	
	    private static Connection connect() //tiene que ser estático
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

	    
    

}
