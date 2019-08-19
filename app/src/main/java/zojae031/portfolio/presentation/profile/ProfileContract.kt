package zojae031.portfolio.presentation.profile

import zojae031.portfolio.data.dao.BasicEntity
import zojae031.portfolio.presentation.BaseContract

interface ProfileContract : BaseContract {
    interface View : BaseContract.View {
        fun showBasicInformation(data: BasicEntity)
    }

    interface Presenter : BaseContract.Presenter {

    }
}