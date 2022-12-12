package com.example.recetasexamen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recetasexamen.model.Receta

class RecetaAdapter (private var recetaList: MutableList<Receta>,
                     private var listener: RecetaOnClickListener)
    : RecyclerView.Adapter<RecetaAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_receta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = recetaList.get(position)
        holder.bind(item)

        holder.setListener(item)
    }

    override fun getItemCount(): Int {
        return recetaList.size
    }

    fun setReceta(receta: MutableList<Receta>) {
        this.recetaList = receta
        notifyDataSetChanged()
    }

    fun update(receta: Receta) {
        val index = recetaList.indexOf(receta)
        //preguntamos por el index
        if(index != -1){
            recetaList.set(index, receta)
            notifyItemChanged(index)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val binding = ViewRecetaBinding.bind(view)

        fun bind(receta: Receta){
            binding.textName.text = receta.name
            binding.textGift.text = receta.gift
            binding.textMoney.text = receta.money.toString()
            binding.textDate.text = receta.date
            binding.viewCompleted.isChecked = receta.iscompleated
        }

        fun setListener(item: Receta) {
            binding.viewCompleted.setOnClickListener { listener.onCompleatedReceta(item) }
            binding.root.setOnClickListener { listener.onClickReceta(item) }

        }
    }
}