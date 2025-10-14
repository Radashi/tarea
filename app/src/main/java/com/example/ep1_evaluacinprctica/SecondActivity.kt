package com.example.ep1_evaluacinprctica // Asegúrate que el paquete sea el correcto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // --- 1. Recibir y mostrar el saludo ---
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        // Recibe el nombre enviado desde MainActivity (si existe)
        val name = intent.getStringExtra("EXTRA_NAME") ?: "Usuario" // Valor por defecto "Usuario"
        tvGreeting.text = "¡Hola, $name!"


        // --- 2. Referencias a los botones ---
        val btnGoToHome = findViewById<Button>(R.id.btnGoToHome)
        val btnOpenCuvalles = findViewById<Button>(R.id.btnOpenCuvalles)


        // --- 3. Lógica para el botón "Ir a Inicio" ---
        btnGoToHome.setOnClickListener {
            // Crea un Intent para volver a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Limpia las actividades anteriores para que no se apilen
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish() // Cierra la actividad actual
        }


        // --- 4. Lógica para el botón "Abrir CUValles" ---
        btnOpenCuvalles.setOnClickListener {
            // Crea un Intent implícito para abrir una URL en el navegador
            val url = "http://www.cuvalles.udg.mx"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}
