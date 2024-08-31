package com.basicsandroid.chatapp.Register

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.basicsandroid.chatapp.model.AppUser
import com.basicsandroid.chatapp.model.FirebaseUtils
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class RegisterViewModel: ViewModel() {
    val firstNameState= mutableStateOf("")
    val firstNameErrorState= mutableStateOf<String?>(null)
    val emailState= mutableStateOf("")
    val emailErrorState= mutableStateOf<String?>(null)
    val passwordState= mutableStateOf("")
    val passwordErrorState= mutableStateOf<String?>(null)
    val auth=Firebase.auth

    fun validateFields():Boolean{
        if(firstNameState.value.isEmpty() || firstNameState.value.isBlank()){
            firstNameErrorState.value="Required"
            return false
        }else{
            firstNameErrorState.value=null
        }
        if(emailState.value.isEmpty() || emailState.value.isBlank()){
            emailErrorState.value="Required"
            return false
        }else{
            emailErrorState.value=null
        }
        if(passwordState.value.isEmpty() || passwordState.value.isBlank()){
            passwordErrorState.value="Required"
            return false
        }else{

            passwordErrorState.value=null
        }

        return true
    }
    fun authenticationUser(){
        if(!validateFields()) return
        auth.createUserWithEmailAndPassword(emailState.value,passwordState.value)
            .addOnCompleteListener{task->
                if(!task.isSuccessful){
                    Log.e("TAG","authenticationUser: ${task.exception?.message}")
                    return@addOnCompleteListener
                }

                val uid=task.result.user?.uid
                addUserToFireStore(uid!!)
            }

    }
    fun addUserToFireStore(uid:String){
        val user=AppUser(uid, firstname = firstNameState.value,emailState.value)


    }

}