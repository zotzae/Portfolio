package zojae031.portfolio.data

import io.reactivex.Single
import zojae031.portfolio.data.datasource.local.LocalDataSource
import zojae031.portfolio.data.datasource.remote.RemoteDataSource

class RepositoryImpl private constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun getBasicInformation(): Single<String> {
        /*
        1. 네트워크 연결 x -> 로컬
        2. 리모트 != 로컬 -> 로컬 update
        3. 로컬 x -> 리모트
        */
        return localDataSource.getBasicInformation()
//        return remoteDataSource.getBasicInformation()
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