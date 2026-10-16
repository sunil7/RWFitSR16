package b6;

import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        e.f(chain, "chain");
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        if (d6.a.f12304c == null) {
            synchronized (d6.a.class) {
                d6.a.f12304c = new d6.a();
            }
        }
        d6.a aVar = d6.a.f12304c;
        if (aVar != null && aVar.f12305a == 2) {
            String file = request.url().url().getFile();
            e.c(file);
            if (m.c(file, "/member/info", false) || m.c(file, "/member/update", false)) {
                return new Response.Builder().code(10086).protocol(Protocol.HTTP_2).message("Network is closed by visitor").body(ResponseBody.Companion.create(MediaType.Companion.get("text/html; charset=utf-8"), "")).request(chain.request()).build();
            }
        }
        if (d6.a.f12304c == null) {
            synchronized (d6.a.class) {
                d6.a.f12304c = new d6.a();
            }
        }
        d6.a aVar2 = d6.a.f12304c;
        newBuilder.addHeader("Authorization", "bearer " + (aVar2 != null ? (String) aVar2.f12306b : null));
        return chain.proceed(newBuilder.build());
    }
}
