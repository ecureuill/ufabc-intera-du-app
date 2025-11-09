package edu.estudos.ufabc.atividade11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobile.mobiledu.DUSettingsApplier
import com.mobile.mobiledu.EnvironmentApplier
import com.mobile.mobiledu.SoundApplier

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var edtNome: EditText
    private lateinit var edtPeso: EditText
    private lateinit var edtAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCalcular = findViewById(R.id.btnCalcular)
        edtNome = findViewById(R.id.txtNome)
        edtPeso = findViewById(R.id.txtPeso)
        edtAltura = findViewById(R.id.txtAltura)

        btnCalcular.setOnClickListener {
            val intent = Intent(this, IMC_Activity::class.java)
            val nome = edtNome.text.toString()
            val peso = edtPeso.text.toString()
            val altura = edtAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty() && nome.isNotEmpty()) {
                intent.putExtra("nome", nome)
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (::edtNome.isInitialized) edtNome.text.clear()
        if (::edtPeso.isInitialized) edtPeso.text.clear()
        if (::edtAltura.isInitialized) edtAltura.text.clear()
        edtNome.requestFocus()
        try {
            DUSettingsApplier.applyToActivity(this)
            EnvironmentApplier.applyToActivity(this)
            SoundApplier.applyToActivity(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}