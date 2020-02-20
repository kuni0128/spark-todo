package todolist.controllers

import spark.Route
import todolist.repositories.TaskRepository

class TaskController(private val taskRepository: TaskRepository) {
    fun index(): Route = Route { req, res ->
        taskRepository.findAll()
    }
}
