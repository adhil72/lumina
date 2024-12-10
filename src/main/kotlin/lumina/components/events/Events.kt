package lumina.components.events

import lumina.components.ui.component.Component
import lumina.modals.Listener

class Events(private val component: Component) {
    fun onAfterprint(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onafterprint", res)
    }


    fun onBeforeprint(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onbeforeprint", res)
    }


    fun onBeforeunload(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onbeforeunload", res)
    }


    fun onError(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onerror", res)
    }


    fun onHashchange(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onhashchange", res)
    }


    fun onLoad(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onload", res)
    }


    fun onMessage(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onmessage", res)
    }


    fun onOffline(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onoffline", res)
    }


    fun onOnline(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ononline", res)
    }


    fun onPagehide(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onpagehide", res)
    }


    fun onPageshow(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onpageshow", res)
    }


    fun onPopstate(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onpopstate", res)
    }


    fun onResize(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onresize", res)
    }


    fun onStorage(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onstorage", res)
    }


    fun onUnload(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onunload", res)
    }


    fun onBlur(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onblur", res)
    }


    fun onChange(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onchange", res)
    }


    fun onFocus(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onfocus", res)
    }


    fun onInput(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("oninput", res)
    }


    fun onInvalid(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("oninvalid", res)
    }


    fun onReset(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onreset", res)
    }


    fun onSelect(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onselect", res)
    }


    fun onSearch(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onsearch", res)
    }


    fun onSubmit(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onsubmit", res)
    }


    fun onClick(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onclick", res)
    }


    fun onDblclick(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondblclick", res)
    }


    fun onContextmenu(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("oncontextmenu", res)
    }


    fun onDrag(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondrag", res)
    }


    fun onDragend(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondragend", res)
    }


    fun onDragenter(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondragenter", res)
    }


    fun onDragleave(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondragleave", res)
    }


    fun onDragover(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondragover", res)
    }


    fun onDragstart(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondragstart", res)
    }


    fun onDrop(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondrop", res)
    }


    fun onMousedown(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onmousedown", res)
    }


    fun onMousemove(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onmousemove", res)
    }


    fun onMouseout(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onmouseout", res)
    }


    fun onMouseover(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onmouseover", res)
    }


    fun onMouseup(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onmouseup", res)
    }


    fun onMousewheel(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onmousewheel", res)
    }


    fun onScroll(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onscroll", res)
    }


    fun onShow(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onshow", res)
    }


    fun onToggle(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ontoggle", res)
    }


    fun onWheel(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onwheel", res)
    }


    fun onKeydown(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onkeydown", res)
    }


    fun onKeypress(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onkeypress", res)
    }


    fun onKeyup(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onkeyup", res)
    }

    fun onMouseEnter(res: (data: Component?) -> Unit) {
        component.addEvent("onmouseenter", res)
    }

    fun onMouseLeave(res: (data: Component?) -> Unit) {
        component.addEvent("onmouseleave", res)
    }

    fun clearEvent(listener: Listener) {
        component.removeEvent(listener)
    }
}