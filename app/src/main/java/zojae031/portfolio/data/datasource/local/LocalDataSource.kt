package zojae031.portfolio.data.datasource.local

import io.reactivex.Single

interface LocalDataSource{
    fun getBasicInformation(): Single<String>
}