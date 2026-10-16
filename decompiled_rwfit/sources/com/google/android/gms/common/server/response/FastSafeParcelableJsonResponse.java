package com.google.android.gms.common.server.response;

import android.util.Base64;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.r6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import q9.n;
import x9.a;
import z9.c;

/* loaded from: classes.dex */
public abstract class FastSafeParcelableJsonResponse implements SafeParcelable {
    public static final void j(StringBuilder sb2, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        int i3 = fastJsonResponse$Field.f9149a;
        if (i3 == 11) {
            Class cls = fastJsonResponse$Field.f9154g;
            n.e(cls);
            sb2.append(((FastSafeParcelableJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i3 != 7) {
                sb2.append(obj);
                return;
            }
            sb2.append("\"");
            sb2.append(c.a((String) obj));
            sb2.append("\"");
        }
    }

    public abstract Map a();

    public final Object b(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f9154g == null) {
            return d();
        }
        Object d5 = d();
        String str = fastJsonResponse$Field.e;
        if (d5 != null) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + str);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object d() {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastSafeParcelableJsonResponse fastSafeParcelableJsonResponse = (FastSafeParcelableJsonResponse) obj;
        for (FastJsonResponse$Field fastJsonResponse$Field : a().values()) {
            if (h(fastJsonResponse$Field)) {
                if (!fastSafeParcelableJsonResponse.h(fastJsonResponse$Field) || !n.h(b(fastJsonResponse$Field), fastSafeParcelableJsonResponse.b(fastJsonResponse$Field))) {
                    return false;
                }
            } else if (fastSafeParcelableJsonResponse.h(fastJsonResponse$Field)) {
                return false;
            }
        }
        return true;
    }

    public final boolean h(FastJsonResponse$Field fastJsonResponse$Field) {
        if (fastJsonResponse$Field.f9151c != 11) {
            return i();
        }
        if (fastJsonResponse$Field.f9152d) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public final int hashCode() {
        int i3 = 0;
        for (FastJsonResponse$Field fastJsonResponse$Field : a().values()) {
            if (h(fastJsonResponse$Field)) {
                Object b3 = b(fastJsonResponse$Field);
                n.e(b3);
                i3 = (i3 * 31) + b3.hashCode();
            }
        }
        return i3;
    }

    public boolean i() {
        return false;
    }

    public String toString() {
        a aVar;
        Map a3 = a();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : a3.keySet()) {
            FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) a3.get(str);
            if (h(fastJsonResponse$Field)) {
                Object b3 = b(fastJsonResponse$Field);
                aVar = fastJsonResponse$Field.zak;
                if (aVar != null) {
                    b3 = fastJsonResponse$Field.h(b3);
                }
                if (sb2.length() == 0) {
                    sb2.append(Const.STR_MART_JSON_BEGIN);
                } else {
                    sb2.append(Const.STR_MART_COMMA);
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (b3 != null) {
                    switch (fastJsonResponse$Field.f9151c) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(Base64.encodeToString((byte[]) b3, 0));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(Base64.encodeToString((byte[]) b3, 10));
                            sb2.append("\"");
                            break;
                        case 10:
                            r6.a(sb2, (HashMap) b3);
                            break;
                        default:
                            if (fastJsonResponse$Field.f9150b) {
                                ArrayList arrayList = (ArrayList) b3;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    if (i3 > 0) {
                                        sb2.append(Const.STR_MART_COMMA);
                                    }
                                    Object obj = arrayList.get(i3);
                                    if (obj != null) {
                                        j(sb2, fastJsonResponse$Field, obj);
                                    }
                                }
                                sb2.append("]");
                                break;
                            } else {
                                j(sb2, fastJsonResponse$Field, b3);
                                break;
                            }
                    }
                } else {
                    sb2.append("null");
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }
}
