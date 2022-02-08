fun main() {

    // Note * can be applied only to arrays, not to lists
   var ar = arrayOf("A","B","C")

    printAll(*ar)
}

fun printAll(vararg args:String){
    for (arg in args){
        println(arg)
    }
}