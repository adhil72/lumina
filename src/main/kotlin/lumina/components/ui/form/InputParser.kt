package lumina.components.ui.form

import lumina.components.ui.component.Component

class InputParser {
    companion object {
        fun parseInput(elem: Component): Input {
            val input = Input()
            input.id = elem.getAttribute("id")
            input.name = elem.getAttribute("name")
            input.type = elem.getAttribute("type")
            input.value = elem.getAttribute("value")
            input.copyAttributes(elem)
            return input
        }
    }
}