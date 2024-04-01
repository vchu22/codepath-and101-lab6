package com.driuft.random_pets_starter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PetAdapter(petList: MutableList<String>) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {
    private val petList: List<String> = petList

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView

        init {
            // Find our RecyclerView item's ImageView for future use
            petImage = view.findViewById(R.id.pet_image)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.pet_item, p0, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = petList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        Glide.with(p0.itemView)
            .load(petList[p1])
            .centerCrop()
            .into(p0.petImage)
        p0.petImage.setOnClickListener {
            Toast.makeText(p0.itemView.context, "Doggo at position $p1 clicked", Toast.LENGTH_SHORT).show()
        }
    }
}