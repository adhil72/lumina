package lumina

import lumina.components.ui.component.Component
import lumina.components.ipc.WebViewIPC
import lumina.components.ui.component.ComponentParser
import javafx.application.Application
import javafx.application.Platform
import javafx.scene.Scene
import javafx.scene.web.WebView
import javafx.stage.Stage
import lumina.templates.htmlTemplate

open class Lumina( private val htmlTemplate: String = htmlTemplate()) : Application() {


    override fun start(primaryStage: Stage) {
        System.setProperty("prism.forceGPU", "true")
//        validateHtmlTemplate(htmlTemplate)
        webView = WebView()
        webView.engine.loadContent(htmlTemplate)
        scene = Scene(webView, 800.0, 600.0)
        Companion.primaryStage = primaryStage
        primaryStage.scene = scene
        primaryStage.show()
        WebViewIPC(webView.engine){
            onWindowCreated()
        }
    }

    open fun onWindowCreated() {}

    companion object {
        lateinit var webView: WebView
        lateinit var scene: Scene
        lateinit var primaryStage: Stage
        var ipcReady = false
        val components = mutableListOf<Component>()

        fun getCurrentHtml(): String {
            return webView.engine.executeScript("document.documentElement.outerHTML").toString()
        }

        fun setTitle(title: String) {
            primaryStage.title = title
        }

        fun exec(script: String): Any {
            return webView.engine.executeScript(script)?:""
        }

        fun push(component: Component) {
            Platform.runLater {
                components.add(component)
                exec("document.getElementById('root').appendChild(${component.render()})")
            }
        }

        fun pop() {
            Platform.runLater {
                components.removeLast()
                exec("document.getElementById('root').removeChild(document.getElementById('root').lastChild)")
            }
        }

        fun set(component: Component) {
            Platform.runLater {
                components.clear()
                components.add(component)
                exec("document.getElementById('root').innerHTML = `${component.render()}`")
            }
        }

        fun getElemById(id: String): Component {
            val element = exec("document.getElementById('$id')?.outerHTML || ''").toString()
            return ComponentParser.parseHtmlToComponent(element).apply {
                rendered = true
            }
        }

        @JvmStatic
        fun startApp(AppClass: Class<out Lumina>) {
            launch(AppClass)
        }
    }
}