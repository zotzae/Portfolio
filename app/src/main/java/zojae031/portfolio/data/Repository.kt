package zojae031.portfolio.data

import io.reactivex.Single

interface Repository {
    fun getBasicInformation(): Single<String>
}