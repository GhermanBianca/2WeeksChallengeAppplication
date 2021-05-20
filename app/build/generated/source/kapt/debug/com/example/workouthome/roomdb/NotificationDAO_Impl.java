package com.example.workouthome.roomdb;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

import com.example.workouthome.dao.NotificationDAO;
import com.example.workouthome.model.NotificationEntity;

import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class NotificationDAO_Impl implements NotificationDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfNotificationEntity;

  public NotificationDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotificationEntity = new EntityInsertionAdapter<NotificationEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `NotificationEntity`(`userEmail`,`NOTIFICATION_STATUS`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NotificationEntity value) {
        if (value.getUserEmail() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserEmail());
        }
        final int _tmp;
        _tmp = value.getWasActivated() ? 1 : 0;
        stmt.bindLong(2, _tmp);
      }
    };
  }

  @Override
  public void saveNotification(NotificationEntity notification) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfNotificationEntity.insert(notification);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
