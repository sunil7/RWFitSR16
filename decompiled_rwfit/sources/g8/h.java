package g8;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final h f13891b = new h(0);

    /* renamed from: c, reason: collision with root package name */
    public static final h f13892c = new h(1);

    /* renamed from: d, reason: collision with root package name */
    public static final h f13893d = new h(2);
    public static final h e = new h(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13894a;

    public /* synthetic */ h(int i3) {
        this.f13894a = i3;
    }

    @Override // g8.i
    public final void a(SQLiteDatabase sQLiteDatabase) {
        switch (this.f13894a) {
            case 0:
                List list = j.f13895c;
                sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
                sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
                sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
                sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
                break;
            case 1:
                List list2 = j.f13895c;
                sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
                sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
                break;
            case 2:
                List list3 = j.f13895c;
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
                break;
            default:
                List list4 = j.f13895c;
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
                sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
                break;
        }
    }
}
