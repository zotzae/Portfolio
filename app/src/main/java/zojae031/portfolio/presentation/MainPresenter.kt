package zojae031.portfolio.presentation

import zojae031.portfolio.presentation.contract.MainContract

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    override fun onCreate() {
        view.showUserImage()
    }
}