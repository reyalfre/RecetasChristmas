package com.example.recetasexamen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recetasexamen.R
import com.example.recetasexamen.RecetaApplication
import com.example.recetasexamen.adapter.RecetaAdapter
import com.example.recetasexamen.databinding.FragmentHomeBinding
import com.example.recetasexamen.model.Receta
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    lateinit var  binding : FragmentHomeBinding
    private lateinit var mGridLayoutManager: GridLayoutManager
    private lateinit var mAdapter: RecetaAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //se indica a donde se va a navegar
        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addFragment)
        }

        getAllReceta()
        setupRecyclerView()
        setFilter()


    }
    private fun setFilter() {
        //primera opcion sin filtro
        binding.allNotes.setOnClickListener {
            getAllReceta()
            setupRecyclerView()
        }
        binding.filterComple.setOnClickListener {
            getCompleatedReceta()
            setupRecyclerView()
        }
        binding.filterPending.setOnClickListener {
            getPendingReceta()
            setupRecyclerView()
        }
    }
    private fun getPendingReceta() {
        lifecycleScope.launch{
            val recetaList = RecetaApplication.database.recetaDao().getPendingReceta()
            mAdapter.setReceta(recetaList)
        }
    }
    private fun getCompleatedReceta() {
        lifecycleScope.launch {
            val recetaComple = RecetaApplication.database.recetaDao().getCompleatedReceta()
            mAdapter.setReceta(recetaComple)
        }
    }
    private fun setupRecyclerView() {
        mAdapter = RecetaAdapter(mutableListOf(),this)
        mGridLayoutManager = GridLayoutManager(requireContext(),2)

        binding.recycler.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayoutManager
            adapter = mAdapter
        }
    }
    private fun getAllReceta() {
        lifecycleScope.launch {
            val recetaList = RecetaApplication.database.recetaDao().getAllReceta()
            mAdapter.setReceta(recetaList)
        }
    }
    override fun onCompleatedReceta(receta: Receta) {
        //modificar el valor de iscompleated
        receta.iscompleated = !receta.iscompleated
        //actualizar las datos
        lifecycleScope.launch {
            val recetaList = RecetaApplication.database.recetaDao().updateReceta(receta)
            mAdapter.update(receta)
        }
    }
    override fun onClickReceta(receta: Receta) {
        //val action = homeFragmentDirections.actionHomeFragmentToEditShoppingFragment(receta)
        Navigation.findNavController(requireView()).navigate(action)
    }
}