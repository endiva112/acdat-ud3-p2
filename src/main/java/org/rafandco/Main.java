package org.rafandco;

import org.rafandco.db.Definition;
import org.rafandco.db.SingletonConnection;
import org.rafandco.dao.TareaDAO;
import org.rafandco.model.Tarea;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {










        // Crear la conexión
        Connection connection = SingletonConnection.getConnection();

        //Obtener fecha actual
        LocalDate fechaActual = java.time.LocalDate.now();

        // Sentencias DDL (definition)
        Definition definition = new Definition(connection);
        //definition.eliminarTablaTareas();
        definition.crearTablaTareas();

        // Uso del DAO
        TareaDAO tareaDAO = new TareaDAO(connection);
        Tarea t1 = new Tarea("Comprar café", "Ir al supermercado y comprar leche", fechaActual);
        tareaDAO.insertar(t1);

        Tarea t2 = tareaDAO.buscarPorId(2);
        System.out.println(t2.toString());

        for (Tarea tarea : tareaDAO.listarTodas()) {
            System.out.println(tarea);
        }

        // Cerrar la conexión
        SingletonConnection.closeConnection();
    }
}
