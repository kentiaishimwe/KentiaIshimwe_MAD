package com.example.iteration1.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

data class FarmerRegistration (val name : String,
                          val phone_number : String,
                          val location : String,
                          val crops : String,
                          val email : String,
                          val passw : String,
                          val confpassw : String) {

}