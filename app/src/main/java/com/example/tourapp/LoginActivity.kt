package com.example.tourapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import repositories.UserRepository

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonSingUp = findViewById<Button>(R.id.buttonSingUp)
        buttonSingUp.setOnClickListener {
            setup()
        }

        val buttonLogin = findViewById<Button>(R.id.buttonStart)
        buttonLogin.setOnClickListener {
            login()
        }
    }

    private fun setup() {

        val editTextName: EditText = findViewById(R.id.editTextTextName)
        val editTextPass: EditText = findViewById(R.id.editTextTextPassword)

        // Asigna el nickname y password cuando se hace clic en el botón
        val nickname = editTextName.text.toString()
        val password = editTextPass.text.toString()

        // Realiza la validación, llamando a una función de validación
        if (nickname.isNotBlank() && password.isNotBlank()) {
            val user = UserRepository.enabledUser(nickname, password)
            if (user != null) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                /*FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(nickname, password)
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            showPurchase(it.result?.user?.email ?: "", ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                    }*/
            } else {
                // Muestra un mensaje de error al usuario
                Toast.makeText(this, "Invalid nickname or password. Try again", Toast.LENGTH_SHORT).show()
            }
        }else {
            // Muestra un mensaje si los campos están vacíos
            Toast.makeText(this, "Please enter both nickname and password", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun login(){

        val editTextName: EditText = findViewById(R.id.editTextTextName)
        val editTextPass: EditText = findViewById(R.id.editTextTextPassword)

        // Asigna el nickname y password cuando se hace clic en el botón
        val nickname = editTextName.text.toString()
        val password = editTextPass.text.toString()

        // Realiza la validación, llamando a una función de validación
            if (nickname.isNotBlank() && password.isNotBlank()) {
                val user = UserRepository.enabledUser(nickname, password)
                if (user != null) {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    showPurchase(user.id)
                    /*FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(nickname, password)
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                showPurchase(it.result?.user?.email ?: "", ProviderType.BASIC)
                            }else{
                                showAlert()
                            }
                        }*/
                } else {
                    // Muestra un mensaje de error al usuario
                    Toast.makeText(this, "Invalid nickname or password. Try again", Toast.LENGTH_SHORT).show()
                }
            }else {
                // Muestra un mensaje si los campos están vacíos
                Toast.makeText(this, "Please enter both nickname and password", Toast.LENGTH_SHORT)
                    .show()
            }
    }
    /*private fun showAlert() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("An error occurred authenticating the user")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }*/
    private fun showPurchase(userId: Long){
        //Creo un Intent para iniciar la proxima activity
        val purchaseIntent = Intent(this, PurchaseActivity::class.java).apply {
            //Paso en el Intent los valores obtenidos en el regitro
            putExtra("userId", userId)
        }
        //Comienzo la proxima activity
        startActivity(purchaseIntent)
        //El finish permite que el usuario no pueda volver a la pagina de registro clicando atras
        finish()
    }
}