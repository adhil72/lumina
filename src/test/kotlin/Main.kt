import javafx.application.Application
import lumina.Lumina
import views.Layout


class Biometry:Lumina(){
    override fun onWindowCreated() {
        super.onWindowCreated()
        setView(Layout())
    }
}

fun main(){
    Application.launch(Biometry::class.java)
}