package com.example.gamebooth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class PS4Activity : AppCompatActivity() {
    private  var recyclerView : RecyclerView? = null
    private lateinit var recyclerViewGameAdapter : RecyclerViewGameAdapter
    private var gameList =  ArrayList<Games>()
    private lateinit var searchView: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ps4)

        searchView = findViewById(R.id.mSearchBarps4)

        recyclerView = findViewById(R.id.PS4games) as RecyclerView
        recyclerViewGameAdapter = RecyclerViewGameAdapter(this, gameList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewGameAdapter

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
        var game = Games("God of War:Ragnarok", R.drawable.img_9, "PS4", "Rent")
        gameList.add(game)

        game = Games("Spiderman 1", R.drawable.img_12, "PS4", "Rent")
        gameList.add(game)

        game = Games("GTA V", R.drawable.img_13, "PS4", "Rent")
        gameList.add(game)

        game = Games("Hogwarts Legacy", R.drawable.img_14, "PS4", "Rent")
        gameList.add(game)

        game = Games("God of War 4", R.drawable.img_15, "PS4", "Rent")
        gameList.add(game)

        game = Games("Far Cry 6", R.drawable.img_16, "PS4", "Rent")
        gameList.add(game)

        game = Games("Red Dead Redemption 2", R.drawable.img_17 ,"PS4", "Rent")
        gameList.add(game)

        game = Games("Fifa 22", R.drawable.img_18, "PS4", "Rent")
        gameList.add(game)

        game = Games("Mortal Kombat 11", R.drawable.img_20, "PS4", "Rent")
        gameList.add(game)

        game = Games("Blood Bourne", R.drawable.img_21, "PS4", "Rent")
        gameList.add(game)

        game = Games("Cyberpunk 2099", R.drawable.img_8, "PS4" , "Rent")
        gameList.add(game)

        game = Games("WWE 2K23", R.drawable.img_70, "PS4" , "Rent")
        gameList.add(game)

        game = Games("The show 22", R.drawable.img_71, "PS4" , "Rent")
        gameList.add(game)

        game = Games("Astro Bot", R.drawable.img_72, "PS4" , "Rent")
        gameList.add(game)

        game = Games("TMNT:Shredders Revenge", R.drawable.img_73, "PS4" , "Rent")
        gameList.add(game)

        game = Games("Call of duty", R.drawable.img_74, "PS4" , "Rent")
        gameList.add(game)

        game = Games("Dying light 2", R.drawable.img_75, "PS4" , "Rent")
        gameList.add(game)

        game = Games("Blood and Art", R.drawable.img_76, "PS4" , "Rent")
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