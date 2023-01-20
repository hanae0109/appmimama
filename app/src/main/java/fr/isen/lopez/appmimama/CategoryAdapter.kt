package fr.isen.lopez.appmimama

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.lopez.appmimama.model.Items
import kotlin.collections.ArrayList

class CategoryAdapter(var dishes: ArrayList<Items>, val onItemClickListener: (Items) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellName = view.findViewById<TextView>(R.id.cellName)
        val cellPicture = view.findViewById<TextView>(R.id.cellPicture)
        val cellPrice = view.findViewById<TextView>(R.id.cellPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_cell, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dishes = dishes[position]
        holder.cellName.text = dishes.nameFr
        holder.cellPrice.text = dishes.prices[0].price

        val firstImage = dishes.images[0]
        if (firstImage.isNotEmpty()) {
            Picasso.get().load(firstImage).into(holder.cellPicture)
        }

        holder.itemView.setOnClickListener {
            onItemClickListener(dishes)
        }
    }

    override fun getItemCount(): Int =dishes.size

    fun refreshList(dishesFromAPI: ArrayList<Items>){
        dishes = dishesFromAPI
        notifyDataSetChanged()
    }

}