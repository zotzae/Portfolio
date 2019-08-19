package zojae031.portfolio.data

import io.reactivex.Single
import zojae031.portfolio.data.dao.BasicEntity

interface Repository {
    fun getBasicInformation(): Single<String>
    fun insertBasicInformation(data: BasicEntity)
    fun getCompetitionInformation(): Single<String>
}