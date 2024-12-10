package lumina.components.ui.form

import lumina.components.ui.component.Component

open class Input(name: String = "input") : Component(name) {

    var type: String = "text"
        set(value) {
            field = value
            setAttribute("type", value)
        }

    var name: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("name", value)
            else removeAttribute("name")
        }

    var value: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("value", value)
            else removeAttribute("value")
        }

    var placeholder: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("placeholder", value)
            else removeAttribute("placeholder")
        }

    var readonly: Boolean = false
        set(value) {
            field = value
            if (value) setAttribute("readonly", "")
            else removeAttribute("readonly")
        }

    var disabled: Boolean = false
        set(value) {
            field = value
            if (value) setAttribute("disabled", "")
            else removeAttribute("disabled")
        }

    var required: Boolean = false
        set(value) {
            field = value
            if (value) setAttribute("required", "")
            else removeAttribute("required")
        }

    var maxLength: Int? = null
        set(value) {
            field = value
            if (value != null) setAttribute("maxlength", value.toString())
            else removeAttribute("maxlength")
        }

    var minLength: Int? = null
        set(value) {
            field = value
            if (value != null) setAttribute("minlength", value.toString())
            else removeAttribute("minlength")
        }

    var size: Int? = null
        set(value) {
            field = value
            if (value != null) setAttribute("size", value.toString())
            else removeAttribute("size")
        }

    var autocomplete: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("autocomplete", value)
            else removeAttribute("autocomplete")
        }

    var pattern: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("pattern", value)
            else removeAttribute("pattern")
        }
}
