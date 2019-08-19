package zojae031.portfolio.presentation.main

import zojae031.portfolio.presentation.BaseContract

interface MainContract : BaseContract {
    interface View : BaseContract.View {
        fun showUserImage()
    }

    interface Presenter : BaseContract.Presenter
}