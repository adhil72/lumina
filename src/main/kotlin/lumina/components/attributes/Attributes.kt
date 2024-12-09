package lumina.components.attributes

import lumina.components.ui.component.Component

class Attributes(private val component: Component) {
    var accesskey: String
        get() = component.getAttribute("accesskey")
        set(value) {
            component.setAttribute("accesskey", value)
        }


    var className: String
        get() = component.getAttribute("class")
        set(value) {
            component.setAttribute("class", value)
        }


    var contenteditable: String
        get() = component.getAttribute("contenteditable")
        set(value) {
            component.setAttribute("contenteditable", value)
        }


    var contextmenu: String
        get() = component.getAttribute("contextmenu")
        set(value) {
            component.setAttribute("contextmenu", value)
        }


    var dir: String
        get() = component.getAttribute("dir")
        set(value) {
            component.setAttribute("dir", value)
        }


    var draggable: String
        get() = component.getAttribute("draggable")
        set(value) {
            component.setAttribute("draggable", value)
        }


    var dropzone: String
        get() = component.getAttribute("dropzone")
        set(value) {
            component.setAttribute("dropzone", value)
        }


    var hidden: String
        get() = component.getAttribute("hidden")
        set(value) {
            component.setAttribute("hidden", value)
        }


    var id: String
        get() = component.getAttribute("id")
        set(value) {
            throw IllegalStateException("Cannot change id")
        }


    var lang: String
        get() = component.getAttribute("lang")
        set(value) {
            component.setAttribute("lang", value)
        }


    var spellcheck: String
        get() = component.getAttribute("spellcheck")
        set(value) {
            component.setAttribute("spellcheck", value)
        }


    var style: String
        get() = component.getAttribute("style")
        set(value) {
            component.setAttribute("style", value)
        }


    var tabindex: String
        get() = component.getAttribute("tabindex")
        set(value) {
            component.setAttribute("tabindex", value)
        }


    var title: String
        get() = component.getAttribute("title")
        set(value) {
            component.setAttribute("title", value)
        }


    var translate: String
        get() = component.getAttribute("translate")
        set(value) {
            component.setAttribute("translate", value)
        }


    var xmlLang: String
        get() = component.getAttribute("xml:lang")
        set(value) {
            component.setAttribute("xml:lang", value)
        }
}