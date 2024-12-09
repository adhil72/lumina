package lumina.components.ui.image


import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

class ImageParser {
    companion object {
        fun parse(htmlString: String): Image {
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val inputSource = org.xml.sax.InputSource(htmlString.reader())
            val document = builder.parse(inputSource)

            val rootElement = document.documentElement
            if (rootElement.tagName != "img") {
                throw IllegalArgumentException("Provided string is not a valid <img> element.")
            }

            return parseImage(rootElement)
        }

        private fun parseImage(element: Element): Image {
            val image = Image()
            element.attributes?.let { attrs ->
                for (i in 0 until attrs.length) {
                    val attr = attrs.item(i)
                    when (attr.nodeName) {
                        "src" -> image.src = attr.nodeValue
                        "alt" -> image.alt = attr.nodeValue
                        "width" -> image.width = attr.nodeValue
                        "height" -> image.height = attr.nodeValue
                        "srcset" -> image.srcset = attr.nodeValue
                        "sizes" -> image.sizes = attr.nodeValue
                        "loading" -> image.loading = attr.nodeValue
                        "decoding" -> image.decoding = attr.nodeValue
                        "ismap" -> image.isMap = attr.nodeValue
                        "usemap" -> image.useMap = attr.nodeValue
                        else -> image.setAttribute(attr.nodeName, attr.nodeValue)
                    }
                }
            }
            return image
        }
    }
}
