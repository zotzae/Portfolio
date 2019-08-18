package zojae031.portfolio.presentation

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    override fun onCreate() {
        view.showUserImage()
    }
}