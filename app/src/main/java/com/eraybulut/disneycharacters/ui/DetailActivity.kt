package com.eraybulut.disneycharacters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.eraybulut.disneycharacters.databinding.ActivityDetailBinding
import com.eraybulut.disneycharacters.utils.Extensions.gone
import com.eraybulut.disneycharacters.utils.MySingleton


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val characterDetail = MySingleton.character

        characterDetail?.let {

            binding.toolbarDetail.title = "Characters : ${characterDetail.name}"

            Glide.with(this)
                .load(characterDetail.imageUrl)
                .into(binding.imageViewDetailImage)

            binding.textViewDetailCharactersName.text = characterDetail.name



            if (characterDetail.videoGames.isNotEmpty()) {
               binding.textViewDetailCharactersVideoGames.text=characterDetail.videoGames.toString()
            } else binding.linearLayoutVideoGames.gone()

            if (characterDetail.films.isNotEmpty()) {
                binding.textViewDetailCharactersFilms.text = characterDetail.films.toString()

            } else binding.linearLayoutFilms.gone()

            if (characterDetail.tvShows.isNotEmpty()) {
                binding.textViewDetailCharactersTvShow.text=characterDetail.tvShows.toString()
            } else binding.linearLayoutTvShow.gone()

            if (characterDetail.shortFilms.isNotEmpty()) {
                binding.textViewDetailCharactersShortFilms.text=characterDetail.shortFilms.toString()
            } else binding.linearLayoutShortFilms.gone()


        }
    }
}