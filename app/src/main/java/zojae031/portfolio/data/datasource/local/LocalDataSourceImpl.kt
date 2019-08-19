package zojae031.portfolio.data.datasource.local

import android.content.Context
import android.util.Log
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers

class LocalDataSourceImpl private constructor(context: Context) : LocalDataSource {
    private val db = LocalDataBase.getInstance(context)
    private val basicDao = db.basicDao()

    override fun getBasicInformation(): Single<String> {
        return Single.create(SingleOnSubscribe<String> {
            Log.e("list",basicDao.select().toString())
            it.onSuccess("a")
        }).subscribeOn(Schedulers.io())
    }


    companion object {
        private var INSTANCE: LocalDataSourceImpl? = null
        fun getInstance(context: Context): LocalDataSourceImpl {
            if (INSTANCE == null) {
                INSTANCE =
                    LocalDataSourceImpl(context)
            }
            return INSTANCE!!
        }
    }
}