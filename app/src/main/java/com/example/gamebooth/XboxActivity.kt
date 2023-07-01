package com.example.gamebooth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebooth.databinding.ActivityXboxBinding
import java.util.Locale
import java.util.Locale.filter
import kotlin.collections.ArrayList

class XboxActivity : AppCompatActivity() {
    private  var recyclerView : RecyclerView? = null
    private lateinit var recyclerViewGameAdapter : RecyclerViewGameAdapter
    private var gameList =  ArrayList<Games>()
    private lateinit var searchView:SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xbox)

        searchView = findViewById(R.id.mSearchBarXbox)


        recyclerView = findViewById(R.id.Xboxgames) as RecyclerView
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
        var game = Games("Fallout 4", R.drawable.img_39, "Xbox", "Rent")
        gameList.add(game)

        game = Games("Sonic: The Fighters", R.drawable.img_40, "Xbox", "Rent")
        gameList.add(game)

        game = Games("Minecraft Dungeons", R.drawable.img_30, "Xbox", "Rent")
        gameList.add(game)

        game = Games("Wizard of Wor", R.drawable.img_41, "Xbox", "Rent")
        gameList.add(game)

        game = Games("God of War 4", R.drawable.img_15, "Xbox", "Rent")
        gameList.add(game)

        game = Games("Arcana Heart 3", R.drawable.img_42, "Xbox", "Rent")
        gameList.add(game)

        game = Games("Sniper Elite", R.drawable.img_43 ,"Xbox", "Rent")
        gameList.add(game)

        game = Games("Life is Strange", R.drawable.img_44, "Xbox", "Rent")
        gameList.add(game)

        game = Games("Pulse Racer", R.drawable.img_45, "Xbox", "Rent")
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