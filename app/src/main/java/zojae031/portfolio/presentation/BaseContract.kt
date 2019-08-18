package zojae031.portfolio.presentation

interface BaseContract {
    interface View{
        fun showToast()

    }
    interface Presenter{
        fun onCreate()
    }
}