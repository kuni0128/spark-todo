package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    get("/tasks", { req, res ->
        listOf(
            Task(1, "英単語を勉強する", false),
            Task(2, "ジムに行く", true)
        )
    }, objectMapper::writeValueAsString)
}
