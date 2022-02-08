package sr.kotcon

import kotlin.concurrent.thread
import kotlin.coroutines.*

suspend fun main() {

    println("Before in thread: ${Thread.currentThread().name}")

    suspendCoroutine<Unit> { continuation ->
        thread(name="ResumingThread") {
            println("Starting thread: ${Thread.currentThread().name}")

            Thread.sleep(2000) // Give main method a chance to suspend
            // Now resume the suspended flow
            continuation.resume(Unit)
            // This will be printed after completion of suspended flow
            println("At the end of thread: ${Thread.currentThread().name}")
        }
    }

    // All code after suspension will run in the resuming thread.
    println("Resumed in thread: ${Thread.currentThread().name}")

}

/**
 * OUTPUT:
 *
Before in thread: main
Starting thread: ResumingThread
Resumed in thread: ResumingThread
At the end of thread: ResumingThread
 */