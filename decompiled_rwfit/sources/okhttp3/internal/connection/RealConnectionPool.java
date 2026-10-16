package okhttp3.internal.connection;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import r5.a;

/* loaded from: classes2.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public static final class Companion {
        private Companion() {
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            e.f(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i3, long j4, TimeUnit timeUnit) {
        e.f(taskRunner, "taskRunner");
        e.f(timeUnit, "timeUnit");
        this.maxIdleConnections = i3;
        this.keepAliveDurationNs = timeUnit.toNanos(j4);
        this.cleanupQueue = taskRunner.newQueue();
        final String f2 = a.f(new StringBuilder(), Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(f2) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (!(j4 > 0)) {
            throw new IllegalArgumentException(l0.l(j4, "keepAliveDuration <= 0: ").toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j4) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(realConnection);
            throw new AssertionError(sb2.toString());
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i3 = 0;
        while (i3 < calls.size()) {
            Reference<RealCall> reference = calls.get(i3);
            if (reference.get() != null) {
                i3++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i3);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(j4 - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    public final boolean callAcquirePooledConnection(Address address, RealCall call, List<Route> list, boolean z5) {
        e.f(address, "address");
        e.f(call, "call");
        Iterator<RealConnection> it = this.connections.iterator();
        while (it.hasNext()) {
            RealConnection connection = it.next();
            e.e(connection, "connection");
            synchronized (connection) {
                if (z5) {
                    try {
                        if (!connection.isMultiplexed$okhttp()) {
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (connection.isEligible$okhttp(address, list)) {
                    call.acquireConnectionNoEvents(connection);
                    return true;
                }
            }
        }
        return false;
    }

    public final long cleanup(long j4) {
        Iterator<RealConnection> it = this.connections.iterator();
        int i3 = 0;
        long j10 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i10 = 0;
        while (it.hasNext()) {
            RealConnection connection = it.next();
            e.e(connection, "connection");
            synchronized (connection) {
                if (pruneAndGetAllocationCount(connection, j4) > 0) {
                    i10++;
                } else {
                    i3++;
                    long idleAtNs$okhttp = j4 - connection.getIdleAtNs$okhttp();
                    if (idleAtNs$okhttp > j10) {
                        realConnection = connection;
                        j10 = idleAtNs$okhttp;
                    }
                }
            }
        }
        long j11 = this.keepAliveDurationNs;
        if (j10 < j11 && i3 <= this.maxIdleConnections) {
            if (i3 > 0) {
                return j11 - j10;
            }
            if (i10 > 0) {
                return j11;
            }
            return -1L;
        }
        e.c(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs$okhttp() + j10 != j4) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection connection) {
        e.f(connection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(connection)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(connection);
            throw new AssertionError(sb2.toString());
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        connection.setNoNewExchanges(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        e.e(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection connection = it.next();
            e.e(connection, "connection");
            synchronized (connection) {
                if (connection.getCalls().isEmpty()) {
                    it.remove();
                    connection.setNoNewExchanges(true);
                    socket = connection.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i3 = 0;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.isEmpty()) {
            return 0;
        }
        for (RealConnection it : concurrentLinkedQueue) {
            e.e(it, "it");
            synchronized (it) {
                isEmpty = it.getCalls().isEmpty();
            }
            if (isEmpty && (i3 = i3 + 1) < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i3;
    }

    public final void put(RealConnection connection) {
        e.f(connection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(connection)) {
            this.connections.add(connection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return;
        }
        StringBuilder sb2 = new StringBuilder("Thread ");
        Thread currentThread = Thread.currentThread();
        e.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(connection);
        throw new AssertionError(sb2.toString());
    }
}
