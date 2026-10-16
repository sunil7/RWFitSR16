package he;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Rational;
import android.util.Size;
import android.util.SparseArray;
import androidx.camera.core.impl.u;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import ff.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import w0.o;
import y.h;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f14314a;

    /* renamed from: b, reason: collision with root package name */
    public int f14315b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14316c;

    /* renamed from: d, reason: collision with root package name */
    public Object f14317d;
    public Object e;

    public b(u uVar, Size size) {
        Rational rational;
        this.f14316c = uVar;
        this.f14314a = uVar.a();
        this.f14315b = uVar.b();
        if (size != null) {
            rational = new Rational(size.getWidth(), size.getHeight());
        } else {
            List j4 = uVar.j(256);
            if (j4.isEmpty()) {
                rational = null;
            } else {
                Size size2 = (Size) Collections.max(j4, new i(false, 1));
                rational = new Rational(size2.getWidth(), size2.getHeight());
            }
        }
        this.f14317d = rational;
        this.e = new h(uVar, rational);
    }

    public static ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(v.b.f19106a);
        arrayList2.add(v.b.f19108c);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Size size2 = (Size) obj;
            Rational rational = new Rational(size2.getWidth(), size2.getHeight());
            if (!arrayList2.contains(rational)) {
                int size3 = arrayList2.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size3) {
                        arrayList2.add(rational);
                        break;
                    }
                    Object obj2 = arrayList2.get(i10);
                    i10++;
                    if (v.b.a((Rational) obj2, size2)) {
                        break;
                    }
                }
            }
        }
        return arrayList2;
    }

    public static Rational c(int i3, boolean z5) {
        if (i3 == -1) {
            return null;
        }
        if (i3 == 0) {
            return z5 ? v.b.f19106a : v.b.f19107b;
        }
        if (i3 == 1) {
            return z5 ? v.b.f19108c : v.b.f19109d;
        }
        a0.b("SupportedOutputSizesCollector", "Undefined target aspect ratio: " + i3);
        return null;
    }

    public static HashMap d(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        ArrayList a3 = a(arrayList);
        int size = a3.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = a3.get(i10);
            i10++;
            hashMap.put((Rational) obj, new ArrayList());
        }
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            Size size3 = (Size) obj2;
            for (Rational rational : hashMap.keySet()) {
                if (v.b.a(rational, size3)) {
                    ((List) hashMap.get(rational)).add(size3);
                }
            }
        }
        return hashMap;
    }

    public static void f(List list, Size size, boolean z5) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = (Size) list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z5) {
            list.addAll(arrayList);
        }
    }

    public static void g(List list, Size size, boolean z5) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Size size2 = (Size) list.get(i3);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z5) {
            list.addAll(arrayList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d2, code lost:
    
        if (b0.a.a(r9) < (r8.getHeight() * r8.getWidth())) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List b(androidx.camera.core.impl.a2 r18) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: he.b.b(androidx.camera.core.impl.a2):java.util.List");
    }

    public void e(Context context, XmlResourceParser xmlResourceParser) {
        o oVar = new o();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlResourceParser.getAttributeName(i3);
            String attributeValue = xmlResourceParser.getAttributeValue(i3);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                oVar.k(context, xmlResourceParser);
                ((SparseArray) this.e).put(identifier, oVar);
                return;
            }
        }
    }
}
