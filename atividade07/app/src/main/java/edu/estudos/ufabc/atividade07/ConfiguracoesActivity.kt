package edu.estudos.ufabc.atividade07

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.edit

class ConfiguracoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val highContrast = prefs.getBoolean("high_contrast", false)
        if (highContrast) {
            setTheme(R.style.Theme_Atividade07_HighContrast)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)

        val switch = findViewById<SwitchCompat>(R.id.switchHighContrast)
        switch.isChecked = highContrast
        switch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit { putBoolean("high_contrast", isChecked) }
            // Reinicia MainActivity para aplicar o tema imediatamente
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
