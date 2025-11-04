package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

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

        //FindViewById
        val tvCustoTotal = findViewById<TextView>(R.id.tvCustoTotal)
        val tvDistancia = findViewById<TextView>(R.id.tvDistancia)
        val tvConsumo= findViewById<TextView>(R.id.tvConsumo)
        val tvPreco= findViewById<TextView>(R.id.tvPreco)
        val btnResultadoNovo = findViewById<Button>(R.id.btnResultadoNovo)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_resultado)
        //Habilita toolbar
        setSupportActionBar(toolbar)

        //Botões de Voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)



        val resposta = resultado.toString()

        tvCustoTotal.text = ("R$ $resposta")
        tvDistancia.text = distancia.toString()
        tvConsumo.text = consumo.toString()
        tvPreco.text = precoCombustivel.toString()

        btnResultadoNovo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    // Faz voltar a activity quando o botão de voltar for clicado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}