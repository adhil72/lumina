package gecw.ace

import gecw.ace.lumina.Window
import gecw.ace.lumina.ui.common.Button
import gecw.ace.lumina.ui.common.Div
import gecw.ace.lumina.ui.common.Span
import javafx.application.Application

class App:Window(){
    override fun onViewCreated() {
        super.onViewCreated()

        body.cn("m-0 p-0 bg-gray-300 w-full h-screen flex justify-center items-center")
        add(Div().apply {
            cn("bg-white w-[400px] h-[200px] p-5 rounded-xl flex flex-col justify-center items-center text-2xl font-bold")
            onMouseEnter{
                element("title")?.textContent = "Mouse entered"
            }
            onMouseLeave {
                element("title")?.textContent = "Mouse left"
            }
            add(Span("Hello, World!").apply {
                id = "title"
            })
            add(Button("Click me").apply {
                id = "button"
            })
        })
        updateUi()
    }
}

fun main() {
    Application.launch(App::class.java)
}