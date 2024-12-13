import lumina.Lumina
import lumina.components.ui.Div

class App:Lumina(enableTailwindCss = true){
    override fun onWindowCreated() {
        super.onWindowCreated()

        set(Div().apply {
            addClassName("w-full h-screen bg-red-500 flex items-center justify-center")
            addChild(Div().apply {
                addClassName("w-1/2 h-1/2 bg-white flex items-center justify-center hover:bg-blue-300 transition-all duration-500 rounded-xl")
                setText("Hello")
                events.onClick {
                    setText("Hi")
                    addClassName("bg-blue-500 rounded-3xl")
                }
            })
        })
    }
}

fun main(){
    Lumina.startApp(App::class.java)
}