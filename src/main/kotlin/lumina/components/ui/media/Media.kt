package lumina.components.ui.media

import lumina.components.ui.component.Component

open class Media(name: String) : Component(name) {
    val mediaEvents = MediaEvents(this)

    var autoPlay = false
        set(value) {
            field = value
            if (value) setAttribute("autoplay", "") else removeAttribute("autoplay")
        }

    var controls = false
        set(value) {
            field = value
            if (value) setAttribute("controls", "") else removeAttribute("controls")
        }

    var crossOrigin: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("crossorigin", value) else removeAttribute("crossorigin")
        }

    var loop = false
        set(value) {
            field = value
            if (value) setAttribute("loop", "") else removeAttribute("loop")
        }

    var muted = false
        set(value) {
            field = value
            if (value) setAttribute("muted", "") else removeAttribute("muted")
        }

    var preload: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("preload", value) else removeAttribute("preload")
        }

    var src: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("src", value) else removeAttribute("src")
        }

    var poster: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("poster", value) else removeAttribute("poster")
        }

    var width: Int? = null
        set(value) {
            field = value
            if (value != null) setAttribute("width", value.toString()) else removeAttribute("width")
        }

    var height: Int? = null
        set(value) {
            field = value
            if (value != null) setAttribute("height", value.toString()) else removeAttribute("height")
        }

    var playsInline = false
        set(value) {
            field = value
            if (value) setAttribute("playsinline", "") else removeAttribute("playsinline")
        }
}
