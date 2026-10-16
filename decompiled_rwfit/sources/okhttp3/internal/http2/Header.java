package okhttp3.internal.http2;

import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okio.ByteString;
import wh.m;

/* loaded from: classes2.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final ByteString PSEUDO_PREFIX;
    public static final ByteString RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    static {
        ByteString.Companion.getClass();
        PSEUDO_PREFIX = m.c(":");
        RESPONSE_STATUS = m.c(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = m.c(TARGET_METHOD_UTF8);
        TARGET_PATH = m.c(TARGET_PATH_UTF8);
        TARGET_SCHEME = m.c(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = m.c(TARGET_AUTHORITY_UTF8);
    }

    public Header(ByteString name, ByteString value) {
        e.f(name, "name");
        e.f(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = value.size() + name.size() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            byteString = header.name;
        }
        if ((i3 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString name, ByteString value) {
        e.f(name, "name");
        e.f(value, "value");
        return new Header(name, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return e.a(this.name, header.name) && e.a(this.value, header.value);
    }

    public int hashCode() {
        ByteString byteString = this.name;
        int hashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.value;
        return hashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String name, String value) {
        this(m.c(name), m.c(value));
        e.f(name, "name");
        e.f(value, "value");
        ByteString.Companion.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString name, String value) {
        this(name, m.c(value));
        e.f(name, "name");
        e.f(value, "value");
        ByteString.Companion.getClass();
    }
}
