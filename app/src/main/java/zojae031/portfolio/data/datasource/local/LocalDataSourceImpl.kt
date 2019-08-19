package zojae031.portfolio.data.datasource.local

import android.content.Context
import com.google.gson.JsonObject
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers
import zojae031.portfolio.data.dao.BasicEntity

class LocalDataSourceImpl private constructor(context: Context) : LocalDataSource {
    private val db = LocalDataBase.getInstance(context)
    private val basicDao = db.basicDao()

    override fun getBasicInformation(): Single<String> {
        return Single.create(SingleOnSubscribe<String> { emitter ->
            val data = basicDao.select()
            JsonObject().apply {
                addProperty("name", data[0].name)
                addProperty("age", data[0].age)
                addProperty("university", data[0].university)
                addProperty("major", data[0].major)
                addProperty("military", data[0].military)
            }.also { emitter.onSuccess(it.toString()) }

        }).subscribeOn(Schedulers.io())
    }

    override fun insertBasicInformation(data: BasicEntity) {
        basicDao.insert(data)
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