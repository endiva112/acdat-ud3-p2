package org.rafandco;

import org.rafandco.db.Definition;
import org.rafandco.db.SingletonConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Crear la conexión
        Connection connection = SingletonConnection.getConnection();

        // Secuencia de acciones de la app
        // Sentencias DDL (definition)
        Definition definition = new Definition(connection);
        definition.crearTablaTareas();


        // Cerrar la conexión
        SingletonConnection.closeConnection();
    }
}
