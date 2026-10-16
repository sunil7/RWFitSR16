package o2;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final String f16709b = m.i("Data");

    /* renamed from: c, reason: collision with root package name */
    public static final f f16710c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f16711a;

    static {
        f fVar = new f(new HashMap());
        b(fVar);
        f16710c = fVar;
    }

    public f(f fVar) {
        this.f16711a = new HashMap(fVar.f16711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0040 -> B:16:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static o2.f a(byte[] r8) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            java.lang.String r1 = o2.f.f16709b
            int r2 = r8.length
            r3 = 10240(0x2800, float:1.4349E-41)
            if (r2 > r3) goto L78
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r8)
            r8 = 0
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L44 java.lang.ClassNotFoundException -> L48 java.io.IOException -> L4d
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L44 java.lang.ClassNotFoundException -> L48 java.io.IOException -> L4d
            int r8 = r4.readInt()     // Catch: java.lang.Throwable -> L2d java.lang.ClassNotFoundException -> L2f java.io.IOException -> L31
        L1d:
            if (r8 <= 0) goto L33
            java.lang.String r5 = r4.readUTF()     // Catch: java.lang.Throwable -> L2d java.lang.ClassNotFoundException -> L2f java.io.IOException -> L31
            java.lang.Object r6 = r4.readObject()     // Catch: java.lang.Throwable -> L2d java.lang.ClassNotFoundException -> L2f java.io.IOException -> L31
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L2d java.lang.ClassNotFoundException -> L2f java.io.IOException -> L31
            int r8 = r8 + (-1)
            goto L1d
        L2d:
            r8 = move-exception
            goto L65
        L2f:
            r8 = move-exception
            goto L4f
        L31:
            r8 = move-exception
            goto L4f
        L33:
            r4.close()     // Catch: java.io.IOException -> L37
            goto L3b
        L37:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L3b:
            r3.close()     // Catch: java.io.IOException -> L3f
            goto L5f
        L3f:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
            goto L5f
        L44:
            r2 = move-exception
            r4 = r8
            r8 = r2
            goto L65
        L48:
            r4 = move-exception
        L49:
            r7 = r4
            r4 = r8
            r8 = r7
            goto L4f
        L4d:
            r4 = move-exception
            goto L49
        L4f:
            android.util.Log.e(r1, r0, r8)     // Catch: java.lang.Throwable -> L2d
            if (r4 == 0) goto L5c
            r4.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L5c:
            r3.close()     // Catch: java.io.IOException -> L3f
        L5f:
            o2.f r8 = new o2.f
            r8.<init>(r2)
            return r8
        L65:
            if (r4 == 0) goto L6f
            r4.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L6f:
            r3.close()     // Catch: java.io.IOException -> L73
            goto L77
        L73:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L77:
            throw r8
        L78:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.f.a(byte[]):o2.f");
    }

    public static byte[] b(f fVar) {
        ObjectOutputStream objectOutputStream;
        String str = f16709b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            objectOutputStream.writeInt(fVar.f16711a.size());
            for (Map.Entry entry : fVar.f16711a.entrySet()) {
                objectOutputStream.writeUTF((String) entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e10) {
                Log.e(str, "Error in Data#toByteArray: ", e10);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                Log.e(str, "Error in Data#toByteArray: ", e11);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e12) {
            e = e12;
            objectOutputStream2 = objectOutputStream;
            Log.e(str, "Error in Data#toByteArray: ", e);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e13) {
                    Log.e(str, "Error in Data#toByteArray: ", e13);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e14) {
                Log.e(str, "Error in Data#toByteArray: ", e14);
            }
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e15) {
                    Log.e(str, "Error in Data#toByteArray: ", e15);
                }
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException e16) {
                Log.e(str, "Error in Data#toByteArray: ", e16);
                throw th;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && f.class == obj.getClass()) {
                HashMap hashMap = this.f16711a;
                Set<String> keySet = hashMap.keySet();
                HashMap hashMap2 = ((f) obj).f16711a;
                if (keySet.equals(hashMap2.keySet())) {
                    for (String str : keySet) {
                        Object obj2 = hashMap.get(str);
                        Object obj3 = hashMap2.get(str);
                        if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f16711a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        HashMap hashMap = this.f16711a;
        if (!hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                Object obj = hashMap.get(str);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public f(HashMap hashMap) {
        this.f16711a = new HashMap(hashMap);
    }
}
