package hks.dev.i2ademo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import hks.dev.i2ademo.R
import hks.dev.i2ademo.fragment.AlphaFragment
import hks.dev.i2ademo.manager.DataManager


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
        vPush.text = "Push Button"
        vPush.setOnClickListener {
            Log.d("Hi Tag", "you have clicked vPush")

            //old way
            val newFragment = AlphaFragment()
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack if needed
            transaction.add(R.id.vContainer, newFragment)
            transaction.addToBackStack("AlphaFragment")
            transaction.commit()

            //new way from fragment-ktx functions
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<AlphaFragment>(R.id.vContainer)
//            }
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


        //show number of backstack in this fragment manager
        val vBackstackCount: TextView = findViewById(R.id.vBackstackCount)
        supportFragmentManager.addOnBackStackChangedListener {
            vBackstackCount.text =
                "Fragment Backstack Count: ${supportFragmentManager.backStackEntryCount.toString()}"
        }

        findViewById<TextView>(R.id.vPresentThird)
            .setOnClickListener {
                val intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent)
            }
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