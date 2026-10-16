package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import net.zetetic.database.sqlcipher.SQLiteConnection;

/* loaded from: classes2.dex */
public final class SQLiteConnectionPool implements Closeable, AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    public final SQLiteDatabaseConfiguration f16509d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16510f;

    /* renamed from: g, reason: collision with root package name */
    public int f16511g;

    /* renamed from: h, reason: collision with root package name */
    public ConnectionWaiter f16512h;

    /* renamed from: i, reason: collision with root package name */
    public ConnectionWaiter f16513i;

    /* renamed from: k, reason: collision with root package name */
    public SQLiteConnection f16515k;

    /* renamed from: a, reason: collision with root package name */
    public final CloseGuard f16506a = new CloseGuard();

    /* renamed from: b, reason: collision with root package name */
    public final Object f16507b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f16508c = new AtomicBoolean();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f16514j = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final WeakHashMap f16516l = new WeakHashMap();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AcquiredConnectionStatus {
        public static final AcquiredConnectionStatus DISCARD;
        public static final AcquiredConnectionStatus NORMAL;
        public static final AcquiredConnectionStatus RECONFIGURE;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AcquiredConnectionStatus[] f16520a;

        static {
            AcquiredConnectionStatus acquiredConnectionStatus = new AcquiredConnectionStatus("NORMAL", 0);
            NORMAL = acquiredConnectionStatus;
            AcquiredConnectionStatus acquiredConnectionStatus2 = new AcquiredConnectionStatus("RECONFIGURE", 1);
            RECONFIGURE = acquiredConnectionStatus2;
            AcquiredConnectionStatus acquiredConnectionStatus3 = new AcquiredConnectionStatus("DISCARD", 2);
            DISCARD = acquiredConnectionStatus3;
            f16520a = new AcquiredConnectionStatus[]{acquiredConnectionStatus, acquiredConnectionStatus2, acquiredConnectionStatus3};
        }

        public static AcquiredConnectionStatus valueOf(String str) {
            return (AcquiredConnectionStatus) Enum.valueOf(AcquiredConnectionStatus.class, str);
        }

        public static AcquiredConnectionStatus[] values() {
            return (AcquiredConnectionStatus[]) f16520a.clone();
        }
    }

    public static final class ConnectionWaiter {

        /* renamed from: a, reason: collision with root package name */
        public ConnectionWaiter f16521a;

        /* renamed from: b, reason: collision with root package name */
        public Thread f16522b;

        /* renamed from: c, reason: collision with root package name */
        public long f16523c;

        /* renamed from: d, reason: collision with root package name */
        public int f16524d;
        public boolean e;

        /* renamed from: f, reason: collision with root package name */
        public String f16525f;

        /* renamed from: g, reason: collision with root package name */
        public int f16526g;

        /* renamed from: h, reason: collision with root package name */
        public SQLiteConnection f16527h;

        /* renamed from: i, reason: collision with root package name */
        public RuntimeException f16528i;

        /* renamed from: j, reason: collision with root package name */
        public int f16529j;
    }

    public SQLiteConnectionPool(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.f16509d = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        A();
    }

    public static void c(SQLiteConnection sQLiteConnection) {
        try {
            sQLiteConnection.g(false);
        } catch (RuntimeException e) {
            Log.e("SQLiteConnectionPool", "Failed to close connection, its fate is now in the hands of the merciful GC: " + sQLiteConnection, e);
        }
    }

    public final void A() {
        if ((this.f16509d.f16555c & 536870912) != 0) {
            this.e = Math.max(2, 10);
        } else {
            this.e = 1;
        }
    }

    public final void F() {
        if (!this.f16510f) {
            throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
        }
    }

    public final SQLiteConnection I(int i3, String str) {
        ArrayList arrayList = this.f16514j;
        int size = arrayList.size();
        if (size > 1 && str != null) {
            for (int i10 = 0; i10 < size; i10++) {
                SQLiteConnection sQLiteConnection = (SQLiteConnection) arrayList.get(i10);
                if (sQLiteConnection.f16482g.get(str) != null) {
                    arrayList.remove(i10);
                    f(sQLiteConnection, i3);
                    return sQLiteConnection;
                }
            }
        }
        if (size > 0) {
            SQLiteConnection sQLiteConnection2 = (SQLiteConnection) arrayList.remove(size - 1);
            f(sQLiteConnection2, i3);
            return sQLiteConnection2;
        }
        int size2 = this.f16516l.size();
        if (this.f16515k != null) {
            size2++;
        }
        if (size2 >= this.e) {
            return null;
        }
        SQLiteConnection i11 = i(this.f16509d, false);
        f(i11, i3);
        return i11;
    }

    public final SQLiteConnection O(int i3) {
        SQLiteConnection sQLiteConnection = this.f16515k;
        if (sQLiteConnection != null) {
            this.f16515k = null;
            f(sQLiteConnection, i3);
            return sQLiteConnection;
        }
        Iterator it = this.f16516l.keySet().iterator();
        while (it.hasNext()) {
            if (((SQLiteConnection) it.next()).e) {
                return null;
            }
        }
        SQLiteConnection i10 = i(this.f16509d, true);
        f(i10, i3);
        return i10;
    }

    public final void W() {
        SQLiteConnection sQLiteConnection;
        ConnectionWaiter connectionWaiter = this.f16513i;
        ConnectionWaiter connectionWaiter2 = null;
        boolean z5 = false;
        boolean z6 = false;
        while (connectionWaiter != null) {
            boolean z8 = true;
            if (this.f16510f) {
                try {
                    if (connectionWaiter.e || z5) {
                        sQLiteConnection = null;
                    } else {
                        sQLiteConnection = I(connectionWaiter.f16526g, connectionWaiter.f16525f);
                        if (sQLiteConnection == null) {
                            z5 = true;
                        }
                    }
                    if (sQLiteConnection == null && !z6 && (sQLiteConnection = O(connectionWaiter.f16526g)) == null) {
                        z6 = true;
                    }
                    if (sQLiteConnection != null) {
                        connectionWaiter.f16527h = sQLiteConnection;
                    } else if (z5 && z6) {
                        return;
                    } else {
                        z8 = false;
                    }
                } catch (RuntimeException e) {
                    connectionWaiter.f16528i = e;
                }
            }
            ConnectionWaiter connectionWaiter3 = connectionWaiter.f16521a;
            if (z8) {
                if (connectionWaiter2 != null) {
                    connectionWaiter2.f16521a = connectionWaiter3;
                } else {
                    this.f16513i = connectionWaiter3;
                }
                connectionWaiter.f16521a = null;
                LockSupport.unpark(connectionWaiter.f16522b);
            } else {
                connectionWaiter2 = connectionWaiter;
            }
            connectionWaiter = connectionWaiter3;
        }
    }

    public final void b() {
        ArrayList arrayList = this.f16514j;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            c((SQLiteConnection) arrayList.get(i3));
        }
        arrayList.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        e(false);
    }

    public final void e(boolean z5) {
        Throwable th2;
        CloseGuard closeGuard = this.f16506a;
        if (z5 && (th2 = closeGuard.f16473a) != null) {
            Log.w("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", th2);
        }
        this.f16506a.f16473a = null;
        if (z5) {
            return;
        }
        synchronized (this.f16507b) {
            try {
                F();
                this.f16510f = false;
                b();
                SQLiteConnection sQLiteConnection = this.f16515k;
                if (sQLiteConnection != null) {
                    c(sQLiteConnection);
                    this.f16515k = null;
                }
                int size = this.f16516l.size();
                if (size != 0) {
                    Log.i("SQLiteConnectionPool", "The connection pool for " + this.f16509d.f16554b + " has been closed but there are still " + size + " connections in use.  They will be closed as they are released back to the pool.");
                }
                W();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void f(SQLiteConnection sQLiteConnection, int i3) {
        try {
            sQLiteConnection.f16486k = (i3 & 1) != 0;
            this.f16516l.put(sQLiteConnection, AcquiredConnectionStatus.NORMAL);
        } catch (RuntimeException e) {
            Log.e("SQLiteConnectionPool", "Failed to prepare acquired connection for session, closing it: " + sQLiteConnection + ", connectionFlags=" + i3);
            c(sQLiteConnection);
            throw e;
        }
    }

    public final void finalize() {
        try {
            e(true);
        } finally {
            super.finalize();
        }
    }

    public final void g(int i3, long j4) {
        int i10;
        int i11;
        String str;
        Thread currentThread = Thread.currentThread();
        StringBuilder sb2 = new StringBuilder("The connection pool for database '");
        sb2.append(this.f16509d.f16554b);
        sb2.append("' has been unable to grant a connection to thread ");
        sb2.append(currentThread.getId());
        sb2.append(" (");
        sb2.append(currentThread.getName());
        sb2.append(") with flags 0x");
        sb2.append(Integer.toHexString(i3));
        sb2.append(" for ");
        sb2.append(j4 * 0.001f);
        sb2.append(" seconds.\n");
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        if (this.f16516l.isEmpty()) {
            i10 = 0;
            i11 = 0;
        } else {
            Iterator it = this.f16516l.keySet().iterator();
            i10 = 0;
            i11 = 0;
            while (it.hasNext()) {
                SQLiteConnection.OperationLog operationLog = ((SQLiteConnection) it.next()).f16484i;
                synchronized (operationLog.f16496a) {
                    try {
                        SQLiteConnection.Operation operation = operationLog.f16496a[operationLog.f16497b];
                        if (operation == null || operation.f16493g) {
                            str = null;
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            operation.a(sb3);
                            str = sb3.toString();
                        }
                    } finally {
                    }
                }
                if (str != null) {
                    arrayList.add(str);
                    i10++;
                } else {
                    i11++;
                }
            }
        }
        int size = this.f16514j.size();
        if (this.f16515k != null) {
            size++;
        }
        sb2.append("Connections: ");
        sb2.append(i10);
        sb2.append(" active, ");
        sb2.append(i11);
        sb2.append(" idle, ");
        sb2.append(size);
        sb2.append(" available.\n");
        if (!arrayList.isEmpty()) {
            sb2.append("\nRequests in progress:\n");
            int size2 = arrayList.size();
            while (i12 < size2) {
                Object obj = arrayList.get(i12);
                i12++;
                sb2.append("  ");
                sb2.append((String) obj);
                sb2.append("\n");
            }
        }
        Log.w("SQLiteConnectionPool", sb2.toString());
    }

    public final void h(AcquiredConnectionStatus acquiredConnectionStatus) {
        WeakHashMap weakHashMap = this.f16516l;
        if (weakHashMap.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(weakHashMap.size());
        for (Map.Entry entry : weakHashMap.entrySet()) {
            AcquiredConnectionStatus acquiredConnectionStatus2 = (AcquiredConnectionStatus) entry.getValue();
            if (acquiredConnectionStatus != acquiredConnectionStatus2 && acquiredConnectionStatus2 != AcquiredConnectionStatus.DISCARD) {
                arrayList.add((SQLiteConnection) entry.getKey());
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            weakHashMap.put((SQLiteConnection) arrayList.get(i3), acquiredConnectionStatus);
        }
    }

    public final SQLiteConnection i(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, boolean z5) {
        int i3 = this.f16511g;
        this.f16511g = i3 + 1;
        SQLiteConnection sQLiteConnection = new SQLiteConnection(this, sQLiteDatabaseConfiguration, i3, z5);
        try {
            sQLiteConnection.p();
            return sQLiteConnection;
        } catch (SQLiteException e) {
            sQLiteConnection.g(false);
            throw e;
        }
    }

    public final void j(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration == null) {
            throw new IllegalArgumentException("configuration must not be null.");
        }
        synchronized (this.f16507b) {
            try {
                F();
                boolean z5 = ((sQLiteDatabaseConfiguration.f16555c ^ this.f16509d.f16555c) & 536870912) != 0;
                if (z5) {
                    if (!this.f16516l.isEmpty()) {
                        throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                    }
                    b();
                }
                if (sQLiteDatabaseConfiguration.f16557f != this.f16509d.f16557f && !this.f16516l.isEmpty()) {
                    throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                }
                if (!Arrays.equals(sQLiteDatabaseConfiguration.f16558g, this.f16509d.f16558g)) {
                    this.f16515k.e(sQLiteDatabaseConfiguration.f16558g);
                    this.f16509d.a(sQLiteDatabaseConfiguration);
                    b();
                    k();
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.f16509d;
                if (sQLiteDatabaseConfiguration2.f16555c != sQLiteDatabaseConfiguration.f16555c) {
                    if (z5) {
                        b();
                        SQLiteConnection sQLiteConnection = this.f16515k;
                        if (sQLiteConnection != null) {
                            c(sQLiteConnection);
                            this.f16515k = null;
                        }
                    }
                    SQLiteConnection i3 = i(sQLiteDatabaseConfiguration, true);
                    b();
                    SQLiteConnection sQLiteConnection2 = this.f16515k;
                    if (sQLiteConnection2 != null) {
                        c(sQLiteConnection2);
                        this.f16515k = null;
                    }
                    h(AcquiredConnectionStatus.DISCARD);
                    this.f16515k = i3;
                    this.f16509d.a(sQLiteDatabaseConfiguration);
                    A();
                } else {
                    sQLiteDatabaseConfiguration2.a(sQLiteDatabaseConfiguration);
                    A();
                    ArrayList arrayList = this.f16514j;
                    int size = arrayList.size();
                    while (true) {
                        int i10 = size - 1;
                        if (size <= this.e - 1) {
                            break;
                        }
                        c((SQLiteConnection) arrayList.remove(i10));
                        size = i10;
                    }
                    k();
                }
                W();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k() {
        SQLiteConnection sQLiteConnection = this.f16515k;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.f16509d;
        if (sQLiteConnection != null) {
            try {
                sQLiteConnection.r(sQLiteDatabaseConfiguration);
            } catch (RuntimeException e) {
                Log.e("SQLiteConnectionPool", "Failed to reconfigure available primary connection, closing it: " + this.f16515k, e);
                c(this.f16515k);
                this.f16515k = null;
            }
        }
        ArrayList arrayList = this.f16514j;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            SQLiteConnection sQLiteConnection2 = (SQLiteConnection) arrayList.get(i3);
            try {
                sQLiteConnection2.r(sQLiteDatabaseConfiguration);
            } catch (RuntimeException e10) {
                Log.e("SQLiteConnectionPool", "Failed to reconfigure available non-primary connection, closing it: " + sQLiteConnection2, e10);
                c(sQLiteConnection2);
                arrayList.remove(i3);
                size--;
                i3--;
            }
            i3++;
        }
        h(AcquiredConnectionStatus.RECONFIGURE);
    }

    public final boolean l(SQLiteConnection sQLiteConnection, AcquiredConnectionStatus acquiredConnectionStatus) {
        if (acquiredConnectionStatus == AcquiredConnectionStatus.RECONFIGURE) {
            try {
                sQLiteConnection.r(this.f16509d);
            } catch (RuntimeException e) {
                Log.e("SQLiteConnectionPool", "Failed to reconfigure released connection, closing it: " + sQLiteConnection, e);
                acquiredConnectionStatus = AcquiredConnectionStatus.DISCARD;
            }
        }
        if (acquiredConnectionStatus != AcquiredConnectionStatus.DISCARD) {
            return true;
        }
        c(sQLiteConnection);
        return false;
    }

    public final String toString() {
        return "SQLiteConnectionPool: " + this.f16509d.f16553a;
    }

    public final void y(SQLiteConnection sQLiteConnection) {
        synchronized (this.f16507b) {
            try {
                AcquiredConnectionStatus acquiredConnectionStatus = (AcquiredConnectionStatus) this.f16516l.remove(sQLiteConnection);
                if (acquiredConnectionStatus == null) {
                    throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                }
                if (!this.f16510f) {
                    c(sQLiteConnection);
                } else if (sQLiteConnection.e) {
                    if (l(sQLiteConnection, acquiredConnectionStatus)) {
                        this.f16515k = sQLiteConnection;
                    }
                    W();
                } else if (this.f16514j.size() >= this.e - 1) {
                    c(sQLiteConnection);
                } else {
                    if (l(sQLiteConnection, acquiredConnectionStatus)) {
                        this.f16514j.add(sQLiteConnection);
                    }
                    W();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
