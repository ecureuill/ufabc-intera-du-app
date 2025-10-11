package edu.estudos.ufabc.atividade06

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var count: Int = 0
    private lateinit var txtContador: TextView
    private lateinit var btnIncrementar: Button
    private lateinit var btnZerar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtContador = findViewById<TextView>(R.id.txtContador)
        btnIncrementar = findViewById<Button>(R.id.btnIncrementar)
        btnZerar = findViewById<Button>(R.id.btnZerar)
        btnIncrementar.setOnClickListener {
            count++
            txtContador.text = count.toString()
        }
        btnZerar.setOnClickListener {
            count = 0
            txtContador.text = count.toString()
        }
    }
}