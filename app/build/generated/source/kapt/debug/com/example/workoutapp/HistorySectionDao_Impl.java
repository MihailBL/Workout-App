package com.example.workoutapp;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HistorySectionDao_Impl implements HistorySectionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistorySectionEntity> __insertionAdapterOfHistorySectionEntity;

  private final EntityDeletionOrUpdateAdapter<HistorySectionEntity> __deletionAdapterOfHistorySectionEntity;

  public HistorySectionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistorySectionEntity = new EntityInsertionAdapter<HistorySectionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `history-table` (`date`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistorySectionEntity value) {
        if (value.getDate() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDate());
        }
      }
    };
    this.__deletionAdapterOfHistorySectionEntity = new EntityDeletionOrUpdateAdapter<HistorySectionEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `history-table` WHERE `date` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistorySectionEntity value) {
        if (value.getDate() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDate());
        }
      }
    };
  }

  @Override
  public Object insert(final HistorySectionEntity historyEntity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHistorySectionEntity.insert(historyEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final HistorySectionEntity historyEntity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfHistorySectionEntity.handle(historyEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllDatesForCompletedExercises(
      final Continuation<? super List<HistorySectionEntity>> continuation) {
    final String _sql = "SELECT * FROM 'history-table'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<HistorySectionEntity>>() {
      @Override
      public List<HistorySectionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<HistorySectionEntity> _result = new ArrayList<HistorySectionEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final HistorySectionEntity _item;
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            _item = new HistorySectionEntity(_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
