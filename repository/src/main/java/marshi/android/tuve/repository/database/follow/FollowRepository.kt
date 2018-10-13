package marshi.android.tuve.repository.database.follow

import com.google.common.base.Optional
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.entity.FollowEntity
import marshi.android.tuve.domain.repository.IFollowRepository
import marshi.android.tuve.domain.valueobject.FollowStatus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FollowRepository @Inject constructor(
  private val dao: FollowDao
) : IFollowRepository{

  override fun insertOrUpdate(channelId: ChannelId): Single<Unit> {
    val data = Follow(channelId = channelId.id)
    return Single.create<Unit> {
      it.onSuccess(dao.insertOrUpdate(data))
    }.subscribeOn(Schedulers.io())
  }

  override fun delete(channelId: ChannelId): Single<Unit> {
    val data = Follow(channelId = channelId.id)
    return Single.create<Unit> {
      it.onSuccess(dao.delete(data))
    }.subscribeOn(Schedulers.io())
  }

  override fun followStatus(channelId: ChannelId): Single<FollowStatus> {
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
