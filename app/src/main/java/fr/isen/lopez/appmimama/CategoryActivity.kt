package fr.isen.lopez.appmimama
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.isen.lopez.appmimama.databinding.ActivityCategoryBinding
import fr.isen.lopez.appmimama.model.Data
import fr.isen.lopez.appmimama.model.DataResult
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creation de list et la recup sous forme de variable
        binding.categoryList.layoutManager = LinearLayoutManager( this)
       /* binding.categoryList.adapter = CategoryAdapter(dishes) {
            val intent = Intent( this, DetailActivity:: class.java)
            startActivity(intent)
        }*/

        loadDishesFromAPI()
    }

    private fun loadDishesFromAPI(){
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject,{
            Log.w("CategoryActivity", "response : $it")
           this.handleAPIData(it.toString())
        }, {
            Log.w("CategoryActivity", "error : $it")
        })
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data:String){

        println("on est dans handleApi")
        val dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategory = dishesResult.data.firstOrNull { it.nameFr == intent.getStringExtra("Category") }

        val adapter = binding.categoryList.adapter as CategoryAdapter
        val dishes = ArrayList<String>()
        //val dishes = dishCategory.map { it.nameFr } as ArrayList<String>

        /*for(value in dishCategory)

        for(value in dishes){
            println("HandleApiData : " + value)
        }

        binding.categoryList.adapter = CategoryAdapter(dishes)


        adapter.refreshList(dishes)*/
    }

}