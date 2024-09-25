package lumina.ui

import lumina.Lumina
import lumina.utils.WebViewIPC
import java.util.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.nodes.Document

open class View(val name: String, val valueVar: Boolean = false) {
    private val childs = mutableListOf<View>()
    private val attributes = mutableMapOf<String, String>()
    private val classList = mutableListOf<String>()
    private val style = mutableMapOf<String, String>()
    val id = UUID.randomUUID().toString()
    var rendered = false

    fun render(): String {
        rendered = true
        if (valueVar) return name
        val classes = classList.joinToString(" ")
        val style = style.map { "${it.key}: ${it.value};" }.joinToString(" ")
        val styleAttr = if (style.isNotBlank()) "style=\"$style\"" else ""
        val attrs = attributes.map {
            if (it.key != "style") "${it.key}=\"${it.value}\""
            else styleAttr
        }.joinToString(" ")
        val childs = childs.joinToString("") { it.render() }
        return "<$name id=\"$id\" class=\"$classes\" $attrs>$childs</$name>"
    }

    open fun onRendered() {}

    fun cn(vararg classes: String) {
        if (rendered) Lumina.exec("""document.getElementById("$id").classList.add(`${classes.joinToString(" ")}`)""".trimIndent())
        classList.addAll(classes)
    }

    fun addView(view: View) {
        if (rendered) Lumina.exec("""document.getElementById("$id").innerHTML += `${view.render()}` """.trimIndent())
        childs.add(view)
    }

    fun addView(view: View, className: String) {
        view.cn(className)
        if (rendered) Lumina.exec("""document.getElementById("$id").innerHTML += `${view.render()}` """.trimIndent())
        childs.add(view)
    }

    fun addView(text: String) {
        if (rendered) Lumina.exec("""document.getElementById("$id").innerHTML += `${text}` """.trimIndent())
        childs.add(View(text, true))
    }

    fun setView(view: View) {
        if (rendered) Lumina.exec("""document.getElementById("$id").innerHTML = `${view.render()}` """.trimIndent())
        else {
            childs.clear()
            childs.add(view)
        }
    }

    fun removeView() {
        try {
            if (rendered) Lumina.exec("""document.getElementById("$id").remove()""".trimIndent())
        } catch (_: Exception) {
        }
    }

    fun clearChilds() {
        if (rendered) Lumina.exec("""document.getElementById("$id").innerHTML = """"".trimIndent())
        else childs.clear()
    }

    fun attr(key: String, value: String) {
        if (rendered) Lumina.exec("""document.getElementById("$id").setAttribute(`$key`, `$value`)""".trimIndent())
        else attributes[key] = value
    }

    fun style(key: String, value: String) {
        if (rendered) Lumina.exec("""document.getElementById("$id").style.`$key` = `$value`""".trimIndent())
        else style[key] = value
    }

    fun removeAttr(key: String) {
        if (rendered) Lumina.exec("""document.getElementById("$id").removeAttribute(`$key`)""".trimIndent())
        else attributes.remove(key)
    }

    fun removeStyle(key: String) {
        if (rendered) Lumina.exec("""document.getElementById("$id").style.removeProperty(`$key`)""".trimIndent())
        else style.remove(key)
    }

    open var value: String
        get() {
            return if (rendered) Lumina.exec("""document.getElementById("$id").value""".trimIndent())
            else attributes["value"] ?: ""
        }
        set(value) {
            if (rendered) Lumina.exec("""document.getElementById("$id").value = `$value`""".trimIndent())
            attributes["value"] = value
        }

    fun onClick(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onclick = (e) => clickHandler(e,'$id')")
        else attributes["onclick"] = "clickAndPreventPropagationHandler(event, '$id')"
        WebViewIPC.clickListeners[id] = res
    }

    fun onMouseEnter(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onmouseenter = () => mouseEnterHandler('$id')")
        else attributes["onmouseenter"] = "mouseEnterHandler('$id')"
        WebViewIPC.onMouseEnterListeners[id] = res
    }

    fun onMouseLeave(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onmouseleave = () => mouseLeaveHandler('$id')")
        else attributes["onmouseleave"] = "mouseLeaveHandler('$id')"
        WebViewIPC.onMouseLeaveListeners[id] = res
    }

    fun onChange(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onchange = () => changeHandler('$id')")
        else attributes["onchange"] = "changeHandler('$id')"
        WebViewIPC.onChangeListeners[id] = res
    }

    fun onInput(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').oninput = () => inputHandler('$id')")
        else attributes["oninput"] = "inputHandler('$id')"
        WebViewIPC.onInputListeners[id] = res
    }

    fun onScroll(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onscroll = () => scrollHandler('$id')")
        else attributes["onscroll"] = "scrollHandler('$id')"
        WebViewIPC.onScrollListeners[id] = res
    }

    fun onKeyPress(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onkeypress = () => keyPressHandler('$id')")
        else attributes["onkeypress"] = "keyPressHandler('$id')"
        WebViewIPC.onKeyPressListeners[id] = res
    }

    fun onKeyUp(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onkeyup = () => keyUpHandler('$id')")
        else attributes["onkeyup"] = "keyUpHandler('$id')"
        WebViewIPC.onKeyUpListeners[id] = res
    }

    fun onKeyDown(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onkeydown = () => keyDownHandler('$id')")
        else attributes["onkeydown"] = "keyDownHandler('$id')"
        WebViewIPC.onKeyDownListeners[id] = res
    }

    fun onContextMenu(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').oncontextmenu = () => contextMenuHandler('$id')")
        else attributes["oncontextmenu"] = "contextMenuHandler('$id')"
        WebViewIPC.onContextMenuListeners[id] = res
    }

    fun onDoubleClick(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondblclick = () => doubleClickHandler('$id')")
        else attributes["ondblclick"] = "doubleClickHandler('$id')"
        WebViewIPC.onDoubleClickListeners[id] = res
    }

    fun onFocus(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onfocus = () => focusHandler('$id')")
        else attributes["onfocus"] = "focusHandler('$id')"
        WebViewIPC.onFocusListeners[id] = res
    }

    fun onBlur(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').onblur = () => blurHandler('$id')")
        else attributes["onblur"] = "blurHandler('$id')"
        WebViewIPC.onBlurListeners[id] = res
    }

    fun onDrag(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondrag = () => dragHandler('$id')")
        else attributes["ondrag"] = "dragHandler('$id')"
        WebViewIPC.onDragListeners[id] = res
    }

    fun onDragEnd(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondragend = () => dragEndHandler('$id')")
        else attributes["ondragend"] = "dragEndHandler('$id')"
        WebViewIPC.onDragEndListeners[id] = res
    }

    fun onDragEnter(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondragenter = () => dragEnterHandler('$id')")
        else attributes["ondragenter"] = "dragEnterHandler('$id')"
        WebViewIPC.onDragEnterListeners[id] = res
    }

    fun onDragExit(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondragexit = () => dragExitHandler('$id')")
        else attributes["ondragexit"] = "dragExitHandler('$id')"
        WebViewIPC.onDragExitListeners[id] = res
    }

    fun onDragLeave(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondragleave = () => dragLeaveHandler('$id')")
        else attributes["ondragleave"] = "dragLeaveHandler('$id')"
        WebViewIPC.onDragLeaveListeners[id] = res
    }

    fun onDragOver(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondragover = () => dragOverHandler('$id')")
        else attributes["ondragover"] = "dragOverHandler('$id')"
        WebViewIPC.onDragOverListeners[id] = res
    }

    fun onDragStart(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondragstart = () => dragStartHandler('$id')")
        else attributes["ondragstart"] = "dragStartHandler('$id')"
        WebViewIPC.onDragStartListeners[id] = res
    }

    fun onDrop(res: () -> Unit) {
        if (rendered) Lumina.exec("document.getElementById('$id').ondrop = () => dropHandler('$id')")
        else attributes["ondrop"] = "dropHandler('$id')"
        WebViewIPC.onDropListeners[id] = res
    }

    fun rcn(className: String) {
        if (rendered) Lumina.exec("document.getElementById('$id').classList.remove('$className')")
        else classList.remove(className)
    }

    fun removeClass(className: String) {
        if (rendered) Lumina.exec("document.getElementById('$id').classList.remove('$className')")
        else classList.remove(className)
    }
}

class DuplicateIdException(id: String) : Exception("Duplicate ID found: $id")

fun convertHtmlToView(html: String): View {
    val document: Document = Jsoup.parse(html)
    val idMap = mutableSetOf<String>()
    return convertElementToView(document.body(), idMap)
}

private fun convertElementToView(element: Element, idMap: MutableSet<String>): View {
    val view = View(element.tagName())
    val id = element.attr("id")
    if (id.isNotBlank()) {
        if (idMap.contains(id)) {
            throw DuplicateIdException(id)
        }
        idMap.add(id)
        view.attr("id", id)
    }
    val classes = element.classNames().toTypedArray()
    if (classes.isNotEmpty()) {
        view.cn(*classes)
    }
    for (attribute in element.attributes()) {
        if (attribute.key != "id" && attribute.key != "class") {
            view.attr(attribute.key, attribute.value)
        }
    }
    for (child in element.children()) {
        val childView = convertElementToView(child, idMap)
        view.addView(childView)
    }
    if (element.ownText().isNotBlank()) {
        view.addView(View(element.ownText(), true))
    }
    return view
}
