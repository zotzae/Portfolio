package zojae031.portfolio.project

import com.google.gson.Gson
import com.google.gson.JsonParser
import io.reactivex.android.schedulers.AndroidSchedulers
import zojae031.portfolio.data.Repository
import zojae031.portfolio.data.dao.CompetitionEntity


class ProjectPresenter(private val view: ProjectContract.View, private val repository: Repository) :
    ProjectContract.Presenter {
    private lateinit var adapterView: ProjectAdapterContract.View
    private lateinit var adapterModel: ProjectAdapterContract.Model

    override fun setAdapter(view: ProjectAdapterContract.View, model: ProjectAdapterContract.Model) {
        adapterView = view
        adapterModel = model
    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        repository
            .getCompetitionInformation()
            .map { data ->
                JsonParser().parse(data).asJsonArray.apply {
                    return@map Gson().fromJson(this, Array<CompetitionEntity>::class.java)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { enitity ->
                adapterView.clearList()
                adapterView.updateList(enitity as Array<CompetitionEntity>)
                adapterModel.notifyAdapter()
            }
    }

    override fun onPause() {

    }

}