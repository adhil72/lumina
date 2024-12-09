package lumina.components.ui.form

import lumina.components.ui.component.Component

class Form(name: String = "form") : Component(name) {

    var action: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("action", value)
            else removeAttribute("action")
        }

    var method: String = "get"
        set(value) {
            field = value
            setAttribute("method", value)
        }

    var enctype: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("enctype", value)
            else removeAttribute("enctype")
        }

    var target: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("target", value)
            else removeAttribute("target")
        }

    var autocomplete: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("autocomplete", value)
            else removeAttribute("autocomplete")
        }

    var novalidate: Boolean = false
        set(value) {
            field = value
            if (value) setAttribute("novalidate", "")
            else removeAttribute("novalidate")
        }
}