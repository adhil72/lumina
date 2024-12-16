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

    fun onAnimationStart(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("animationstart", res)
    }

    fun onAnimationEnd(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("animationend", res)
    }

    fun onAnimationIteration(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("animationiteration", res)
    }

    fun onTransitionEnd(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("transitionend", res)
    }

    fun onTouchStart(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("touchstart", res)
    }

    fun onTouchMove(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("touchmove", res)
    }

    fun onTouchEnd(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("touchend", res)
    }

    fun onTouchCancel(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("touchcancel", res)
    }

    fun onPointerDown(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointerdown", res)
    }

    fun onPointerMove(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointermove", res)
    }

    fun onPointerUp(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointerup", res)
    }

    fun onPointerCancel(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointercancel", res)
    }

    fun onPointerEnter(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointerenter", res)
    }

    fun onPointerLeave(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointerleave", res)
    }

    fun onPointerOver(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointerover", res)
    }

    fun onPointerOut(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("pointerout", res)
    }

    fun onGotPointerCapture(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("gotpointercapture", res)
    }

    fun onLostPointerCapture(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("lostpointercapture", res)
    }

    fun onCopy(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("oncopy", res)
    }

    fun onCut(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("oncut", res)
    }

    fun onPaste(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onpaste", res)
    }

    fun onAbort(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onabort", res)
    }

    fun onCanPlay(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("oncanplay", res)
    }

    fun onCanPlayThrough(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("oncanplaythrough", res)
    }

    fun onDurationChange(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ondurationchange", res)
    }

    fun onEmptied(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onemptied", res)
    }

    fun onEncrypted(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onencrypted", res)
    }

    fun onEnded(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onended", res)
    }

    fun onLoadedData(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onloadeddata", res)
    }

    fun onLoadedMetadata(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onloadedmetadata", res)
    }

    fun onLoadStart(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onloadstart", res)
    }

    fun onPause(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onpause", res)
    }

    fun onPlay(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onplay", res)
    }

    fun onPlaying(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onplaying", res)
    }

    fun onProgress(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onprogress", res)
    }

    fun onRateChange(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onratechange", res)
    }

    fun onSeeked(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onseeked", res)
    }

    fun onSeeking(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onseeking", res)
    }

    fun onStalled(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onstalled", res)
    }

    fun onSuspend(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onsuspend", res)
    }

    fun onTimeUpdate(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("ontimeupdate", res)
    }

    fun onVolumeChange(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onvolumechange", res)
    }

    fun onWaiting(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onwaiting", res)
    }

    fun onFocusIn(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onfocusin", res)
    }

    fun onFocusOut(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onfocusout", res)
    }

    fun onFullscreenChange(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onfullscreenchange", res)
    }

    fun onFullscreenError(res: (data: Component?) -> Unit): Listener {
        return component.addEvent("onfullscreenerror", res)
    }
}