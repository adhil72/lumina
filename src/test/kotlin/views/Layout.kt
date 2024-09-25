package views

import lumina.ui.View
import lumina.ui.common.Div
import lumina.ui.common.Span

class Layout:Div() {

    val container = Div().apply {}

    init {
        cn("w-full h-screen bg-gray-100 flex")
        addView(Sidebar())
        addView(Div().apply {
            cn("flex-1 flex flex-col overflow-y-auto p-5")
            addView(container,"flex-1")
        })
        setContainer(AddStudentView())
    }

    fun setContainer(view: View){
        container.setView(view)
    }
}