package gecw.ace.lumina.ui.common

import gecw.ace.lumina.ui.Component

class Span(var text: String? = null) : Component("span") {
    init {
        text?.let { add(it) }
    }
}