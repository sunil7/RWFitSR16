package z7;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final long f20381a;

    public m(long j4) {
        this.f20381a = j4;
    }

    public static m a(BufferedReader bufferedReader) {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader.peek() == JsonToken.STRING ? new m(Long.parseLong(jsonReader.nextString())) : new m(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            if (this.f20381a == ((m) obj).f20381a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f20381a;
        return ((int) ((j4 >>> 32) ^ j4)) ^ 1000003;
    }

    public final String toString() {
        return android.support.v4.media.session.e.n(new StringBuilder("LogResponse{nextRequestWaitMillis="), this.f20381a, "}");
    }
}
