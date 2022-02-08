package sr.kotcon

import kotlin.coroutines.*

suspend fun main() {

    println("Before")

    // After this call, main returns with SUSPENDED, the lambda passed is called in another invocation of main.
    suspendCoroutine<Unit> { continuation ->
        println("Not Resuming")
        //continuation.resume(Unit)
    }

    println("After")
}

