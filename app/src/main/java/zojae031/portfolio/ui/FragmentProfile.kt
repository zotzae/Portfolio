package zojae031.portfolio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import zojae031.portfolio.R
import zojae031.portfolio.presentation.contract.ProfileContract
import zojae031.portfolio.presentation.ProfilePresenter

class FragmentProfile : Fragment(), ProfileContract.View {
    private val presenter by lazy {
        ProfilePresenter(this@FragmentProfile)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}