package lumina.components.ui.table

import lumina.components.ui.component.Component

open class TableFooter : Component("tfoot") {
    fun addRow(row: TableRow): TableFooter {
        addChild(row)
        return this
    }
}
