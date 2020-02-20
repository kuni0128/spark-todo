package todolist.controllers

import spark.Route
import todolist.Task

class TaskController {
    fun index(): Route = Route { req, res ->
        listOf(
            Task(1, "英単語を勉強する", false),
            Task(2, "ジムに行く", true)
        )
    }
}
