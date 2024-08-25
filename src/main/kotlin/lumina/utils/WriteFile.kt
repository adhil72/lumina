package gecw.ace.lumina.utils

import java.io.File

class WriteFile(var path: String, var content: String) {
    init {
        File(path).writeText(content)
    }
}