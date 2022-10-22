package com.eraybulut.disneycharacters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.eraybulut.disneycharacters.R
import com.eraybulut.disneycharacters.adapter.CharactersAdapter
import com.eraybulut.disneycharacters.data.ApiClient
import com.eraybulut.disneycharacters.databinding.ActivityMainBinding
import com.eraybulut.disneycharacters.model.CharactersResponse
import com.eraybulut.disneycharacters.utils.Extensions.gone
import com.eraybulut.disneycharacters.utils.Extensions.showToast
import com.eraybulut.disneycharacters.utils.Extensions.visible
import com.eraybulut.disneycharacters.utils.MySingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    val apiClient by lazy { ApiClient.getApiClient() }
    private lateinit var characterAdapter:CharactersAdapter
    private lateinit var binding: ActivityMainBinding
    private var page=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        getData()
        setupUI()



        binding.imageView13.setOnClickListener(){
            page+=1
            binding.textView2.text=page.toString()
            getData()
        }
        binding.imageView12.setOnClickListener(){
            if (page>=1){
                page-=1
                getData()
                binding.textView2.text=page.toString()
            }
        }


        binding.progressBar.visible()


    }
    private fun getData(){
        apiClient.getCharacter(page).enqueue(object :Callback<CharactersResponse>{
            override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
               if (response.isSuccessful){
                   characterAdapter=CharactersAdapter(this@MainActivity,response.body()!!.characterList)
                   binding.rv.adapter=characterAdapter
                   binding.progressBar.gone()
               }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                showToast(t.localizedMessage)
            }
        })
    }

    private fun setupUI(){
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        binding.toolbarMain.title="Disney Characters"
        setSupportActionBar(binding.toolbarMain)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item=menu.findItem(R.id.action_search)
        val searchView=item.actionView as SearchView

        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {

        return true
    }
}