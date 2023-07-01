package com.example.gamebooth

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewGameAdapter(var context: Context ,private var gameList: List<Games>) :
    RecyclerView.Adapter<RecyclerViewGameAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_home_games, parent, false)
        return MyViewHolder(view)
    }
    fun filterList(filterList: ArrayList<Games>){
        gameList = filterList
        notifyDataSetChanged()
    }
    fun setFilteredList(gameList: List<Games>){
        this.gameList = gameList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.gameTitle.text  = gameList[position].title
        holder.gamesimg.setImageResource(gameList[position].image)
        holder.console.text = gameList[position].console
        holder.renting.text = gameList[position].rent
        holder.renting.setOnClickListener {
            val intent = Intent(context,DetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val gameTitle : TextView = itemView.findViewById(R.id.gameTitle)
        val gamesimg : ImageView = itemView.findViewById(R.id.gamesimg)
        val renting : TextView  = itemView.findViewById(R.id.Rent)
        val console : TextView = itemView.findViewById(R.id.gameConsole)

    }
}

