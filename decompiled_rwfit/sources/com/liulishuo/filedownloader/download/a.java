package com.liulishuo.filedownloader.download;

import android.text.TextUtils;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import de.i;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import n.m0;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f11394a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11395b;

    /* renamed from: c, reason: collision with root package name */
    public final FileDownloadHeader f11396c;

    /* renamed from: d, reason: collision with root package name */
    public b f11397d;
    public final String e;

    /* renamed from: f, reason: collision with root package name */
    public Map f11398f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f11399g;

    public a(b bVar, int i3, String str, String str2, FileDownloadHeader fileDownloadHeader) {
        this.f11394a = i3;
        this.f11395b = str;
        this.e = str2;
        this.f11396c = fileDownloadHeader;
        this.f11397d = bVar;
    }

    public final m0 a() {
        String str;
        HashMap a3;
        i iVar = c.f11405a;
        m0 d5 = iVar.d(this.f11395b);
        FileDownloadHeader fileDownloadHeader = this.f11396c;
        if (fileDownloadHeader != null && (a3 = fileDownloadHeader.a()) != null) {
            for (Map.Entry entry : a3.entrySet()) {
                String str2 = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((URLConnection) d5.f16254b).addRequestProperty(str2, (String) it.next());
                    }
                }
            }
        }
        long j4 = this.f11397d.f11400a;
        String str3 = this.e;
        if (!TextUtils.isEmpty(str3)) {
            ((URLConnection) d5.f16254b).addRequestProperty("If-Match", str3);
        }
        b bVar = this.f11397d;
        boolean z5 = bVar.e;
        URLConnection uRLConnection = (URLConnection) d5.f16254b;
        if (!z5) {
            if (bVar.f11404f && ye.c.f20115a.f20122h && (uRLConnection instanceof HttpURLConnection)) {
                ((HttpURLConnection) uRLConnection).setRequestMethod("HEAD");
            }
            long j10 = bVar.f11402c;
            long j11 = bVar.f11401b;
            if (j10 == -1) {
                int i3 = ye.e.f20123a;
                Locale locale = Locale.ENGLISH;
                str = "bytes=" + j11 + "-";
            } else {
                int i10 = ye.e.f20123a;
                Locale locale2 = Locale.ENGLISH;
                str = "bytes=" + j11 + "-" + j10;
            }
            ((URLConnection) d5.f16254b).addRequestProperty("Range", str);
        }
        if (fileDownloadHeader == null || fileDownloadHeader.a().get("User-Agent") == null) {
            int i11 = ye.e.f20123a;
            Locale locale3 = Locale.ENGLISH;
            ((URLConnection) d5.f16254b).addRequestProperty("User-Agent", "FileDownloader/1.7.7");
        }
        this.f11398f = uRLConnection.getRequestProperties();
        ((URLConnection) d5.f16254b).connect();
        ArrayList arrayList = new ArrayList();
        this.f11399g = arrayList;
        Map map = this.f11398f;
        int B = d5.B();
        String headerField = uRLConnection.getHeaderField("Location");
        ArrayList arrayList2 = new ArrayList();
        int i12 = 0;
        do {
            if (B != 301 && B != 302 && B != 303 && B != 300 && B != 307 && B != 308) {
                arrayList.addAll(arrayList2);
                return d5;
            }
            if (headerField == null) {
                Object[] objArr = {Integer.valueOf(B), ((URLConnection) d5.f16254b).getHeaderFields()};
                int i13 = ye.e.f20123a;
                throw new IllegalAccessException(String.format(Locale.ENGLISH, "receive %d (redirect) but the location is null with response [%s]", objArr));
            }
            d5.z();
            d5 = iVar.d(headerField);
            for (Map.Entry entry2 : map.entrySet()) {
                String str4 = (String) entry2.getKey();
                List list2 = (List) entry2.getValue();
                if (list2 != null) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        ((URLConnection) d5.f16254b).addRequestProperty(str4, (String) it2.next());
                    }
                }
            }
            arrayList2.add(headerField);
            ((URLConnection) d5.f16254b).connect();
            B = d5.B();
            headerField = ((URLConnection) d5.f16254b).getHeaderField("Location");
            i12++;
        } while (i12 < 10);
        int i14 = ye.e.f20123a;
        throw new IllegalAccessException(String.format(Locale.ENGLISH, "redirect too many times! %s", arrayList2));
    }
}
