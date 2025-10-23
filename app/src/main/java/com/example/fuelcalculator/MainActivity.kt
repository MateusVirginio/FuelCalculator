package com.example.fuelcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val edtDistancia = findViewById<EditText>(R.id.edtDistancia)
        val edtKmLitro = findViewById<EditText>(R.id.edtKmLitro)
        val edtPrecoCombustivel = findViewById<EditText>(R.id.edtPrecoCombustivel)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val distancia = edtDistancia.text.toString().toInt()
            val kmLitro = edtKmLitro.text.toString().toInt()
            val precoCombustivel = edtPrecoCombustivel.text.toString().toDouble()

            val litrosNecessarios = distancia / kmLitro

            val custoTotal = litrosNecessarios * precoCombustivel
        }
    }
}