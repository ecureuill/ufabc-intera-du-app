package edu.estudos.ufabc.atividade07

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val highContrast = prefs.getBoolean("high_contrast", false)
        if (highContrast) {
            setTheme(R.style.Theme_Atividade07_HighContrast)
        }
        super.onCreate(savedInstanceState)
        // Preferência do tema
        setContentView(R.layout.activity_main)
        // Safe: ensure the root view exists before attaching the insets listener
        val rootView = findViewById<android.view.View?>(R.id.main)
        rootView?.let { view ->
            ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

                val btnPersonalizar = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fbtnPersonalizar)
        btnPersonalizar.setOnClickListener {
            startActivity(Intent(this, ConfiguracoesActivity::class.java))
        }
    }
}