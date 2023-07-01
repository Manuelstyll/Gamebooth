package com.example.gamebooth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class PS3Activity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private lateinit var recyclerViewGameAdapter: RecyclerViewGameAdapter
    private var gameList = ArrayList<Games>()
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ps3)

        searchView = findViewById(R.id.mSearchBarps3)

        recyclerView = findViewById(R.id.PS3games) as RecyclerView
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
        var game = Games("The Last of Us", R.drawable.img_22, "PS3", "Rent")
        gameList.add(game)

        game = Games("Red Redemption", R.drawable.img_23, "PS3", "Rent")
        gameList.add(game)

        game = Games("Call of Duty:Blackops", R.drawable.img_24, "PS3", "Rent")
        gameList.add(game)

        game = Games("Fallout 3", R.drawable.img_25, "PS3", "Rent")
        gameList.add(game)

        game = Games("Minecraft", R.drawable.img_26, "PS3", "Rent")
        gameList.add(game)

        game = Games("Batman Arkham City", R.drawable.img_27, "PS3", "Rent")
        gameList.add(game)

        game = Games("Assasin's Creed", R.drawable.img_77, "PS3", "Rent")
        gameList.add(game)

        game = Games("Portal 2", R.drawable.img_78, "PS3", "Rent")
        gameList.add(game)

        game = Games("Bioshock", R.drawable.img_79, "PS3", "Rent")
        gameList.add(game)

        game = Games("Infamous", R.drawable.img_80, "PS3", "Rent")
        gameList.add(game)

        game = Games("Far cry 3", R.drawable.img_81, "PS3", "Rent")
        gameList.add(game)

        game = Games("GTA:San Andreas", R.drawable.img_82, "PS3", "Rent")
        gameList.add(game)

        game = Games("Fifa 18", R.drawable.img_83, "PS3", "Rent")
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