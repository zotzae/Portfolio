package zojae031.portfolio.data.datasource.local

import io.reactivex.Single
import zojae031.portfolio.data.dao.BasicEntity

interface LocalDataSource {
    fun getBasicInformation(): Single<String>
    fun insertBasicInformation(data: BasicEntity)
}