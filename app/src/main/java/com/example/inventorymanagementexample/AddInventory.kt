package com.example.inventorymanagementexample
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_inventory.*

class AddInventory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_inventory)

        addItembutton.setOnClickListener{
            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHandler(this, null)

            // making variables with the information from the text box
            val productName = idProductName.text.toString()
            val productType = idTypeofProduct.text.toString()
            val productBrand= idBrand.text.toString()
            val productQuantity = idQuantityProduct.text.toString()
            val productPrice = idProductprice.text.toString()

            // adding the data to the data base created
            db.addNewItem(productType,productQuantity,productPrice,productBrand,productName)

            // toast if it adds to the data base
            if (productType.isEmpty() && productQuantity.isEmpty() && productPrice.isEmpty() && productName.isEmpty())
            {
                Toast.makeText(this,"Error ! Please fill all the lines ", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,productName + "added to database", Toast.LENGTH_LONG).show()
            }

            // clearing editText
            idBrand.text.clear()
            idProductName.text.clear()
            idProductprice.text.clear()
            idQuantityProduct.text.clear()
            idBrand.text.clear()

        }

    }
}