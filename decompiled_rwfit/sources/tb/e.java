package tb;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rb.f;

/* loaded from: classes.dex */
public final class e implements rb.d, f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f18604a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f18605b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f18606c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f18607d;
    public final a e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18608f;

    public e(Writer writer, HashMap hashMap, HashMap hashMap2, a aVar, boolean z5) {
        this.f18605b = new JsonWriter(writer);
        this.f18606c = hashMap;
        this.f18607d = hashMap2;
        this.e = aVar;
        this.f18608f = z5;
    }

    @Override // rb.d
    public final rb.d a(rb.b bVar, Object obj) {
        f(obj, bVar.f18109a);
        return this;
    }

    @Override // rb.f
    public final f b(String str) {
        g();
        this.f18605b.value(str);
        return this;
    }

    @Override // rb.f
    public final f c(boolean z5) {
        g();
        this.f18605b.value(z5);
        return this;
    }

    @Override // rb.d
    public final rb.d d(rb.b bVar, long j4) {
        String str = bVar.f18109a;
        g();
        JsonWriter jsonWriter = this.f18605b;
        jsonWriter.name(str);
        g();
        jsonWriter.value(j4);
        return this;
    }

    public final e e(Object obj) {
        JsonWriter jsonWriter = this.f18605b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        f(entry.getValue(), (String) key);
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            rb.c cVar = (rb.c) this.f18606c.get(obj.getClass());
            if (cVar != null) {
                jsonWriter.beginObject();
                cVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            rb.e eVar = (rb.e) this.f18607d.get(obj.getClass());
            if (eVar != null) {
                eVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.e.a(obj, this);
                throw null;
            }
            String name = ((Enum) obj).name();
            g();
            jsonWriter.value(name);
            return this;
        }
        if (obj instanceof byte[]) {
            g();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        int i3 = 0;
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i3 < length) {
                jsonWriter.value(r6[i3]);
                i3++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i3 < length2) {
                long j4 = jArr[i3];
                g();
                jsonWriter.value(j4);
                i3++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i3 < length3) {
                jsonWriter.value(dArr[i3]);
                i3++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i3 < length4) {
                jsonWriter.value(zArr[i3]);
                i3++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i3 < length5) {
                e(numberArr[i3]);
                i3++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i3 < length6) {
                e(objArr[i3]);
                i3++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final e f(Object obj, String str) {
        boolean z5 = this.f18608f;
        JsonWriter jsonWriter = this.f18605b;
        if (z5) {
            if (obj == null) {
                return this;
            }
            g();
            jsonWriter.name(str);
            e(obj);
            return this;
        }
        g();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        e(obj);
        return this;
    }

    public final void g() {
        if (!this.f18604a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
