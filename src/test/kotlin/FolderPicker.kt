import lumina.Lumina
import lumina.components.styles.JustifyContent
import lumina.components.ui.Div
import lumina.components.ui.component.Component
import java.io.File
import javafx.stage.DirectoryChooser

class CustomDialog : Div() {

    val child = Div().apply {
        styles.width = "50%"
        styles.height = "50%"
        styles.backgroundColor = "white"
        styles.borderRadius = "1rem"
        styles.padding = "1rem"

        val header = Div().apply {
            styles.width = "100%"
            styles.display = "flex"
            styles.justifyContent = JustifyContent.SPACEBETWEEN

            val title = Div().apply {
                styles.color = "black"
                styles.fontSize = "1.5rem"
                styles.fontWeight = "bold"
                styles.padding = "0.5rem"
                setText("Select Folder")
            }

            val closeBtn = Component("span").apply {
                styles.color = "black"
                styles.fontSize = "1.5rem"
                styles.fontWeight = "bold"
                styles.cursor = "pointer"
                setText("X")
                events.onClick {
                    close()
                }
            }

            addChild(title)
            addChild(closeBtn)
        }

        val container = Div().apply {
            styles.marginTop = "1rem"
        }

        addChild(header)
        addChild(container)
    }

    init {
        styles.transition = "all 0.3s"
        styles.width = "100vw"
        styles.height = "100vh"
        styles.backgroundColor = "#00000050"
        styles.position = "fixed"
        styles.inset = 0
        styles.justifyContent = "center"
        styles.alignItems = "center"
        styles.display = "none"
        styles.zIndex = 1000

        addChild(child)
    }

    fun open() {
        styles.display = "flex"
    }

    fun close() {
        styles.display = "none"
    }
}

class CustomFolderPicker : Div() {

    val dialog = CustomDialog()

    init {
        setClassName("w-fit h-fit")
        addChild(dialog)

        val openButton = Component("button").apply {
            setText("Open Folder Picker")
            styles.padding = "0.5rem 1rem"
            styles.fontSize = "1rem"
            styles.cursor = "pointer"
            events.onClick {
                openFolderPicker()
            }
        }

        addChild(openButton)
    }

    private fun openFolderPicker() {
        val directoryChooser = DirectoryChooser()
        val selectedDirectory = directoryChooser.showDialog(Lumina.primaryStage)
        if (selectedDirectory != null) {
            println("Selected folder: ${selectedDirectory.absolutePath}")
            // Handle the selected folder (e.g., display its contents)
        }
    }
}