package zojae031.portfolio.presentation.contract

import zojae031.portfolio.data.dao.BasicDao

interface ProfileContract : BaseContract {
    interface View : BaseContract.View {
        fun showBasicInformation(data: BasicDao)
    }

    interface Presenter : BaseContract.Presenter{

    }
}