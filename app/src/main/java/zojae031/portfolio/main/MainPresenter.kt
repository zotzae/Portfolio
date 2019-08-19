package zojae031.portfolio.main

class MainPresenter(private val view: MainContract.View) :
    MainContract.Presenter {
    override fun onCreate() {
        view.showUserImage()
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}