package lumina.components.ui.table

import lumina.components.ui.component.Component
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.xml.sax.InputSource
import javax.xml.parsers.DocumentBuilderFactory

class TableParser {
    companion object {
        fun parse(xml: String): Table {
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val inputSource = InputSource(xml.reader())
            val document = builder.parse(inputSource)

            val rootElement = document.documentElement
            if (rootElement.tagName != "table") {
                throw IllegalArgumentException("Provided XML is not a valid table.")
            }

            val table = Table()
            rootElement.attributes?.let { attrs ->
                for (i in 0 until attrs.length) {
                    val attr = attrs.item(i)
                    table.setAttribute(attr.nodeName, attr.nodeValue)
                }
            }

            fun processNode(node: Node, parent: Component) {
                if (node.nodeType == Node.ELEMENT_NODE) {
                    val element = node as Element
                    when (element.tagName) {
                        "thead" -> {
                            val thead = TableHead()
                            processNode(element, thead)
                            (parent as? Table)?.addHeader(thead)
                        }
                        "tbody" -> {
                            val tbody = TableBody()
                            processNode(element, tbody)
                            (parent as? Table)?.addBody(tbody)
                        }
                        "tfoot" -> {
                            val tfoot = TableFooter()
                            processNode(element, tfoot)
                            (parent as? Table)?.addFooter(tfoot)
                        }
                        "tr" -> {
                            val row = TableRow()
                            processNode(element, row)
                            (parent as? TableHead)?.addRow(row)
                                ?: (parent as? TableBody)?.addRow(row)
                                ?: (parent as? TableFooter)?.addRow(row)
                        }
                        "th" -> {
                            val content = element.textContent ?: ""
                            val headerCell = TableHeaderCell(content)
                            element.attributes?.let { attrs ->
                                for (i in 0 until attrs.length) {
                                    val attr = attrs.item(i)
                                    headerCell.setAttribute(attr.nodeName, attr.nodeValue)
                                }
                            }
                            (parent as? TableRow)?.addHeaderCell(headerCell)
                        }
                        "td" -> {
                            val content = element.textContent ?: ""
                            val dataCell = TableDataCell(content)
                            element.attributes?.let { attrs ->
                                for (i in 0 until attrs.length) {
                                    val attr = attrs.item(i)
                                    dataCell.setAttribute(attr.nodeName, attr.nodeValue)
                                }
                            }
                            (parent as? TableRow)?.addDataCell(dataCell)
                        }
                    }
                }
            }

            fun processChildren(element: Element, parent: Component) {
                val children = element.childNodes
                for (i in 0 until children.length) {
                    processNode(children.item(i), parent)
                }
            }

            processChildren(rootElement, table)

            return table
        }
    }
}
