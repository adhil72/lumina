package lumina.components.ui.table

import lumina.components.ui.component.Component

class TableHead : Component("thead") {
    fun addRow(row: TableRow): TableHead {
        addChild(row)
        return this
    }
}
