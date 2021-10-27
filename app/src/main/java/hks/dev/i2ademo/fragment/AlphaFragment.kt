package hks.dev.i2ademo.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import hks.dev.i2ademo.manager.DataManager
import hks.dev.i2ademo.R

class AlphaFragment : Fragment(R.layout.alpha_fragment) {

    lateinit var vAlpha: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vAlpha = view.findViewById(R.id.vAlpha)

        val vButton: TextView = view.findViewById(R.id.vButton)
        vButton.setOnClickListener {
            val text = DataManager.dataString
            setAlphaContent(text)
        }

        view.findViewById<TextView>(R.id.vBeta).setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack("BetaFragment")
                add<BetaFragment>(R.id.vContainer)
            }
        }

    }

    private fun setAlphaContent(content: String?) {
        vAlpha.text = content ?: "null"
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}