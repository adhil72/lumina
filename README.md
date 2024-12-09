
# Lumina Documentation

## Overview

Lumina is a Kotlin-based UI framework designed for building desktop applications using JavaFX and a WebView component. It allows developers to create user interfaces using HTML, CSS, and JavaScript, while leveraging the power of Kotlin for backend logic and application management. Lumina simplifies the development process by providing a set of reusable UI components and utilities, making it easier to build and manage complex desktop applications.

## Core Features

- **Component-Based UI:** Build user interfaces using pre-built or custom components.
- **WebView Integration:** Utilizes a JavaFX WebView to render UI elements, allowing the use of web technologies.
- **Inter-Process Communication (IPC):** Facilitates communication between the Kotlin backend and the JavaScript frontend.
- **Styling:** Supports CSS styling directly or through a Kotlin-based `Styles` class.
- **Event Handling:** Provides a mechanism for handling user interactions and other events.
- **Tailwind CSS Support:** Optionally integrate Tailwind CSS for rapid UI development.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 1.8 or higher.
- Kotlin 2.0.20 or higher.
- Maven build tool.

### Installation

To start using Lumina, you need to include it as a dependency in your Maven project. The `pom.xml` file provided demonstrates the necessary configurations, including the Kotlin plugin, JavaFX dependencies, and other required libraries.

### Creating a Lumina Application

A Lumina application is initialized by extending the `Lumina` class and overriding the `start` method. Here's a basic example:

```kotlin
package test

import lumina.Lumina
import lumina.components.ui.Div


class App:Lumina(enableTailwindCss = true){
    override fun onWindowCreated() {
        super.onWindowCreated()

        val box = Div().apply {
            setClassName("bg-white p-4 rounded-lg shadow-lg transition-all duration-300")

            addChild(Div().apply {
                setClassName("text-2xl font-semibold transition-all duration-300")
                setText("Hello World")
            })

            events.onMouseEnter {
                this.setClassName("bg-blue-500")
            }

            events.onMouseLeave {
                this.removeClassName("bg-blue-500")
            }
        }

        set(Div().apply {
            setClassName("w-vw h-screen bg-gray-100 flex items-center justify-center")
            addChild(box)
        })
    }
}

fun main() {
    App().startApp()
}
```


## Usable Components

Lumina provides a variety of UI components that can be used to build your application. Here are some of the key components:

### Div

The `Div` component represents a `<div>` HTML element.

```kotlin
val myDiv = Div().apply {
    id = "my-div"
    styles.backgroundColor = "lightblue"
    setText("Hello, Lumina!")
}
Lumina.push(myDiv)
```
### Section

The `Section` component represents a `<section>` HTML element.

```kotlin
val mySection = Section().apply {
    id = "my-section"
    styles.padding = "20px"
    addChild(Div().apply { setText("This is a section") })
}
Lumina.push(mySection)
```

### Form

The `Form` component represents a `<form>` HTML element with various attributes like `action`, `method`, `enctype`, `target`, `autocomplete`, and `novalidate`.

```kotlin
val myForm = Form().apply {
    id = "my-form"
    action = "/submit"
    method = "post"
    addChild(Div().apply { setText("Form Content") })
}
Lumina.push(myForm)
```

### Table

The `Table` component represents a `<table>` HTML element. You can add rows, headers, body, and footer using `TableRow`, `TableHead`, `TableBody`, and `TableFooter` respectively.

```kotlin
val myTable = Table().apply {
    id = "my-table"
    width = "100%"
    border = "1"
    addRow(TableRow().apply {
        addCell(TableCell().apply { setText("Row 1, Cell 1") })
        addCell(TableCell().apply { setText("Row 1, Cell 2") })
    })
}
Lumina.push(myTable)
```

### Select

The `Select` component represents a `<select>` HTML element.

```kotlin
val mySelect = Select().apply {
    id = "my-select"
    // Add options here
}
Lumina.push(mySelect)
```

### Media (Video/Audio)

The `Media` component is a base class for `<video>` and `<audio>` elements. It supports attributes like `autoplay`, `controls`, `loop`, `muted`, `src`, `poster`, `width`, and `height`.

```kotlin
val myVideo = Media("video").apply {
    id = "my-video"
    src = "path/to/video.mp4"
    controls = true
    width = 640
    height = 480
}
Lumina.push(myVideo)
```

### Image

The `Image` component represents an `<img>` HTML element. It supports attributes like `src`, `alt`, `width`, `height`, `srcset`, `sizes`, `loading`, and `decoding`.

```kotlin
val myImage = Image().apply {
    id = "my-image"
    src = "path/to/image.jpg"
    alt = "An example image"
    width = "300"
    height = "200"
}
Lumina.push(myImage)
```

### Iframe

The `Iframe` component represents an `<iframe>` HTML element. It supports attributes like `src`, `width`, `height`, `frameBorder`, `allowFullScreen`, `loading`, `sandbox`, `referrerPolicy`, and `allow`.

```kotlin
val myIframe = Iframe().apply {
    id = "my-iframe"
    src = "https://www.example.com"
    width = "600"
    height = "400"
    allowFullScreen = true
}
Lumina.push(myIframe)
```

### Svg

The `Svg` component represents an `<svg>` HTML element. It supports attributes like `viewBox`, `xmlns`, `fill`, `stroke`, `strokeWidth`, and `preserveAspectRatio`. You can add various shapes like paths, circles, rectangles, and lines.

```kotlin
val mySvg = Svg().apply {
    id = "my-svg"
    viewBox = "0 0 100 100"
    addCircle("50", "50", "40", mapOf("fill" to "red"))
}
Lumina.push(mySvg)
```

## Styling Components

You can style components using the `styles` property, which is an instance of the `Styles` class. This class provides access to all CSS properties.

```kotlin
myDiv.styles.apply {
    backgroundColor = "blue"
    color = "white"
    padding = "10px"
    fontSize = "16px"
}
```

## Event Handling

Lumina components support event handling through the `addEvent` method.

```kotlin
myDiv.addEvent("click") { component ->
    println("Div clicked!")
    component?.styles?.backgroundColor = "green"
}
```

## Tailwind CSS Integration

To use Tailwind CSS, set `enableTailwindCss` to `true` when creating your `Lumina` instance:

```kotlin
class MyApp : Lumina(enableTailwindCss = true) {
    // ...
}
```

This will include the Tailwind CSS script in your HTML template.

## Building and Running
```bash
mvn javafx:run
```

## Conclusion

Lumina provides a powerful and flexible way to build desktop applications using web technologies. Its component-based architecture, styling capabilities, event handling, and IPC mechanism make it a comprehensive framework for developing modern desktop applications. By leveraging the strengths of Kotlin and JavaFX, Lumina simplifies the development process and allows you to create rich and interactive user interfaces.
