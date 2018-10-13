package marshi.android.tuve.repository.database.follow

import com.google.common.base.Optional
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.tuve.domain.ChannelId
import marshi.android.tuve.domain.FollowEntity
import marshi.android.tuve.domain.FollowStatus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FollowRepository @Inject constructor(
  private val dao: FollowDao
) {

  fun insertOrUpdate(followEntity: FollowEntity): Single<Unit> {
    val data = Follow.from(followEntity)
    return Single.create<Unit> {
      it.onSuccess(dao.insertOrUpdate(data))
    }.subscribeOn(Schedulers.io())
  }

  fun delete(followEntity: FollowEntity): Single<Unit> {
    val data = Follow.from(followEntity)
    return Single.create<Unit> {
      it.onSuccess(dao.delete(data))
    }.subscribeOn(Schedulers.io())
  }

  fun followStatus(channelId: ChannelId): Single<FollowStatus> {
    return Single.create<Optional<Follow?>> {
      it.onSuccess(Optional.fromNullable(dao.query(channelId = channelId.id)))
    }.subscribeOn(
      Schedulers.io()
    ).flatMap {
      if (it.isPresent) {
        Single.just(FollowStatus.AlreadyFollowed)
      } else {
        Single.just(FollowStatus.NotFollow)
      }
    }
  }
}
