package zojae031.portfolio.presentation

interface MainContract : BaseContract{
    interface View :BaseContract.View {
        fun showUserImage()
    }
    interface Presenter : BaseContract.Presenter{

    }
}