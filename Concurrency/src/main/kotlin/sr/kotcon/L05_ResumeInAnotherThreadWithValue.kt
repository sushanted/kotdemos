package sr.kotcon

import kotlin.concurrent.thread
import kotlin.coroutines.*

suspend fun main() {

    println("Before in thread ${Thread.currentThread()}")

    val result = suspendCoroutine<String> { continuation ->
        thread(name="ResumingThread") {
            println("Resuming in thread ${Thread.currentThread()}")
            // This will complete the suspended flow
            continuation.resume("Hello")
            // This will be printed after completion of suspended flow
            println("After Resuming in thread ${Thread.currentThread()}")
        }
        Thread.sleep(2000)
        println("Suspending...")
    }

    println("Waiting...")
    Thread.sleep(1000)
    // All code after suspension will run in the resuming thread.
    println("After in thread ${Thread.currentThread()}, with result $result")

    /**
        Before in thread Thread[main,5,main]
        Resuming in thread Thread[ResumingThread,5,main]
        Waiting...
        After in thread Thread[ResumingThread,5,main], with result Hello
        After Resuming in thread Thread[ResumingThread,5,main]
     */

}

