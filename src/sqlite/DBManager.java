package sqlite;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.Icon;

import usuarios.Estudiante;
import usuarios.Trabajador;

/**
 * Es el gestor de la base de datos
 * @author Alumno Amaia y Olatz
 *
 */


public class DBManager {

    private static Connection conn;
    private static String BDname;
    private final static String URL = "jdbc:sqlite:";

    
    /**
     * Es el constructor
     * @param BDname el nombre de la base de datos
     */
    
	    public DBManager(String BDname)
	    {
	        DBManager.BDname = URL + BDname;
	
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
	            DBManager.createLink();

	            // Step 3 - Create table
	            DBManager.createNewTableEstudiante();
	            DBManager.createNewTableTrabajador();
	            
	            DBManager.insertTrabajador("72608821Y", "Olatz", "Gonzalez" , "Santiago" , "program.profesor1", "Profesor1" , "program.profesor1@gmail.com", "ES0000000000000000000000", "profesor", 2000.0);
	            DBManager.insertTrabajador("72608821R", "Leire", "Gonzalez" , "Santiago" , "program.secretario1", "Secretario1" , "program.secretario1@gmail.com", "ES0000000000000000000003", "secretario", 2000.0);
	            DBManager.insertEstudiante("82476952I", "Jon", "Zabaleta", "Peña", "program.estudiante1", "Estudiante1", "program.estudiante1@gmail.com","ES0000000000000000000001", "estudiante", 9.8, 0,0);
	            DBManager.insertEstudiante("82476952P", "Aritz", "Eraun", "Peña", "program.estudiante2", "Estudiante2", "program.estudiante2@gmail.com","ES0000000000000000000002", "estudiante", 9.7, 0,0);
	            DBManager.insertEstudiante("82476952T", "Ane", "Bollo", "Peña", "program.estudiante3", "Estudiante3", "program.estudiante3@gmail.com","ES0000000000000000000008", "estudiante", 9.6, 0,0);
	            
	            // Last step - Close connection
	            DBManager.closeLink();
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
	
	    public static void createLink() throws SQLException
	    {
	        try
	        {
	            conn = DriverManager.getConnection(BDname); //si no fuese static en conn y bdname antes this.
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
	
	        public static void createNewTableEstudiante() throws SQLException
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
	                        Statement stmt = conn.createStatement()
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
	
	    public static void createNewTableTrabajador() throws SQLException
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
	                        Statement stmt = conn.createStatement()
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
	                        //Connection conn= connect();
	                		PreparedStatement pstmt = conn.prepareStatement(sql) 		
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
	                        //Connection conn=connect();
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
	     * Es la clase que devuelve el array de estudiantes de la base de datos
	     * @return diccionarioTrabajadores devuelve todos los trabajadores
	     */
	    
	    public static ArrayList<Trabajador> selectAllTrabajadores()
	    {

	        ArrayList <Trabajador> diccionarioTrabajadores= new ArrayList <>();
	        String sql = "SELECT dni, nombre, apellido1, apellido2, user, password, email, iban, tipopersona, salario  FROM trabajador";

	        try
	                (
	                        Connection conn = connect(); //hay que poner esto porque al principio no hay un link a la bd
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
	    
	    /**
	     * Seleccionar todos los estudiantes
	     * @return la lista de todos los estudiantes
	     */

	    public static ArrayList<Estudiante> selectAllEstudiantes()
	    {

	        ArrayList <Estudiante> diccionarioEstudiantes= new ArrayList <>();
	        String sql = "SELECT dni, nombre, apellido1, apellido2, user, password, email, iban, tipopersona, " +
	                "notamedia, faltaleve, faltagrave  FROM estudiante";

	        try
	                (
	                	
	        		
	        				//DBManager.createLink();
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
	    
	    /**
	     * Actualiza el valor de las faltas leves
	     * @param user el usuario
	     * @param faltaleve el número de faltas leves
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	    
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
	    
	    /**
	     * Actualiza el valor de las faltas graves
	     * @param user el usuario
	     * @param faltagrave el número de faltas graves
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	    
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
	    
	    /**
	     * actualiza la nota media
	     * @param user usuario
	     * @param notamedia notamedia
	     * @throws SQLException sqlexcepcion
	     */
	    
	    public static void actualizarNotaMedia(String user, int notamedia) throws SQLException{

	    	String sql = "UPDATE estudiante SET notamedia = ? WHERE user = ?";
			
			try
			(
			   Connection conn = connect();
			   PreparedStatement pstmt = conn.prepareStatement(sql) 
			)
			
			{
				pstmt.setInt(1, notamedia);
	            pstmt.setString(2, user);

	            pstmt.executeUpdate();
	            
			
			}
			catch (SQLException e)
			{
			System.out.println(e.getMessage());
			}
		}
	    
	    /**
	     * elimina el estudiante
	     * @param user el usuario
	     */
	    
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
	    
	    /**
	     * Sirve para realizar la conexión
	     * @return
	     */
	
	    private static Connection connect() //tiene que ser estático
	    {
	        // SQLite connection string
	    	String name = "UniversidadDeusto4.db";
	    	//String url= BDname;
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
	     * Devuelve la lista de estudiantes de la base de datos creada para junit
	     * @return la lista de estudiantes
	     */
	    
	    public static ArrayList<Estudiante> selectAllEstudiantesJunit()
	    {

	        ArrayList <Estudiante> diccionarioEstudiantes= new ArrayList <>();
	        String sql = "SELECT dni, nombre, apellido1, apellido2, user, password, email, iban, tipopersona, " +
	                "notamedia, faltaleve, faltagrave  FROM estudiante";

	        try
	                (
	                        Connection conn = connectJunit();
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
	    
	    /**
	     * Devuelve la lista de trabajadores de la base de datos creada para junit
	     * @return la lista de trabajadores
	     */
	    
	    public static ArrayList<Trabajador> selectAllTrabajadoresJunit()
	    {

	        ArrayList <Trabajador> diccionarioTrabajadores= new ArrayList <>();
	        String sql = "SELECT dni, nombre, apellido1, apellido2, user, password, email, iban, tipopersona, salario  FROM trabajador";

	        try
	                (
	                        Connection conn = connectJunit();
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
	    
	    /**
	     * Realiza la conexion con la base de datos creada para junit
	     * @return la conexion
	     */
	    
	    private static Connection connectJunit() //tiene que ser estático
	    {
	        // SQLite connection string
	    	String name = "UniversidadDeusto6.db";
	    	//String url= BDname;
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
	     * Sirve para cerrar la conexión
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	    
	    public static void closeLink()throws SQLException{
	
	        try{
	
	            if(conn != null){
	
	                conn.close();
	            }
	        }
	        catch (SQLException ex){
	
	            System.out.println("BadAss error closing connection" +ex.getMessage());
	
	        }
	
	
	    }    
	    
	    public static void setNameBD(){
	    	
	    	DBManager.BDname = URL + BDname;
	    	
	    }
	    

}
