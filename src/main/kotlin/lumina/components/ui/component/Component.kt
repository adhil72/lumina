package lumina.components.ui.component

import lumina.Lumina
import lumina.components.attributes.Attributes
import lumina.components.events.Events
import lumina.components.ipc.WebViewIPC
import lumina.components.styles.Styles
import lumina.modals.Listener
import java.util.*

open class Component(val tagName: String) {
    private val childs = mutableListOf<Any>()
    private val attributesMap = mutableMapOf<String, String>()
    private val classNames by lazy { mutableListOf<String>() }
    private val stylesMap by lazy { HashMap<String, String>() }
    var rendered = false
    var id: String = "lumina_" + UUID.randomUUID().toString()
        set(value) {
            field = value
            setAttribute("id", value)
        }

    val styles = Styles(this)
    val attributes = Attributes(this)
    val events = Events(this)

    internal var onReady: (() -> Unit)? = null

    init {
        setAttribute("id", id)
    }

    internal fun setStyle(key: String, value: String) {
        stylesMap[key] = value
        if (rendered) Lumina.exec("document.getElementById('$id').style.setProperty('$key', '$value')")
    }

    private fun removeStyle(key: String) {
        stylesMap.remove(key)
        if (rendered) Lumina.exec("document.getElementById('$id').style.removeProperty('$key')")
    }

    open fun addChild(child: Component) {
        childs.add(child)
        if (rendered) Lumina.exec(
            """
    let elem = document.createElement('${child.tagName}');
    elem.innerHTML = `${child.render()}`;
    document.getElementById('$id').appendChild(elem);"""
        )
    }

    open fun addChildAtBeginning(child: Component) {
        childs.add(0, child)
        if (rendered) Lumina.exec(
            """
            document.getElementById('$id').innerHTML = `${child.render()}` + document.getElementById('$id').innerHTML
        """.trimIndent()
        )
    }

    fun addText(text: String) {
        childs.add(text)
        if (rendered) Lumina.exec("document.getElementById('$id').innerHTML += '$text'")
    }

    fun setText(text: String) {
        childs.add(text)
        if (rendered) Lumina.exec("document.getElementById('$id').innerHTML = '$text'")
    }

    fun setChild(child: Component) {
        childs.apply {
            clear()
            add(child)
        }
        if (rendered) Lumina.exec("document.getElementById('$id').innerHTML = `${child.render()}`")
    }

    fun setClassName(className: String) {
        if (!rendered) className.split(" ").forEach { classNames.add(it) }
        else {
            className.split(" ").forEach { Lumina.exec("document.getElementById('$id').className = `$it`") }
        }
    }

    fun addClassName(className: String) {
        if (!rendered) className.split(" ").forEach { classNames.add(it) }
        else className.split(" ").forEach { Lumina.exec("document.getElementById('$id').classList.add(`$it`)") }
    }

    fun removeClassName(className: String) {
        if (!rendered) className.split(" ").forEach { classNames.remove(it) }
        else className.split(" ").forEach { Lumina.exec("document.getElementById('$id').classList.remove(`$it`)") }
    }

    open fun render(): String {
        val attributesString = attributesMap.map { (key, value) -> "$key=\'$value\'" }.joinToString(" ")
        val classNamesString = classNames.joinToString(" ")
        val stylesString = stylesMap.map { (key, value) -> "$key: $value;" }.joinToString(" ")
        val childsString = childs.joinToString("") {
            if (it is Component) it.render()
            else it.toString()
        }
        rendered = true
        return "<$tagName class=\"$classNamesString\" $attributesString style=\"$stylesString\">$childsString</$tagName>"
    }

    fun addEvent(event: String, action: (data: Component?) -> Unit): Listener {
        setAttribute(event, "sendMessageToJava(\"$id::$event\",event)")
        val listener = Listener(id, event, action)
        WebViewIPC.listeners.add(listener)
        return listener
    }

    fun removeEvent(listener: Listener) {
        setAttribute(listener.event, "")
        WebViewIPC.listeners.remove(listener)
    }

    fun remove() {
        if (rendered) Lumina.exec("document.getElementById('$id').remove()")
        else throw IllegalStateException("Component not rendered")
    }

    private fun getProperty(property: String, map: Map<String, String>): String {
        return if (rendered) {
            Lumina.exec("document.getElementById('$id').$property") as String
        } else {
            map[property] ?: ""
        }
    }

    fun getStyle(style: String) = getProperty(style, stylesMap)

    fun getAttribute(attribute: String) = getProperty(attribute, attributesMap)

    fun setAttribute(s: String, value: String) {
        if (rendered) {
            Lumina.webView.engine.document.getElementById(id).setAttribute(s, value)
        } else {
            attributesMap[s] = value
        }
    }

    fun onRendered(callback: () -> Unit) {
        if (rendered) return callback()
        WebViewIPC.waitComponents.add(this)
        onReady = callback
        Lumina.exec("waitForElementById('$id')")
    }

    fun removeAttribute(s: String) {
        if (rendered) {
            Lumina.exec("document.getElementById('$id').removeAttribute('$s')")
        } else {
            attributesMap.remove(s)
        }
    }

    fun clearChildren() {
        childs.clear()
        if (rendered) Lumina.exec("document.getElementById('$id').innerHTML = ''")
    }

    override fun toString(): String {
        return Lumina.exec("document.getElementById('$id').outerHTML") as String
    }

    fun copyAttributes(elem: Component) {
        elem.attributesMap.forEach { (key, value) -> setAttribute(key, value) }
    }

    fun copyStyles(elem: Component) {
        elem.stylesMap.forEach { (key, value) -> setStyle(key, value) }
    }

}