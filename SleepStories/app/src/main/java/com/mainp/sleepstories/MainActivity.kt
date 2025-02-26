package com.mainp.sleepstories

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mainp.sleepstories.adapter.AdapterMenuClass
import com.mainp.sleepstories.adapter.AdapterMusicClass
import com.mainp.sleepstories.model.Menu
import com.mainp.sleepstories.model.Music

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewMenu: RecyclerView
    private lateinit var dataListMenu: ArrayList<Menu>
    lateinit var imageListMenu: Array<Int>
    lateinit var titleListMenu: Array<String>
    private lateinit var myAdapterMenu: AdapterMenuClass

    private lateinit var recyclerViewMusic: RecyclerView
    private lateinit var dataListMusic: ArrayList<Music>
    lateinit var imageListMusic: Array<Int>
    lateinit var nameListMusic: Array<String>
    lateinit var timeListMusic: Array<String>
    lateinit var categoryListMusic: Array<String>
    private lateinit var myAdapterMusic: AdapterMusicClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerViewMenu = findViewById(R.id.recyclerView)
        recyclerViewMenu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        imageListMenu = arrayOf(
            R.drawable.ic_all,
            R.drawable.ic_my,
            R.drawable.ic_anxious,
            R.drawable.ic_sleep,
            R.drawable.ic_kids
        )
        titleListMenu = arrayOf(
            "All",
            "My",
            "Anxious",
            "Sleep",
            "Kids"
        )

        dataListMenu = arrayListOf()
        getDataMenu()

        myAdapterMenu = AdapterMenuClass(dataListMenu)
        recyclerViewMenu.adapter = myAdapterMenu

//
        recyclerViewMusic = findViewById(R.id.recyclerViewMusic)
        val layoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        recyclerViewMusic.layoutManager = layoutManager

        imageListMusic = arrayOf(
            R.drawable.img_moon_yellow_cloud_sleep,
            R.drawable.img_three_owl_sleep,
            R.drawable.img_one_owl_sleep,
            R.drawable.img_moon_pink_cloud_sleep,
        )
        nameListMusic = arrayOf(
            "Night Island",
            "Sweet Sleep",
            "Night Island",
            "Sweet Sleep",
        )
        timeListMusic = arrayOf(
            "45 MIN",
            "45 MIN",
            "45 MIN",
            "45 MIN",
        )
        categoryListMusic = arrayOf(
            "SLEEP MUSIC",
            "SLEEP MUSIC",
            "SLEEP MUSIC",
            "SLEEP MUSIC",
        )

        dataListMusic = arrayListOf()
        getDataMusic()

        myAdapterMusic = AdapterMusicClass(dataListMusic)
        recyclerViewMusic.adapter = myAdapterMusic
    }

    private fun getDataMenu() {
        for (i in imageListMenu.indices) {
            val menu = Menu(imageListMenu[i], titleListMenu[i])
            dataListMenu.add(menu)
        }
    }

    private fun getDataMusic() {
        for (i in imageListMusic.indices) {
            val music = Music(imageListMusic[i], nameListMusic[i], timeListMusic[1], categoryListMusic[1])
            dataListMusic.add(music)
        }
    }
}
