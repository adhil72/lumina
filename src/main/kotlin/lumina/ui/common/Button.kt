package lumina.ui.common

import lumina.Lumina
import lumina.ui.View

class Button() : View("button") {
    var text = ""
        set(value) {
            field = value
            setView(Text(value))
        }

    var backgroundColor = "bg-gray-700"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }

    var textColor = "text-white"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }

    var hoverBackgroundColor = "hover:bg-gray-800"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }

    var activeBackgroundColor = "active:bg-gray-900"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }

    var paddingLeft = "pl-4"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }

    var paddingRight = "pr-4"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }

    var paddingTop = "pt-2"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }

    var paddingBottom = "pb-2"
        set(value) {
            field = value
            rcn(field)
            cn(value)
        }


    init {
        cn("flex rounded $backgroundColor $textColor font-semibold $hoverBackgroundColor $activeBackgroundColor transition-all duration-200 $paddingLeft $paddingRight $paddingTop $paddingBottom")
        addView(Text(text))
    }
}