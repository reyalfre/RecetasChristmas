package com.example.recetasexamen.ui

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.recetasexamen.R
import com.example.recetasexamen.RecetaApplication
import com.example.recetasexamen.model.Receta
import kotlinx.coroutines.launch
import java.util.*

class AddFragment : Fragment() {
    lateinit var binding: FragmentCreateRecetaBinding
    var priority: String = "1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_add, container, false)
        binding = FragmentCreateRecetaBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDone.setOnClickListener {
            createShopping()
        }
    }

    private fun createShopping() {
        val name = binding.editName.text.toString()
        val gift = binding.editGift.text.toString()
        val description = binding.editDescription.text.toString()
        val money = binding.editMoney.text.toString()
        val d = Date()
        val shoppingDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        Log.i("info", "create notes: $shoppingDate")

        //crear Shopping
        val data = Receta(
            null,
            name = name,
            product = gift,
            category = description,
            webUrl = money.toLong(),
            date = shoppingDate.toString(),
            iscompleated = false
        )
        //lanzamos una courutine para la tarea de añadir un registro
        lifecycleScope.launch{
            RecetaApplication.database.recetaDao().insertReceta(data)
        }

        Toast.makeText(requireContext(), "Nota añadida correctamente", Toast.LENGTH_SHORT).show()

        //volver al fragmet Homefragment
        Navigation.findNavController(requireView()).navigate(R.id.action_createRecetaFragment_to_homeFragment)
    }
}