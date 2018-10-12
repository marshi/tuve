package marshi.android.tuve.repository.database.follow

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FollowRepository @Inject constructor(
  private val dao: FollowDao
) {
}
