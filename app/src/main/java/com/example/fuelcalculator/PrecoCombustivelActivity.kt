package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrecoCombustivelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco_combustivel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Recuperar dados tela anterior
        val litrosNecessarios = intent.getIntExtra("LITROS_NECESSARIOS", 0)

        //FindViewById
        val edtPrecoCombustivel = findViewById<EditText>(R.id.edtPrecoCombustivel)
        val btnPrecoCombustivelCalcular = findViewById<Button>(R.id.btnPrecoCombustivel)

        btnPrecoCombustivelCalcular.setOnClickListener {
            val precoCombustivel = edtPrecoCombustivel.text.toString().toDouble()

            val custoTotal = litrosNecessarios * precoCombustivel

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("CUSTO_TOTAL",custoTotal)
            startActivity(intent)
        }
    }
}