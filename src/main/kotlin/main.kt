import spark.Spark.get

fun main(args: Array<String>) {
    get("/hello") { req, res ->
        val name: String? = req.queryParams("name")
        "Hello, ${name ?: "world"}!"
    }
}
