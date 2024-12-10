package lumina.components.ui

import lumina.components.ui.component.Component
import lumina.utils.openLink

open class Link : Component("span") {

    var href: String = ""
        set(value) {
            field = value
            setAttribute("href", value)
        }


    init {
        setStyle("cursor", "pointer")
        events.onClick {
            openLink(href)
        }
    }
}