package com.example.workouthome.roomdb;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.workouthome.dao.NotificationDAO;
import com.example.workouthome.dao.NotificationDAO_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotificationDB_Impl extends NotificationDB {
  private volatile NotificationDAO _notificationDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `notification_table` (`userId` TEXT NOT NULL, `wasActivated` INTEGER NOT NULL, `notificationDescription` TEXT NOT NULL, PRIMARY KEY(`userId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '41c5f765131ade0c4f20be49e2580597')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `notification_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
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
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsNotificationTable = new HashMap<String, TableInfo.Column>(3);
        _columnsNotificationTable.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTable.put("wasActivated", new TableInfo.Column("wasActivated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationTable.put("notificationDescription", new TableInfo.Column("notificationDescription", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotificationTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationTable = new TableInfo("notification_table", _columnsNotificationTable, _foreignKeysNotificationTable, _indicesNotificationTable);
        final TableInfo _existingNotificationTable = TableInfo.read(_db, "notification_table");
        if (! _infoNotificationTable.equals(_existingNotificationTable)) {
          return new RoomOpenHelper.ValidationResult(false, "notification_table(com.example.workouthome.model.NotificationEntity).\n"
                  + " Expected:\n" + _infoNotificationTable + "\n"
                  + " Found:\n" + _existingNotificationTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "41c5f765131ade0c4f20be49e2580597", "9a3606e2ca932170a4b19904b6b859d0");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "notification_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `notification_table`");
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
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(NotificationDAO.class, NotificationDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
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
