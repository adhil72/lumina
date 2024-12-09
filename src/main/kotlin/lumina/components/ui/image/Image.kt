package lumina.components.ui.image

import lumina.components.ui.component.Component

class Image : Component("img") {
    var src: String = ""
        set(value) {
            field = value
            setAttribute("src", value)
        }
    var alt: String = ""
        set(value) {
            field = value
            setAttribute("alt", value)
        }
    var width: String = ""
        set(value) {
            field = value
            setAttribute("width", value)
        }
    var height: String = ""
        set(value) {
            field = value
            setAttribute("height", value)
        }

    var srcset: String = ""
        set(value) {
            field = value
            setAttribute("srcset", value)
        }

    var sizes: String = ""
        set(value) {
            field = value
            setAttribute("sizes", value)
        }

    var loading: String = ""
        set(value) {
            field = value
            setAttribute("loading", value)
        }

    var decoding: String = ""
        set(value) {
            field = value
            setAttribute("decoding", value)
        }

    var isMap: String = ""
        set(value) {
            field = value
            setAttribute("ismap", value)
        }

    var useMap: String = ""
        set(value) {
            field = value
            setAttribute("usemap", value)
        }
}