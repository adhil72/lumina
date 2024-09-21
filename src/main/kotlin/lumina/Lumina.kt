package gecw.ace.lumina

import gecw.ace.lumina.ui.View
import gecw.ace.lumina.utils.WebViewIPC
import gecw.ace.utils.getResourceAsString
import javafx.animation.PauseTransition
import javafx.application.Application
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.scene.web.WebView
import javafx.stage.Stage
import javafx.util.Duration

open class Lumina : Application() {

    companion object {
        val webView = WebView()

        fun exec(script: String): String {
            try {
                return webView.engine.executeScript(script).toString()
            } catch (e: Exception) {
                println("Error :\n${script}\n$e")
                return ""
            }
        }

        fun setView(view: View) {
            runOnUiThread {
                exec(
                    """
                    document.getElementById("root").innerHTML = `${view.render()}`
                """
                )
            }
        }

        fun runOnUiThread(action: () -> Unit) {
            Platform.runLater(action)
        }

        fun setTimeout(ms: Double, action: () -> Unit) {
            val delay = PauseTransition(Duration.millis(ms))
            delay.setOnFinished {
                action()
            }
            delay.play()
        }

        fun setInterval(millis: Double, action: () -> Boolean) {
            val delay = PauseTransition(Duration.millis(millis))
            delay.setOnFinished {
                if (action()) {
                    setInterval(millis, action)
                }
            }
            delay.play()
        }

        fun getHtml(): String {
            return exec("""document.getElementsByTagName('html')[0].innerHTML """.trimIndent())
        }

    }

    override fun start(p0: Stage?) {
        val scene = javafx.scene.Scene(webView)
        p0?.scene = scene
        p0?.show()
        webView.engine.onAlert = EventHandler {
            println("alert : " + it.data)
        }
        var htmlContent = getResourceAsString("root.html")
        htmlContent = htmlContent.replace("""<script id="config.script"></script>""","""
            <script id="config.script">
                ${getResourceAsString("ipc.js")}
            </script>
            <script>
                ${getResourceAsString("tw.js")}
            </script>
        """.trimIndent())
        WebViewIPC(webView.engine)
        webView.engine.loadContent(htmlContent)
        webView.engine.loadWorker.stateProperty()
            .addListener(object : javafx.beans.value.ChangeListener<javafx.concurrent.Worker.State> {
                override fun changed(
                    p0: javafx.beans.value.ObservableValue<out javafx.concurrent.Worker.State>?,
                    p1: javafx.concurrent.Worker.State?,
                    p2: javafx.concurrent.Worker.State?
                ) {
                    if (p2 == javafx.concurrent.Worker.State.SUCCEEDED) {
                        onWindowCreated()
                        webView.engine.loadWorker.stateProperty().removeListener(this)
                    }
                }
            })

    }

    open fun onWindowCreated() {}
}