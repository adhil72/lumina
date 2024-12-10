import lumina.Lumina
import lumina.components.ui.Div
import lumina.components.ui.component.ComponentParser
import lumina.components.ui.form.InputParser
import lumina.utils.getResourceAsString
import java.io.File


class App : Lumina() {
    override fun onWindowCreated() {
        super.onWindowCreated()


        try {
            val page = ComponentParser.parseHtmlToComponent(getResourceAsString("template/Home.html"))
            set(page)

            page.onRendered {
                val selectFolderBtn = getElemById("select-folder-btn")
                try {
                    val apiInput = getElemById("api-input")

                    val folderPicker = CustomFolderPicker()
                    page.addChild(folderPicker)

                    selectFolderBtn.events.onClick {
                        folderPicker.dialog.open()
                    }

                    apiInput.events.onInput {
                        println(apiInput.getAttribute("value"))
//                        File("btn.html").writeText(apiInput.toString())
                    }
                }catch (e: Exception){
                    e.printStackTrace()
                }


            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}

fun main() {
    App().startApp()
}