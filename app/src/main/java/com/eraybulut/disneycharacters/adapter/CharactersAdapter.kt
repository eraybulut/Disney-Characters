package com.eraybulut.disneycharacters.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eraybulut.disneycharacters.databinding.CardViewLayoutBinding
import com.eraybulut.disneycharacters.model.Results
import com.eraybulut.disneycharacters.ui.DetailActivity
import com.eraybulut.disneycharacters.utils.MySingleton


class CharactersAdapter(var mContext: Context, var characterList: List<Results>):RecyclerView.Adapter<CharactersAdapter.CardViewHolder>() {

    class CardViewHolder(val binding: CardViewLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding=CardViewLayoutBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val character=characterList[position]

        holder.binding.textViewCharacterName.text=character.name

        Glide.with(mContext)
            .load(character.imageUrl)
            .circleCrop()
            .fitCenter()
            .into(holder.binding.imageViewCharacterImage)


        holder.itemView.setOnClickListener(){
            holder.itemView.context.startActivity(Intent(holder.itemView.context,DetailActivity::class.java))
            MySingleton.character=character
        }

    }

    override fun getItemCount(): Int {
       return characterList.size
    }


}


