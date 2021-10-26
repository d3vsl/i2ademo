package hks.dev.i2ademo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AlphaFragment: Fragment(R.layout.alpha_fragment) {

    lateinit var vAlpha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vAlpha = view.findViewById(R.id.vAlpha)

        val vButton: TextView = view.findViewById(R.id.vButton)
        vButton.setOnClickListener {
            val text = DataManager.dataString
            setAlphaContent(text)
        }
    }

    private fun setAlphaContent(content: String?){
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