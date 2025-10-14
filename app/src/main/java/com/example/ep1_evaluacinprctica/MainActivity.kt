package com.example.ep1_evaluacinprctica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Aplicar padding para las barras del sistema (gestos de borde a borde)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener referencias a las vistas del layout
        val btnAccept = findViewById<Button>(R.id.btnAccept)
        val etName = findViewById<EditText>(R.id.etName)

        // Configurar el listener del botón
        btnAccept.setOnClickListener {
            val name = etName.text.toString()

            // Crear un Intent para abrir SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // Añadir el nombre como un "extra" al Intent
            intent.putExtra("EXTRA_NAME", name)

            // Iniciar la nueva actividad
            startActivity(intent)
        }
    }
}
