import java.io.File


fun mapFolder(basePath: String, callback: (msg: String) -> Unit={}): Map<String, String> {
    val map = mutableMapOf<String, String>()
    val files = File(basePath).walk().filter { it.isFile }.toList()
    files.forEach {
        callback(it.path)
        map[it.path] = it.readText()
    }
    return map
}


fun readDir(path: String, callback:(msg:String)->Unit = {}): List<String> {
    val files = File(path).listFiles()?.map {
        callback(it.absolutePath.toString())
        it.absoluteFile.toString()
    }?.toList()
    return files ?: emptyList()
}
