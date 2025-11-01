package edu.estudos.ufabc.atividade11

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IMC_Activity : AppCompatActivity() {
    private lateinit var txtNome: TextView
    private lateinit var txtPeso: TextView
    private lateinit var txtAltura: TextView
    private lateinit var txtIMC: TextView
    private lateinit var txtResultado: TextView
    private lateinit var txtClassificacao: TextView
    private lateinit var btnVoltar: Button
    private lateinit var imgClassificacao: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtNome = findViewById(R.id.txtNome)
        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)
        txtIMC = findViewById(R.id.txtIMC)
        txtResultado = findViewById(R.id.txtResultado)
        btnVoltar = findViewById(R.id.btnVoltar)
        imgClassificacao = findViewById(R.id.imgClassificacao)

        btnVoltar.setOnClickListener {
            finish()
        }

        val         val bundle = intent.extras
        if (bundle != null) {
            val nome = bundle.getString("nome")
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            txtNome.text = getString(R.string.imc_display_nome, nome)
            txtPeso.text = getString(R.string.imc_display_peso, peso)
            txtAltura.text = getString(R.string.imc_display_altura, altura)

            val imc = peso / (altura * altura)
            txtIMC.text = getString(R.string.imc_display_imc, imc)


            val classificacao: String
            val imagemResource: Int
            if (imc < 20) {
                classificacao = getString(R.string.imc_classificacao_magro)
                imagemResource = R.drawable.magro
            } else if (imc <= 25) {
                classificacao = getString(R.string.imc_classificacao_normal)
                imagemResource = R.drawable.normal
            } else if (imc <= 30) {
                classificacao = getString(R.string.imc_classificacao_sobrepeso)
                imagemResource = R.drawable.sobrepeso
            } else {
                classificacao = getString(R.string.imc_classificacao_obeso)
                imagemResource = R.drawable.obeso
            }
            txtResultado.text = classificacao
            imgClassificacao.setImageResource(imagemResource)
        }
    }
}
