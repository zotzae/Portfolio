package zojae031.portfolio.data.datasource

import io.reactivex.Single

interface RemoteDataSource {
    fun getBasicInformation() : Single<String>
}