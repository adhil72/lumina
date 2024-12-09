package lumina.modals

import lumina.components.ui.component.Component

data class Listener(var id: String, var event: String, var action: (data: Component?) -> Unit)