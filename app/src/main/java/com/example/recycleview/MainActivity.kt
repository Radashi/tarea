package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Localizar el RecyclerView en el layout.
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // 2. Especificar cómo se deben organizar los items (lineal, cuadrícula, etc.).
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 3. Crear una lista de datos de ejemplo.
        val data = ArrayList<ItemModel>()
        for (i in 1..20) {
            data.add(ItemModel("Item " + i, "Descripción para el item número " + i))
        }

        // 4. Crear una instancia del adaptador personalizado.
        val adapter = CustomAdapter(data)

        // 5. Asignar el adaptador al RecyclerView.
        recyclerView.adapter = adapter
    }
}
