import lumina.Lumina
import lumina.components.ui.Div

class App:Lumina(){
    override fun onWindowCreated() {
        super.onWindowCreated()

        set(Div().apply {
            addText("Hello World")
        })
    }
}

fun main(){
App().startApp()
}