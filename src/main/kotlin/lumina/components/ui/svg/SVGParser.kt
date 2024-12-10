package lumina.components.ui.svg

import lumina.components.ui.component.Component
import org.w3c.dom.Element
import org.w3c.dom.Node
import lumina.utils.getResourceAsString
import javax.xml.parsers.DocumentBuilderFactory

open class SVGParser {
    companion object {
        fun parse(resourcePath: String): Svg {
            val svgString = getResourceAsString(resourcePath)
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val inputSource = org.xml.sax.InputSource(svgString.reader())
            val document = builder.parse(inputSource)

            val rootElement = document.documentElement
            if (rootElement.tagName != "svg") {
                throw IllegalArgumentException("Provided string is not a valid SVG.")
            }

            val svgComponent = Svg()
            rootElement.attributes?.let { attrs ->
                for (i in 0 until attrs.length) {
                    val attr = attrs.item(i)
                    svgComponent.setAttribute(attr.nodeName, attr.nodeValue)
                }
            }

            fun processNode(node: Node, parent: Component) {
                if (node.nodeType == Node.ELEMENT_NODE) {
                    val element = node as Element
                    val child = Component(element.tagName)

                    element.attributes?.let { attrs ->
                        for (i in 0 until attrs.length) {
                            val attr = attrs.item(i)
                            child.setAttribute(attr.nodeName, attr.nodeValue)
                        }
                    }

                    parent.addChild(child)

                    val children = element.childNodes
                    for (i in 0 until children.length) {
                        processNode(children.item(i), child)
                    }
                }
            }

            val children = rootElement.childNodes
            for (i in 0 until children.length) {
                processNode(children.item(i), svgComponent)
            }

            return svgComponent
        }
    }
}
