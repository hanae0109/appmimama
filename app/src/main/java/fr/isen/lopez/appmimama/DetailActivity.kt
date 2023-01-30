package fr.isen.lopez.appmimama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.lopez.appmimama.model.Items

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val items = intent.getSerializableExtra("dishes") as Items
    }
}


