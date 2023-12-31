package com.ffahim.multiple_api_call_coroutions.repository

import android.util.Log
import com.ffahim.multiple_api_call_coroutions.model.Animal
import com.ffahim.multiple_api_call_coroutions.model.Human
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Repository {


    fun returnSomeItems(result: (human: List<Human>, animal: List<Animal>) -> Unit) {

        CoroutineScope(Dispatchers.IO).launch {
            val humansResponse = async {
                Log.e("calling", "humans")
                getHumans()
            }
            val animalsResponse = async {

                Log.e("calling", "animals")
                getAnimals()
            }
            val humans = humansResponse.await()
            val animals = animalsResponse.await()

            result(humans, animals)

        }


    }

    suspend fun getHumans(): List<Human> {

        val list = mutableListOf<Human>()
        for (i in 1..10) {

            list.add(
                Human(
                    "Putin",
                    "Russian"
                )
            )
        }
        delay(1000)
        Log.e("sending ", "get humans")
        return list
    }

    suspend fun getAnimals(): List<Animal> {

        val list = mutableListOf<Animal>()
        for (i in 1..10) {

            list.add(
                Animal(
                    "Bear",
                    "Vodka"
                )
            )
        }
        delay(3000)
        Log.e("sending ", "get animals")
        return list
    }
}