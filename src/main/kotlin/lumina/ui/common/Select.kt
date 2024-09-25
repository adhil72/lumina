package lumina.ui.common

import lumina.Lumina

class Select : Div() {

    val options = mutableListOf<Option>()

    var selectedOption: Option? = null;

    val displayValue = Span().apply { cn("text-black") }
    val optionsContainer = Div().apply {
        cn("absolute top-full left-0 hidden z-50 hidden")
    }
    val optionsOuter = Div().apply {
        cn("w-full h-screen fixed inset-0 z-40 hidden")
        onClick { open = false }
    }

    var open = false
        set(value) {
            field = value
            if (value) {
                options.forEachIndexed { index, option ->
                    Lumina.setTimeout((index * 100).toDouble()) {
                        option.onOpen()
                    }
                }
                optionsContainer.rcn("hidden")
                optionsOuter.rcn("hidden")
            } else {
                options.forEachIndexed { index, option ->
                    Lumina.setTimeout((index * 100).toDouble()) {
                        option.onClose()
                    }
                }
                optionsOuter.cn("hidden")
                optionsContainer.cn("hidden")
            }
        }

    init {
        cn("relative cursor-pointer")
        addView(displayValue)
        addView(optionsOuter)
        addView(optionsContainer)
        options.forEach { optionsContainer.addView(it) }
        onClick {
            open = !open
        }
    }

    fun addOption(option: Option) {
        if (selectedOption == null) {
            selectedOption = option
            displayValue.text = option.title
        }
        option.onClick {
            selectedOption = option
            displayValue.text = option.displayValue.text
            open = false
        }
        options.add(option)
        optionsContainer.addView(option)
    }

    fun removeOption(option: Option) {
        options.remove(option)
        option.removeView()
    }

}

class Option(override var value: String, var title: String, onSelect: (option: Option) -> Unit={}) : Div() {
    val displayValue = Span().apply {
        cn("text-black transition-all duration-300 max-h-0 overflow-hidden w-full")
    }

    fun onOpen() {
        displayValue.rcn("max-h-0")
    }

    fun onClose() {
        displayValue.cn("max-h-0")
    }

    init {
        addView(displayValue)
        displayValue.text = title
        onClick {
            onSelect(this)
        }
    }
}