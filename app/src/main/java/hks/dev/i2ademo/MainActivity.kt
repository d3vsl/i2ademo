package hks.dev.i2ademo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //present button setup
        val vPresent: TextView = findViewById(R.id.vPresent)
        vPresent.text = getString(R.string.button_present)
        vPresent.setOnClickListener {
            println("you have clicked vPresent")
            openSecondActivity()
        }

        //push button setup
        val vPush: TextView = findViewById(R.id.vPush)
        vPush.text = "New Push Text"
        vPush.setOnClickListener {
            Log.d("Hi Tag", "you have clicked vPush")

            //fragment-ktx functions
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<AlphaFragment>(R.id.vContainer)
            }
        }

        //send button setup
        findViewById<TextView>(R.id.vSend).setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "This is test message")
            }
            startActivity(sendIntent)
        }

        //save data to singleton
        DataManager.dataString = "Hello this sentence is from MainActivity"
    }

    private fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }


    /**
     *  life cycle
     *  ref: https://developer.android.com/guide/components/activities/intro-activities
     *  ref: https://developer.android.com/guide/components/activities/activity-lifecycle
     */
    //visible to user
    override fun onStart() {
        super.onStart()
    }

    //just before the activity starts interacting with the user
    override fun onResume() {
        super.onResume()
    }

    //when the activity loses focus and enters a Paused state
    override fun onPause() {
        super.onPause()
    }

    //when the activity is no longer visible to the user
    override fun onStop() {
        super.onStop()
    }

    //finally destroy activity
    override fun onDestroy() {
        super.onDestroy()
    }

}