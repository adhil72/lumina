package lumina.utils

fun getResourceAsString(name: String): String {
    return object {}.javaClass.getResource("/$name")?.readText() ?: ""
}

fun getResourcePath(name: String): String {
    return object {}.javaClass.getResource("/$name")?.toExternalForm() ?: ""
}
