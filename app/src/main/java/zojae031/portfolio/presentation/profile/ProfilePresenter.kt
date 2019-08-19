package zojae031.portfolio.presentation.profile

import com.google.gson.JsonParser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import zojae031.portfolio.data.Repository
import zojae031.portfolio.data.dao.BasicEntity

class ProfilePresenter(private val view: ProfileContract.View, private val repository: Repository) :
    ProfileContract.Presenter {
    private val compositeDisposable = CompositeDisposable()
    override fun onCreate() {

    }

    override fun onResume() {
        repository
            .getBasicInformation()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                JsonParser().parse(data).asJsonObject.apply {
                    BasicEntity(
                        get("name").asString,
                        get("age").asString,
                        get("university").asString,
                        get("major").asString,
                        get("military").asString
                    ).also { view.showBasicInformation(it) }
                }
            }.also { compositeDisposable.add(it) }
    }

    override fun onPause() {
        compositeDisposable.clear()
    }
}