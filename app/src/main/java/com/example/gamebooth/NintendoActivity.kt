package com.example.gamebooth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class NintendoActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit  var recyclerViewGameAdapter : RecyclerViewGameAdapter
    private var gameList =  ArrayList<Games>()
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nintendo)

        searchView = findViewById(R.id.mSearchBarnintendo)

        recyclerView = findViewById(R.id.Nintendogames) as RecyclerView
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
        var game = Games("Zapper:One wicked cricket", R.drawable.img_29, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Sonic: The Fighters", R.drawable.img_40, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Lost In Shadow", R.drawable.img_46, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Super Mario World", R.drawable.img_47, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Tadeo jones 3", R.drawable.img_48, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Animal Crossing", R.drawable.img_49, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Mario Kart Deluxe", R.drawable.img_50 ,"Nintendo", "Rent")
        gameList.add(game)

        game = Games("Splatoon 3", R.drawable.img_51, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Hollow Knight", R.drawable.img_92, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Monster hunter rise", R.drawable.img_93, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Super Paper Mario", R.drawable.img_94, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Metroid Droid", R.drawable.img_95, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Pikmin 4", R.drawable.img_96, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Nintendo Switch sports", R.drawable.img_97, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Triangle Strategy", R.drawable.img_98, "Nintendo", "Rent")
        gameList.add(game)

        game = Games("Metroid Prime", R.drawable.img_99, "Nintendo", "Rent")
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