package com.example.inventorymanagementexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_inventory.*
class MainActivity : AppCompatActivity() {
        // making variables


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        // Click add Inventory and takes u the the new view to add items
        val addInvButton = findViewById<View>(R.id.AddInventoryButton)
        addInvButton.setOnClickListener{
            startActivity(Intent(this@MainActivity , AddInventory::class.java))
        }


    }
}