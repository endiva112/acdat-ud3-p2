package org.rafandco.dao;

import org.rafandco.model.Tarea;
import java.util.List;

//No debe leer por teclado ni imprimir por pantalla; solo gestiona datos.
public class TareaDAO {
    public void insertar(Tarea tarea) {
        // INSERT INTO tareas (...)
    }

    public void actualizar(Tarea tarea) {
        // UPDATE tareas SET ... WHERE id = ?
    }

    public void eliminar(int id) {
        // DELETE FROM tareas WHERE id = ?
    }

    public Tarea buscarPorId(int id) {
        // SELECT ... FROM tareas WHERE id = ?
        return  null;
    }

    public List<Tarea> listarTodas() {
        // SELECT ... FROM tareas
        return  null;
    }
}


