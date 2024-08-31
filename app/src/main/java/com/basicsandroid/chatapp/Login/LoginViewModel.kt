package com.basicsandroid.chatapp.Login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    val emailState = mutableStateOf("")
    val emailErrorState= mutableStateOf<String?>(null)
    val passwordState = mutableStateOf("")
    val passwordErrorState= mutableStateOf<String?>(null)
    val events= mutableStateOf<LoginViewEvent>(LoginViewEvent.Idle)

    fun validateFields():Boolean{

        if(emailState.value.isEmpty() ||emailState.value.isBlank()){
            emailErrorState.value="Required"
            return false

        }else{
            emailErrorState.value=null
        }
        if (passwordState.value.isEmpty()){
            passwordErrorState.value="Required"
            return false
        }else{
            passwordErrorState.value=null
            if (passwordState.value.length<6){
                passwordErrorState.value="Password Cannot be Less than 6 Characters"
                return false
            }
        }
        return true
    }

    fun navigateToRegistration(){
        events.value=LoginViewEvent.NavigateToRegistration
    }

}