package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public final class l implements e {

    /* renamed from: a, reason: collision with root package name */
    public final d4.g f6975a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6976b;

    /* renamed from: c, reason: collision with root package name */
    public HttpURLConnection f6977c;

    /* renamed from: d, reason: collision with root package name */
    public InputStream f6978d;
    public volatile boolean e;

    public l(d4.g gVar, int i3) {
        this.f6975a = gVar;
        this.f6976b = i3;
    }

    public static int c(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        InputStream inputStream = this.f6978d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f6977c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f6977c = null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.e = true;
    }

    public final InputStream d(URL url, int i3, URL url2, Map map) {
        if (i3 >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int i10 = this.f6976b;
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.f6977c = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.f6978d = this.f6977c.getInputStream();
                if (this.e) {
                    return null;
                }
                int c9 = c(this.f6977c);
                int i11 = c9 / 100;
                if (i11 == 2) {
                    HttpURLConnection httpURLConnection2 = this.f6977c;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.f6978d = new t4.d(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            this.f6978d = httpURLConnection2.getInputStream();
                        }
                        return this.f6978d;
                    } catch (IOException e) {
                        throw new HttpException("Failed to obtain InputStream", c(httpURLConnection2), e);
                    }
                }
                if (i11 != 3) {
                    if (c9 == -1) {
                        throw new HttpException(c9);
                    }
                    try {
                        throw new HttpException(this.f6977c.getResponseMessage(), c9);
                    } catch (IOException e10) {
                        throw new HttpException("Failed to get a response message", c9, e10);
                    }
                }
                String headerField = this.f6977c.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new HttpException("Received empty or null redirect url", c9);
                }
                try {
                    URL url3 = new URL(url, headerField);
                    b();
                    return d(url3, i3 + 1, url, map);
                } catch (MalformedURLException e11) {
                    throw new HttpException(l0.n("Bad redirect url: ", headerField), c9, e11);
                }
            } catch (IOException e12) {
                throw new HttpException("Failed to connect or obtain data", c(this.f6977c), e12);
            }
        } catch (IOException e13) {
            throw new HttpException("URL.openConnection threw", 0, e13);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource e() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void f(Priority priority, d dVar) {
        d4.g gVar = this.f6975a;
        int i3 = t4.g.f18515b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                dVar.d(d(gVar.d(), 0, null, gVar.f12259b.b()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + t4.g.a(elapsedRealtimeNanos));
                }
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                dVar.c(e);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + t4.g.a(elapsedRealtimeNanos));
                }
            }
        } catch (Throwable th2) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + t4.g.a(elapsedRealtimeNanos));
            }
            throw th2;
        }
    }
}
