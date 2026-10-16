package org.joda.time.format;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17206a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f17207b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public Object f17208c;

    public /* synthetic */ p(Object obj) {
        this.f17208c = obj;
    }

    public static void n(Appendable appendable, int i3) {
        while (true) {
            i3--;
            if (i3 < 0) {
                return;
            } else {
                appendable.append((char) 65533);
            }
        }
    }

    public static boolean o(CharSequence charSequence, int i3, String str) {
        int length = str.length();
        if (charSequence.length() - i3 < length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i3 + i10) != str.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(int i3, String str, String str2) {
        char upperCase;
        char upperCase2;
        int length = str2.length();
        if (str.length() - i3 >= length) {
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i3 + i10);
                char charAt2 = str2.charAt(i10);
                if (charAt == charAt2 || (upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(charAt2)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
                }
            }
            return true;
        }
        return false;
    }

    public void a(Object obj, String str) {
        this.f17207b.add(r5.a.c(str, "=", String.valueOf(obj)));
    }

    public void b(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("No formatter supplied");
        }
        e(bVar.f17152a, bVar.f17153b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.joda.time.format.t] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.joda.time.format.t] */
    public void c(y[] yVarArr) {
        int length = yVarArr.length;
        int i3 = 0;
        if (length == 1) {
            y yVar = yVarArr[0];
            if (yVar == null) {
                throw new IllegalArgumentException("No parser supplied");
            }
            e(null, yVar);
            return;
        }
        x[] xVarArr = new x[length];
        while (i3 < length - 1) {
            y yVar2 = yVarArr[i3];
            if (yVar2 == null) {
                yVar2 = yVar2 == null ? null : new t(yVar2);
            }
            xVarArr[i3] = yVar2;
            if (yVar2 == null) {
                throw new IllegalArgumentException("Incomplete parser array");
            }
            i3++;
        }
        y yVar3 = yVarArr[i3];
        if (yVar3 == null) {
            yVar3 = yVar3 == null ? null : new t(yVar3);
        }
        xVarArr[i3] = yVar3;
        e(null, new g(xVarArr));
    }

    public void d(Object obj) {
        this.f17208c = null;
        ArrayList arrayList = this.f17207b;
        arrayList.add(obj);
        arrayList.add(obj);
    }

    public void e(z zVar, x xVar) {
        this.f17208c = null;
        ArrayList arrayList = this.f17207b;
        arrayList.add(zVar);
        arrayList.add(xVar);
    }

    public void f(DateTimeFieldType dateTimeFieldType, int i3, int i10) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i10 < i3) {
            i10 = i3;
        }
        if (i3 < 0 || i10 <= 0) {
            throw new IllegalArgumentException();
        }
        if (i3 <= 1) {
            d(new o(dateTimeFieldType, i10, false));
        } else {
            d(new i(dateTimeFieldType, i10, false, i3));
        }
    }

    public void g(DateTimeFieldType dateTimeFieldType, int i3) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException(l0.j(i3, "Illegal number of digits: "));
        }
        d(new e(dateTimeFieldType, i3, false, i3));
    }

    public void h(DateTimeFieldType dateTimeFieldType, int i3, int i10) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i10 < i3) {
            i10 = i3;
        }
        if (i3 < 0 || i10 <= 0) {
            throw new IllegalArgumentException();
        }
        d(new f(dateTimeFieldType, i3, i10));
    }

    public void i(char c9) {
        d(new c(c9));
    }

    public void j(String str) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                d(new j(str));
            } else {
                d(new c(str.charAt(0)));
            }
        }
    }

    public void k(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
        e(null, new g(new x[]{yVar, null}));
    }

    public void l(DateTimeFieldType dateTimeFieldType, int i3, int i10) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i10 < i3) {
            i10 = i3;
        }
        if (i3 < 0 || i10 <= 0) {
            throw new IllegalArgumentException();
        }
        if (i3 <= 1) {
            d(new o(dateTimeFieldType, i10, true));
        } else {
            d(new i(dateTimeFieldType, i10, true, i3));
        }
    }

    public void m(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        d(new k(dateTimeFieldType, false));
    }

    public Object q() {
        Object obj = this.f17208c;
        if (obj == null) {
            ArrayList arrayList = this.f17207b;
            if (arrayList.size() == 2) {
                Object obj2 = arrayList.get(0);
                Object obj3 = arrayList.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new d(arrayList);
            }
            this.f17208c = obj;
        }
        return obj;
    }

    public b r() {
        Object q5 = q();
        x xVar = null;
        z zVar = (!(q5 instanceof z) || ((q5 instanceof d) && ((d) q5).f17163a == null)) ? null : (z) q5;
        if ((q5 instanceof x) && (!(q5 instanceof d) || ((d) q5).f17164b != null)) {
            xVar = (x) q5;
        }
        if (zVar == null && xVar == null) {
            throw new UnsupportedOperationException("Both printing and parsing not supported");
        }
        return new b(zVar, xVar);
    }

    public y s() {
        Object q5 = q();
        if (!(q5 instanceof x) || ((q5 instanceof d) && ((d) q5).f17164b == null)) {
            throw new UnsupportedOperationException("Parsing is not supported");
        }
        return y.a((x) q5);
    }

    public String toString() {
        switch (this.f17206a) {
            case 1:
                StringBuilder sb2 = new StringBuilder(100);
                sb2.append(this.f17208c.getClass().getSimpleName());
                sb2.append('{');
                ArrayList arrayList = this.f17207b;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    sb2.append((String) arrayList.get(i3));
                    if (i3 < size - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public p() {
    }
}
