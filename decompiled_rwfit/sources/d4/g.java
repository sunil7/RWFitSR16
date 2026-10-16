package d4;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class g implements x3.c {

    /* renamed from: b, reason: collision with root package name */
    public final k f12259b;

    /* renamed from: c, reason: collision with root package name */
    public final URL f12260c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12261d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public URL f12262f;

    /* renamed from: g, reason: collision with root package name */
    public volatile byte[] f12263g;

    /* renamed from: h, reason: collision with root package name */
    public int f12264h;

    public g(URL url) {
        k kVar = h.f12267a;
        t4.f.c(url, "Argument must not be null");
        this.f12260c = url;
        this.f12261d = null;
        t4.f.c(kVar, "Argument must not be null");
        this.f12259b = kVar;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        if (this.f12263g == null) {
            this.f12263g = c().getBytes(x3.c.f19771a);
        }
        messageDigest.update(this.f12263g);
    }

    public final String c() {
        String str = this.f12261d;
        if (str != null) {
            return str;
        }
        URL url = this.f12260c;
        t4.f.c(url, "Argument must not be null");
        return url.toString();
    }

    public final URL d() {
        if (this.f12262f == null) {
            if (TextUtils.isEmpty(this.e)) {
                String str = this.f12261d;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.f12260c;
                    t4.f.c(url, "Argument must not be null");
                    str = url.toString();
                }
                this.e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f12262f = new URL(this.e);
        }
        return this.f12262f;
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c().equals(gVar.c()) && this.f12259b.equals(gVar.f12259b);
    }

    @Override // x3.c
    public final int hashCode() {
        if (this.f12264h == 0) {
            int hashCode = c().hashCode();
            this.f12264h = hashCode;
            this.f12264h = this.f12259b.f12270b.hashCode() + (hashCode * 31);
        }
        return this.f12264h;
    }

    public final String toString() {
        return c();
    }

    public g(String str) {
        k kVar = h.f12267a;
        this.f12260c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f12261d = str;
            t4.f.c(kVar, "Argument must not be null");
            this.f12259b = kVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
