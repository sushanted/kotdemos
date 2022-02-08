package sr.kotcon

import kotlin.concurrent.thread
import kotlin.coroutines.*

suspend fun main() {

    println("Before in thread: ${Thread.currentThread().name}")

    suspendCoroutine<Unit> { continuation ->
        thread(name="ResumingThread") {
            println("Starting thread: ${Thread.currentThread().name}")

            // call resume before main method suspends
            continuation.resume(Unit)
            println("Called resume")
            println("At the end of thread: ${Thread.currentThread().name}")
        }

        // Don't give main method a chance to suspend
        Thread.sleep(2000)
    }

    // This code will run in main thread itself, because
    println("Continued in thread: ${Thread.currentThread().name}")

}

/**
 * OUTPUT:
 *
Before in thread: main
Starting thread: ResumingThread
Called resume
At the end of thread: ResumingThread
Continued in thread: main
 */