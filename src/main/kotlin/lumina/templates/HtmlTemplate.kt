package lumina.templates

import lumina.utils.getResourceAsString
import lumina.utils.getResourcePath

fun htmlTemplate(): String {
    return """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Lumina</title>
            <style>
                @font-face {
                    font-family: 'MyCustomFont';
                    src: url('${getResourcePath("fonts/Roboto-Black.ttf")}') format('truetype');
                }
                body {
                    font-family: 'MyCustomFont', sans-serif;
                }
                @tailwind base;
                @tailwind components;
                @tailwind utilities;
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
            <div id="root" class="z-10"></div>
            ${getResourceAsString("ipc.js")}
        </body>
        </html>
    """.trimIndent()
}
