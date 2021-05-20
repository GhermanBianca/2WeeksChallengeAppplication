package com.example.workouthome.roomdb;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class NotificationDB_Impl extends NotificationDB {
  private volatile NotificationDAO _notificationDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `NotificationEntity` (`userEmail` TEXT NOT NULL, `NOTIFICATION_STATUS` INTEGER NOT NULL, PRIMARY KEY(`userEmail`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"959bb9c927ad371fa8fc0441927d5e7e\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `NotificationEntity`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsNotificationEntity = new HashMap<String, TableInfo.Column>(2);
        _columnsNotificationEntity.put("userEmail", new TableInfo.Column("userEmail", "TEXT", true, 1));
        _columnsNotificationEntity.put("NOTIFICATION_STATUS", new TableInfo.Column("NOTIFICATION_STATUS", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotificationEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationEntity = new TableInfo("NotificationEntity", _columnsNotificationEntity, _foreignKeysNotificationEntity, _indicesNotificationEntity);
        final TableInfo _existingNotificationEntity = TableInfo.read(_db, "NotificationEntity");
        if (! _infoNotificationEntity.equals(_existingNotificationEntity)) {
          throw new IllegalStateException("Migration didn't properly handle NotificationEntity(com.example.workouthome.model.NotificationEntity).\n"
                  + " Expected:\n" + _infoNotificationEntity + "\n"
                  + " Found:\n" + _existingNotificationEntity);
        }
      }
    }, "959bb9c927ad371fa8fc0441927d5e7e", "304587f9859203660918890e0828dd83");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "NotificationEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `NotificationEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public NotificationDAO notificationDAO() {
    if (_notificationDAO != null) {
      return _notificationDAO;
    } else {
      synchronized(this) {
        if(_notificationDAO == null) {
          _notificationDAO = new NotificationDAO_Impl(this);
        }
        return _notificationDAO;
      }
    }
  }
}
