package gecw.ace

import gecw.ace.lumina.Lumina
import gecw.ace.lumina.ui.View
import gecw.ace.lumina.ui.common.Div
import gecw.ace.lumina.ui.common.Span
import gecw.ace.test.Hello
import gecw.ace.test.Hi
import gecw.ace.test.Layout
import javafx.application.Application
import java.io.File


class App:Lumina(){
    override fun onWindowCreated() {
        super.onWindowCreated()
        val l = Layout()
        setView(l)
        l.setContainerView(Hello())
        l.sidebar.onItemClick = {
            if (it == "0") l.setContainerView(Hello())
            else l.setContainerView(Hi())
        }

    }
}

fun main() {
    Application.launch(App::class.java)
}