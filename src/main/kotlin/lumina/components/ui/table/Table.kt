package lumina.components.ui.table

import lumina.components.ui.component.Component

class Table : Component("table") {
    var border: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("border", value) else removeAttribute("border")
        }

    var cellSpacing: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("cellspacing", value) else removeAttribute("cellspacing")
        }

    var cellPadding: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("cellpadding", value) else removeAttribute("cellpadding")
        }

    var width: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("width", value) else removeAttribute("width")
        }

    var height: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("height", value) else removeAttribute("height")
        }

    var align: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("align", value) else removeAttribute("align")
        }

    var summary: String? = null
        set(value) {
            field = value
            if (value != null) setAttribute("summary", value) else removeAttribute("summary")
        }

    fun addRow(row: TableRow): Table {
        addChild(row)
        return this
    }

    fun addHeader(header: TableHead): Table {
        addChild(header)
        return this
    }

    fun addBody(body: TableBody): Table {
        addChild(body)
        return this
    }

    fun addFooter(footer: TableFooter): Table {
        addChild(footer)
        return this
    }
}
