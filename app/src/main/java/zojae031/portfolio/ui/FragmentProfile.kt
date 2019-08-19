package zojae031.portfolio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import zojae031.portfolio.R
import zojae031.portfolio.data.RepositoryImpl
import zojae031.portfolio.data.datasource.LocalDataSourceImpl
import zojae031.portfolio.data.datasource.RemoteDataSourceImpl
import zojae031.portfolio.presentation.ProfilePresenter
import zojae031.portfolio.presentation.contract.ProfileContract

class FragmentProfile : Fragment(), ProfileContract.View {
    private val presenter by lazy {
        ProfilePresenter(this@FragmentProfile, RepositoryImpl.getInstance(LocalDataSourceImpl, RemoteDataSourceImpl))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}