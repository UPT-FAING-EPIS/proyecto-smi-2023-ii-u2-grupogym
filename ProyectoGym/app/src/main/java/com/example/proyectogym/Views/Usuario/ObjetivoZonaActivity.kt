package com.example.proyectogym.Views.Usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.proyectogym.R
import com.example.proyectogym.Views.UserSingleton

class ObjetivoZonaActivity : AppCompatActivity() {

    private var selectedButton: Button? = null
    private val defaultButtonBackgroundResId: Int = R.drawable.fondo_blanco_con_borde
    private var selectedButtonText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivo_zona)

        val buttonTodo = findViewById<Button>(R.id.buttonTodo)
        val buttonBrazo = findViewById<Button>(R.id.buttonBrazo)
        val buttonPecho = findViewById<Button>(R.id.buttonPecho)
        val buttonAbdominales = findViewById<Button>(R.id.buttonAbdominales)
        val buttonPiernas = findViewById<Button>(R.id.buttonPiernas)

        val buttonSiguiente = findViewById<Button>(R.id.buttonSiguiente3)

        buttonTodo.setOnClickListener { onButtonClick(it) }
        buttonBrazo.setOnClickListener { onButtonClick(it) }
        buttonPecho.setOnClickListener { onButtonClick(it) }
        buttonAbdominales.setOnClickListener { onButtonClick(it) }
        buttonPiernas.setOnClickListener { onButtonClick(it) }

        buttonSiguiente.setOnClickListener {
            if (selectedButton != null) {
                val usuario = UserSingleton.getInstance()
                usuario.zona = selectedButtonText
                val intent = Intent(this@ObjetivoZonaActivity, PesoTallaActivity::class.java)
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