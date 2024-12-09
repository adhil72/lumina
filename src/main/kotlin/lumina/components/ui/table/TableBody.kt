package lumina.components.ui.table

import lumina.components.ui.component.Component

class TableBody : Component("tbody") {
    fun addRow(row: TableRow): TableBody {
        addChild(row)
        return this
    }

    fun clearRows() {

    }
}
