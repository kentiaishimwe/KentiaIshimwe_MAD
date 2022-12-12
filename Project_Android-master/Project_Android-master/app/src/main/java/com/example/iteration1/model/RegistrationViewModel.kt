package com.example.iteration1.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {

    var farmersList = mutableStateListOf<FarmerRegistration>()

//    fun add (newUser : FarmerRegistration) {
//        farmersList.add(newUser)
//    }


}