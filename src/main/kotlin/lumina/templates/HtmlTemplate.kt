package lumina.templates

import lumina.utils.getResourceAsString

val template = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Lumina</title>
            <style>
                body {
                    margin: 0;
                    padding: 0;
                }
                
                ::-webkit-scrollbar {
                    width: 8px;
                    height: 8px;
                }
                ::-webkit-scrollbar-track {
                    background: #f0f0f0;
                }
                ::-webkit-scrollbar-thumb {
                    background: #888888;
                    border-radius: 4px;
                }
                ::-webkit-scrollbar-thumb:hover {
                    background: #555555;
                }
                body {
                    scrollbar-width: thin;
                    scrollbar-color: #888888 #f0f0f0;
                }
                *{
                    -webkit-user-select: none;
                    -moz-user-select: none;
                    -ms-user-select: none;
                    user-select: none; 
                    cursor: inherit;
                }
                
                #root {
                    width: 100vw;
                    height: 100vh;
                    display: flex;
                    flex-direction: column;
                    cursor: default;
                }
            </style>
        </head>
        <body>
            <div id="root"></div>
            ${getResourceAsString("ipc.js")}
            <<--TAILWINDCSS-->>
        </body>
        </html>
    """.trimIndent()

fun htmlTemplate(enableTailwindCss: Boolean): String {
    if (enableTailwindCss) return template.replace("<<--TAILWINDCSS-->>", getResourceAsString("tw.js"))
    return template.replace("<<--TAILWINDCSS-->>", "")
}
