package lumina.modals

data class IpcMessage(
    val id: String,
    val event: String
) {
    companion object {
        fun fromJson(message: String): IpcMessage {
            val parts = message.split("::")
            return IpcMessage(parts[0], parts[1])
        }
    }
}