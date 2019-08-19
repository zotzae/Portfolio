package zojae031.portfolio.data.datasource.remote

import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers
import org.jsoup.Connection
import org.jsoup.Jsoup

object RemoteDataSourceImpl : RemoteDataSource {
    private const val basicInfoUrl = "https://github.com/zojae031/Portfolio/issues/1"

    override fun getBasicInformation(): Single<String> {
        return Single.create(SingleOnSubscribe<String> {
            Jsoup.connect(basicInfoUrl)
                .method(Connection.Method.GET)
                .execute()
                .apply {
                    it.onSuccess(this.parse().select(".d-block").select("p").text())
                }

        }).subscribeOn(Schedulers.io())
    }

}