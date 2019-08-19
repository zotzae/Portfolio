package zojae031.portfolio.presentation.profile

import zojae031.portfolio.data.dao.BasicDao
import zojae031.portfolio.presentation.BaseContract

interface ProfileContract : BaseContract {
    interface View : BaseContract.View {
        fun showBasicInformation(data: BasicDao)
    }

    interface Presenter : BaseContract.Presenter {

    }
}