package a6;

import retrofit2.Retrofit;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f113a = a();

    /* renamed from: b, reason: collision with root package name */
    public Retrofit f114b;

    public abstract Object a();

    /* JADX WARN: Removed duplicated region for block: B:11:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final retrofit2.Retrofit b() {
        /*
            r9 = this;
            retrofit2.Retrofit r0 = r9.f114b
            if (r0 != 0) goto Lb9
            okhttp3.logging.HttpLoggingInterceptor r0 = new okhttp3.logging.HttpLoggingInterceptor
            b6.b r1 = new b6.b
            r1.<init>()
            r0.<init>(r1)
            okhttp3.logging.HttpLoggingInterceptor$Level r1 = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
            r0.setLevel(r1)
            a6.a r1 = new a6.a
            r1.<init>()
            r2 = 0
            java.lang.String r3 = "SSL"
            javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch: java.security.KeyManagementException -> L32 java.security.NoSuchAlgorithmException -> L37
            r4 = 1
            javax.net.ssl.TrustManager[] r4 = new javax.net.ssl.TrustManager[r4]     // Catch: java.security.KeyManagementException -> L2e java.security.NoSuchAlgorithmException -> L30
            r5 = 0
            r4[r5] = r1     // Catch: java.security.KeyManagementException -> L2e java.security.NoSuchAlgorithmException -> L30
            java.security.SecureRandom r5 = new java.security.SecureRandom     // Catch: java.security.KeyManagementException -> L2e java.security.NoSuchAlgorithmException -> L30
            r5.<init>()     // Catch: java.security.KeyManagementException -> L2e java.security.NoSuchAlgorithmException -> L30
            r3.init(r2, r4, r5)     // Catch: java.security.KeyManagementException -> L2e java.security.NoSuchAlgorithmException -> L30
            goto L43
        L2e:
            r2 = move-exception
            goto L3c
        L30:
            r2 = move-exception
            goto L40
        L32:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L3c
        L37:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L40
        L3c:
            r2.printStackTrace()
            goto L43
        L40:
            r2.printStackTrace()
        L43:
            okhttp3.OkHttpClient r2 = new okhttp3.OkHttpClient
            r2.<init>()
            okhttp3.OkHttpClient$Builder r2 = r2.newBuilder()
            okhttp3.OkHttpClient$Builder r0 = r2.addInterceptor(r0)
            b6.a r2 = new b6.a
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            okhttp3.ConnectionPool r2 = new okhttp3.ConnectionPool
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MINUTES
            r5 = 32
            r6 = 5
            r2.<init>(r5, r6, r4)
            okhttp3.OkHttpClient$Builder r0 = r0.connectionPool(r2)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
            r4 = 20
            okhttp3.OkHttpClient$Builder r0 = r0.connectTimeout(r4, r2)
            r4 = 60
            okhttp3.OkHttpClient$Builder r0 = r0.writeTimeout(r4, r2)
            r4 = 100
            okhttp3.OkHttpClient$Builder r0 = r0.readTimeout(r4, r2)
            if (r3 == 0) goto L8e
            javax.net.ssl.SSLSocketFactory r2 = r3.getSocketFactory()
            okhttp3.OkHttpClient$Builder r1 = r0.sslSocketFactory(r2, r1)
            a6.b r2 = new a6.b
            r2.<init>()
            r1.hostnameVerifier(r2)
        L8e:
            okhttp3.OkHttpClient r0 = r0.build()
            retrofit2.Retrofit$Builder r1 = new retrofit2.Retrofit$Builder
            r1.<init>()
            java.lang.String r2 = r9.c()
            retrofit2.Retrofit$Builder r1 = r1.baseUrl(r2)
            retrofit2.converter.gson.GsonConverterFactory r2 = retrofit2.converter.gson.GsonConverterFactory.create()
            retrofit2.Retrofit$Builder r1 = r1.addConverterFactory(r2)
            retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory r2 = retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create()
            retrofit2.Retrofit$Builder r1 = r1.addCallAdapterFactory(r2)
            retrofit2.Retrofit$Builder r0 = r1.client(r0)
            retrofit2.Retrofit r0 = r0.build()
            r9.f114b = r0
        Lb9:
            retrofit2.Retrofit r0 = r9.f114b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.c.b():retrofit2.Retrofit");
    }

    public String c() {
        return "https://www.ruiwo168.com/api/";
    }
}
