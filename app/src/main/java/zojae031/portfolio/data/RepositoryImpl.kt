package zojae031.portfolio.data

import io.reactivex.Single
import zojae031.portfolio.data.datasource.LocalDataSource
import zojae031.portfolio.data.datasource.RemoteDataSource

class RepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getBasicInformation(): Single<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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