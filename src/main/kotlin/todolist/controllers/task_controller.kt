package todolist.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import spark.Route
import spark.Spark.halt
import todolist.TaskCreateRequest
import todolist.repositories.TaskRepository

class TaskController(
    private val objectMapper: ObjectMapper,
    private val taskRepository: TaskRepository
) {
    fun index(): Route = Route { req, res ->
        taskRepository.findAll()
    }

    fun create(): Route = Route { req, res ->
        val request: TaskCreateRequest =
            try {
                objectMapper.readValue(req.bodyAsBytes(), TaskCreateRequest::class.java)
            } catch (e: Exception) {
                throw halt(400)
            }
        val task = taskRepository.create(request.content)
        res.status(201)
        task
    }
}
