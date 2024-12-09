package lumina.components.ui.component

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.parser.Parser

object ComponentParser {

    fun parseHtmlToComponent(htmlString: String): Component {
        // Check if the HTML string contains <html> and <body>, and add them if missing
        val wrappedHtml = if (!htmlString.contains("<html>") && !htmlString.contains("<body>")) {
            "<html><body>$htmlString</body></html>"
        } else {
            htmlString
        }

        val document = Jsoup.parse(wrappedHtml, "", Parser.xmlParser())
        val rootElement = document.selectFirst("body > *")
            ?: throw IllegalArgumentException("HTML string does not contain any valid root element.") // Get the first child of body

        return parseElementToComponent(rootElement)
    }

    private fun parseElementToComponent(element: Element): Component {
        val component = Component(element.tagName())

        element.attributes().forEach { attr ->
            if (attr.key == "style") return@forEach
            if (attr.key == "id") component.id = attr.value
            component.setAttribute(attr.key, attr.value)
        }

        element.attr("style").split(";").forEach { style ->
            val styleParts = style.split(":")
            if (styleParts.size == 2) {
                val key = styleParts[0].trim()
                val value = styleParts[1].trim()
                component.setStyle(key, value)
            }
        }

        element.classNames().forEach { className ->
            component.setClassName(className)
        }

        element.childNodes().forEach { node ->
            when (node) {
                is Element -> component.addChild(parseElementToComponent(node))
                else -> component.setText(node.toString().trim())
            }
        }

        return component
    }
}
