package com.basicsandroid.chatapp.model

import com.basicsandroid.chatapp.Constants
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

object FirebaseUtils {
    fun addUser(user:AppUser){
        Firebase.firestore.collection(Constants.USERS)
            .document(user.uid!!)
            .set(user)
            .addOnSuccessListener {

            }
            .addOnFailureListener{
                
            }
    }
}