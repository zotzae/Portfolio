package zojae031.portfolio.data

import io.reactivex.Single
import zojae031.portfolio.data.datasource.local.LocalDataSource
import zojae031.portfolio.data.datasource.remote.RemoteDataSource

class RepositoryImpl private constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getBasicInformation(): Single<String> {
        return remoteDataSource.getBasicInformation()
    }

    companion object {
        private var INSTANCE: RepositoryImpl? = null
        fun getInstance(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource): RepositoryImpl {
            if (INSTANCE == null) {
                INSTANCE = RepositoryImpl(localDataSource, remoteDataSource)
            }
            return INSTANCE!!
        }
    }
}