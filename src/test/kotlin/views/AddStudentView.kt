package views

import lumina.ui.common.*
import views.common.SolidInput

fun createInput(name: String, type: String, placeHolder: String): Div {
    val input = SolidInput()
    input.placeholder = placeHolder
    input.type = type

    val label = Span(name)

    return Div().apply {
        cn("w-full flex flex-col")
        addView(label, "text-black text-xs font-semibold")
        addView(input, "mt-1")
    }
}

val select = Select()

fun createSelect(name: String, options: MutableList<Option>): Div {

    select.cn("w-full bg-gray-100 border rounded p-2")
    select.optionsContainer.cn("w-full bg-white border rounded p-2")
    options.forEach {
        it.cn("p-2 cursor-pointer hover:bg-gray-100 rounded")
        select.addOption(it)
    }

    val label = Span(name)

    return Div().apply {
        cn("w-full flex flex-col")
        addView(label, "text-black text-xs font-semibold")
        addView(select, "mt-1")
    }
}

class AddStudentView : Div() {
    init {
        cn("flex-1 flex justify-center")
        addView(Div().apply {
            cn("flex flex-col bg-white border p-5 rounded w-[400px]")
            addView(Div().apply {
                addView(Span("Enter student details"), "text-black")
            })
            addView(createInput("Name", "text", "Enter name"), "mt-5")
            addView(createInput("Age", "number", "Enter age"), "mt-2")
            addView(createInput("Email", "email", "Enter email"), "mt-2")
            addView(createInput("Phone", "tel", "Enter phone"), "mt-2")
            addView(createSelect(
                "Select type", mutableListOf(
                    Option("in", "In"),
                    Option("out", "Out")
                )
            ), "mt-2")
            addView(Button().apply {
                text = "Add Student"
                onClick {
                    println( " " + select.selectedOption?.value)
                }
            })
        })
    }
}