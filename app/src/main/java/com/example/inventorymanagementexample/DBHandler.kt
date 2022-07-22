package com.example.inventorymanagementexample

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHandler(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DB_NAME, factory, DB_VERSION) {
    // below method is for creating a database by running a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + "INTEGER PRIMARY KEY,"
                + PRODUCT_NAME + " TEXT, "
                + TYPE_COL + " TEXT,"
                + BRAND_COL + " TEXT,"
                + PRICE_COL + " INT,"
                + QUANTITY_COL + " INT"+")")

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query)
    }
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }
    // this method is use to add new item to our sqlite database.
    fun addNewItem(
        type_of_item: String?,
        quantity_of_item: String,
        price_of_item: String,
        item_brand: String?,
        item_name: String?)
    {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        val db = this.writableDatabase

        // on below line we are creating a
        // variable for content values.
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(TYPE_COL, type_of_item)
        values.put(QUANTITY_COL, quantity_of_item)
        values.put(PRICE_COL, price_of_item)
        values.put(BRAND_COL, item_brand)
        values.put(PRODUCT_NAME, item_name)

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values)

        // at last we are closing our
        // database after adding database.
        db.close()
    }

   //fun getData(): Cursor?
  // {
     //  val db = this.readableDatabase
      // return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
  // }

    companion object {
        // creating a constant variables for our database.
        // below variable is for our database name.
        private const val DB_NAME = "InventoryDB"

        // below int is our database version
        private const val DB_VERSION = 1

        // below int is our row id
        private const val ID_COL = "ID"

        // below variable is for our table name.
        private const val TABLE_NAME = "Items Table"

        // below variable is for our product name column
        private const val PRODUCT_NAME = "Product Name"

        // below variable is for our brand column.
        private const val BRAND_COL = "Brand"

        // below variable is for our type name column
        private const val TYPE_COL = "Type"

        // below variable id for our quantity duration column.
        private const val QUANTITY_COL = "Quantity"

        // below variable for our price description column.
        private const val PRICE_COL = "Price"


    }
}
