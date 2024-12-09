package lumina.components.events

import lumina.components.ui.component.Component
import lumina.modals.Listener

class Events(private val component: Component) {
    fun onAfterprint(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onafterprint", res)
    }


    fun onBeforeprint(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onbeforeprint", res)
    }


    fun onBeforeunload(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onbeforeunload", res)
    }


    fun onError(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onerror", res)
    }


    fun onHashchange(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onhashchange", res)
    }


    fun onLoad(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onload", res)
    }


    fun onMessage(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onmessage", res)
    }


    fun onOffline(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onoffline", res)
    }


    fun onOnline(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ononline", res)
    }


    fun onPagehide(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onpagehide", res)
    }


    fun onPageshow(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onpageshow", res)
    }


    fun onPopstate(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onpopstate", res)
    }


    fun onResize(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onresize", res)
    }


    fun onStorage(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onstorage", res)
    }


    fun onUnload(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onunload", res)
    }


    fun onBlur(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onblur", res)
    }


    fun onChange(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onchange", res)
    }


    fun onFocus(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onfocus", res)
    }


    fun onInput(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("oninput", res)
    }


    fun onInvalid(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("oninvalid", res)
    }


    fun onReset(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onreset", res)
    }


    fun onSelect(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onselect", res)
    }


    fun onSearch(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onsearch", res)
    }


    fun onSubmit(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onsubmit", res)
    }


    fun onClick(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onclick", res)
    }


    fun onDblclick(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondblclick", res)
    }


    fun onContextmenu(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("oncontextmenu", res)
    }


    fun onDrag(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondrag", res)
    }


    fun onDragend(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondragend", res)
    }


    fun onDragenter(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondragenter", res)
    }


    fun onDragleave(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondragleave", res)
    }


    fun onDragover(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondragover", res)
    }


    fun onDragstart(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondragstart", res)
    }


    fun onDrop(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondrop", res)
    }


    fun onMousedown(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onmousedown", res)
    }


    fun onMousemove(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onmousemove", res)
    }


    fun onMouseout(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onmouseout", res)
    }


    fun onMouseover(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onmouseover", res)
    }


    fun onMouseup(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onmouseup", res)
    }


    fun onMousewheel(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onmousewheel", res)
    }


    fun onScroll(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onscroll", res)
    }


    fun onShow(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onshow", res)
    }


    fun onToggle(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ontoggle", res)
    }


    fun onWheel(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onwheel", res)
    }


    fun onKeydown(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onkeydown", res)
    }


    fun onKeypress(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onkeypress", res)
    }


    fun onKeyup(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onkeyup", res)
    }

    fun onMouseEnter(res: (data: Any?) -> Unit) {
        component.addEvent("onmouseenter", res)
    }

    fun onMouseLeave(res: (data: Any?) -> Unit) {
        component.addEvent("onmouseleave", res)
    }

    fun clearEvent(listener: Listener) {
        component.removeEvent(listener)
    }
}