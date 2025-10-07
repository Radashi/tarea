package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val itemList: List<ItemModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Esta clase interna representa la vista de cada item en el RecyclerView.
    // Mantiene las referencias a los TextViews para evitar buscarlos repetidamente.
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val descriptionTextView: TextView = view.findViewById(R.id.item_description)
    }

    // Se llama cuando el RecyclerView necesita una nueva vista de item.
    // Infla el layout XML (list_item_layout.xml) y crea un ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    // Se llama para mostrar los datos en una posición específica.
    // Vincula los datos del `itemList` en la posición `position` con las vistas del ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.titleTextView.text = item.title
        holder.descriptionTextView.text = item.description
    }

    // Devuelve el número total de items en la lista de datos.
    // El RecyclerView usa este método para saber cuántos items debe mostrar.
    override fun getItemCount(): Int {
        return itemList.size
    }
}