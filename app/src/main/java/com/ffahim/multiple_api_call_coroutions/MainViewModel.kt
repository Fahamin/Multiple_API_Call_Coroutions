package com.ffahim.multiple_api_call_coroutions

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ffahim.multiple_api_call_coroutions.repository.Repository

class MainViewModel : ViewModel() {

    val repository: Repository = Repository()

    fun doSomeApiCalls() {
        repository.returnSomeItems { human, animal ->
            Log.e("humans", human.toString())
            Log.e("animals", animal.toString())
        }
    }

}