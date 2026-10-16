package v3;

import a2.g;
import android.os.StrictMode;
import com.google.android.gms.internal.mlkit_common.i;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final File f19156a;

    /* renamed from: b, reason: collision with root package name */
    public final File f19157b;

    /* renamed from: c, reason: collision with root package name */
    public final File f19158c;

    /* renamed from: d, reason: collision with root package name */
    public final File f19159d;

    /* renamed from: f, reason: collision with root package name */
    public final long f19160f;

    /* renamed from: i, reason: collision with root package name */
    public BufferedWriter f19163i;

    /* renamed from: k, reason: collision with root package name */
    public int f19165k;

    /* renamed from: h, reason: collision with root package name */
    public long f19162h = 0;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f19164j = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    public long f19166l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f19167m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());

    /* renamed from: n, reason: collision with root package name */
    public final i f19168n = new i(this, 3);
    public final int e = 1;

    /* renamed from: g, reason: collision with root package name */
    public final int f19161g = 1;

    public c(File file, long j4) {
        this.f19156a = file;
        this.f19157b = new File(file, "journal");
        this.f19158c = new File(file, "journal.tmp");
        this.f19159d = new File(file, "journal.bkp");
        this.f19160f = j4;
    }

    public static void F(File file, File file2, boolean z5) {
        if (z5) {
            e(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void b(c cVar, g gVar, boolean z5) {
        synchronized (cVar) {
            b bVar = (b) gVar.f33b;
            if (bVar.f19154f != gVar) {
                throw new IllegalStateException();
            }
            if (z5 && !bVar.e) {
                for (int i3 = 0; i3 < cVar.f19161g; i3++) {
                    if (!((boolean[]) gVar.f34c)[i3]) {
                        gVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                    }
                    if (!bVar.f19153d[i3].exists()) {
                        gVar.a();
                        return;
                    }
                }
            }
            for (int i10 = 0; i10 < cVar.f19161g; i10++) {
                File file = bVar.f19153d[i10];
                if (!z5) {
                    e(file);
                } else if (file.exists()) {
                    File file2 = bVar.f19152c[i10];
                    file.renameTo(file2);
                    long j4 = bVar.f19151b[i10];
                    long length = file2.length();
                    bVar.f19151b[i10] = length;
                    cVar.f19162h = (cVar.f19162h - j4) + length;
                }
            }
            cVar.f19165k++;
            bVar.f19154f = null;
            if (bVar.e || z5) {
                bVar.e = true;
                cVar.f19163i.append((CharSequence) "CLEAN");
                cVar.f19163i.append(' ');
                cVar.f19163i.append((CharSequence) bVar.f19150a);
                cVar.f19163i.append((CharSequence) bVar.a());
                cVar.f19163i.append('\n');
                if (z5) {
                    cVar.f19166l++;
                }
            } else {
                cVar.f19164j.remove(bVar.f19150a);
                cVar.f19163i.append((CharSequence) "REMOVE");
                cVar.f19163i.append(' ');
                cVar.f19163i.append((CharSequence) bVar.f19150a);
                cVar.f19163i.append('\n');
            }
            g(cVar.f19163i);
            if (cVar.f19162h > cVar.f19160f || cVar.i()) {
                cVar.f19167m.submit(cVar.f19168n);
            }
        }
    }

    public static void c(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void e(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void g(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static c j(File file, long j4) {
        if (j4 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                F(file2, file3, false);
            }
        }
        c cVar = new c(file, j4);
        if (cVar.f19157b.exists()) {
            try {
                cVar.l();
                cVar.k();
                return cVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                cVar.close();
                f.a(cVar.f19156a);
            }
        }
        file.mkdirs();
        c cVar2 = new c(file, j4);
        cVar2.A();
        return cVar2;
    }

    public final synchronized void A() {
        try {
            BufferedWriter bufferedWriter = this.f19163i;
            if (bufferedWriter != null) {
                c(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f19158c), f.f19174a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.e));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f19161g));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (b bVar : this.f19164j.values()) {
                    if (bVar.f19154f != null) {
                        bufferedWriter2.write("DIRTY " + bVar.f19150a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + bVar.f19150a + bVar.a() + '\n');
                    }
                }
                c(bufferedWriter2);
                if (this.f19157b.exists()) {
                    F(this.f19157b, this.f19159d, true);
                }
                F(this.f19158c, this.f19157b, false);
                this.f19159d.delete();
                this.f19163i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f19157b, true), f.f19174a));
            } catch (Throwable th2) {
                c(bufferedWriter2);
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final void I() {
        while (this.f19162h > this.f19160f) {
            String str = (String) ((Map.Entry) this.f19164j.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.f19163i == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    b bVar = (b) this.f19164j.get(str);
                    if (bVar != null && bVar.f19154f == null) {
                        for (int i3 = 0; i3 < this.f19161g; i3++) {
                            File file = bVar.f19152c[i3];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j4 = this.f19162h;
                            long[] jArr = bVar.f19151b;
                            this.f19162h = j4 - jArr[i3];
                            jArr[i3] = 0;
                        }
                        this.f19165k++;
                        this.f19163i.append((CharSequence) "REMOVE");
                        this.f19163i.append(' ');
                        this.f19163i.append((CharSequence) str);
                        this.f19163i.append('\n');
                        this.f19164j.remove(str);
                        if (i()) {
                            this.f19167m.submit(this.f19168n);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f19163i == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f19164j.values());
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                g gVar = ((b) obj).f19154f;
                if (gVar != null) {
                    gVar.a();
                }
            }
            I();
            c(this.f19163i);
            this.f19163i = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final g f(String str) {
        synchronized (this) {
            try {
                if (this.f19163i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                b bVar = (b) this.f19164j.get(str);
                if (bVar == null) {
                    bVar = new b(this, str);
                    this.f19164j.put(str, bVar);
                } else if (bVar.f19154f != null) {
                    return null;
                }
                g gVar = new g(this, bVar);
                bVar.f19154f = gVar;
                this.f19163i.append((CharSequence) "DIRTY");
                this.f19163i.append(' ');
                this.f19163i.append((CharSequence) str);
                this.f19163i.append('\n');
                g(this.f19163i);
                return gVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized mc.g h(String str) {
        if (this.f19163i == null) {
            throw new IllegalStateException("cache is closed");
        }
        b bVar = (b) this.f19164j.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.e) {
            return null;
        }
        for (File file : bVar.f19152c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f19165k++;
        this.f19163i.append((CharSequence) "READ");
        this.f19163i.append(' ');
        this.f19163i.append((CharSequence) str);
        this.f19163i.append('\n');
        if (i()) {
            this.f19167m.submit(this.f19168n);
        }
        return new mc.g(bVar.f19152c, 19);
    }

    public final boolean i() {
        int i3 = this.f19165k;
        return i3 >= 2000 && i3 >= this.f19164j.size();
    }

    public final void k() {
        e(this.f19158c);
        Iterator it = this.f19164j.values().iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            g gVar = bVar.f19154f;
            int i3 = this.f19161g;
            int i10 = 0;
            if (gVar == null) {
                while (i10 < i3) {
                    this.f19162h += bVar.f19151b[i10];
                    i10++;
                }
            } else {
                bVar.f19154f = null;
                while (i10 < i3) {
                    e(bVar.f19152c[i10]);
                    e(bVar.f19153d[i10]);
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void l() {
        File file = this.f19157b;
        e eVar = new e(new FileInputStream(file), f.f19174a);
        try {
            String b3 = eVar.b();
            String b10 = eVar.b();
            String b11 = eVar.b();
            String b12 = eVar.b();
            String b13 = eVar.b();
            if (!"libcore.io.DiskLruCache".equals(b3) || !"1".equals(b10) || !Integer.toString(this.e).equals(b11) || !Integer.toString(this.f19161g).equals(b12) || !"".equals(b13)) {
                throw new IOException("unexpected journal header: [" + b3 + ", " + b10 + ", " + b12 + ", " + b13 + "]");
            }
            int i3 = 0;
            while (true) {
                try {
                    y(eVar.b());
                    i3++;
                } catch (EOFException unused) {
                    this.f19165k = i3 - this.f19164j.size();
                    if (eVar.e == -1) {
                        A();
                    } else {
                        this.f19163i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), f.f19174a));
                    }
                    try {
                        eVar.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            try {
                eVar.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused3) {
            }
            throw th2;
        }
    }

    public final void y(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i3 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i3);
        LinkedHashMap linkedHashMap = this.f19164j;
        if (indexOf2 == -1) {
            substring = str.substring(i3);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i3, indexOf2);
        }
        b bVar = (b) linkedHashMap.get(substring);
        if (bVar == null) {
            bVar = new b(this, substring);
            linkedHashMap.put(substring, bVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f19154f = new g(this, bVar);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        bVar.e = true;
        bVar.f19154f = null;
        if (split.length != bVar.f19155g.f19161g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(split));
        }
        for (int i10 = 0; i10 < split.length; i10++) {
            try {
                bVar.f19151b[i10] = Long.parseLong(split[i10]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            }
        }
    }
}
