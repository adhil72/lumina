package lumina.utils

import java.awt.Desktop
import java.net.URI

fun openLink(url: String) {
    if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().browse(URI(url))
    } else {
        println("Desktop is not supported")
    }
}