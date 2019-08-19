package zojae031.portfolio.project

class ProjectPresenter(private val view: ProjectContract.View) : ProjectContract.Presenter {
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

    }

    override fun onPause() {

    }

}