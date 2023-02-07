package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //habilita o botão voltar para a tela de home
        supportActionBar?.setHomeButtonEnabled(true)

        //torna visíel o botão de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        
        val resultado = intent.getFloatExtra("EXTRA_RESULT", 0.01f)

        tvResult.text = resultado.toString()

        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val classificacao = if (resultado < 18.5){
            tvResult.setTextColor(ContextCompat.getColor(this, R.color.abx_peso))
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.abx_peso))
            "ABAIXO DO PESO"

        }else if (resultado in 18.5..24.9){
            tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
            "PESO NORMAL"

        }else if (resultado in 25.0..29.9){
            tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobre_peso))
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.sobre_peso))
            "SOBREPESO"

        }else if (resultado in 30.0..39.9){
            tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidade))
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.obesidade))
            "OBESIDADE"

        }else{
            tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidade_grave))
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.obesidade_grave))
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}