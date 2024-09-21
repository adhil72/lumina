package lumina.ui.common

import lumina.Lumina
import lumina.ui.View


class Image : View("img") {
    var src: String = ""
        get() {
            if (rendered) return Lumina.exec("document.getElementById(\"$id\").src")
            return field
        }
        set(value) {
            attr("src", value)
            field = value
        }
    var alt: String = ""
        get() {
            if (rendered) return Lumina.exec("document.getElementById(\"$id\").alt")
            return field
        }
        set(value) {
            if (rendered) Lumina.exec("document.getElementById(\"$id\").alt = \"$value\"")
            field = value
        }
}