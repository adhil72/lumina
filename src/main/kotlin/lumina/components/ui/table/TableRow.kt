package lumina.components.ui.table

import lumina.components.ui.component.Component

class TableRow : Component("tr") {
    fun addHeaderCell(headerCell: TableHeaderCell): TableRow {
        addChild(headerCell)
        return this
    }

    fun addDataCell(dataCell: TableDataCell): TableRow {
        addChild(dataCell)
        return this
    }
}
