package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding o UI Component Button
        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)

        //Binding o UI Component EditText Peso
        val edtPeso: EditText = findViewById<EditText>(R.id.edittext_Peso)

        //Binding o UI Component EditText Altura
        val edtAltura: EditText = findViewById<EditText>(R.id.edittext_Altura)



        btnCalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()
                val imc: Float = peso / (altura * altura)

                val resultado: Float = Math.round(imc * 10f) / 10f


                //Intent explicita chamando a ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", resultado)
                    }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Preecha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}