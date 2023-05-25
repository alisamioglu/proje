package com.samioglu.newp1



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.samioglu.newp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth


    }


    fun signInClicked(view : View) {

        val userEmail = binding.userEmailText.text.toString()
        val password = binding.passwordText.text.toString()

        if (userEmail.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(userEmail,password).addOnCompleteListener  { task ->

                if (task.isSuccessful) {
                    //Signed In
                    Toast.makeText(applicationContext,"Hoşgeldin: ${auth.currentUser?.email.toString()}",Toast.LENGTH_LONG).show()
                    val intent = Intent(applicationContext, MainActivity2::class.java)
                    startActivity(intent)
                    finish()

                }

            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }



    }

    fun signUpClicked(view : View) {

        val userEmail = binding.userEmailText.text.toString()
        val password = binding.passwordText.text.toString()

        if (userEmail.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(userEmail,password).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    val intent = Intent(applicationContext, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                }

            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()

            }
        }



    }
}
