import lumina.Lumina
import lumina.components.ui.Div

class App: Lumina(enableTailwindCss = true) {
    override fun onWindowCreated() {
        super.onWindowCreated()
        val box = Div().apply {
            setClassName("bg-white p-4 rounded-lg shadow-lg")

            addChild(Div().apply {
                setClassName("text-2xl font-semibold transition-all duration-300")
                setText("Hello World")
            })

            events.onClick {
                this.setClassName("bg-blue-500 p-4 rounded-lg shadow-lg")
            }
        }

        set(Div().apply {
            setClassName("w-vw h-screen bg-gray-100 flex items-center justify-center")
            addChild(box)
        })    }
}

fun main(){
    App().startApp()
}