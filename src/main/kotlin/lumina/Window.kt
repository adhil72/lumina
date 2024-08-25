package gecw.ace.lumina

import gecw.ace.lumina.ui.Component
import gecw.ace.lumina.ui.common.Body
import javafx.application.Application
import javafx.scene.web.WebView
import javafx.stage.Stage

open class Window:Application() {

    companion object{
        val webView = WebView()
        val engine = webView.engine
        val html = Component("html")
        var body = Body()
    }

    init {
        html.add(body)
    }

    override fun start(p0: Stage?) {
        val scene = javafx.scene.Scene(webView)
        p0?.scene = scene
        p0?.show()

        webView.engine.loadContent(Component("html").render())
        onViewCreated()
    }

    open fun onViewCreated(){}
}