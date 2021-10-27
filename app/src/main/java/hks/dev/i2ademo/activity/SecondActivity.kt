package hks.dev.i2ademo.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import hks.dev.i2ademo.R

class SecondActivity : AppCompatActivity(R.layout.second_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<TextView>(R.id.vDismiss).setOnClickListener {
            this@SecondActivity.finish()
        }
    }

}