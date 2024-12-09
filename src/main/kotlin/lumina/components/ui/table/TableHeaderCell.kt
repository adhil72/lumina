package lumina.components.ui.table

import lumina.components.ui.component.Component

class TableHeaderCell(content: String = "") : Component("th") {
    init {
        setText(content)
    }
}
