package zojae031.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this@MainActivity)
            .load("https://avatars2.githubusercontent.com/u/31091115?s=400&u=6db0ee4cb9b8a82cef9fe3a4196b437dc537339d&v=4")
            .centerCrop()
            .into(imageView)
    }
}
