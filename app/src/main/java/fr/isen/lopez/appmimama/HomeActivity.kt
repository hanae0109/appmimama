package fr.isen.lopez.appmimama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.lopez.appmimama.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, CategoryActivity::class.java)
        binding.homeEntree.setOnClickListener{

            // Snackbar.make(it, "affichage", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText(this,"Chargement des entrées,Toast.LENGTH_SHORT)

            intent.putExtra( "Category", "Entrées")
            startActivity(intent)
        }

        binding.homePlat.setOnClickListener{

            // Snackbar.make(it, "affichage", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText(this,"Chargement des entrées,Toast.LENGTH_SHORT)

            intent.putExtra("Category", "Plats")
            startActivity(intent)}

        binding.homeDessert.setOnClickListener{

            // Snackbar.make(it, "affichage", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText(this,"Chargement des entrées,Toast.LENGTH_SHORT)

            intent.putExtra("Category", "Desserts")
            startActivity(intent)}
    }
}
