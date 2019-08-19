package zojae031.portfolio.data.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface BasicDao : BaseDao<BasicEntity> {
    @Query("Select * from BasicEntity")
    fun select(): List<BasicEntity>
}