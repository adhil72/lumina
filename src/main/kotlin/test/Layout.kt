package gecw.ace.test

import gecw.ace.lumina.ui.View
import gecw.ace.lumina.ui.common.Div

class Layout:Div() {
    val container = Div().apply {
        cn("flex-1")
    }
    val sidebar = Sidebar()
    init {
        cn("w-full h-screen flex")
        addView(sidebar)
        addView(container)
    }

    fun setContainerView(view: View){
        container.setView(view)
    }
}