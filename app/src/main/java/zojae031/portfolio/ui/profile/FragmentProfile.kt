package zojae031.portfolio.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import zojae031.portfolio.R
import zojae031.portfolio.data.RepositoryImpl
import zojae031.portfolio.data.dao.BasicEntity
import zojae031.portfolio.data.datasource.local.LocalDataSourceImpl
import zojae031.portfolio.data.datasource.remote.RemoteDataSourceImpl
import zojae031.portfolio.presentation.profile.ProfileContract
import zojae031.portfolio.presentation.profile.ProfilePresenter

class FragmentProfile : Fragment(), ProfileContract.View {
    private val presenter by lazy {
        ProfilePresenter(
            this@FragmentProfile, RepositoryImpl.getInstance(
                LocalDataSourceImpl.getInstance(context!!),
                RemoteDataSourceImpl
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun showBasicInformation(data: BasicEntity) {
        information.text =
            String.format("이름 : ${data.name}\n나이 : ${data.age}\n학력 : ${data.university}\n전공 : ${data.major}\n병역 : ${data.military}")
    }
}