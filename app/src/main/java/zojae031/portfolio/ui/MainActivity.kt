package zojae031.portfolio.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*
import zojae031.portfolio.R
import zojae031.portfolio.presentation.MainContract
import zojae031.portfolio.presentation.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {


    private val presenter = MainPresenter(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()

        indicator.createDotPanel(3, R.drawable.indicator_off, R.drawable.indicator_on, 0)

        with(pager) {
            adapter = MainPagerAdapter(supportFragmentManager)
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                }

                override fun onPageSelected(position: Int) {
                    indicator.selectDot(position)
                }

            })
        }

    }

    override fun showToast(text: String) {
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
    }

    override fun showUserImage() {
        Glide.with(this@MainActivity)
            .load("https://avatars2.githubusercontent.com/u/31091115?s=400&u=6db0ee4cb9b8a82cef9fe3a4196b437dc537339d&v=4")
            .centerCrop()
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }

}
