package com.amap.api.col.p0003sl;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class fb implements Closeable, AutoCloseable {

    /* renamed from: o, reason: collision with root package name */
    static final Pattern f4128o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p, reason: collision with root package name */
    public static final Charset f4129p = Charset.forName("US-ASCII");

    /* renamed from: q, reason: collision with root package name */
    private static final ThreadFactory f4130q;
    static ThreadPoolExecutor r;

    /* renamed from: s, reason: collision with root package name */
    private static final OutputStream f4131s;

    /* renamed from: a, reason: collision with root package name */
    private final File f4132a;

    /* renamed from: b, reason: collision with root package name */
    private final File f4133b;

    /* renamed from: c, reason: collision with root package name */
    private final File f4134c;

    /* renamed from: d, reason: collision with root package name */
    private final File f4135d;
    private final int e;

    /* renamed from: f, reason: collision with root package name */
    private long f4136f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4137g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f4139i;

    /* renamed from: l, reason: collision with root package name */
    private int f4142l;

    /* renamed from: h, reason: collision with root package name */
    private long f4138h = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f4140j = 1000;

    /* renamed from: k, reason: collision with root package name */
    private final LinkedHashMap<String, f> f4141k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m, reason: collision with root package name */
    private long f4143m = 0;

    /* renamed from: n, reason: collision with root package name */
    private final Callable<Void> f4144n = new b();

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4145a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f4145a.getAndIncrement());
        }
    }

    public class b implements Callable<Void> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            synchronized (fb.this) {
                try {
                    if (fb.this.f4139i == null) {
                        return null;
                    }
                    fb.this.j();
                    if (fb.this.g()) {
                        fb.this.e();
                        fb.e(fb.this);
                    }
                    return null;
                } finally {
                }
            }
        }
    }

    public static class c extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int i3) throws IOException {
        }
    }

    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final f f4147a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f4148b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4149c;

        public class a extends FilterOutputStream implements AutoCloseable {
            public /* synthetic */ a(d dVar, OutputStream outputStream, byte b3) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.c(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.c(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i3) {
                try {
                    ((FilterOutputStream) this).out.write(i3);
                } catch (IOException unused) {
                    d.c(d.this);
                }
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i3, int i10) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i3, i10);
                } catch (IOException unused) {
                    d.c(d.this);
                }
            }
        }

        public /* synthetic */ d(fb fbVar, f fVar, byte b3) {
            this(fVar);
        }

        public static /* synthetic */ boolean c(d dVar) {
            dVar.f4149c = true;
            return true;
        }

        private d(f fVar) {
            this.f4147a = fVar;
            this.f4148b = fVar.f4155c ? null : new boolean[fb.this.f4137g];
        }

        public final OutputStream a(int i3) throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (i3 < 0 || i3 >= fb.this.f4137g) {
                StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Expected index ", " to be greater than 0 and less than the maximum value count of ");
                q5.append(fb.this.f4137g);
                throw new IllegalArgumentException(q5.toString());
            }
            synchronized (fb.this) {
                try {
                    if (this.f4147a.f4156d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f4147a.f4155c) {
                        this.f4148b[i3] = true;
                    }
                    File b3 = this.f4147a.b(i3);
                    try {
                        fileOutputStream = new FileOutputStream(b3);
                    } catch (FileNotFoundException unused) {
                        fb.this.f4132a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b3);
                        } catch (FileNotFoundException unused2) {
                            return fb.f4131s;
                        }
                    }
                    aVar = new a(this, fileOutputStream, (byte) 0);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return aVar;
        }

        public final void b() throws IOException {
            if (!this.f4149c) {
                fb.a(fb.this, this, true);
            } else {
                fb.a(fb.this, this, false);
                fb.this.d(this.f4147a.f4153a);
            }
        }

        public final void a() throws IOException {
            fb.a(fb.this, this, false);
        }
    }

    public final class e implements Closeable, AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream[] f4152a;

        public /* synthetic */ e(fb fbVar, String str, long j4, InputStream[] inputStreamArr, long[] jArr, byte b3) {
            this(fbVar, str, j4, inputStreamArr, jArr);
        }

        public final InputStream a(int i3) {
            return this.f4152a[i3];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f4152a) {
                fb.a(inputStream);
            }
        }

        private e(fb fbVar, String str, long j4, InputStream[] inputStreamArr, long[] jArr) {
            this.f4152a = inputStreamArr;
        }
    }

    public final class f {

        /* renamed from: a, reason: collision with root package name */
        private final String f4153a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f4154b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4155c;

        /* renamed from: d, reason: collision with root package name */
        private d f4156d;
        private long e;

        public /* synthetic */ f(fb fbVar, String str, byte b3) {
            this(str);
        }

        private f(String str) {
            this.f4153a = str;
            this.f4154b = new long[fb.this.f4137g];
        }

        public final File b(int i3) {
            return new File(fb.this.f4132a, this.f4153a + "." + i3 + ".tmp");
        }

        public static /* synthetic */ boolean a(f fVar) {
            fVar.f4155c = true;
            return true;
        }

        public final String a() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j4 : this.f4154b) {
                sb2.append(' ');
                sb2.append(j4);
            }
            return sb2.toString();
        }

        public final File a(int i3) {
            return new File(fb.this.f4132a, this.f4153a + "." + i3);
        }

        public static void a(f fVar, String[] strArr) throws IOException {
            if (strArr.length == fb.this.f4137g) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    try {
                        fVar.f4154b[i3] = Long.parseLong(strArr[i3]);
                    } catch (NumberFormatException unused) {
                        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
                    }
                }
                return;
            }
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    static {
        Charset.forName("UTF-8");
        a aVar = new a();
        f4130q = aVar;
        r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        f4131s = new c();
    }

    private fb(File file, int i3, int i10, long j4) {
        this.f4132a = file;
        this.e = i3;
        this.f4133b = new File(file, "journal");
        this.f4134c = new File(file, "journal.tmp");
        this.f4135d = new File(file, "journal.bkp");
        this.f4137g = i10;
        this.f4136f = j4;
    }

    public static /* synthetic */ int e(fb fbVar) {
        fbVar.f4142l = 0;
        return 0;
    }

    private void h() {
        if (this.f4139i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws IOException {
        while (true) {
            if (this.f4138h <= this.f4136f && this.f4141k.size() <= this.f4140j) {
                return;
            } else {
                d(this.f4141k.entrySet().iterator().next().getKey());
            }
        }
    }

    public static ThreadPoolExecutor l() {
        try {
            ThreadPoolExecutor threadPoolExecutor = r;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f4130q);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return r;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        try {
            if (this.f4139i == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f4141k.values());
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                f fVar = (f) obj;
                if (fVar.f4156d != null) {
                    fVar.f4156d.a();
                }
            }
            j();
            this.f4139i.close();
            this.f4139i = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void i() throws IOException {
        h();
        j();
        this.f4139i.flush();
    }

    public final File k() {
        return this.f4132a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.fb.b():void");
    }

    private void c() throws IOException {
        a(this.f4134c);
        Iterator<f> it = this.f4141k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i3 = 0;
            if (next.f4156d == null) {
                while (i3 < this.f4137g) {
                    this.f4138h += next.f4154b[i3];
                    i3++;
                }
            } else {
                next.f4156d = null;
                while (i3 < this.f4137g) {
                    a(next.a(i3));
                    a(next.b(i3));
                    i3++;
                }
                it.remove();
            }
        }
    }

    public static void d() {
        ThreadPoolExecutor threadPoolExecutor = r;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        r.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() throws IOException {
        try {
            Writer writer = this.f4139i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4134c), f4129p));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f4137g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (f fVar : this.f4141k.values()) {
                    if (fVar.f4156d != null) {
                        bufferedWriter.write("DIRTY " + fVar.f4153a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + fVar.f4153a + fVar.a() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f4133b.exists()) {
                    a(this.f4133b, this.f4135d, true);
                }
                a(this.f4134c, this.f4133b, false);
                this.f4135d.delete();
                this.f4139i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4133b, true), f4129p));
            } catch (Throwable th2) {
                bufferedWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        int i3 = this.f4142l;
        return i3 >= 2000 && i3 >= this.f4141k.size();
    }

    public final void f() throws IOException {
        close();
        b(this.f4132a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0008, code lost:
    
        if (r2 > 10000) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r2) {
        /*
            r1 = this;
            r0 = 10
            if (r2 >= r0) goto L6
        L4:
            r2 = r0
            goto Lb
        L6:
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r2 <= r0) goto Lb
            goto L4
        Lb:
            r1.f4140j = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.fb.a(int):void");
    }

    public static fb a(File file, int i3, int i10, long j4) throws IOException {
        if (j4 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i10 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            fb fbVar = new fb(file, i3, i10, j4);
            if (fbVar.f4133b.exists()) {
                try {
                    fbVar.b();
                    fbVar.c();
                    fbVar.f4139i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fbVar.f4133b, true), f4129p));
                    return fbVar;
                } catch (Throwable unused) {
                    fbVar.close();
                    b(fbVar.f4132a);
                }
            }
            file.mkdirs();
            fb fbVar2 = new fb(file, i3, i10, j4);
            fbVar2.e();
            return fbVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public final synchronized boolean d(String str) throws IOException {
        try {
            h();
            a(str);
            f fVar = this.f4141k.get(str);
            if (fVar != null && fVar.f4156d == null) {
                for (int i3 = 0; i3 < this.f4137g; i3++) {
                    File a3 = fVar.a(i3);
                    if (a3.exists() && !a3.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(a3)));
                    }
                    this.f4138h -= fVar.f4154b[i3];
                    fVar.f4154b[i3] = 0;
                }
                this.f4142l++;
                this.f4139i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f4141k.remove(str);
                if (g()) {
                    l().submit(this.f4144n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public final synchronized e c(String str) throws IOException {
        Throwable th2;
        InputStream inputStream;
        try {
            h();
            a(str);
            f fVar = this.f4141k.get(str);
            if (fVar == null) {
                return null;
            }
            if (!fVar.f4155c) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.f4137g];
            for (int i3 = 0; i3 < this.f4137g; i3++) {
                try {
                    try {
                        try {
                            inputStreamArr[i3] = new FileInputStream(fVar.a(i3));
                        } catch (Throwable th3) {
                            th2 = th3;
                            throw th2;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i10 = 0; i10 < this.f4137g && (inputStream = inputStreamArr[i10]) != null; i10++) {
                            a(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th2 = th;
                    throw th2;
                }
            }
            this.f4142l++;
            this.f4139i.append((CharSequence) ("READ " + str + '\n'));
            if (g()) {
                l().submit(this.f4144n);
            }
            return new e(this, str, fVar.e, inputStreamArr, fVar.f4154b, (byte) 0);
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z5) throws IOException {
        if (z5) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void a(fb fbVar, d dVar, boolean z5) throws IOException {
        synchronized (fbVar) {
            f fVar = dVar.f4147a;
            if (fVar.f4156d == dVar) {
                if (z5 && !fVar.f4155c) {
                    for (int i3 = 0; i3 < fbVar.f4137g; i3++) {
                        if (dVar.f4148b[i3]) {
                            if (!fVar.b(i3).exists()) {
                                dVar.a();
                                return;
                            }
                        } else {
                            dVar.a();
                            throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i3)));
                        }
                    }
                }
                for (int i10 = 0; i10 < fbVar.f4137g; i10++) {
                    File b3 = fVar.b(i10);
                    if (z5) {
                        if (b3.exists()) {
                            File a3 = fVar.a(i10);
                            b3.renameTo(a3);
                            long j4 = fVar.f4154b[i10];
                            long length = a3.length();
                            fVar.f4154b[i10] = length;
                            fbVar.f4138h = (fbVar.f4138h - j4) + length;
                        }
                    } else {
                        a(b3);
                    }
                }
                fbVar.f4142l++;
                fVar.f4156d = null;
                if (fVar.f4155c | z5) {
                    f.a(fVar);
                    fbVar.f4139i.write("CLEAN " + fVar.f4153a + fVar.a() + '\n');
                    if (z5) {
                        long j10 = fbVar.f4143m;
                        fbVar.f4143m = 1 + j10;
                        fVar.e = j10;
                    }
                } else {
                    fbVar.f4141k.remove(fVar.f4153a);
                    fbVar.f4139i.write("REMOVE " + fVar.f4153a + '\n');
                }
                fbVar.f4139i.flush();
                if (fbVar.f4138h > fbVar.f4136f || fbVar.g()) {
                    l().submit(fbVar.f4144n);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final d b(String str) throws IOException {
        synchronized (this) {
            try {
                h();
                a(str);
                f fVar = this.f4141k.get(str);
                byte b3 = 0;
                if (fVar != null) {
                    if (fVar.f4156d != null) {
                        return null;
                    }
                } else {
                    fVar = new f(this, str, b3);
                    this.f4141k.put(str, fVar);
                }
                d dVar = new d(this, fVar, b3);
                fVar.f4156d = dVar;
                this.f4139i.write("DIRTY " + str + '\n');
                this.f4139i.flush();
                return dVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    private static void a(String str) {
        if (!f4128o.matcher(str).matches()) {
            throw new IllegalArgumentException(l0.o("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }
}
