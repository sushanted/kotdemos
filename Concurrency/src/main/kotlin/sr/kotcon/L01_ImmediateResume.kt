package sr.kotcon

import kotlin.coroutines.*

suspend fun main() {

    println("Before")

    // After this call, the lambda passed is called and then the main method is tried to be suspended.
    suspendCoroutine<Unit> { continuation ->
        println("Resuming")
        continuation.resume(Unit) // The main method is not suspended yet, because lambda is still running, but we called resume
        println("will resume")
    }
    // main method will not suspend because resume was already called in the lambda (and the result (Unit) is already available),
    // it will just continue.
    println("After")
}

/**
 *
Before
Resuming
will resume
After
 */