package com.ml.qasey.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class  LoginDatasource @Inject constructor( private val firebaseAuth: FirebaseAuth) {

    fun loginFirebase(username: String, password:String, onNavigate: () -> Unit) {

        firebaseAuth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onNavigate()

                    //login correcto
                    Log.d("TAB----", "Login success")
                } else {
                    
                    //login fallido
                    Log.d("TAB----", "Login failure")
                }
            }
    }


}