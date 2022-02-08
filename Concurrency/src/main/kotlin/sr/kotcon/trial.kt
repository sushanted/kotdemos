package sr.kotcon

import kotlin.concurrent.thread
import kotlin.coroutines.*


fun main(){

       suspend{
           susfun() // on suspend, return to the caller, main continues
           println("${Thread.currentThread().name}")
       }
           .startCoroutine(object : Continuation<Unit>{
           override val context: CoroutineContext
               get() = EmptyCoroutineContext

           override fun resumeWith(result: Result<Unit>) {
               println("resumed")
           }

       })

    println("suspended")

}

suspend fun susfun(){

    println("Start susfun")

    suspendCoroutine<Unit> {
        thread{
            Thread.sleep(2000)
            it.resume(Unit)
        }
    }

    println("End susfun")
}
