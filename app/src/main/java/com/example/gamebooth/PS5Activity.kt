package com.example.gamebooth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.compose.ui.text.toLowerCase
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class PS5Activity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerViewGameAdapter : RecyclerViewGameAdapter
    private var gameList =  ArrayList<Games>()
    private lateinit var searchView:SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ps5)

        searchView = findViewById(R.id.mSearchBarps5)

        recyclerView = findViewById(R.id.PS5games) as RecyclerView
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
        var game = Games("Final Fantasy XVI", R.drawable.img_1, "PS5", "Rent")
        gameList.add(game)

        game = Games("Ghost of Tsushima", R.drawable.img_11, "PS5", "Rent")
        gameList.add(game)

        game = Games("Apex Legends", R.drawable.img_9, "PS5", "Rent")
        gameList.add(game)

        game = Games("Genshin Impact", R.drawable.img_10, "PS5", "Rent")
        gameList.add(game)

        game = Games("Diablo IV", R.drawable.img_2, "PS5", "Rent")
        gameList.add(game)

        game = Games("Star Wars:Jedi Survivor", R.drawable.img_3, "PS5", "Rent")
        gameList.add(game)

        game = Games("Gran Turismo 7", R.drawable.img_4 ,"PS5", "Rent")
        gameList.add(game)

        game = Games("Street Fighter 6", R.drawable.img_5, "PS5", "Rent")
        gameList.add(game)

        game = Games("NBA 2K23", R.drawable.img_6, "PS5", "Rent")
        gameList.add(game)

        game = Games("Spiderman 2", R.drawable.img_7, "PS5", "Rent")
        gameList.add(game)

        game = Games("F1 23", R.drawable.img_64, "PS5" , "Rent")
        gameList.add(game)

        game = Games("The last of us", R.drawable.img_65, "PS5" , "Rent")
        gameList.add(game)

        game = Games("Dead island 2", R.drawable.img_66, "PS5" , "Rent")
        gameList.add(game)

        game = Games("Xdefiant", R.drawable.img_67, "PS5" , "Rent")
        gameList.add(game)

        game = Games("Teken 8", R.drawable.img_68, "PS5" , "Rent")
        gameList.add(game)

        game = Games("Assasin's Creed Mirage", R.drawable.img_69, "PS5" , "Rent")
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