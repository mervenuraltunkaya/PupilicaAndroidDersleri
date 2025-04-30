package com.merve.tasarimodev

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //R (Kotlin sınıfları içinde)= res klasörü, kaynaklar klasörü
        //@ (XML sınıfları içinde)= res kalsörü, kaynaklar klasörü
        // <item name="android:statusBarColor">@color/anaRenk</item>
    }
}