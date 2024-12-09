package lumina.utils

fun getResourceAsString(name: String): String {
    return object {}.javaClass.getResource("/$name")?.readText() ?: throw IllegalArgumentException("Resource not found: $name")
}

fun getResourcePath(name: String): String {
    return object {}.javaClass.getResource("/$name")?.toExternalForm() ?: throw IllegalArgumentException("Resource not found: $name")
}
