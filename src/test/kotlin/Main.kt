import lumina.Lumina
import lumina.components.ui.Div

class App:Lumina(){
    override fun onWindowCreated() {
        super.onWindowCreated()

        set(Div().apply {
            setText("Hello, World!")
        })
    }
}

fun main(){
    Lumina.startApp(App::class.java)
}