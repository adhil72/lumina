package views

import lumina.ui.common.Div
import lumina.ui.common.Span

class Sidebar:Div() {
    init {
        cn("w-64 h-screen overflow-y-auto bg-white p-5")
        addView(Span("Biometry"),"text-2xl text-black")
    }
}