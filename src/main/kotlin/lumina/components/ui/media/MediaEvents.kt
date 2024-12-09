package lumina.components.ui.media

import lumina.components.ui.component.Component
import lumina.modals.Listener

class MediaEvents(private val component: Component) {

    fun onAbort(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onabort", res)
    }

    fun onCanPlay(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("oncanplay", res)
    }

    fun onCanPlayThrough(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("oncanplaythrough", res)
    }

    fun onCueChange(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("oncuechange", res)
    }

    fun onDurationChange(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ondurationchange", res)
    }

    fun onEmptied(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onemptied", res)
    }

    fun onEnded(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onended", res)
    }

    fun onError(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onerror", res)
    }

    fun onLoadedData(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onloadeddata", res)
    }

    fun onLoadedMetadata(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onloadedmetadata", res)
    }

    fun onLoadStart(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onloadstart", res)
    }

    fun onPause(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onpause", res)
    }

    fun onPlay(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onplay", res)
    }

    fun onPlaying(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onplaying", res)
    }

    fun onProgress(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onprogress", res)
    }

    fun onRateChange(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onratechange", res)
    }

    fun onSeeked(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onseeked", res)
    }

    fun onSeeking(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onseeking", res)
    }

    fun onStalled(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onstalled", res)
    }

    fun onSuspend(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onsuspend", res)
    }

    fun onTimeUpdate(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("ontimeupdate", res)
    }

    fun onVolumeChange(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onvolumechange", res)
    }

    fun onWaiting(res: (data: Any?) -> Unit): Listener {
        return component.addEvent("onwaiting", res)
    }
}
