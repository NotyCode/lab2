package com.example.myapplication.Learn

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.myapplication.R


class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        /* val btnFindBeer = findViewById<AppCompatButton>(R.id.btnFindBeer)
        btnFindBeer.setOnClickListener {
            Log.i("btn", "boton presionado")

        }*/
        // Create a dictionary of strings
        val texts = mapOf(
            "1" to "Curva pronunciada a la derecha" +
                    "\n" + "Cruce de animales.",
            "2" to "Este es el segundo texto",
            "3" to "Este es el tercer texto"
        )

        val beers = mapOf(
            "1" to "Señales de advertencia o precaución",
            "2" to "Señales de regulación",
            "3" to "Señales de prohibición",
            "4" to "Señales de obligación",
            "5" to "Señales informativas"
        )

        val spinner = findViewById<Spinner>(R.id.lista)

// Set the adapter of the Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, beers.values.toList())
        spinner.adapter = adapter

// Set the OnItemSelectedListener of the Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // Get the selected text
                val key = beers.keys.toList()[position]
                val text = texts[key]

                // Show the list of texts below the spinner
                val list = findViewById<TextView>(/* id = */ R.id.text)
                list.text = text
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}