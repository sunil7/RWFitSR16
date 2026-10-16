package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class f implements Iterable<String> {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f12071a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f12072b;

    public f() {
        this.f12071a = null;
        this.f12072b = null;
        this.f12071a = new ConcurrentLinkedQueue<>();
        this.f12072b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f12071a.add(str);
        return this.f12072b.addAndGet(length);
    }

    public void b() {
        this.f12071a.clear();
        this.f12072b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f12071a.iterator();
    }

    public void a(Writer[] writerArr, char[] cArr) throws IOException {
        if (writerArr == null || cArr == null || cArr.length == 0 || writerArr.length < 2) {
            return;
        }
        Writer writer = writerArr[0];
        Writer writer2 = writerArr[1];
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i3 = 0;
        int i10 = length;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i11 = 0;
            while (length2 > 0) {
                int i12 = i10 > length2 ? length2 : i10;
                int i13 = i11 + i12;
                next.getChars(i11, i13, cArr, i3);
                i10 -= i12;
                i3 += i12;
                length2 -= i12;
                if (i10 == 0) {
                    if (writer != null) {
                        try {
                            writer.write(cArr, 0, length);
                        } catch (Exception unused) {
                        }
                    }
                    if (writer2 != null) {
                        try {
                            writer2.write(cArr, 0, length);
                        } catch (Exception unused2) {
                        }
                    }
                    i3 = 0;
                    i10 = length;
                }
                i11 = i13;
            }
        }
        if (i3 > 0) {
            if (writer != null) {
                try {
                    writer.write(cArr, 0, i3);
                } catch (Exception unused3) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.write(cArr, 0, i3);
                } catch (Exception unused4) {
                }
            }
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (Exception unused5) {
            }
        }
        if (writer2 != null) {
            try {
                writer2.flush();
            } catch (Exception unused6) {
            }
        }
    }

    public int a() {
        return this.f12072b.get();
    }
}
