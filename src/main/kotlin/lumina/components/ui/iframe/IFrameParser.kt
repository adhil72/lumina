package lumina.components.ui.iframe


import lumina.components.ui.component.Component
import org.w3c.dom.Element
import org.w3c.dom.Node
import lumina.utils.getResourceAsString
import javax.xml.parsers.DocumentBuilderFactory

class IframeParser {
    companion object {
        fun parse(resourcePath: String): Iframe {
            val iframeString = getResourceAsString(resourcePath)
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val inputSource = org.xml.sax.InputSource(iframeString.reader())
            val document = builder.parse(inputSource)

            val rootElement = document.documentElement
            if (rootElement.tagName != "iframe") {
                throw IllegalArgumentException("Provided string is not a valid Iframe.")
            }

            val iframeComponent = Iframe()

            // Set attributes for iframe tag
            rootElement.attributes?.let { attrs ->
                for (i in 0 until attrs.length) {
                    val attr = attrs.item(i)
                    when (attr.nodeName) {
                        "src" -> iframeComponent.src = attr.nodeValue
                        "width" -> iframeComponent.width = attr.nodeValue
                        "height" -> iframeComponent.height = attr.nodeValue
                        "frameborder" -> iframeComponent.frameBorder = attr.nodeValue
                        "allowfullscreen" -> iframeComponent.allowFullScreen = true
                        "loading" -> iframeComponent.loading = attr.nodeValue
                        "sandbox" -> iframeComponent.sandbox = attr.nodeValue
                        "referrerpolicy" -> iframeComponent.referrerPolicy = attr.nodeValue
                        "name" -> iframeComponent.iFrameName = attr.nodeValue
                        "allow" -> iframeComponent.allow = attr.nodeValue
                    }
                }
            }

            // Process child nodes
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
                processNode(children.item(i), iframeComponent)
            }

            return iframeComponent
        }
    }
}
