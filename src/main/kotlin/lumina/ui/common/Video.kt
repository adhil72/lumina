package lumina.ui.common

import lumina.Lumina
import lumina.ui.View


class Video : View("video") {
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
            attr("alt", value)
            field = value
        }

    var autoplay: Boolean = false
        get() {
            if (rendered) return Lumina.exec("document.getElementById(\"$id\").autoplay").toBoolean()
            return field
        }
        set(value) {
            attr("autoplay", value.toString())
            field = value
        }

    var loop: Boolean = false
        get() {
            if (rendered) return Lumina.exec("document.getElementById(\"$id\").loop").toBoolean()
            return field
        }
        set(value) {
            attr("loop", value.toString())
            field = value
        }

    var controls: Boolean = false
        get() {
            if (rendered) return Lumina.exec("document.getElementById(\"$id\").controls").toBoolean()
            return field
        }
        set(value) {
            attr("controls", value.toString())
            field = value
        }
}