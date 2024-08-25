package gecw.ace.lumina.ui.common

import gecw.ace.lumina.ui.Component

class Button(text:String):Component("button"){
    init {
        cn("bg-blue-500 text-lg text-white px-3 py-1 rounded-lg hover:bg-blue-600 active:bg-blue-700 transition-all duration-200 ease-in-out")
        add(text)
    }
}