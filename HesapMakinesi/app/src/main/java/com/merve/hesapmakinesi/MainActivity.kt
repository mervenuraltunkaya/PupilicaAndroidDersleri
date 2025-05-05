package com.merve.hesapmakinesi

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textSonuc: TextView
    private var currentInput = "" // O an girilen bir sayı
    private var total = 0
    private var isNewOperation = false // Yeni bir işlem başlatıldı
    private var operation: String? = null // Yapılacak işlem (toplama, çıkarma, vb.)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSonuc = findViewById(R.id.textSonuc)

        val sayiButonlari = listOf(R.id.button0, R.id.buttonBir, R.id.buttonIki, R.id.buttonUc, R.id.buttonDort, R.id.buttonBes, R.id.buttonAlti, R.id.buttonYedi, R.id.buttonSekiz, R.id.buttonDokuz)

        for (id in sayiButonlari) {
            findViewById<Button>(id).setOnClickListener {
                if (isNewOperation) { //yeni bir sayı giriliyor
                    currentInput = "" // önceki girdi sıfırlanır
                    isNewOperation = false // Yeni işlem başladığı için false olur
                }
                val value = (it as Button).text.toString()
                currentInput += value
                textSonuc.text = currentInput
            }
        }

        // Toplama
        findViewById<Button>(R.id.buttonTopla).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                if (total == 0) {
                    total = currentInput.toInt()
                } else {
                    if (operation == "+") {
                        total += currentInput.toInt()
                    }
                }
                operation = "+"
                currentInput = ""
                textSonuc.text = "+"
            }
        }

        // Çıkarma
        findViewById<Button>(R.id.buttonCikar).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                if (total == 0) {
                    total = currentInput.toInt()
                } else {
                    if (operation == "-") {
                        total -= currentInput.toInt()
                    }
                }
                operation = "-"
                currentInput = ""
                textSonuc.text = "-"
            }
        }

        // Çarpma
        findViewById<Button>(R.id.buttonCarp).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                if (total == 0) {
                    total = currentInput.toInt()
                } else {
                    if (operation == "x") {
                        total *= currentInput.toInt()
                    }
                }
                operation = "x"
                currentInput = ""
                textSonuc.text = "x"
            }
        }

        // Bölme
        findViewById<Button>(R.id.buttonBolme).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                if (total == 0) {
                    total = currentInput.toInt()
                } else {
                    if (operation == "/") {
                        total /= currentInput.toInt()
                    }
                }
                operation = "/"
                currentInput = ""
                textSonuc.text = "/"
            }
        }

        // =
        findViewById<Button>(R.id.buttonEsittir).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                when (operation) { //hangi butona basıldıysa ona göre işlem yapılacak
                    "+" -> total += currentInput.toInt()
                    "-" -> total -= currentInput.toInt()
                    "x" -> total *= currentInput.toInt()
                    "/" -> total /= currentInput.toInt()
                }
            }
            textSonuc.text = total.toString()
            currentInput = ""
            total = 0
            operation = null
            isNewOperation = true // Yeni işlem için true yapıyoruz
        }

        // Sıfırlama
        findViewById<Button>(R.id.buttonSifirla).setOnClickListener {
            currentInput = ""
            total = 0
            operation = null
            textSonuc.text = "0"
        }
    }
}




