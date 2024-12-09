package lumina.components.ui.form


import lumina.components.ui.component.Component
import org.w3c.dom.Element
import org.w3c.dom.Node
import javax.xml.parsers.DocumentBuilderFactory

class FormParser {
    companion object {
        fun parseForm(xmlString: String): Form {
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val inputSource = org.xml.sax.InputSource(xmlString.reader())
            val document = builder.parse(inputSource)

            val rootElement = document.documentElement
            if (rootElement.tagName != "form") {
                throw IllegalArgumentException("Provided string is not a valid Form.")
            }

            val form = Form()
            parseAttributes(rootElement, form)

            val children = rootElement.childNodes
            for (i in 0 until children.length) {
                val node = children.item(i)
                if (node.nodeType == Node.ELEMENT_NODE && node.nodeName == "input") {
                    val inputElement = parseInput(node as Element)
                    form.addChild(inputElement)
                }
            }

            return form
        }

        fun parseInput(element: Element): Input {
            val input = Input()
            parseAttributes(element, input)
            return input
        }

        private fun parseAttributes(element: Element, component: Component) {
            element.attributes?.let { attrs ->
                for (i in 0 until attrs.length) {
                    val attr = attrs.item(i)
                    component.setAttribute(attr.nodeName, attr.nodeValue)
                }
            }
        }
    }
}
