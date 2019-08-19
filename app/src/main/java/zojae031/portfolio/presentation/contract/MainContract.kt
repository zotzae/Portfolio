package zojae031.portfolio.presentation.contract

interface MainContract : BaseContract {
    interface View : BaseContract.View {
        fun showUserImage()
    }
    interface Presenter : BaseContract.Presenter {

    }
}