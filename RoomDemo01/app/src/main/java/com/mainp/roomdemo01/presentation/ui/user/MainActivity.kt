package com.mainp.roomdemo01.presentation.ui.user

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.recyclerview.widget.LinearLayoutManager
import com.mainp.roomdemo01.data.repository.UserRepository
import com.mainp.roomdemo01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userRepository: UserRepository
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()
    private var selectedUserId: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userDao = UserDatabase.getDatabase(this).userDao()
        userRepository = UserRepository(userDao)

        userAdapter = UserAdapter(userList) { user ->
            selectedUserId = user.id
            binding.etName.setText(user.name)
            binding.etAge.setText(user.age.toString())
        }
        binding.recyclerView.adapter = userAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = userAdapter

        binding.btnAddUser.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0

            if (name.isNotEmpty() && age > 0) {
                val user = User(name = name, age = age)
                addUser(user)
            } else {
                Toast.makeText(this, "Vui lòng nhập đúng thông tin!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnUpdate.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0

            if (name.isNotEmpty() && age > 0) {
                val user = User(id = selectedUserId!!, name = name, age = age)
                updateUser(user)
            } else {
                Toast.makeText(this, "Vui lòng nhập đúng thông tin!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDelete.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0

            if (name.isNotEmpty() && age > 0) {
                val user = User(id = selectedUserId!!, name = name, age = age)
                deleteUser(user)
            } else {
                Toast.makeText(this, "Vui lòng nhập đúng thông tin!", Toast.LENGTH_SHORT).show()
            }
        }

        userRepository.getAllUsers().observe(this, Observer { users ->
            userList.clear()
            userList.addAll(users)
            userAdapter.notifyDataSetChanged()
        })
    }

    private fun updateUser(user: User) {
        lifecycleScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }

    private fun deleteUser(user: User) {
        lifecycleScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)
        }
    }
    private fun addUser(user: User) {
        lifecycleScope.launch(Dispatchers.IO) {
            userRepository.insertUser(user)
        }
    }
}
