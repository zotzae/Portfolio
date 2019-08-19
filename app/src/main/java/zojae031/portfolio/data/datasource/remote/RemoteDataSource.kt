package zojae031.portfolio.data.datasource.remote

import io.reactivex.Single

interface RemoteDataSource {

    var isDirty: Boolean
    fun getBasicInformation(): Single<String>
}