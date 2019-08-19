package zojae031.portfolio.profile

import zojae031.portfolio.data.dao.BasicEntity
import zojae031.portfolio.BaseContract

interface ProfileContract : BaseContract {
    interface View : BaseContract.View {
        fun showBasicInformation(data: BasicEntity)
    }

    interface Presenter : BaseContract.Presenter
}