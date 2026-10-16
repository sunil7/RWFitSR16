package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class pc implements ThreadFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final int f4856i;

    /* renamed from: j, reason: collision with root package name */
    private static final int f4857j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f4858k;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f4859a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadFactory f4860b;

    /* renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f4861c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4862d;
    private final int e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4863f;

    /* renamed from: g, reason: collision with root package name */
    private final BlockingQueue<Runnable> f4864g;

    /* renamed from: h, reason: collision with root package name */
    private final int f4865h;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f4866a;

        /* renamed from: b, reason: collision with root package name */
        private String f4867b;

        /* renamed from: c, reason: collision with root package name */
        private int f4868c = pc.f4857j;

        /* renamed from: d, reason: collision with root package name */
        private int f4869d;
        private BlockingQueue<Runnable> e;

        public a() {
            int unused = pc.f4858k;
            this.f4869d = 30;
        }

        public static /* synthetic */ ThreadFactory a(a aVar) {
            aVar.getClass();
            return null;
        }

        public static /* synthetic */ Integer f(a aVar) {
            aVar.getClass();
            return null;
        }

        public static /* synthetic */ Boolean g(a aVar) {
            aVar.getClass();
            return null;
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("Naming pattern must not be null!");
            }
            this.f4867b = str;
            return this;
        }

        public a b(int i3) {
            if (this.f4868c > 0) {
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public a a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler != null) {
                this.f4866a = uncaughtExceptionHandler;
                return this;
            }
            throw new NullPointerException("Uncaught exception handler must not be null!");
        }

        public a a(int i3) {
            if (i3 > 0) {
                this.f4868c = i3;
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public a a(BlockingQueue<Runnable> blockingQueue) {
            this.e = blockingQueue;
            return this;
        }

        public pc a() {
            pc pcVar = new pc(this, (byte) 0);
            this.f4866a = null;
            this.f4867b = null;
            return pcVar;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f4856i = availableProcessors;
        f4857j = Math.max(2, Math.min(availableProcessors - 1, 4));
        f4858k = (availableProcessors * 2) + 1;
    }

    public /* synthetic */ pc(a aVar, byte b3) {
        this(aVar);
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f4865h;
    }

    public int e() {
        return this.f4863f;
    }

    public BlockingQueue<Runnable> f() {
        return this.f4864g;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f4860b.newThread(runnable);
        if (this.f4862d != null) {
            newThread.setName(String.format(r5.a.f(new StringBuilder(), this.f4862d, "-%d"), Long.valueOf(this.f4859a.incrementAndGet())));
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4861c;
        if (uncaughtExceptionHandler != null) {
            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        return newThread;
    }

    private pc(a aVar) {
        a.a(aVar);
        this.f4860b = Executors.defaultThreadFactory();
        int i3 = aVar.f4868c;
        this.e = i3;
        int i10 = f4858k;
        this.f4863f = i10;
        if (i10 < i3) {
            throw new NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.f4865h = aVar.f4869d;
        if (aVar.e == null) {
            this.f4864g = new LinkedBlockingQueue(256);
        } else {
            this.f4864g = aVar.e;
        }
        if (TextUtils.isEmpty(aVar.f4867b)) {
            this.f4862d = "amap-threadpool";
        } else {
            this.f4862d = aVar.f4867b;
        }
        a.f(aVar);
        a.g(aVar);
        this.f4861c = aVar.f4866a;
        this.f4859a = new AtomicLong();
    }
}
