package hks.dev.i2ademo.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import hks.dev.i2ademo.R

class BetaFragment : Fragment(R.layout.beta_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.vButton).setOnClickListener {

        }

    }

}