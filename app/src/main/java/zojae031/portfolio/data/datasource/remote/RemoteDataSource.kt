package zojae031.portfolio.data.datasource.remote

import io.reactivex.Single

interface RemoteDataSource {

    var isDirty: MutableList<Boolean>
    fun getBasicInformation(): Single<String>
    fun getCompetitionInformation(): Single<String>
}