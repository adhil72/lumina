package lumina.components.ui.iframe

import lumina.components.ui.component.Component

open class Iframe : Component("iframe") {

    var src: String = ""
        set(value) {
            field = value
            setAttribute("src", value)
        }

    var width: String = "300"
        set(value) {
            field = value
            setAttribute("width", value)
        }

    var height: String = "150"
        set(value) {
            field = value
            setAttribute("height", value)
        }

    var frameBorder: String = "0"
        set(value) {
            field = value
            setAttribute("frameborder", value)
        }

    var allowFullScreen: Boolean = false
        set(value) {
            field = value
            if (value) setAttribute("allowfullscreen", "")
            else removeAttribute("allowfullscreen")
        }

    var loading: String = "auto"
        set(value) {
            field = value
            setAttribute("loading", value)
        }

    var sandbox: String = ""
        set(value) {
            field = value
            setAttribute("sandbox", value)
        }

    var referrerPolicy: String = "no-referrer"
        set(value) {
            field = value
            setAttribute("referrerpolicy", value)
        }

    var iFrameName: String = ""
        set(value) {
            field = value
            setAttribute("name", value)
        }

    var allow: String = ""
        set(value) {
            field = value
            setAttribute("allow", value)
        }

    init {
        // Set default attributes if necessary
        width = "300"
        height = "150"
    }
}
