package com.example.proyectogym.Views.Usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.proyectogym.R
import com.example.proyectogym.Views.UserSingleton

class NivelActivity : AppCompatActivity() {

    private var selectedButton: Button? = null
    private val defaultButtonBackgroundResId: Int = R.drawable.fondo_blanco_con_borde
    private var selectedButtonText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel)

        val buttonPrincipiante = findViewById<Button>(R.id.buttonPrincipiante)
        val buttonIntermedio = findViewById<Button>(R.id.buttonIntermedio)
        val buttonAvanzado = findViewById<Button>(R.id.buttonAvanzado)
        val buttonSiguiente1 = findViewById<Button>(R.id.buttonSiguiente1)

        buttonPrincipiante.setOnClickListener { onButtonClick(it) }
        buttonIntermedio.setOnClickListener { onButtonClick(it) }
        buttonAvanzado.setOnClickListener { onButtonClick(it) }

        buttonSiguiente1.setOnClickListener {
            if (selectedButton != null) {
                val usuario = UserSingleton.getInstance()
                usuario.nivel = selectedButtonText
                val intent = Intent(this@NivelActivity, ObjetivoActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun onButtonClick(view: View) {
        val clickedButton = view as Button

        if (clickedButton != selectedButton) {
            selectedButton?.setBackgroundResource(defaultButtonBackgroundResId)
            selectedButton?.setTextColor(resources.getColor(R.color.black))

            clickedButton.setBackgroundResource(R.color.app_theme)
            clickedButton.setTextColor(resources.getColor(android.R.color.white))
            selectedButton = clickedButton
            selectedButtonText = clickedButton.text.toString()

        } else {

            clickedButton.setBackgroundResource(defaultButtonBackgroundResId)
            clickedButton.setTextColor(resources.getColor(R.color.black))

            selectedButton = null
            selectedButtonText = ""

        }
    }

}