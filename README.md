Okay, here is a comprehensive documentation for the Lumina project, a Kotlin-based UI framework.

**Lumina UI Framework Documentation**

**Introduction**

Lumina is a modern Kotlin UI framework designed for building dynamic and interactive web-based user interfaces embedded within desktop applications. It leverages the power of JavaFX's WebView to render web content, enabling you to create desktop applications using familiar web technologies like HTML, CSS, and JavaScript, while being written in Kotlin.

**Core Concepts**

1. **`Lumina` Class:** The entry point for your application. It initializes the JavaFX WebView, sets up the initial HTML structure, and manages the application's lifecycle.

2. **`Component` Class:** The fundamental building block of your UI. All UI elements, from simple divs to complex custom components, are derived from this class.

3. **Styling:** Lumina supports both inline styles and CSS classes for styling components. It also provides a `Styles` class for programmatic manipulation of styles.

4. **Event Handling:** Events are handled using the `Events` class, which allows you to attach listeners to various DOM events and execute Kotlin code in response.

5. **Inter-Process Communication (IPC):** Lumina provides a built-in IPC mechanism to communicate between the Kotlin backend and the JavaScript frontend running inside the WebView.

**Getting Started**

**Project Setup**

1. **Maven Dependency:** Add the Lumina dependency to your `pom.xml`:

    ```xml
    <dependency>
        <groupId>lumina</groupId>
        <artifactId>Lumina</artifactId>
        <version>2.0.3</version>
    </dependency>
    ```

2. **JavaFX Dependencies:** Ensure you have the required JavaFX dependencies:

    ```xml
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>YOUR_JAVAFX_VERSION</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>YOUR_JAVAFX_VERSION</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-web</artifactId>
        <version>YOUR_JAVAFX_VERSION</version>
    </dependency>
    ```

**Creating a Basic Lumina Application**

```kotlin
import lumina.Lumina
import lumina.components.ui.Div
import lumina.components.ui.component.Component
import javafx.application.Application
import javafx.stage.Stage

class MyApp : Lumina() {

    override fun start(primaryStage: Stage) {
        super.start(primaryStage)
        Lumina.setTitle("My Lumina App") // Set window title
    }

    override fun onWindowCreated() {
        // Create a simple Div component
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

**Explanation**

*   **`class MyApp : Lumina()`:** Your main application class extends `Lumina`.
*   **`start(primaryStage: Stage)`:** The main entry point, called by JavaFX.
*   **`onWindowCreated()`:** A callback function that's executed after the WebView has finished loading the initial HTML template. This is where you'll build and add your UI components.
*   **`Lumina.push(myDiv)`:** Adds the `myDiv` component to the root of the HTML document.
*   **`Lumina.setTitle()`:** Sets the title of the application's window.

**Components**

**`Component` Class**

The base class for all UI elements.

**Properties:**

*   `tagName`: The HTML tag name (e.g., "div", "span", "img").
*   `id`: A unique identifier for the component.
*   `rendered`: Indicates whether the component has been rendered in the WebView.
*   `styles`: An instance of `Styles` to manage the component's styles.
*   `attributes`: An instance of `Attributes` to manage the component's HTML attributes.
*   `events`: An instance of `Events` to handle events.
*   `onReady`: A callback function that is executed after the component's corresponding DOM element is fully rendered and ready in the WebView.

**Methods:**

*   `addChild(child: Component)`: Adds a child component.
*   `addChildAtBeginning(child: Component)`: Adds a child component to the beginning.
*   `addText(text: String)`: Adds text content.
*   `setText(text: String)`: Sets the text content (overwrites existing content).
*   `setChild(child: Component)`: Replaces all children with a single child component.
*   `setClassName(className: String)`: Sets the CSS class name(s).
*   `addClassName(className: String)`: Adds a CSS class name.
*   `removeClassName(className: String)`: Removes a CSS class name.
*   `render(): String`: Returns the HTML representation of the component.
*   `addEvent(event: String, action: (data: Component?) -> Unit)`: Attaches an event listener.
*   `removeEvent(listener: Listener)`: Removes an event listener.
*   `remove()`: Removes the component from the DOM.
*   `getStyle(style: String)`: Gets the value of a style property.
*   `getAttribute(attribute: String)`: Gets the value of an attribute.
*   `setAttribute(s: String, value: String)`: Sets the value of an attribute.
*   `onRendered(callback: () -> Unit)`: Sets a callback to be executed when the component is rendered.
*   `removeAttribute(s: String)`: Removes an attribute.
*   `clearChildren()`: Removes all child components.

**UI Components**

Lumina provides a set of pre-built UI components that you can use directly or extend to create your own custom components.

*   **`Div`:** A basic container element (`<div>`).
*   **`Link`:** A hyperlink (`<span>` with click event to open the link).
*   `href`: The URL the link points to.
*   **`Section`:** A section element (`<section>`).
*   **`Form`:** A form element (`<form>`).
    *   `action`: The URL to submit the form data to.
    *   `method`: The HTTP method for form submission (e.g., "get", "post").
    *   `enctype`: The encoding type for form data.
    *   `target`: The target window or frame for the form submission response.
    *   `autocomplete`: Enables or disables form autocompletion.
    *   `novalidate`: Disables form validation.
*   **`Input`:** An input field (`<input>`).
    *   `type`: The input type (e.g., "text", "password", "email", "number").
    *   `name`: The name of the input field.
    *   `value`: The current value of the input field.
    *   `placeholder`: Placeholder text displayed when the input is empty.
    *   `readonly`: Makes the input field read-only.
    *   `disabled`: Disables the input field.
    *   `required`: Makes the input field required.
    *   `maxLength`: The maximum number of characters allowed.
    *   `minLength`: The minimum number of characters required.
    *   `size`: The visible width of the input field.
    *   `autocomplete`: Enables or disables input autocompletion.
    *   `pattern`: A regular expression that the input value must match.
*   **`Iframe`:** An inline frame (`<iframe>`).
    *   `src`: The URL of the page to embed.
    *   `width`: The width of the iframe.
    *   `height`: The height of the iframe.
    *   `frameBorder`: The border width of the iframe.
    *   `allowFullScreen`: Allows the iframe to be displayed in fullscreen mode.
    *   `loading`: Specifies how the iframe should be loaded ("eager" or "lazy").
    *   `sandbox`: Enables sandboxing restrictions for the iframe content.
    *   `referrerPolicy`: Controls how much referrer information is sent with requests from the iframe.
    *   `iFrameName`: The name of the iframe.
    *   `allow`: Specifies a feature policy for the iframe.
*   **`Image`:** An image element (`<img>`).
    *   `src`: The URL of the image.
    *   `alt`: Alternative text for the image.
    *   `width`: The width of the image.
    *   `height`: The height of the image.
    *   `srcset`: A set of image sources for different screen sizes or resolutions.
    *   `sizes`: Specifies the image sizes for different layouts.
    *   `loading`: Specifies how the image should be loaded ("eager" or "lazy").
    *   `decoding`: Provides a hint to the browser on how to decode the image ("sync", "async", or "auto").
    *   `isMap`: Indicates whether the image is part of a server-side image map.
    *   `useMap`: Specifies the name of a client-side image map to use.
*   **`Audio`:** An audio element (`<audio>`) - extends `Media`.
*   **`Video`:** A video element (`<video>`) - extends `Media`.
*   **`Media`:** Base class for `Audio` and `Video`.
    *   `autoPlay`: Automatically starts playing the media.
    *   `controls`: Shows the browser's default media controls.
    *   `crossOrigin`: Sets the CORS (Cross-Origin Resource Sharing) policy.
    *   `loop`: Loops the media playback.
    *   `muted`: Mutes the media.
    *   `preload`: Provides a hint to the browser about how much media data to preload.
    *   `src`: The URL of the media file.
    *   `poster`: The URL of an image to display before the video starts.
    *   `width`: The width of the video.
    *   `height`: The height of the video.
    *   `playsInline`: Hints that the video should play inline (not fullscreen).
*   **`Select`:** A dropdown list (`<select>`).
*   **`Option`:** An option within a select list (`<option>`).
*   **`Svg`:** An SVG element (`<svg>`).
    *   `viewBox`: Defines the coordinate system and aspect ratio of the SVG.
    *   `xmlns`: The XML namespace for SVG elements.
    *   `fill`: The fill color of SVG shapes.
    *   `stroke`: The stroke color of SVG shapes.
    *   `strokeWidth`: The width of the stroke.
    *   `preserveAspectRatio`: Controls how the SVG scales to fit its container.
    *   `addPath()`: Adds a path element to the SVG.
    *   `addCircle()`: Adds a circle element to the SVG.
    *   `addRect()`: Adds a rectangle element to the SVG.
    *   `addLine()`: Adds a line element to the SVG.
*   **`Table`:** A table element (`<table>`).
    *   `border`: The width of the table border.
    *   `cellSpacing`: The space between cells.
    *   `cellPadding`: The space between cell content and the cell border.
    *   `width`: The width of the table.
    *   `height`: The height of the table.
    *   `align`: The horizontal alignment of the table.
    *   `summary`: A description of the table's content (for accessibility).
    *   `addRow()`: Adds a row to the table.
    *   `addHeader()`: Adds a header section to the table.
    *   `addBody()`: Adds a body section to the table.
    *   `addFooter()`: Adds a footer section to the table.
*   **`TableBody`:** The body of a table (`<tbody>`).
    *   `addRow()`: Adds a row to the table body.
*   **`TableDataCell`:** A data cell within a table row (`<td>`).
*   **`TableFooter`:** The footer of a table (`<tfoot>`).
    *   `addRow()`: Adds a row to the table footer.
*   **`TableHead`:** The header of a table (`<thead>`).
    *   `addRow()`: Adds a row to the table header.
*   **`TableHeaderCell`:** A header cell within a table row (`<th>`).
*   **`TableRow`:** A row within a table (`<tr>`).
    *   `addHeaderCell()`: Adds a header cell to the row.
    *   `addDataCell()`: Adds a data cell to the row.

**Styling**

**Inline Styles**

You can set inline styles using the `styles` property of a component:

```kotlin
myDiv.styles.backgroundColor = "red"
myDiv.styles.fontSize = "16px"
myDiv.styles.padding = "10px 20px"
```

**CSS Classes**

You can add or remove CSS classes using the `setClassName`, `addClassName`, and `removeClassName` methods:

```kotlin
myDiv.setClassName("my-class") // Sets the class to "my-class"
myDiv.addClassName("another-class") // Adds "another-class"
myDiv.removeClassName("my-class") // Removes "my-class"
```

**`Styles` Class**

The `Styles` class provides a comprehensive set of properties to control the appearance of components. You can access it through the `styles` property of a `Component`.

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

**Note:**  A complete list of available style properties is provided in the code files `lumina.components.styles.*`. Each file represents a specific CSS property category (e.g., `AlignContent.kt`, `FontWeight.kt`, `Position.kt`, etc.). You can refer to these files for a detailed list of options.

**Event Handling**

Use the `events` property of a component to attach event listeners:

```kotlin
myButton.events.onClick { 
    println("Button clicked!")
}

myInput.events.onInput { eventData ->
    val inputValue = eventData?.getAttribute("value") ?: "" // Get input value
    println("Input value changed: $inputValue")
}
```

**`Events` Class**

The `Events` class provides methods for handling a wide range of DOM events.

**Example Events:**

*   `onAfterprint`, `onBeforeprint`, `onBeforeunload`, `onError`, `onHashchange`, `onLoad`, `onMessage`, `onOffline`, `onOnline`, `onPagehide`, `onPageshow`, `onPopstate`, `onResize`, `onStorage`, `onUnload`
*   `onBlur`, `onChange`, `onFocus`, `onInput`, `onInvalid`, `onReset`, `onSelect`, `onSearch`, `onSubmit`
*   `onClick`, `onDblclick`, `onContextmenu`
*   `onDrag`, `onDragend`, `onDragenter`, `onDragleave`, `onDragover`, `onDragstart`, `onDrop`
*   `onMousedown`, `onMousemove`, `onMouseout`, `onMouseover`, `onMouseup`, `onMousewheel`
*   `onScroll`
*   `onShow`, `onToggle`
*   `onWheel`
*   `onKeydown`, `onKeypress`, `onKeyup`
*   `onMouseEnter`, `onMouseLeave`
*   `onAnimationStart`, `onAnimationEnd`, `onAnimationIteration`
*   `onTransitionEnd`
*   `onTouchStart`, `onTouchMove`, `onTouchEnd`, `onTouchCancel`
*   `onPointerDown`, `onPointerMove`, `onPointerUp`, `onPointerCancel`, `onPointerEnter`, `onPointerLeave`, `onPointerOver`, `onPointerOut`
*   `onGotPointerCapture`, `onLostPointerCapture`
*   `onCopy`, `onCut`, `onPaste`
*   `onAbort`, `onCanPlay`, `onCanPlayThrough`, `onDurationChange`, `onEmptied`, `onEncrypted`, `onEnded`
*   `onLoadedData`, `onLoadedMetadata`, `onLoadStart`, `onPause`, `onPlay`, `onPlaying`, `onProgress`, `onRateChange`, `onSeeked`, `onSeeking`, `onStalled`, `onSuspend`, `onTimeUpdate`, `onVolumeChange`, `onWaiting`
*   `onFocusIn`, `onFocusOut`, `onFullscreenChange`, `onFullscreenError`
*   And more... (refer to `Events.kt` for the complete list)

**Inter-Process Communication (IPC)**

Lumina's IPC system allows your Kotlin code to communicate with JavaScript code running in the WebView and vice-versa.

**Sending Messages from Kotlin to JavaScript**

```kotlin
Lumina.exec("alert('Hello from Kotlin!');") // Execute arbitrary JavaScript code
```

**Sending Messages from JavaScript to Kotlin**

1. **JavaScript:** Use the `sendMessageToJava` function (provided by Lumina in `ipc.js`) to send messages:

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

2. **Kotlin:** Add event listeners using `component.addEvent()` and handle messages in your event handler functions. The `WebViewIPC.listeners` list stores the registered listeners.

    ```kotlin
    myButton.addEvent("onclick") { component ->
        // Handle the message received from JavaScript
        println("Message from JavaScript: ${component?.id}") 
    }
    ```

**Example: Button Click to Update Text**

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

**Utilities**

*   **`Date`:**
    *   `getDaysInMonth(year: Int, month: Int)`: Returns a list of `Day` objects for a given month and year.
*   **`Link`:**
    *   `openLink(url: String)`: Opens a URL in the default web browser.
*   **`ResourceUtils`:**
    *   `getResourceAsString(name: String)`: Loads a resource file as a string.
    *   `getResourcePath(name: String)`: Gets the path to a resource file.

**Advanced Usage**

*   **`ComponentParser`:** Parse HTML strings into Lumina `Component` objects.
*   **`FormParser`:** Parse HTML forms into `Form` and `Input` components.
*   **`IframeParser`:** Parse HTML iframes into `Iframe` components.
*   **`ImageParser`:** Parse HTML images into `Image` components.
*   **`SVGParser`:** Parse SVG strings into `Svg` components.
*   **`TableParser`:** Parse HTML tables into `Table` components.

**Example: Parsing HTML**

```kotlin
val htmlString = "<div id=\"myDiv\">Hello, <b>World!</b></div>"
val myComponent = ComponentParser.parseHtmlToComponent(htmlString)

// Access and modify the parsed component
println(myComponent.id) // Output: myDiv
println(myComponent.childs[0].toString()) // Output: Hello,
println(myComponent.childs[1].tagName) // Output: b
```

**Note:** The parsers are useful for dynamically generating UI from HTML strings obtained from external sources (e.g., web APIs, user input).

**Conclusion**

This documentation provides a comprehensive overview of the Lumina UI framework. By understanding the core concepts, components, styling, event handling, and IPC mechanisms, you can start building powerful and interactive desktop applications using the elegance and expressiveness of Kotlin combined with the familiarity of web technologies. Remember to refer to the inline documentation (comments in the source code) for more specific details on individual classes and methods.
