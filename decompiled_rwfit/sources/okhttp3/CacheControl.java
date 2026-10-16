package okhttp3;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;

/* loaded from: classes2.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(SubsamplingScaleImageView.TILE_SIZE_AUTO, TimeUnit.SECONDS).build();

    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j4) {
            return j4 > ((long) SubsamplingScaleImageView.TILE_SIZE_AUTO) ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) j4;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i3, TimeUnit timeUnit) {
            e.f(timeUnit, "timeUnit");
            if (!(i3 >= 0)) {
                throw new IllegalArgumentException(l0.j(i3, "maxAge < 0: ").toString());
            }
            this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i3));
            return this;
        }

        public final Builder maxStale(int i3, TimeUnit timeUnit) {
            e.f(timeUnit, "timeUnit");
            if (!(i3 >= 0)) {
                throw new IllegalArgumentException(l0.j(i3, "maxStale < 0: ").toString());
            }
            this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i3));
            return this;
        }

        public final Builder minFresh(int i3, TimeUnit timeUnit) {
            e.f(timeUnit, "timeUnit");
            if (!(i3 >= 0)) {
                throw new IllegalArgumentException(l0.j(i3, "minFresh < 0: ").toString());
            }
            this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i3));
            return this;
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        private final int indexOfElement(String str, String str2, int i3) {
            int length = str.length();
            while (i3 < length) {
                if (m.d(str2, str.charAt(i3))) {
                    return i3;
                }
                i3++;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i3, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i3 = 0;
            }
            return companion.indexOfElement(str, str2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.CacheControl parse(okhttp3.Headers r26) {
            /*
                Method dump skipped, instructions count: 378
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    private CacheControl(boolean z5, boolean z6, int i3, int i10, boolean z8, boolean z10, boolean z11, int i11, int i12, boolean z12, boolean z13, boolean z14, String str) {
        this.noCache = z5;
        this.noStore = z6;
        this.maxAgeSeconds = i3;
        this.sMaxAgeSeconds = i10;
        this.isPrivate = z8;
        this.isPublic = z10;
        this.mustRevalidate = z11;
        this.maxStaleSeconds = i11;
        this.minFreshSeconds = i12;
        this.onlyIfCached = z12;
        this.noTransform = z13;
        this.immutable = z14;
        this.headerValue = str;
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m96deprecated_immutable() {
        return this.immutable;
    }

    /* renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m97deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m98deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m99deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m100deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m101deprecated_noCache() {
        return this.noCache;
    }

    /* renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m102deprecated_noStore() {
        return this.noStore;
    }

    /* renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m103deprecated_noTransform() {
        return this.noTransform;
    }

    /* renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m104deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m105deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.noCache) {
            sb2.append("no-cache, ");
        }
        if (this.noStore) {
            sb2.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb2.append("max-age=");
            sb2.append(this.maxAgeSeconds);
            sb2.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.sMaxAgeSeconds);
            sb2.append(", ");
        }
        if (this.isPrivate) {
            sb2.append("private, ");
        }
        if (this.isPublic) {
            sb2.append("public, ");
        }
        if (this.mustRevalidate) {
            sb2.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb2.append("max-stale=");
            sb2.append(this.maxStaleSeconds);
            sb2.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.minFreshSeconds);
            sb2.append(", ");
        }
        if (this.onlyIfCached) {
            sb2.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb2.append("no-transform, ");
        }
        if (this.immutable) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String sb3 = sb2.toString();
        e.e(sb3, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = sb3;
        return sb3;
    }

    public /* synthetic */ CacheControl(boolean z5, boolean z6, int i3, int i10, boolean z8, boolean z10, boolean z11, int i11, int i12, boolean z12, boolean z13, boolean z14, String str, c cVar) {
        this(z5, z6, i3, i10, z8, z10, z11, i11, i12, z12, z13, z14, str);
    }
}
