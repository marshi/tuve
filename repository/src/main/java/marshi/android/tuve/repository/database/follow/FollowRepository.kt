package marshi.android.tuve.repository.database.follow

import marshi.android.tuve.domain.FollowEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FollowRepository @Inject constructor(
  private val dao: FollowDao
) {

  fun insert(followEntity: FollowEntity) {
    val data = Follow.from(followEntity)
    dao.insert(data)
  }

}
