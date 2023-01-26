package fr.isen.lopez.appmimama

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.lopez.appmimama.model.Items
import kotlin.collections.ArrayList

class CategoryAdapter(var dishes: ArrayList<String>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellName = view.findViewById<TextView>(R.id.cellName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_cell, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dishes = dishes[position]
        holder.cellName.text = dishes

    }

    override fun getItemCount(): Int =dishes.size

    fun refreshList(dishesFromAPI: ArrayList<String>){
        for(value in dishes){
            println("plat : " + value)
        }
        dishes = dishesFromAPI
        notifyDataSetChanged()
    }

}