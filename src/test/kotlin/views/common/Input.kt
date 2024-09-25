package views.common

import lumina.ui.common.Input

class SolidInput:Input() {
    init {
       cn("border border-gray-200 bg-white px-2 py-1 focus:border-black rounded transition-all duration-200")
    }
}