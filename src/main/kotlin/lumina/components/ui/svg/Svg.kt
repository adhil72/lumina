package lumina.components.ui.svg

import lumina.components.ui.component.Component

open class Svg : Component("svg") {

    var viewBox: String = ""
        set(value) {
            field = value
            setAttribute("viewBox", value)
        }

    var xmlns: String = "http://www.w3.org/2000/svg"
        set(value) {
            field = value
            setAttribute("xmlns", value)
        }

    var fill: String = "none"
        set(value) {
            field = value
            setAttribute("fill", value)
        }

    var stroke: String = ""
        set(value) {
            field = value
            setAttribute("stroke", value)
        }

    var strokeWidth: String = "1"
        set(value) {
            field = value
            setAttribute("stroke-width", value)
        }

    var preserveAspectRatio: String = "xMidYMid meet"
        set(value) {
            field = value
            setAttribute("preserveAspectRatio", value)
        }

    init {
        xmlns = "http://www.w3.org/2000/svg" // Set default xmlns
    }

    fun addPath(d: String, pathAttributes: Map<String, String> = emptyMap()): Svg {
        val attributesString = pathAttributes.map { (key, value) -> "$key=\"$value\"" }.joinToString(" ")
        addChild(object : Component("path") {
            init {
                setAttribute("d", d)
                pathAttributes.forEach { (key, value) -> setAttribute(key, value) }
            }

            override fun render(): String {
                return "<path d=\"$d\" $attributesString></path>"
            }
        })
        return this
    }

    fun addCircle(cx: String, cy: String, r: String, circleAttributes: Map<String, String> = emptyMap()): Svg {
        val attributesString = circleAttributes.map { (key, value) -> "$key=\"$value\"" }.joinToString(" ")
        addChild(object : Component("circle") {
            init {
                setAttribute("cx", cx)
                setAttribute("cy", cy)
                setAttribute("r", r)
                circleAttributes.forEach { (key, value) -> setAttribute(key, value) }
            }

            override fun render(): String {
                return "<circle cx=\"$cx\" cy=\"$cy\" r=\"$r\" $attributesString></circle>"
            }
        })
        return this
    }

    fun addRect(
        x: String,
        y: String,
        width: String,
        height: String,
        rectAttributes: Map<String, String> = emptyMap()
    ): Svg {
        val attributesString = rectAttributes.map { (key, value) -> "$key=\"$value\"" }.joinToString(" ")
        addChild(object : Component("rect") {
            init {
                setAttribute("x", x)
                setAttribute("y", y)
                setAttribute("width", width)
                setAttribute("height", height)
                rectAttributes.forEach { (key, value) -> setAttribute(key, value) }
            }

            override fun render(): String {
                return "<rect x=\"$x\" y=\"$y\" width=\"$width\" height=\"$height\" $attributesString></rect>"
            }
        })
        return this
    }

    fun addLine(x1: String, y1: String, x2: String, y2: String, lineAttributes: Map<String, String> = emptyMap()): Svg {
        val attributesString = lineAttributes.map { (key, value) -> "$key=\"$value\"" }.joinToString(" ")
        addChild(object : Component("line") {
            init {
                setAttribute("x1", x1)
                setAttribute("y1", y1)
                setAttribute("x2", x2)
                setAttribute("y2", y2)
                lineAttributes.forEach { (key, value) -> setAttribute(key, value) }
            }

            override fun render(): String {
                return "<line x1=\"$x1\" y1=\"$y1\" x2=\"$x2\" y2=\"$y2\" $attributesString></line>"
            }
        })
        return this
    }
}
