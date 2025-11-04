package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class KmLitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_km_litro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Recuperar dados tela anterior
        val distancia = intent.getIntExtra("DISTANCIA", 0)

        //FindByViewId
        val edtKmLitro = findViewById<EditText>(R.id.edtKmLitro)
        val btnKmLitroProximo= findViewById<Button>(R.id.btnKmLitro)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_km_litro)
        //Habilita o toolbar
        setSupportActionBar(toolbar)

        //Botões de Voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btnKmLitroProximo.setOnClickListener {
            val kmLitroValor = edtKmLitro.text.toString().toInt()
            val intent = Intent(this, PrecoCombustivelActivity::class.java)
            intent.putExtra("DISTANCIA", distancia)
            intent.putExtra("CONSUMO",kmLitroValor)
            startActivity(intent)
        }
    }

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