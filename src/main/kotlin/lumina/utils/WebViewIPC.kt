package gecw.ace.lumina.utils

import com.google.gson.Gson
import javafx.scene.web.WebEngine
import netscape.javascript.JSObject

class WebViewIPC(private val webEngine: WebEngine) {

    init {
        setupIPC()
    }

    companion object {
        val clickListeners = HashMap<String, () -> Unit>()
        val formSubmitListeners = HashMap<String, () -> Unit>()
        val onMouseEnterListeners = HashMap<String, () -> Unit>()
        val onMouseLeaveListeners = HashMap<String, () -> Unit>()
        val onChangeListeners = HashMap<String, () -> Unit>()
        val onInputListeners = HashMap<String, () -> Unit>()
        val onScrollListeners = HashMap<String, () -> Unit>()
        val onKeyPressListeners = HashMap<String, () -> Unit>()
        val onKeyUpListeners = HashMap<String, () -> Unit>()
        val onKeyDownListeners = HashMap<String, () -> Unit>()
        val onContextMenuListeners = HashMap<String, () -> Unit>()
        val onDoubleClickListeners = HashMap<String, () -> Unit>()
        val onDragListeners = HashMap<String, () -> Unit>()
        val onDragEndListeners = HashMap<String, () -> Unit>()
        val onDragEnterListeners = HashMap<String, () -> Unit>()
        val onDragExitListeners = HashMap<String, () -> Unit>()
        val onDragLeaveListeners = HashMap<String, () -> Unit>()
        val onDragOverListeners = HashMap<String, () -> Unit>()
        val onDragStartListeners = HashMap<String, () -> Unit>()
        val onDropListeners = HashMap<String, () -> Unit>()
        val onFocusListeners = HashMap<String, () -> Unit>()
        val onBlurListeners = HashMap<String, () -> Unit>()
    }

    private fun setupIPC() {
        webEngine.loadWorker.stateProperty().addListener { _, _, newState ->
            if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
                val window = webEngine.executeScript("window") as JSObject
                window.setMember("ipc", this)
            }
        }
    }

    @Suppress("unused")
    fun receiveMessage(message: String) {
        val data = Gson().fromJson(message, Map::class.java)
        val path = data["path"] as String
        val id = data["id"] as String

        when (path) {
            "click" -> clickListeners[id]?.invoke()
            "formSubmit" -> formSubmitListeners[id]?.invoke()
            "mouseEnter" -> onMouseEnterListeners[id]?.invoke()
            "mouseLeave" -> onMouseLeaveListeners[id]?.invoke()
            "change" -> onChangeListeners[id]?.invoke()
            "input" -> onInputListeners[id]?.invoke()
            "scroll" -> onScrollListeners[id]?.invoke()
            "keyPress" -> onKeyPressListeners[id]?.invoke()
            "keyUp" -> onKeyUpListeners[id]?.invoke()
            "keyDown" -> onKeyDownListeners[id]?.invoke()
            "contextMenu" -> onContextMenuListeners[id]?.invoke()
            "doubleClick" -> onDoubleClickListeners[id]?.invoke()
            "drag" -> onDragListeners[id]?.invoke()
            "dragEnd" -> onDragEndListeners[id]?.invoke()
            "dragEnter" -> onDragEnterListeners[id]?.invoke()
            "dragExit" -> onDragExitListeners[id]?.invoke()
            "dragLeave" -> onDragLeaveListeners[id]?.invoke()
            "dragOver" -> onDragOverListeners[id]?.invoke()
            "dragStart" -> onDragStartListeners[id]?.invoke()
            "drop" -> onDropListeners[id]?.invoke()
            "focus" -> onFocusListeners[id]?.invoke()
            "blur" -> onBlurListeners[id]?.invoke()
        }
    }

    fun sendMessageToJavaScript(message: String) {
        webEngine.executeScript("alert('$message');")
    }
}
