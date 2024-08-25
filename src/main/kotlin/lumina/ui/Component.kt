package gecw.ace.lumina.ui

import gecw.ace.lumina.utils.WebViewIPC

open class Component(val name: String, var value: Boolean? = false) {
    val attributes = mutableMapOf<String, String>()
    val children = mutableListOf<Component>()
    val classList = mutableListOf<String>()
    val style = mutableMapOf<String, String>()
    var id: String = ""

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

    fun cn(string: String) {
        classList.add(string)
    }

    fun onClick(res: () -> Unit) {
        attributes["onclick"] = "clickHandler('$id')"
        WebViewIPC.clickListeners[id] = res
    }

    fun onFormSubmit(res: () -> Unit) {
        attributes["onsubmit"] = "formSubmitHandler('$id')"
        WebViewIPC.formSubmitListeners[id] = res
    }

    fun onMouseEnter(res: () -> Unit) {
        attributes["onmouseenter"] = "mouseEnterHandler('$id')"
        WebViewIPC.onMouseEnterListeners[id] = res
    }

    fun onMouseLeave(res: () -> Unit) {
        attributes["onmouseleave"] = "mouseLeaveHandler('$id')"
        WebViewIPC.onMouseLeaveListeners[id] = res
    }

    fun onChange(res: () -> Unit) {
        attributes["onchange"] = "changeHandler('$id')"
        WebViewIPC.onChangeListeners[id] = res
    }

    fun onInput(res: () -> Unit) {
        attributes["oninput"] = "inputHandler('$id')"
        WebViewIPC.onInputListeners[id] = res
    }

    fun onScroll(res: () -> Unit) {
        attributes["onscroll"] = "scrollHandler('$id')"
        WebViewIPC.onScrollListeners[id] = res
    }

    fun onKeyPress(res: () -> Unit) {
        attributes["onkeypress"] = "keyPressHandler('$id')"
        WebViewIPC.onKeyPressListeners[id] = res
    }

    fun onKeyUp(res: () -> Unit) {
        attributes["onkeyup"] = "keyUpHandler('$id')"
        WebViewIPC.onKeyUpListeners[id] = res
    }

    fun onKeyDown(res: () -> Unit) {
        attributes["onkeydown"] = "keyDownHandler('$id')"
        WebViewIPC.onKeyDownListeners[id] = res
    }

    fun onContextMenu(res: () -> Unit) {
        attributes["oncontextmenu"] = "contextMenuHandler('$id')"
        WebViewIPC.onContextMenuListeners[id] = res
    }

    fun onDoubleClick(res: () -> Unit) {
        attributes["ondblclick"] = "doubleClickHandler('$id')"
        WebViewIPC.onDoubleClickListeners[id] = res
    }

    fun onDrag(res: () -> Unit) {
        attributes["ondrag"] = "dragHandler('$id')"
        WebViewIPC.onDragListeners[id] = res
    }

    fun onDragEnd(res: () -> Unit) {
        attributes["ondragend"] = "dragEndHandler('$id')"
        WebViewIPC.onDragEndListeners[id] = res
    }

    fun onDragEnter(res: () -> Unit) {
        attributes["ondragenter"] = "dragEnterHandler('$id')"
        WebViewIPC.onDragEnterListeners[id] = res
    }

    fun onDragExit(res: () -> Unit) {
        attributes["ondragexit"] = "dragExitHandler('$id')"
        WebViewIPC.onDragExitListeners[id] = res
    }

    fun onDragLeave(res: () -> Unit) {
        attributes["ondragleave"] = "dragLeaveHandler('$id')"
        WebViewIPC.onDragLeaveListeners[id] = res
    }

    fun onDragOver(res: () -> Unit) {
        attributes["ondragover"] = "dragOverHandler('$id')"
        WebViewIPC.onDragOverListeners[id] = res
    }

    fun onDragStart(res: () -> Unit) {
        attributes["ondragstart"] = "dragStartHandler('$id')"
        WebViewIPC.onDragStartListeners[id] = res
    }

    fun onDrop(res: () -> Unit) {
        attributes["ondrop"] = "dropHandler('$id')"
        WebViewIPC.onDropListeners[id] = res
    }

    fun onFocus(res: () -> Unit) {
        attributes["onfocus"] = "focusHandler('$id')"
        WebViewIPC.onFocusListeners[id] = res
    }

    fun onBlur(res: () -> Unit) {
        attributes["onblur"] = "blurHandler('$id')"
        WebViewIPC.onBlurListeners[id] = res
    }
}
