package lumina.ui.common

import lumina.Lumina
import lumina.ui.View

open class Input : View("input") {
    var type: String = "text"
        get() {
            if (rendered) return Lumina.exec("document.getElementById('$id').type")
            return field
        }
        set(value) {
            if (rendered) Lumina.exec("document.getElementById('$id').type='$value'")
            field = value
        }

    var placeholder: String = ""
        get() {
            if (rendered) return Lumina.exec("document.getElementById('$id').placeholder")
            return field
        }
        set(value) {
            if (rendered) Lumina.exec("document.getElementById('$id').placeholder='$value'")
            field = value
        }
}