package com.example.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.databinding.ActivityMainBinding
import com.example.githubuser.databinding.ItemUserBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private fun showSelectedUser(user: User){
        val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
        moveIntent.putExtra(MoveActivity.EXTRA_USER,user)
        startActivity(moveIntent)
    }

    private val listUser: ArrayList<User>
        get() {
            val dataUser = resources.getStringArray(R.array.username)
            val dataFollow = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataNama = resources.getStringArray(R.array.name)
            val dataLokasi = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepository = resources.getStringArray(R.array.repository)

            val listUser = ArrayList<User>()
            for (i in dataUser.indices) {
                val user = User(dataUser[i], dataFollow[i], dataFollowing[i], dataPhoto.getResourceId(i, -1),
                    dataNama[i], dataLokasi[i], dataCompany[i], dataRepository[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList(){
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter
        listUserAdapter.setOnClickCallback(object: ListUserAdapter.OnItemCallback{
            override fun onItemClicked(user: User) {
                showSelectedUser(user)
            }
        } )
    }
}