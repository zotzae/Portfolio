package zojae031.portfolio.presentation

import android.util.Log
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import zojae031.portfolio.data.Repository
import zojae031.portfolio.presentation.contract.ProfileContract

class ProfilePresenter(private val view: ProfileContract.View, private val repository: Repository) :
    ProfileContract.Presenter {

    override fun onCreate() {
        repository
            .getBasicInformation()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                Log.e("json",Gson().toJson(data))
            }
    }

}