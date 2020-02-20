package todolist.models

data class Task(
    val id: Long,
    val content: String,
    val done: Boolean
)
