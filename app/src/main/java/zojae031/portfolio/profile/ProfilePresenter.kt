package zojae031.portfolio.profile

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
            .map { data ->
                JsonParser().parse(data).asJsonObject.apply {
                    return@map BasicEntity(
                        get("name").asString,
                        get("age").asString,
                        get("university").asString,
                        get("major").asString,
                        get("military").asString
                    )
                }
            }
            .doOnSuccess { entity ->
                repository.insertBasicInformation(entity as BasicEntity)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ entity ->
                view.showBasicInformation(entity as BasicEntity)

            }, { t ->
                view.showToast(t.message.toString())
            }
            ).also { compositeDisposable.add(it) }


    }

    override fun onPause() {
        compositeDisposable.clear()
    }
}