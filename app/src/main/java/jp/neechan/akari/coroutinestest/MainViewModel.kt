package jp.neechan.akari.coroutinestest

import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val textLiveData = liveData {
        printCurrentThread("LiveData block is started")
        emit("Loading...")

        val text = withContext(Dispatchers.IO) {
            printCurrentThread("Stubbing a value on a background thread")
            "Hello, world!"
        }

        printCurrentThread("Should switch back to the UI thread")
        emit(text)
    }

    private fun printCurrentThread(message: String) {
        val threadInfo = "Current thread id: ${Thread.currentThread().id}. UI thread id: ${Looper.getMainLooper().thread.id}"
        println("=================================================================================")
        println(message)
        println(threadInfo)
        println("=================================================================================")
        println()
        println()
    }
}