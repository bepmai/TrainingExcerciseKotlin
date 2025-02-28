package com.mainp.roomdemo01.presentation.ui.user

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.mainp.roomdemo01.R
import com.mainp.roomdemo01.data.model.User
import com.mainp.roomdemo01.data.room.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.lifecycle.Observer
import com.mainp.roomdemo01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userDatabase: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDatabase = UserDatabase.getDatabase(this)

        Thread {
            val user = User(name = "Nguyễn Văn A", age = 30)
            userDatabase.userDao().insertUser(user)
        }.start()

        userDatabase.userDao().getAllUser().observe(this, Observer { users ->
            Log.d("UserList", users.toString())
        })
    }
}
