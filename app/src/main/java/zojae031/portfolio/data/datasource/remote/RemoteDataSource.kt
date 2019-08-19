package zojae031.portfolio.data.datasource.remote

import io.reactivex.Single

interface RemoteDataSource {
    fun getBasicInformation(): Single<String>
}