package com.example.recetasexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.recetasexamen.adapter.RecetaAdapter
import com.example.recetasexamen.databinding.FragmentHomeBinding
import java.security.AccessController

class MainActivity : AppCompatActivity() {
    //lateinit var binding : FragmentHomeBinding
    lateinit var navController: NavController
   // private lateinit var mAdapter : RecetaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.fragmentContainerView)
        setupActionBarWithNavController(navController)
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createShoppingFragment)
        }

        getAllShopping()
        setUpRecyclerView()
        setFilter()
    }

    private fun getAllShopping() {
        TODO("Not yet implemented")
    }

    private fun setUpRecyclerView() {
        TODO("Not yet implemented")
    }

    private fun setFilter() {
        TODO("Not yet implemented")
    }*/
}