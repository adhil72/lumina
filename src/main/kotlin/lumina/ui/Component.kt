package gecw.ace.lumina.ui

import gecw.ace.lumina.utils.generateUniqueClass

open class Component(val name: String, var value: Boolean? = false) {
    val attributes = mutableMapOf<String, String>()
    val children = mutableListOf<Component>()
    val classList = mutableListOf<String>()
    val style = mutableMapOf<String, String>()
    var id: String = ""
    val uniqueClassName: String = generateUniqueClass()

    init {
        classList.add(uniqueClassName)
    }

    fun addClass(className: String) {
        classList.add(className)
    }

    fun removeClass(className: String) {
        classList.remove(className)
    }

    fun toggleClass(className: String) {
        if (classList.contains(className)) {
            classList.remove(className)
        } else {
            classList.add(className)
        }
    }

    fun setAttribute(key: String, value: String) {
        attributes[key] = value
    }

    fun removeAttribute(key: String) {
        attributes.remove(key)
    }

    fun setStyle(key: String, value: String) {
        style[key] = value
    }

    fun removeStyle(key: String) {
        style.remove(key)
    }

    fun add(child: Component) {
        children.add(child)
    }

    fun add(child: String) {
        children.add(Component(child, value = true))
    }

    fun remove(child: Component) {
        children.remove(child)
    }

    fun render(): String {
        if (value == true) return name
        val attributesString = attributes.map { (key, value) -> "$key=\"$value\"" }.joinToString(" ")
        val classListString = if (classList.isNotEmpty()) "class=\"${classList.joinToString(" ")}\"" else ""
        val styleString = if (style.isNotEmpty()) "style=\"${
            style.map { (key, value) -> "$key: $value" }.joinToString("; ")
        }\"" else ""
        val childrenString = children.joinToString("") { it.render() }
        return """<$name id="$id" $attributesString $classListString $styleString>$childrenString</$name>"""
    }
}