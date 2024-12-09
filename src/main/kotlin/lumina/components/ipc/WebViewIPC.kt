package lumina.components.ipc

import lumina.Lumina
import lumina.components.ui.component.Component
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.scene.web.WebEngine
import lumina.modals.IpcMessage
import lumina.modals.Listener
import netscape.javascript.JSObject

class WebViewIPC(private val webEngine: WebEngine,private val onReady: (() -> Unit)? = null) {

    init {
        setupIPC()
        webEngine.onAlert = EventHandler {
            println("alert : " + it.data)
        }
    }

    companion object {
        val listeners = mutableListOf<Listener>()
        val waitComponents = mutableListOf<Component>()
    }

    private fun setupIPC() {
        webEngine.loadWorker.stateProperty().addListener { _, _, newState ->
            if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
                val window = webEngine.executeScript("window") as JSObject
                window.setMember("ipc", this)
                webEngine.executeScript(
                    """const event = new Event('ipcReady');document.dispatchEvent(event); """
                )
            }

        }
    }

    fun receiveMessage(message: String, event: JSObject) {
        try {
            val target = Lumina.getElemById((event.getMember("target") as JSObject).getMember("id").toString())
            val data: IpcMessage = IpcMessage.fromJson(message)
            val event = data.event
            val id = data.id

            Platform.runLater {
                listeners.forEach {
                    if (it.id == id && it.event == event) {
                        it.action.invoke(target)
                    }
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun sendMessageToJavaScript(message: String) {
        webEngine.executeScript("alert('$message');")
    }

    fun log(message: String) {
        println(message)
    }

    fun onDocumentReady(){
        Lumina.ipcReady = true
        onReady?.invoke()
    }

    fun onElementReady(id: String){
        waitComponents.forEach {
            if(it.id == id){
                it.onReady?.invoke()
                waitComponents.remove(it)
            }
        }
    }
}
