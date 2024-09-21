package gecw.ace.test

import gecw.ace.lumina.ui.common.Div
import gecw.ace.lumina.ui.common.Text

class Sidebar(var onItemClick:(id:String)->Unit = {}) : Div() {
    init {
        cn("w-64 flex h-screen bg-gray-200 p-5")
        addView(Div().apply {
            cn("flex-1 flex flex-col bg-white p-5")
            repeat(2){
                addView(
                    Div().apply {
                        onClick {
                            onItemClick("$it")
                        }
                        cn("w-full px-4 py-2 bg-gray-100 text-black hover:bg-gray-200 active:bg-gray-300 my-3")
                        addView(Text("Item $it"))
                    }
                )
            }
        })
    }
}