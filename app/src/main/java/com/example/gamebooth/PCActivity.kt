package com.example.gamebooth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class PCActivity : AppCompatActivity() {
    
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerViewGameAdapter : RecyclerViewGameAdapter
    private var gameList =  ArrayList<Games>()
    private lateinit var searchView: SearchView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pcactivity)

        searchView = findViewById(R.id.mSearchBarpc)

        recyclerView = findViewById(R.id.PCgames) as RecyclerView
        recyclerViewGameAdapter = RecyclerViewGameAdapter(this, gameList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerViewGameAdapter

        prepareGameListData()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }
    private fun prepareGameListData() {
        var game = Games("GTA V", R.drawable.img_13, "PC", "Rent")
        gameList.add(game)

        game = Games("Minecraft", R.drawable.img_33, "PC", "Rent")
        gameList.add(game)

        game = Games("Hades", R.drawable.img_34, "PC", "Rent")
        gameList.add(game)

        game = Games("Elden Ring", R.drawable.img_35 ,"PC", "Rent")
        gameList.add(game)

        game = Games("Cuphead", R.drawable.img_36, "PC", "Rent")
        gameList.add(game)

        game = Games("Half-life Alyx", R.drawable.img_37, "PC", "Rent")
        gameList.add(game)

        game = Games("Forza Horizon 4", R.drawable.img_38, "PC", "Rent")
        gameList.add(game)

        game = Games("Kamaitachi no yoru", R.drawable.img_84, "PC" , "Rent")
        gameList.add(game)

        game = Games("Mega man Zero", R.drawable.img_85, "PC" , "Rent")
        gameList.add(game)

        game = Games("StreetFighter 2", R.drawable.img_86, "PC" , "Rent")
        gameList.add(game)

        game = Games("Pacific Rim", R.drawable.img_87, "PC" , "Rent")
        gameList.add(game)

        game = Games("Hunt the Wumpus", R.drawable.img_88, "PC" , "Rent")
        gameList.add(game)

        game = Games("Sangokushi Taisen", R.drawable.img_89, "PC" , "Rent")
        gameList.add(game)

        game = Games("Bomberman", R.drawable.img_90, "PC" , "Rent")
        gameList.add(game)

        game = Games("Bubsy 2", R.drawable.img_91, "PC" , "Rent")
        gameList.add(game)

        recyclerViewGameAdapter!!.notifyDataSetChanged()
    }
    private fun filterList(query:String?){
        if(query != null){
            val filteredList = ArrayList<Games>()
            for(i in gameList){
                if (i.title.toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()){
                Toast.makeText(this, "No Games found" , Toast.LENGTH_SHORT).show()
            }else{
                recyclerViewGameAdapter.setFilteredList(filteredList)
            }
        }
    }
}