# Lumina UI Framework: Crafting Modern Desktop Experiences with Kotlin

## Introduction

**Lumina** is a cutting-edge Kotlin UI framework engineered to empower developers to build dynamic, interactive, and web-based user interfaces that seamlessly integrate into desktop applications. By harnessing the rendering capabilities of JavaFX's WebView, Lumina enables you to craft desktop applications using the familiar paradigm of web technologies — HTML, CSS, and JavaScript — while writing clean and expressive Kotlin code.

## Core Concepts

At the heart of Lumina lies a set of fundamental concepts that drive its functionality and ease of use:

1. **`Lumina` Class: Your Application's Foundation**

    The `Lumina` class serves as the entry point for your application. It orchestrates the initialization of the JavaFX WebView, establishes the initial HTML structure, and gracefully manages the application's lifecycle.

2. **`Component` Class: The Building Blocks of Your UI**

    Every element within your Lumina UI, from the simplest `div` to the most intricate custom component, inherits from the `Component` class. This foundational class provides a consistent interface for managing UI elements and their behavior.

3. **Styling: Tailoring the Look and Feel**

    Lumina offers a versatile approach to styling, supporting both inline styles and CSS classes. The `Styles` class empowers you with programmatic control over the visual presentation of your components, allowing for dynamic and responsive designs.

4. **Event Handling: Bringing Your UI to Life**

    Interactivity is achieved through the `Events` class, which lets you attach listeners to a wide array of DOM events. When an event occurs, your Kotlin code springs into action, responding to user interactions and dynamically updating the UI.

5. **Inter-Process Communication (IPC): Bridging the Kotlin-JavaScript Divide**

    Lumina features a robust built-in IPC mechanism that facilitates seamless communication between the Kotlin backend and the JavaScript frontend residing within the WebView. This enables a powerful synergy between the two worlds.

## Getting Started: Embark on Your Lumina Journey

### Project Setup: Laying the Groundwork

1. **Maven Dependency: Embracing Lumina**

    Integrate Lumina into your project by adding the following dependency to your `pom.xml`:

    ```xml
    <dependency>
        <groupId>lumina</groupId>
        <artifactId>Lumina</artifactId>
        <version>2.0.3</version>
    </dependency>
    ```

### Creating a Basic Lumina Application: Your First Steps

Let's craft a simple "Hello, World!" application to illustrate the fundamental structure of a Lumina project:

```kotlin
import lumina.Lumina
import lumina.components.ui.Div
import javafx.application.Application
import javafx.stage.Stage

class MyApp : Lumina() {

    override fun start(primaryStage: Stage) {
        super.start(primaryStage)
        Lumina.setTitle("My Lumina App") // Set the window title
    }

    override fun onWindowCreated() {
        // Create a Div component with text and styling
        val myDiv = Div().apply {
            addText("Hello from Lumina!")
            styles.backgroundColor = "lightblue"
            styles.padding = "20px"
        }

        // Add the Div to the root of the application
        Lumina.push(myDiv)
    }
}

fun main() {
    Application.launch(MyApp::class.java)
}
```

**Explanation: Unveiling the Code**

*   **`class MyApp : Lumina()`:** Your main application class extends the `Lumina` base class, inheriting its core functionality.
*   **`start(primaryStage: Stage)`:** The main entry point, invoked by JavaFX, sets up the initial stage.
*   **`onWindowCreated()`:** This crucial callback is triggered after the WebView has loaded the initial HTML. This is where you construct and add your UI components.
*   **`Lumina.push(myDiv)`:**  Adds the `myDiv` component to the root of your HTML document, making it visible in the WebView.
*   **`Lumina.setTitle()`:** Sets the title of your application's window.

## Components: The Heart of Your UI

### The `Component` Class: The Universal Ancestor

The `Component` class is the foundation upon which all UI elements in Lumina are built. It provides a wealth of properties and methods to manage and manipulate your components.

**Key Properties:**

*   `tagName`: The HTML tag name (e.g., "div", "span", "img").
*   `id`: A unique identifier for the component.
*   `rendered`: A boolean flag indicating whether the component has been rendered in the WebView.
*   `styles`: An instance of `Styles` for managing the component's visual appearance.
*   `attributes`: An instance of `Attributes` for managing HTML attributes.
*   `events`: An instance of `Events` for handling user interactions.
*   `onReady`: A callback function invoked when the corresponding DOM element is fully rendered and ready.

**Essential Methods:**

*   `addChild(child: Component)`: Adds a child component.
*   `addChildAtBeginning(child: Component)`: Adds a child component at the beginning of the children list.
*   `addText(text: String)`: Appends text content to the component.
*   `setText(text: String)`: Sets the text content, replacing any existing content.
*   `setChild(child: Component)`: Replaces all existing children with a single child.
*   `setClassName(className: String)`: Sets the CSS class name(s).
*   `addClassName(className: String)`: Adds a CSS class name.
*   `removeClassName(className: String)`: Removes a CSS class name.
*   `render(): String`: Returns the HTML representation of the component.
*   `addEvent(event: String, action: (data: Component?) -> Unit)`: Attaches an event listener.
*   `removeEvent(listener: Listener)`: Removes an event listener.
*   `remove()`: Removes the component from the DOM.
*   `getStyle(style: String)`: Retrieves the value of a style property.
*   `getAttribute(attribute: String)`: Gets the value of an attribute.
*   `setAttribute(s: String, value: String)`: Sets the value of an attribute.
*   `onRendered(callback: () -> Unit)`: Sets a callback to be executed when the component is rendered.
*   `removeAttribute(s: String)`: Removes an attribute.
*   `clearChildren()`: Removes all child components.

### Pre-Built UI Components: Your UI Toolkit

Lumina provides a rich set of pre-built UI components, ready to be used directly or extended to create custom components tailored to your needs:

| Component       | HTML Tag     | Description                                                                                                               | Key Properties                                                                                                                                                                                                                                                                                                       |
| --------------- | ------------ | ------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `Div`           | `<div>`      | A versatile container element.                                                                                             | (Inherits from `Component`)                                                                                                                                                                                                                                                                              |
| `Link`          | `<span>`     | A hyperlink (opens URLs in the default browser).                                                                           | `href`: The URL to navigate to.                                                                                                                                                                                                                                                                              |
| `Section`       | `<section>`  | Represents a thematic section within a page.                                                                               | (Inherits from `Component`)                                                                                                                                                                                                                                                                              |
| `Form`          | `<form>`     | An HTML form for user input.                                                                                               | `action`: Form submission URL. `method`: HTTP method (GET/POST). `enctype`: Encoding type. `target`: Submission response target. `autocomplete`: Autocompletion on/off. `novalidate`: Validation on/off.                                                                                                 |
| `Input`         | `<input>`    | A versatile input field.                                                                                                  | `type`: Input type (text, password, email, etc.). `name`: Field name. `value`: Current value. `placeholder`: Placeholder text. `readonly`: Read-only state. `disabled`: Disabled state. `required`: Required field. `maxLength`: Max characters. `minLength`: Min characters. `size`: Visible width. `autocomplete`: Autocompletion. `pattern`: Validation pattern. |
| `Iframe`        | `<iframe>`   | An inline frame for embedding external content.                                                                            | `src`: URL of the embedded page. `width`: Width. `height`: Height. `frameBorder`: Border width. `allowFullScreen`: Fullscreen capability. `loading`: Loading strategy (eager/lazy). `sandbox`: Sandboxing options. `referrerPolicy`: Referrer policy. `iFrameName`: Frame name. `allow`: Feature policy.    |
| `Image`         | `<img>`      | An image element.                                                                                                         | `src`: Image URL. `alt`: Alternative text. `width`: Width. `height`: Height. `srcset`: Sources for different resolutions. `sizes`: Sizes for different layouts. `loading`: Loading strategy. `decoding`: Decoding hint. `isMap`: Server-side image map. `useMap`: Client-side image map.                     |
| `Audio`         | `<audio>`    | An audio element (extends `Media`).                                                                                      | (Inherits from `Media`)                                                                                                                                                                                                                                                                              |
| `Video`         | `<video>`    | A video element (extends `Media`).                                                                                      | (Inherits from `Media`)                                                                                                                                                                                                                                                                              |
| `Media`         |              | Base class for `Audio` and `Video`.                                                                                       | `autoPlay`: Autoplay. `controls`: Show controls. `crossOrigin`: CORS policy. `loop`: Looping. `muted`: Muted state. `preload`: Preloading hint. `src`: Media URL. `poster`: Poster image (for video). `width`: Width. `height`: Height. `playsInline`: Inline playback hint.                              |
| `Select`        | `<select>`   | A dropdown list.                                                                                                          | (Inherits from `Component`)                                                                                                                                                                                                                                                                              |
| `Option`        | `<option>`   | An option within a `Select` list.                                                                                          | (Inherits from `Component`)                                                                                                                                                                                                                                                                              |
| `Svg`           | `<svg>`      | An SVG element for vector graphics.                                                                                     | `viewBox`: Coordinate system. `xmlns`: XML namespace. `fill`: Fill color. `stroke`: Stroke color. `strokeWidth`: Stroke width. `preserveAspectRatio`: Scaling behavior. Methods: `addPath()`, `addCircle()`, `addRect()`, `addLine()`.                                                                     |
| `Table`         | `<table>`    | A table element.                                                                                                         | `border`: Border width. `cellSpacing`: Space between cells. `cellPadding`: Space within cells. `width`: Width. `height`: Height. `align`: Alignment. `summary`: Description. Methods: `addRow()`, `addHeader()`, `addBody()`, `addFooter()`.                                                                  |
| `TableBody`     | `<tbody>`    | The body section of a table.                                                                                              | `addRow()`: Adds a row.                                                                                                                                                                                                                                                                                   |
| `TableDataCell` | `<td>`       | A data cell within a table row.                                                                                           | (Inherits from `Component`)                                                                                                                                                                                                                                                                              |
| `TableFooter`   | `<tfoot>`    | The footer section of a table.                                                                                             | `addRow()`: Adds a row.                                                                                                                                                                                                                                                                                   |
| `TableHead`     | `<thead>`    | The header section of a table.                                                                                             | `addRow()`: Adds a row.                                                                                                                                                                                                                                                                                   |
| `TableHeaderCell`| `<th>`      | A header cell within a table row.                                                                                           | (Inherits from `Component`)                                                                                                                                                                                                                                                                              |
| `TableRow`      | `<tr>`       | A row within a table.                                                                                                       | `addHeaderCell()`: Adds a header cell. `addDataCell()`: Adds a data cell.                                                                                                                                                                                                                               |

## Styling: Crafting the Visual Identity

Lumina offers flexible styling options to customize the appearance of your components:

### Inline Styles: Direct and Immediate

Apply styles directly to components using the `styles` property:

```kotlin
myDiv.styles.backgroundColor = "red"
myDiv.styles.fontSize = "16px"
myDiv.styles.padding = "10px 20px"
```

### CSS Classes: Reusable and Organized

Define CSS classes in your stylesheets and apply them to components using `setClassName`, `addClassName`, and `removeClassName`:

```kotlin
myDiv.setClassName("my-class")     // Sets the class to "my-class"
myDiv.addClassName("another-class") // Adds "another-class"
myDiv.removeClassName("my-class")  // Removes "my-class"
```

### The `Styles` Class: Comprehensive Control

The `Styles` class provides a vast set of properties mirroring CSS properties, allowing for fine-grained control over component styling. Access it through the `styles` property of any `Component`.

**Example:**

```kotlin
myDiv.styles.apply {
    width = "50%"
    height = "200px"
    border = "1px solid black"
    display = "flex"
    justifyContent = "center"
    alignItems = "center"
}
```

**Note:** For a complete list of available style properties, consult the `lumina.components.styles.*` files. Each file corresponds to a specific CSS property category (e.g., `AlignContent.kt`, `FontWeight.kt`, `Position.kt`), providing detailed options for each category.

## Event Handling: Breathing Life into Your UI

Make your components interactive by attaching event listeners using the `events` property:

```kotlin
myButton.events.onClick { 
    println("Button clicked!")
}

myInput.events.onInput { eventData ->
    val inputValue = eventData?.getAttribute("value") ?: "" // Get input value
    println("Input value changed: $inputValue")
}
```

### The `Events` Class: A World of Events

The `Events` class provides methods for handling a vast array of DOM events, empowering you to create highly responsive UIs.

**Example Events:**

*   **Window Events:** `onAfterprint`, `onBeforeprint`, `onBeforeunload`, `onError`, `onHashchange`, `onLoad`, `onMessage`, `onOffline`, `onOnline`, `onPagehide`, `onPageshow`, `onPopstate`, `onResize`, `onStorage`, `onUnload`
*   **Form Events:** `onBlur`, `onChange`, `onFocus`, `onInput`, `onInvalid`, `onReset`, `onSelect`, `onSearch`, `onSubmit`
*   **Mouse Events:** `onClick`, `onDblclick`, `onContextmenu`, `onMousedown`, `onMousemove`, `onMouseout`, `onMouseover`, `onMouseup`, `onMousewheel`
*   **Drag & Drop Events:** `onDrag`, `onDragend`, `onDragenter`, `onDragleave`, `onDragover`, `onDragstart`, `onDrop`
*   **Keyboard Events:** `onKeydown`, `onKeypress`, `onKeyup`
*   **Animation Events:** `onAnimationStart`, `onAnimationEnd`, `onAnimationIteration`
*   **Transition Events:** `onTransitionEnd`
*   **Touch Events:** `onTouchStart`, `onTouchMove`, `onTouchEnd`, `onTouchCancel`
*   **Pointer Events:** `onPointerDown`, `onPointerMove`, `onPointerUp`, `onPointerCancel`, `onPointerEnter`, `onPointerLeave`, `onPointerOver`, `onPointerOut`, `onGotPointerCapture`, `onLostPointerCapture`
*   **Clipboard Events:** `onCopy`, `onCut`, `onPaste`
*   **Media Events:** `onAbort`, `onCanPlay`, `onCanPlayThrough`, `onDurationChange`, `onEmptied`, `onEncrypted`, `onEnded`, `onLoadedData`, `onLoadedMetadata`, `onLoadStart`, `onPause`, `onPlay`, `onPlaying`, `onProgress`, `onRateChange`, `onSeeked`, `onSeeking`, `onStalled`, `onSuspend`, `onTimeUpdate`, `onVolumeChange`, `onWaiting`
*   **Misc Events:** `onShow`, `onToggle`, `onWheel`, `onScroll`, `onFocusIn`, `onFocusOut`, `onFullscreenChange`, `onFullscreenError`

**Note:** Refer to `Events.kt` for the exhaustive list of supported events.

## Inter-Process Communication (IPC): The Bridge Between Two Worlds

Lumina's IPC system empowers your Kotlin code to communicate seamlessly with JavaScript code running within the WebView, and vice-versa.

### Sending Messages from Kotlin to JavaScript

Execute arbitrary JavaScript code directly from Kotlin using `Lumina.exec()`:

```kotlin
Lumina.exec("alert('Hello from Kotlin!');")
```

### Sending Messages from JavaScript to Kotlin

1. **JavaScript Side:**

    Utilize the `sendMessageToJava` function (provided by Lumina in `ipc.js`) to send messages to the Kotlin backend:

    ```javascript
    function sendMessageToJava(message, event) {
        if (event) {
            event.preventDefault();
            event.stopPropagation();
            let eventData = {};
            let attributes = event.target.attributes;
            for (let i = 0; i < attributes.length; i++) {
                eventData[attributes[i].name] = attributes[i].value;
            }
            eventData.target = { id: event.target.id }
            window.ipc.receiveMessage(JSON.stringify({ id: message.split("::")[0], event: message.split("::")[1] }), eventData);
        } else {
            window.ipc.receiveMessage(message);
        }
    }
    
    
    function waitForElementById(elementId) {
      return new Promise((resolve) => {
        const observer = new MutationObserver((mutationsList, observer) => {
          for (let mutation of mutationsList) {
            if (mutation.type === 'childList') {
              const element = document.getElementById(elementId);
              if (element) {
                observer.disconnect();
                resolve(element);
                window.ipc.onElementReady(elementId);
                return;
              }
            }
          }
        });
    
        observer.observe(document, { childList: true, subtree: true });
      });
    }
    
    document.addEventListener('ipcReady', function (e) {
        window.ipc.onDocumentReady();
    }, false);
    ```

2. **Kotlin Side:**

    Add event listeners to your components using `component.addEvent()`. Your event handler functions will receive the messages sent from JavaScript. The `WebViewIPC.listeners` list stores the registered listeners.

    ```kotlin
    myButton.addEvent("onclick") { component ->
        // Handle the message received from JavaScript
        println("Message from JavaScript: ${component?.id}")
    }
    ```

### Example: Button Click to Update Text

```kotlin
// In your Lumina application:

val myButton = Button("Click Me")
val myText = Div("Initial Text")

myButton.events.onClick {
    myText.setText("Text updated from Kotlin!")
}

Lumina.push(myButton)
Lumina.push(myText)
```

## Utilities: Tools for Common Tasks

Lumina provides several utility classes to streamline common development tasks:

*   **`Date`:**
    *   `getDaysInMonth(year: Int, month: Int)`: Returns a list of `Day` objects representing the days of a given month and year.
*   **`Link`:**
    *   `openLink(url: String)`: Opens the specified URL in the user's default web browser.
*   **`ResourceUtils`:**
    *   `getResourceAsString(name: String)`: Loads a resource file (e.g., from your project's resources folder) as a string.
    *   `getResourcePath(name: String)`: Retrieves the path to a resource file.

## Advanced Usage: Unleashing the Full Potential

### Parsers: Bridging the Gap Between HTML and Lumina

Lumina offers a suite of parsers that can transform raw HTML strings into Lumina `Component` objects, enabling you to dynamically generate UIs from external sources or user input:

*   **`ComponentParser`:** Parses general HTML strings into `Component` hierarchies.
*   **`FormParser`:** Parses HTML forms into `Form` and `Input` components.
*   **`IframeParser`:** Parses HTML iframe elements into `Iframe` components.
*   **`ImageParser`:** Parses HTML image elements into `Image` components.
*   **`SVGParser`:** Parses SVG strings into `Svg` components.
*   **`TableParser`:** Parses HTML tables into `Table` components.

**Example: Parsing HTML with `ComponentParser`**

```kotlin
val htmlString = "<div id=\"myDiv\">Hello, <b>World!</b></div>"
val myComponent = ComponentParser.parseHtmlToComponent(htmlString)

// Access and modify the parsed component
println(myComponent.id)          // Output: myDiv
println(myComponent.childs[0].toString()) // Output: Hello,
println(myComponent.childs[1].tagName)    // Output: b
```

**Note:** The parsers are particularly useful when you need to dynamically generate UI from HTML strings obtained from web APIs, user input, or other external sources.

## Conclusion: Building the Future with Lumina

This documentation has provided a comprehensive exploration of the Lumina UI framework. By mastering the core concepts, leveraging the pre-built components, harnessing the power of styling and event handling, and utilizing the IPC system, you are well-equipped to build sophisticated and interactive desktop applications. Lumina empowers you to combine the elegance and expressiveness of Kotlin with the familiarity and versatility of web technologies.

Remember to delve into the inline documentation (comments within the source code) for in-depth details on specific classes and methods. As you embark on your Lumina journey, explore the possibilities, experiment with the framework's capabilities, and craft exceptional desktop experiences.
