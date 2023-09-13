package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.githubuser.databinding.ActivityMoveBinding

class MoveActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityMoveBinding

    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail User"
        setData()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_back)
        supportActionBar?.setDisplayUseLogoEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setData(){
        val dataUser = intent.getParcelableExtra<User>(EXTRA_USER) as User
        with(binding){
            Glide.with(binding.imgUser)
                .load(dataUser.photo)
                .circleCrop()
                .into(imgUser)
            tvUsername.text = dataUser.nama
            tvUser.text = dataUser.user
            tvComp.text = dataUser.company
            tvLoc.text = dataUser.location
            tvFollower.text = dataUser.follow
            tvFollowing.text = dataUser.following
            tvRepo.text = dataUser.repository
        }
    }
}