package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class SupportSQLiteCompat {

    public static final class Api16Impl {
        public static final Api16Impl INSTANCE = new Api16Impl();

        private Api16Impl() {
        }

        public static final void cancel(CancellationSignal cancellationSignal) {
            e.f(cancellationSignal, "cancellationSignal");
            cancellationSignal.cancel();
        }

        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        public static final boolean deleteDatabase(File file) {
            e.f(file, "file");
            return SQLiteDatabase.deleteDatabase(file);
        }

        public static final void disableWriteAheadLogging(SQLiteDatabase sQLiteDatabase) {
            e.f(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.disableWriteAheadLogging();
        }

        public static final boolean isWriteAheadLoggingEnabled(SQLiteDatabase sQLiteDatabase) {
            e.f(sQLiteDatabase, "sQLiteDatabase");
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        public static final Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, String sql, String[] selectionArgs, String str, CancellationSignal cancellationSignal, SQLiteDatabase.CursorFactory cursorFactory) {
            e.f(sQLiteDatabase, "sQLiteDatabase");
            e.f(sql, "sql");
            e.f(selectionArgs, "selectionArgs");
            e.f(cancellationSignal, "cancellationSignal");
            e.f(cursorFactory, "cursorFactory");
            Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, sql, selectionArgs, str, cancellationSignal);
            e.e(rawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
            return rawQueryWithFactory;
        }

        public static final void setForeignKeyConstraintsEnabled(SQLiteDatabase sQLiteDatabase, boolean z5) {
            e.f(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z5);
        }

        public static final void setWriteAheadLoggingEnabled(SQLiteOpenHelper sQLiteOpenHelper, boolean z5) {
            e.f(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z5);
        }
    }

    public static final class Api19Impl {
        public static final Api19Impl INSTANCE = new Api19Impl();

        private Api19Impl() {
        }

        public static final Uri getNotificationUri(Cursor cursor) {
            e.f(cursor, "cursor");
            Uri notificationUri = cursor.getNotificationUri();
            e.e(notificationUri, "cursor.notificationUri");
            return notificationUri;
        }

        public static final boolean isLowRamDevice(ActivityManager activityManager) {
            e.f(activityManager, "activityManager");
            return activityManager.isLowRamDevice();
        }
    }

    public static final class Api21Impl {
        public static final Api21Impl INSTANCE = new Api21Impl();

        private Api21Impl() {
        }

        public static final File getNoBackupFilesDir(Context context) {
            e.f(context, "context");
            File noBackupFilesDir = context.getNoBackupFilesDir();
            e.e(noBackupFilesDir, "context.noBackupFilesDir");
            return noBackupFilesDir;
        }
    }

    public static final class Api23Impl {
        public static final Api23Impl INSTANCE = new Api23Impl();

        private Api23Impl() {
        }

        public static final void setExtras(Cursor cursor, Bundle extras) {
            e.f(cursor, "cursor");
            e.f(extras, "extras");
            cursor.setExtras(extras);
        }
    }

    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        public static final List<Uri> getNotificationUris(Cursor cursor) {
            e.f(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            e.c(notificationUris);
            return notificationUris;
        }

        public static final void setNotificationUris(Cursor cursor, ContentResolver cr, List<? extends Uri> uris) {
            e.f(cursor, "cursor");
            e.f(cr, "cr");
            e.f(uris, "uris");
            cursor.setNotificationUris(cr, uris);
        }
    }

    private SupportSQLiteCompat() {
    }
}
