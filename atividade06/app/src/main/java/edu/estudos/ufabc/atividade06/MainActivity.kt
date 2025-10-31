package edu.estudos.ufabc.atividade06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var count: Int = 0
    private lateinit var btnIncrementar: Button
    private lateinit var btnZerar: Button
    private lateinit var btnAvancar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnIncrementar = findViewById(R.id.btnIncrementar)
        btnZerar = findViewById(R.id.btnZerar)
        btnAvancar = findViewById(R.id.btnAvancar)

        btnIncrementar.setOnClickListener {
            count++
        }

        btnZerar.setOnClickListener {
            count = 0
        }

        btnAvancar.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("count", count)
            startActivity(intent)
        }
    }
}