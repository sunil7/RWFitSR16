package org.joda.time.tz;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class k implements g {

    /* renamed from: a, reason: collision with root package name */
    public final File f17281a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17282b;

    /* renamed from: c, reason: collision with root package name */
    public final ClassLoader f17283c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f17284d;
    public final SortedSet e;

    public k(File file) {
        if (!file.exists()) {
            throw new IOException("File directory doesn't exist: " + file);
        }
        if (!file.isDirectory()) {
            throw new IOException("File doesn't refer to a directory: " + file);
        }
        this.f17281a = file;
        this.f17282b = null;
        this.f17283c = null;
        ConcurrentHashMap d5 = d(e("ZoneInfoMap"));
        this.f17284d = d5;
        this.e = Collections.unmodifiableSortedSet(new TreeSet(d5.keySet()));
    }

    public static ConcurrentHashMap d(InputStream inputStream) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            f(dataInputStream, concurrentHashMap);
            concurrentHashMap.put("UTC", new SoftReference(DateTimeZone.UTC));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void f(DataInputStream dataInputStream, ConcurrentHashMap concurrentHashMap) {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        for (int i3 = 0; i3 < readUnsignedShort; i3++) {
            strArr[i3] = dataInputStream.readUTF().intern();
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        for (int i10 = 0; i10 < readUnsignedShort2; i10++) {
            try {
                concurrentHashMap.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }

    @Override // org.joda.time.tz.g
    public final DateTimeZone a(String str) {
        Object obj = this.f17284d.get(str);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof SoftReference)) {
            return str.equals(obj) ? c(str) : a((String) obj);
        }
        DateTimeZone dateTimeZone = (DateTimeZone) ((SoftReference) obj).get();
        return dateTimeZone != null ? dateTimeZone : c(str);
    }

    @Override // org.joda.time.tz.g
    public final Set b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0028: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:27:0x0028 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.joda.time.DateTimeZone c(java.lang.String r6) {
        /*
            r5 = this;
            java.util.concurrent.ConcurrentHashMap r0 = r5.f17284d
            r1 = 0
            java.io.InputStream r2 = r5.e(r6)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            boolean r3 = r2 instanceof java.io.DataInput     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            if (r3 == 0) goto L13
            r3 = r2
            java.io.DataInput r3 = (java.io.DataInput) r3     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            org.joda.time.DateTimeZone r3 = org.joda.time.tz.d.a(r3, r6)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            goto L1c
        L13:
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            org.joda.time.DateTimeZone r3 = org.joda.time.tz.d.a(r3, r6)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
        L1c:
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            r0.put(r6, r4)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L2c
            r2.close()     // Catch: java.io.IOException -> L27
        L27:
            return r3
        L28:
            r1 = r2
            goto L3e
        L2a:
            r6 = move-exception
            goto L28
        L2c:
            r3 = move-exception
            goto L32
        L2e:
            r6 = move-exception
            goto L3e
        L30:
            r3 = move-exception
            r2 = r1
        L32:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L2a
            r0.remove(r6)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L3d
            r2.close()     // Catch: java.io.IOException -> L3d
        L3d:
            return r1
        L3e:
            if (r1 == 0) goto L43
            r1.close()     // Catch: java.io.IOException -> L43
        L43:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.k.c(java.lang.String):org.joda.time.DateTimeZone");
    }

    public final InputStream e(String str) {
        File file = this.f17281a;
        if (file != null) {
            return new FileInputStream(new File(file, str));
        }
        String concat = this.f17282b.concat(str);
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new j(this, concat));
        if (inputStream != null) {
            return inputStream;
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Resource not found: \"");
        sb2.append(concat);
        sb2.append("\" ClassLoader: ");
        ClassLoader classLoader = this.f17283c;
        sb2.append(classLoader != null ? classLoader.toString() : "system");
        throw new IOException(sb2.toString());
    }

    public k() {
        String concat = DateTimeZone.DEFAULT_TZ_DATA_PATH.concat("/");
        this.f17281a = null;
        this.f17282b = concat;
        this.f17283c = k.class.getClassLoader();
        ConcurrentHashMap d5 = d(e("ZoneInfoMap"));
        this.f17284d = d5;
        this.e = Collections.unmodifiableSortedSet(new TreeSet(d5.keySet()));
    }
}
