package zojae031.portfolio.presentation.contract

interface BaseContract {
    interface View {
        fun showToast(text: String)

    }

    interface Presenter {
        fun onCreate()
        fun onResume()
        fun onPause()
    }
}