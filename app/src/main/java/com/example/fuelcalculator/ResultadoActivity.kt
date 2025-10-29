package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val distancia = intent.getIntExtra("DISTANCIA", 0)
        val consumo = intent.getIntExtra("CONSUMO",0)
        val precoCombustivel = intent.getDoubleExtra("PRECO_COMBUSTIVEL",0.0)
        val resultado = intent.getDoubleExtra("CUSTO_TOTAL",0.0)

        val tvCustoTotal = findViewById<TextView>(R.id.tvCustoTotal)
        val tvDistancia = findViewById<TextView>(R.id.tvDistancia)
        val tvConsumo= findViewById<TextView>(R.id.tvConsumo)
        val tvPreco= findViewById<TextView>(R.id.tvPreco)
        val btnResultadoNovo = findViewById<Button>(R.id.btnResultadoNovo)

        tvCustoTotal.text = resultado.toString()
        tvDistancia.text = distancia.toString()
        tvConsumo.text = consumo.toString()
        tvPreco.text = precoCombustivel.toString()

        btnResultadoNovo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}