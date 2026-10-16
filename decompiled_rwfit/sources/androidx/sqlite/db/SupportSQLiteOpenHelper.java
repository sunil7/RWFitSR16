package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteCompat;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;

/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable, AutoCloseable {

    public static abstract class Callback {
        public static final Companion Companion = new Companion(null);
        private static final String TAG = "SupportSQLite";
        public final int version;

        public static final class Companion {
            public /* synthetic */ Companion(c cVar) {
                this();
            }

            private Companion() {
            }
        }

        public Callback(int i3) {
            this.version = i3;
        }

        private final void deleteDatabaseFile(String str) {
            if (m.f(str, ":memory:")) {
                return;
            }
            int length = str.length() - 1;
            int i3 = 0;
            boolean z5 = false;
            while (i3 <= length) {
                boolean z6 = e.h(str.charAt(!z5 ? i3 : length), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z6) {
                    i3++;
                } else {
                    z5 = true;
                }
            }
            if (str.subSequence(i3, length + 1).toString().length() == 0) {
                return;
            }
            Log.w(TAG, "deleting the database file: ".concat(str));
            try {
                SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(str));
            } catch (Exception e) {
                Log.w(TAG, "delete failed: ", e);
            }
        }

        public void onConfigure(SupportSQLiteDatabase db2) {
            e.f(db2, "db");
        }

        public void onCorruption(SupportSQLiteDatabase db2) {
            e.f(db2, "db");
            Log.e(TAG, "Corruption reported by sqlite on database: " + db2 + ".path");
            if (!db2.isOpen()) {
                String path = db2.getPath();
                if (path != null) {
                    deleteDatabaseFile(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = db2.getAttachedDbs();
                } catch (SQLiteException unused) {
                }
                try {
                    db2.close();
                } catch (IOException unused2) {
                }
                if (list != null) {
                    return;
                }
            } finally {
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        e.e(obj, "p.second");
                        deleteDatabaseFile((String) obj);
                    }
                } else {
                    String path2 = db2.getPath();
                    if (path2 != null) {
                        deleteDatabaseFile(path2);
                    }
                }
            }
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(SupportSQLiteDatabase db2, int i3, int i10) {
            e.f(db2, "db");
            throw new SQLiteException(l0.i(i3, i10, "Can't downgrade database from version ", " to "));
        }

        public void onOpen(SupportSQLiteDatabase db2) {
            e.f(db2, "db");
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i3, int i10);
    }

    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z5);

    public static final class Configuration {
        public static final Companion Companion = new Companion(null);
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context context) {
                e.f(context, "context");
                this.context = context;
            }

            public Builder allowDataLossOnRecovery(boolean z5) {
                this.allowDataLossOnRecovery = z5;
                return this;
            }

            public Configuration build() {
                String str;
                Callback callback = this.callback;
                if (callback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.useNoBackupDirectory && ((str = this.name) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new Configuration(this.context, this.name, callback, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
            }

            public Builder callback(Callback callback) {
                e.f(callback, "callback");
                this.callback = callback;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder noBackupDirectory(boolean z5) {
                this.useNoBackupDirectory = z5;
                return this;
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(c cVar) {
                this();
            }

            public final Builder builder(Context context) {
                e.f(context, "context");
                return new Builder(context);
            }

            private Companion() {
            }
        }

        public Configuration(Context context, String str, Callback callback, boolean z5, boolean z6) {
            e.f(context, "context");
            e.f(callback, "callback");
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z5;
            this.allowDataLossOnRecovery = z6;
        }

        public static final Builder builder(Context context) {
            return Companion.builder(context);
        }

        public /* synthetic */ Configuration(Context context, String str, Callback callback, boolean z5, boolean z6, int i3, c cVar) {
            this(context, str, callback, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? false : z6);
        }
    }
}
