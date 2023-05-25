package com.samioglu.newp1

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.samioglu.newp1.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        listView = findViewById(R.id.listView)

        val items = arrayOf("Aidat Ödeme", "Sipariş Ver", "Duyurular")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        //yönlenirme


        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedItem = items[position]

            // Seçilen öğeye göre yeni bir sayfaya geçiş yapabilirsiniz.
            when (selectedItem) {
                "Aidat Ödeme" -> {
                    val intent = Intent(this, aidat::class.java)
                    startActivity(intent)
                }
                "Sipariş Ver" -> {
                    val intent = Intent(this, siparis::class.java)
                    startActivity(intent)
                }
                "Duyurular" -> {
                    val intent = Intent(this, duyuru::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}