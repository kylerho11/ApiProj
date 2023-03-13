package com.example.apiproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class BallAdapter(var dataSet: List<PlayerData>) : RecyclerView.Adapter<BallAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        val layout: ConstraintLayout

        init {
            textViewName = view.findViewById(R.id.textView_Name)

            layout = view.findViewById(R.id.layout_viewHolder)
        }


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_player, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //var context = viewHolder.textViewName.context
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val hero = dataSet[position]
        viewHolder.textViewName.text = hero.first_name +" "+  hero.last_name

        viewHolder.layout.setOnClickListener(){
            val detailIntent = Intent(it.context, PlayerDetailView::class.java)
            detailIntent.putExtra(PlayerDetailView.EXTRA_ID, hero)
            it.context.startActivity(detailIntent)
        }

    }
    override fun getItemCount() = dataSet.size

}