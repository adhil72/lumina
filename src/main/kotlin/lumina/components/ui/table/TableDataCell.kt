package lumina.components.ui.table

import lumina.components.ui.component.Component

class TableDataCell(content: String = "") : Component("td") {
    init {
        setText(content)
    }
}
