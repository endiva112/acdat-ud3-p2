package org.rafandco.db;

import java.sql.*;

/**
 * Clase encargada de realizar operaciones de modificación sobre la base de datos.
 * Incluye inserción, actualización y eliminación de registros en la tabla tareas.
 * Esta clase utiliza una conexión JDBC recibida desde el exterior.
 */
public class Modification {
    /**
     * Conexión activa a la base de datos usada por los métodos de modificación.
     */
    private final Connection connection;

    /**
     * Constructor que recibe una conexión y la almacena para ser utilizada
     * por los métodos insert, update y delete.
     *
     * @param connection conexión JDBC existente.
     */
    public Modification(Connection connection) {
        this.connection = connection;
    }

    /**
     * Inserta una nueva tarea en la tabla tareas.
     *
     * @param titulo título de la tarea
     * @param descripcion descripción de la tarea
     * @param completada indica si la tarea está completada
     * @param prioridad nivel de prioridad de la tarea
     */
    public void insert(String titulo, String descripcion, boolean completada, int prioridad) {
        String sql = """
                    INSERT INTO tareas (titulo, descripcion, completada, prioridad)
                    VALUES (?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, descripcion);
            stmt.setBoolean(3, completada);
            stmt.setInt(4, prioridad);
            stmt.executeUpdate();
            System.out.println("Inserción exitosa");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Actualiza una tarea existente en la tabla tareas.
     *
     * @param id identificador de la tarea a modificar
     * @param titulo nuevo título
     * @param descripcion nueva descripción
     * @param completada nuevo estado de completada
     * @param prioridad nueva prioridad de la tarea
     */
    public void update(int id,
                       String titulo,
                       String descripcion,
                       boolean completada,
                       int prioridad) {
        String sql = """
            UPDATE tareas
            SET titulo = ?, descripcion = ?, completada = ?, prioridad = ?
            WHERE id = ?
        """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, descripcion);
            stmt.setBoolean(3, completada);
            stmt.setInt(4, prioridad);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Actualización exitosa");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Elimina una tarea de la tabla tareas según su identificador.
     *
     * @param id identificador de la tarea a eliminar
     */
    public void delete(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Eliminación exitosa");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}