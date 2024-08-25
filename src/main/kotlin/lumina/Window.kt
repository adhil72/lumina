package gecw.ace.lumina

import gecw.ace.lumina.ui.Component
import gecw.ace.lumina.ui.common.Body
import gecw.ace.lumina.ui.common.Html
import gecw.ace.lumina.ui.common.Div
import gecw.ace.lumina.utils.WebViewIPC
import javafx.application.Application
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.web.WebView
import javafx.stage.Stage
import org.w3c.dom.Document

open class Window : Application() {

    init {
        html.add(body)
    }

    override fun start(primaryStage: Stage) {
        val scene = Scene(webView, 800.0, 600.0)
        updateUi()
        WebViewIPC(webView.engine)
        primaryStage.scene = scene
        primaryStage.show()
        onViewCreated()
    }

    fun updateUi() {
        webView.engine.loadContent(html.render())
    }

    companion object{
        val html = Html()
        var body = Body()
        var webView: WebView = WebView()

        fun addJs(js:String){
            body.add("""<script>$js</script>""")
        }

        fun execute(js:String){
            Platform.runLater {
                webView.engine.executeScript(js)
            }
        }
    }

    fun add(c:Component){
        body.add(c)
    }

    fun document(): Document? {
        return webView.engine.document
    }

    fun element(id: String): org.w3c.dom.Element? {
        return document()?.getElementById(id)
    }

    open fun onViewCreated() {}
}
