package lumina.components.ui.table

import lumina.components.ui.component.Component

open class TableHeaderCell(content: String = "") : Component("th") {
    init {
        setText(content)
    }
}
