package gecw.ace.utils

fun getResourceAsString(name:String):String{
    return object {}.javaClass.getResource("/$name")?.readText() ?: ""
}