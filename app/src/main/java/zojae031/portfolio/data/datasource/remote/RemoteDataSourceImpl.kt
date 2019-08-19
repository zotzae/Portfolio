package zojae031.portfolio.data.datasource.remote

import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers
import org.jsoup.Connection
import org.jsoup.Jsoup

object RemoteDataSourceImpl : RemoteDataSource {
    private val urlList = listOf(
        "https://github.com/zojae031/Portfolio/issues/1",
        "https://github.com/zojae031/Portfolio/issues/2"
    )

    @Volatile
    override var isDirty: MutableList<Boolean> = mutableListOf(false)

    override fun getBasicInformation(): Single<String> {
        return parseUrl(0)
    }

    override fun getCompetitionInformation(): Single<String> {
        return parseUrl(1)
    }

    private fun parseUrl(idx: Int): Single<String> =
        Single.create(SingleOnSubscribe<String> {
            Jsoup.connect(urlList[idx])
                .method(Connection.Method.GET)
                .execute()
                .apply {
                    isDirty[idx] = true
                    it.onSuccess(this.parse().select(".d-block").select("p").text())
                }

        }).subscribeOn(Schedulers.io())

    enum class URL {

    }
}