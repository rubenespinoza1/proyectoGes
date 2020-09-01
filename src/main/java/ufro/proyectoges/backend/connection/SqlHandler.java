package ufro.proyectoges.backend.connection;

import javax.swing.*;
import java.sql.*;

/**
 * Clase encargada de manejar la conexion a la base de datos SQL
 * @author Roald
 */
public class SqlHandler {

    private Connection connection;
    private Statement statement;

    /**
     * Constructor de la clase SqlHandler
     * @param ip La direccion IP de la base de datos a la cual se pretende conectar
     * @param databasename El nombre de la base de datos que aloja los datos a los que se quiere acceder
     */
    public SqlHandler(String ip, String databasename) {
        try {

            attempToConnect(ip, databasename);
            createStatement();
        } catch (SQLException e) {
            if (connection == null) {
                JOptionPane.showMessageDialog(null, "Failed to stablish connection to database");
            }

        } catch (ClassNotFoundException nf) {
            System.out.println("Wrong Class name");
        }

    }

    /**
     * Metodo encargado de ejecutar la orden SQL para "insertar" en una tabla dada, "valores" especificados dentro de unas "columnas" en particular
     * @param table_name Nombre de la tabla a la cual se ingresaran los valores
     * @param column_names Nombre de la(s) columna(s) a la(s) cual(es) se insertara los valores
     * @param values Valores que seran insertados
     */
    public void insertInto(String table_name, String column_names, String values) {

        try {
            statement.executeUpdate("INSERT INTO " + table_name + " " + column_names + " VALUES " + values + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void updateWhere(String table_name, String set, String where){
        try{
            statement.executeUpdate("UPDATE " + table_name + " SET " + set + " WHERE " + where);
            
        }catch(SQLException e){
            System.out.println("Query ejecutada");
            System.out.println("query: " + "UPDATE " + table_name + " SET " + set + " WHERE " + where);
        }
    }

    /**
     * Metodo para consultar a la basde datos, que "seleccione" datos de "columna(s)" de "desde" una(s) "tabla(s)" en particular
     * @param selected_columns "Columnas" a las cuales se les extraeran los datos
     * @param table_name nombre de la "tabla" donde se buscaran los datos 
     * @return Devuelve un conjunto de datos encapsulado en un "ResultSet"
     */
    public ResultSet selectFrom(String selected_columns, String table_name) {
        ResultSet queryResult = null;
        try {
            queryResult = statement.executeQuery("SELECT " + selected_columns + " FROM " + table_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryResult;
    }

    /**
     * Metodo para consultar a la basde datos, que "seleccione" datos de "columna(s)" de "desde" una(s) "tabla(s)" en particular "en donde" cierta "columna" posea un "valor" en especifico
     * @param selected_columns Este parametro contiene las columnas de las cuales se pretende obtener datos
     * @param table_name Este parametro contiene el nombre de la tabla a la cual se pretende hacer la consulta
     * @param column_to_find Este parametro contiene el nombre de la columna donde se buscara el valor de filtro
     * @param value_expected Este parametro contiene el valor de filtro que se utilizara
     * @return Retorna un conjunto de datos encapsulado en un "ResultSet"
     */
    public ResultSet selectFromWhere(String selected_columns, String table_name, String column_to_find, String value_expected) {
        ResultSet queryResult = null;
        try {
            queryResult = statement.executeQuery("SELECT " + selected_columns + " FROM " + table_name + " WHERE " + column_to_find + "=" + value_expected + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryResult;
    }

    /**
     * Este Metodo sirve para obtener el atributo "statement"
     * @return Retorna el atributo "statement", de tipo Statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * Este metodo sirve para intentar conectar conectar con la base de datos, para acceder a una tabla en especifico
     * @param ip La direccion IP de la base de datos 
     * @param tableName Nombre de la tabla a la cual se desea acceder
     * @throws java.sql.SQLException El tipo de error que arroja en caso de que exista un problema de conexion con la base de datos
     * @throws ClassNotFoundException El tipo de error que arroja en caso de que exista un problema con el driver encargado de establecer la conexion con la basde de datos
     */
    private void attempToConnect(String ip, String tableName) throws java.sql.SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + tableName, "root", "");
    }

    /**
     * Este metodo genera una conexion con la base de datos para poder generar una consulta
     * @throws java.sql.SQLException El tipo de error que arroja en caso de que exista un error de conexion a la base de datos
     */
    private void createStatement() throws java.sql.SQLException {
        statement = connection.createStatement();
    }

    /**
     * Este metodo sirve para crear una nueva tabla en la base de datos
     * @param tableName El nombre de la nueva tabla a generar
     * @throws SQLException El tipo de error que se genera en caso de que exista un error de conexion con la base de datos
     */
    private void createIfDoesNotExistTable(String tableName) throws SQLException {

        statement.executeUpdate("CREATE TABLE " + tableName);
    }

}
