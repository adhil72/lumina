package gecw.ace.lumina.ui.common

import gecw.ace.lumina.Lumina
import gecw.ace.lumina.ui.View

class Span:View("span") {
    var text:String
        get(){
            return if (rendered) Lumina.exec("return document.getElementById('$id').innerText")
            else ""
        }
        set(value) {
            if (rendered) Lumina.exec("document.getElementById('$id').innerText = '$value'")
            else addView(Text(value))
        }
}