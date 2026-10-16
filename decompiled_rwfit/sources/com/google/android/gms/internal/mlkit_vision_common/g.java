package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class g implements rb.d {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f9917f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final rb.b f9918g;

    /* renamed from: h, reason: collision with root package name */
    public static final rb.b f9919h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f9920i;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f9921a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9922b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f9923c;

    /* renamed from: d, reason: collision with root package name */
    public final f f9924d;
    public final com.google.android.gms.internal.mlkit_vision_barcode.o0 e = new com.google.android.gms.internal.mlkit_vision_barcode.o0(this, 1);

    static {
        zzah zzahVar = zzah.zza;
        c cVar = new c(1, zzahVar);
        HashMap hashMap = new HashMap();
        hashMap.put(e.class, cVar);
        f9918g = new rb.b("key", com.google.android.gms.internal.mlkit_vision_barcode.l0.y(hashMap));
        c cVar2 = new c(2, zzahVar);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(e.class, cVar2);
        f9919h = new rb.b("value", com.google.android.gms.internal.mlkit_vision_barcode.l0.y(hashMap2));
        f9920i = f.f9904b;
    }

    public g(ByteArrayOutputStream byteArrayOutputStream, HashMap hashMap, HashMap hashMap2, f fVar) {
        this.f9921a = byteArrayOutputStream;
        this.f9922b = hashMap;
        this.f9923c = hashMap2;
        this.f9924d = fVar;
    }

    public static int f(rb.b bVar) {
        e eVar = (e) ((Annotation) bVar.f18110b.get(e.class));
        if (eVar != null) {
            return ((c) eVar).f9874a;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @Override // rb.d
    public final rb.d a(rb.b bVar, Object obj) {
        b(bVar, obj, true);
        return this;
    }

    public final void b(rb.b bVar, Object obj, boolean z5) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z5 && charSequence.length() == 0) {
                return;
            }
            h((f(bVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f9917f);
            h(bytes.length);
            this.f9921a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                b(bVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                g(f9920i, bVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (z5 && doubleValue == 0.0d) {
                return;
            }
            h((f(bVar) << 3) | 1);
            this.f9921a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(doubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (z5 && floatValue == 0.0f) {
                return;
            }
            h((f(bVar) << 3) | 5);
            this.f9921a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
            return;
        }
        if (obj instanceof Number) {
            e(bVar, ((Number) obj).longValue(), z5);
            return;
        }
        if (obj instanceof Boolean) {
            c(bVar, ((Boolean) obj).booleanValue() ? 1 : 0, z5);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z5 && bArr.length == 0) {
                return;
            }
            h((f(bVar) << 3) | 2);
            h(bArr.length);
            this.f9921a.write(bArr);
            return;
        }
        rb.c cVar = (rb.c) this.f9922b.get(obj.getClass());
        if (cVar != null) {
            g(cVar, bVar, obj, z5);
            return;
        }
        rb.e eVar = (rb.e) this.f9923c.get(obj.getClass());
        if (eVar != null) {
            com.google.android.gms.internal.mlkit_vision_barcode.o0 o0Var = this.e;
            o0Var.f9454b = false;
            o0Var.f9456d = bVar;
            o0Var.f9455c = z5;
            eVar.a(obj, o0Var);
            return;
        }
        if (obj instanceof d) {
            c(bVar, ((d) obj).zza(), true);
        } else if (obj instanceof Enum) {
            c(bVar, ((Enum) obj).ordinal(), true);
        } else {
            g(this.f9924d, bVar, obj, z5);
        }
    }

    public final void c(rb.b bVar, int i3, boolean z5) {
        if (z5 && i3 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) bVar.f18110b.get(e.class));
        if (eVar == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        c cVar = (c) eVar;
        int ordinal = cVar.f9875b.ordinal();
        int i10 = cVar.f9874a;
        if (ordinal == 0) {
            h(i10 << 3);
            h(i3);
        } else if (ordinal == 1) {
            h(i10 << 3);
            h((i3 + i3) ^ (i3 >> 31));
        } else {
            if (ordinal != 2) {
                return;
            }
            h((i10 << 3) | 5);
            this.f9921a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i3).array());
        }
    }

    @Override // rb.d
    public final /* synthetic */ rb.d d(rb.b bVar, long j4) {
        e(bVar, j4, true);
        return this;
    }

    public final void e(rb.b bVar, long j4, boolean z5) {
        if (z5 && j4 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) bVar.f18110b.get(e.class));
        if (eVar == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        c cVar = (c) eVar;
        int ordinal = cVar.f9875b.ordinal();
        int i3 = cVar.f9874a;
        if (ordinal == 0) {
            h(i3 << 3);
            i(j4);
        } else if (ordinal == 1) {
            h(i3 << 3);
            i((j4 >> 63) ^ (j4 + j4));
        } else {
            if (ordinal != 2) {
                return;
            }
            h((i3 << 3) | 1);
            this.f9921a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j4).array());
        }
    }

    public final void g(rb.c cVar, rb.b bVar, Object obj, boolean z5) {
        com.google.android.gms.internal.mlkit_vision_barcode.h0 h0Var = new com.google.android.gms.internal.mlkit_vision_barcode.h0(1);
        h0Var.f9325b = 0L;
        try {
            OutputStream outputStream = this.f9921a;
            this.f9921a = h0Var;
            try {
                cVar.a(obj, this);
                this.f9921a = outputStream;
                long j4 = h0Var.f9325b;
                h0Var.close();
                if (z5 && j4 == 0) {
                    return;
                }
                h((f(bVar) << 3) | 2);
                i(j4);
                cVar.a(obj, this);
            } catch (Throwable th2) {
                this.f9921a = outputStream;
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                h0Var.close();
            } catch (Throwable th4) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                } catch (Exception unused) {
                }
            }
            throw th3;
        }
    }

    public final void h(int i3) {
        while ((i3 & (-128)) != 0) {
            this.f9921a.write((i3 & 127) | 128);
            i3 >>>= 7;
        }
        this.f9921a.write(i3 & 127);
    }

    public final void i(long j4) {
        while (((-128) & j4) != 0) {
            this.f9921a.write((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        this.f9921a.write(((int) j4) & 127);
    }
}
