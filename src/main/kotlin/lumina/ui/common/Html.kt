package gecw.ace.lumina.ui.common

import gecw.ace.lumina.ui.Component

class Html : Component("html") {
    init {
        add(Component("head").apply {
            add(Component("title").apply {
                add(Component("Lumina", value = true))
            })
            add(Component("<script src=\"https://cdn.tailwindcss.com\"></script>", value = true))
            add(Component("""
                <script>
                    function sendMessageToJava(message) {
                        ipc.receiveMessage(JSON.stringify(message));
                    }
                    
                    function clickHandler(id) {
                        sendMessageToJava({id, path: "click"});
                    }

                    function formSubmitHandler(id) {
                        sendMessageToJava({id, path: "formSubmit"});
                    }

                    function mouseEnterHandler(id) {
                        sendMessageToJava({id, path: "mouseEnter"});
                    }

                    function mouseLeaveHandler(id) {
                        sendMessageToJava({id, path: "mouseLeave"});
                    }

                    function changeHandler(id) {
                        sendMessageToJava({id, path: "change"});
                    }

                    function inputHandler(id) {
                        sendMessageToJava({id, path: "input"});
                    }

                    function scrollHandler(id) {
                        sendMessageToJava({id, path: "scroll"});
                    }

                    function keyPressHandler(id) {
                        sendMessageToJava({id, path: "keyPress"});
                    }

                    function keyUpHandler(id) {
                        sendMessageToJava({id, path: "keyUp"});
                    }

                    function keyDownHandler(id) {
                        sendMessageToJava({id, path: "keyDown"});
                    }

                    function contextMenuHandler(id) {
                        sendMessageToJava({id, path: "contextMenu"});
                    }

                    function doubleClickHandler(id) {
                        sendMessageToJava({id, path: "doubleClick"});
                    }

                    function dragHandler(id) {
                        sendMessageToJava({id, path: "drag"});
                    }

                    function dragEndHandler(id) {
                        sendMessageToJava({id, path: "dragEnd"});
                    }

                    function dragEnterHandler(id) {
                        sendMessageToJava({id, path: "dragEnter"});
                    }

                    function dragExitHandler(id) {
                        sendMessageToJava({id, path: "dragExit"});
                    }

                    function dragLeaveHandler(id) {
                        sendMessageToJava({id, path: "dragLeave"});
                    }

                    function dragOverHandler(id) {
                        sendMessageToJava({id, path: "dragOver"});
                    }

                    function dragStartHandler(id) {
                        sendMessageToJava({id, path: "dragStart"});
                    }

                    function dropHandler(id) {
                        sendMessageToJava({id, path: "drop"});
                    }

                    function focusHandler(id) {
                        sendMessageToJava({id, path: "focus"});
                    }

                    function blurHandler(id) {
                        sendMessageToJava({id, path: "blur"});
                    }
                </script> 
            """.trimIndent(), value = true))
        })
    }
}
