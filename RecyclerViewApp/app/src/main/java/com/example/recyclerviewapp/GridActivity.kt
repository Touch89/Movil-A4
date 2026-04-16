package com.example.recyclerviewapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class User (val fullname: String, var active: Boolean, var batteryLow: Boolean)

class GridViewAdapter(context: Context, list: ArrayList<User>) :
    ArrayAdapter<User?>(context, 0, list as List<User>){

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        }
        val user: User? = getItem(position)
        val itemText: TextView = itemView!!.findViewById(R.id.item_name)
        val itemCheckbox: CheckBox = itemView.findViewById(R.id.item_checkbox)
        val itemImage: ImageView = itemView.findViewById(R.id.item_img)

            itemImage.setOnClickListener {
                user!!.batteryLow = !user.batteryLow
                itemImage.setImageResource(
                    if (user.batteryLow) R.drawable.baseline_battery_1_bar_24
                    else R.drawable.baseline_battery_full_24
                )
        }

        itemText.text = user!!.fullname
        itemCheckbox.isChecked = user.active
        itemImage.setImageResource(
            if (user.batteryLow) R.drawable.baseline_battery_1_bar_24
        else R.drawable.baseline_battery_full_24
        )

        return itemView
    }
}
class GridActivity : AppCompatActivity() {
    private lateinit var gridview: GridView
    private lateinit var users: MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gridview = findViewById(R.id.grid_view)

        val users = ArrayList<User>()

        users.addAll(listOf(
            User("Alice Johnson", active = true, batteryLow = false),
            User("Bob Smith", active = false, batteryLow = true),
            User("Charlie Brown", active = true, batteryLow = true),
            User("David Wilson", active = false, batteryLow = false),
            User("Emma Davis", active = true, batteryLow = false),
            User("Fiona Garcia", active = false, batteryLow = true),
            User("George Miller", active = true, batteryLow = true),
            User("Hannah White", active = false, batteryLow = false),
            User("Ian Harris", active = true, batteryLow = true),
            User("Julia Martin", active = false, batteryLow = true),
            User("Kevin Thompson", active = true, batteryLow = false),
            User("Lily Moore", active = false, batteryLow = false),
            User("Michael Taylor", active = true, batteryLow = true),
            User("Nancy Anderson", active = false, batteryLow = true),
            User("Oscar Martinez", active = true, batteryLow = false),
            User("Paula Thomas", active = false, batteryLow = false),
            User("Quinn Jackson", active = true, batteryLow = true),
            User("Rachel Lee", active = false, batteryLow = true),
            User("Samuel Perez", active = true, batteryLow = false),
            User("Tina Adams", active = false, batteryLow = false),
            User("Ursula Baker", active = true, batteryLow = true),
            User("Victor Nelson", active = false, batteryLow = true),
            User("Wendy Scott", active = true, batteryLow = false),
            User("Xander King", active = false, batteryLow = false),
            User("Yvonne Green", active = true, batteryLow = true),
            User("Zachary Lewis", active = false, batteryLow = false),
            User("Aaron Hall", active = true, batteryLow = true),
            User("Bethany Young", active = false, batteryLow = true),
            User("Caleb Allen", active = true, batteryLow = false),
            User("Diana Wright", active = false, batteryLow = false)
            )
        )

        val adapter = GridViewAdapter(this, users)
        gridview.adapter = adapter
    }
}