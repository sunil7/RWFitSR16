package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import wh.j;
import wh.k;

/* loaded from: classes2.dex */
public final class FormBody extends RequestBody {
    private final List<String> encodedNames;
    private final List<String> encodedValues;
    public static final Companion Companion = new Companion(null);
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder add(String name, String value) {
            e.f(name, "name");
            e.f(value, "value");
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            return this;
        }

        public final Builder addEncoded(String name, String value) {
            e.f(name, "name");
            e.f(value, "value");
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i3, c cVar) {
            this((i3 & 1) != 0 ? null : charset);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public FormBody(List<String> encodedNames, List<String> encodedValues) {
        e.f(encodedNames, "encodedNames");
        e.f(encodedValues, "encodedValues");
        this.encodedNames = Util.toImmutableList(encodedNames);
        this.encodedValues = Util.toImmutableList(encodedValues);
    }

    private final long writeOrCountBytes(k kVar, boolean z5) {
        j m10;
        if (z5) {
            m10 = new j();
        } else {
            e.c(kVar);
            m10 = kVar.m();
        }
        int size = this.encodedNames.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                m10.Z(38);
            }
            m10.h0(this.encodedNames.get(i3));
            m10.Z(61);
            m10.h0(this.encodedValues.get(i3));
        }
        if (!z5) {
            return 0L;
        }
        long j4 = m10.f19654b;
        m10.b();
        return j4;
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m124deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i3) {
        return this.encodedNames.get(i3);
    }

    public final String encodedValue(int i3) {
        return this.encodedValues.get(i3);
    }

    public final String name(int i3) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i3), 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i3) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i3), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(k sink) throws IOException {
        e.f(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
