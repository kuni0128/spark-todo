package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import todolist.controllers.TaskController
import spark.Spark.get

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskController = TaskController()

    get("/tasks", taskController.index(), jsonTransformer)
}
