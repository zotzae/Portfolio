package zojae031.portfolio.project

import zojae031.portfolio.data.dao.CompetitionEntity

interface ProjectAdapterContract {
    interface View {
        fun clearList()
        fun updateList(lists: List<CompetitionEntity>)
    }

    interface Model {
        fun notifyAdapter()
    }
}