package lumina.ui.common

import lumina.Lumina
import lumina.ui.View

class Span(text:String=""):View("span") {
    var text: String
        get(){
            return if (rendered) Lumina.exec("document.getElementById('$id').innerText")
            else ""
        }
        set(value) {
            if (rendered) Lumina.exec("document.getElementById('$id').innerText = '$value'")
            else addView(value)
        }

    init {
        this.text = text
    }
}