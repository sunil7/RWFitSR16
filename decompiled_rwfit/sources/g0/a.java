package g0;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final double f13740h = Math.sqrt(2.3703703703703702d);

    /* renamed from: a, reason: collision with root package name */
    public final Size f13741a;

    /* renamed from: b, reason: collision with root package name */
    public final Rational f13742b;

    /* renamed from: c, reason: collision with root package name */
    public final Rational f13743c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f13744d;
    public final he.b e;

    /* renamed from: f, reason: collision with root package name */
    public final u f13745f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f13746g;

    public a(v vVar, HashSet hashSet) {
        Size d5 = v.d.d(vVar.m().g());
        u h4 = vVar.h();
        he.b bVar = new he.b(h4, d5);
        this.f13746g = new HashMap();
        this.f13741a = d5;
        Rational rational = ((double) d5.getWidth()) / ((double) d5.getHeight()) > f13740h ? v.b.f19108c : v.b.f19106a;
        a0.a("ResolutionsMerger", "The closer aspect ratio to the sensor size (" + d5 + ") is " + rational + ".");
        this.f13742b = rational;
        Rational rational2 = v.b.f19106a;
        if (rational.equals(rational2)) {
            rational2 = v.b.f19108c;
        } else if (!rational.equals(v.b.f19108c)) {
            throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + rational);
        }
        this.f13743c = rational2;
        this.f13745f = h4;
        this.f13744d = hashSet;
        this.e = bVar;
    }

    public static Rect a(Size size, Size size2) {
        RectF rectF;
        RectF rectF2;
        Rational g10 = g(size2);
        int width = size.getWidth();
        int height = size.getHeight();
        Rational g11 = g(size);
        if (g10.floatValue() == g11.floatValue()) {
            rectF2 = new RectF(0.0f, 0.0f, width, height);
        } else {
            if (g10.floatValue() > g11.floatValue()) {
                float f2 = width;
                float floatValue = f2 / g10.floatValue();
                float f10 = (height - floatValue) / 2.0f;
                rectF = new RectF(0.0f, f10, f2, floatValue + f10);
            } else {
                float f11 = height;
                float floatValue2 = g10.floatValue() * f11;
                float f12 = (width - floatValue2) / 2.0f;
                rectF = new RectF(f12, 0.0f, floatValue2 + f12, f11);
            }
            rectF2 = rectF;
        }
        Rect rect = new Rect();
        rectF2.round(rect);
        return rect;
    }

    public static boolean c(Size size, Size size2) {
        return size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth();
    }

    public static Rational g(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    public final List b(a2 a2Var) {
        Rational rational;
        if (!this.f13744d.contains(a2Var)) {
            throw new IllegalArgumentException("Invalid child config: " + a2Var);
        }
        HashMap hashMap = this.f13746g;
        if (hashMap.containsKey(a2Var)) {
            List list = (List) hashMap.get(a2Var);
            Objects.requireNonNull(list);
            return list;
        }
        List<Size> b3 = this.e.b(a2Var);
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Size size : b3) {
            Iterator it = hashMap2.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    rational = null;
                    break;
                }
                rational = (Rational) it.next();
                if (v.b.a(rational, size)) {
                    break;
                }
            }
            if (rational != null) {
                Size size2 = (Size) hashMap2.get(rational);
                Objects.requireNonNull(size2);
                if (size.getHeight() <= size2.getHeight()) {
                    if (size.getWidth() <= size2.getWidth()) {
                        if (size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight()) {
                        }
                    }
                }
            } else {
                rational = g(size);
            }
            arrayList.add(size);
            hashMap2.put(rational, size);
        }
        hashMap.put(a2Var, arrayList);
        return arrayList;
    }

    public final boolean d(Rational rational, Size size) {
        Rational rational2 = this.f13742b;
        if (rational2.equals(rational) || v.b.a(rational, size)) {
            return false;
        }
        float floatValue = rational2.floatValue();
        float floatValue2 = rational.floatValue();
        Rational rational3 = v.b.f19106a;
        if (!v.b.a(rational3, size)) {
            rational3 = v.b.f19108c;
            if (!v.b.a(rational3, size)) {
                rational3 = g(size);
            }
        }
        float floatValue3 = rational3.floatValue();
        if (floatValue == floatValue2 || floatValue2 == floatValue3) {
            return false;
        }
        return floatValue > floatValue2 ? floatValue2 < floatValue3 : floatValue2 > floatValue3;
    }

    public final ArrayList e(List list, boolean z5) {
        int i3;
        List list2;
        HashMap hashMap = new HashMap();
        Rational rational = v.b.f19106a;
        hashMap.put(rational, new ArrayList());
        Rational rational2 = v.b.f19108c;
        hashMap.put(rational2, new ArrayList());
        ArrayList arrayList = new ArrayList();
        arrayList.add(rational);
        arrayList.add(rational2);
        Iterator it = list.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Size size = (Size) it.next();
            if (size.getHeight() > 0) {
                int size2 = arrayList.size();
                while (true) {
                    if (i3 >= size2) {
                        list2 = null;
                        break;
                    }
                    Object obj = arrayList.get(i3);
                    i3++;
                    Rational rational3 = (Rational) obj;
                    if (v.b.a(rational3, size)) {
                        list2 = (List) hashMap.get(rational3);
                        break;
                    }
                }
                if (list2 == null) {
                    list2 = new ArrayList();
                    Rational g10 = g(size);
                    arrayList.add(g10);
                    hashMap.put(g10, list2);
                }
                list2.add(size);
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2, new com.google.android.material.button.e(g(this.f13741a), 1));
        ArrayList arrayList3 = new ArrayList();
        int size3 = arrayList2.size();
        while (i3 < size3) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            Rational rational4 = (Rational) obj2;
            if (!rational4.equals(v.b.f19108c) && !rational4.equals(v.b.f19106a)) {
                List list3 = (List) hashMap.get(rational4);
                Objects.requireNonNull(list3);
                arrayList3.addAll(f(rational4, list3, z5));
            }
        }
        return arrayList3;
    }

    public final ArrayList f(Rational rational, List list, boolean z5) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (v.b.a(rational, size)) {
                arrayList2.add(size);
            }
        }
        Collections.sort(arrayList2, new ff.i(true, 1));
        HashSet hashSet = new HashSet(arrayList2);
        Iterator it2 = this.f13744d.iterator();
        while (true) {
            int i3 = 0;
            if (!it2.hasNext()) {
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList2.size();
                while (i3 < size2) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    Size size3 = (Size) obj;
                    if (!hashSet.contains(size3)) {
                        arrayList3.add(size3);
                    }
                }
                return arrayList3;
            }
            List<Size> b3 = b((a2) it2.next());
            if (!z5) {
                ArrayList arrayList4 = new ArrayList();
                for (Size size4 : b3) {
                    if (!d(rational, size4)) {
                        arrayList4.add(size4);
                    }
                }
                b3 = arrayList4;
            }
            if (b3.isEmpty()) {
                return new ArrayList();
            }
            if (b3.isEmpty() || arrayList2.isEmpty()) {
                arrayList2 = new ArrayList();
            } else {
                ArrayList arrayList5 = new ArrayList();
                int size5 = arrayList2.size();
                int i10 = 0;
                while (i10 < size5) {
                    Object obj2 = arrayList2.get(i10);
                    i10++;
                    Size size6 = (Size) obj2;
                    Iterator it3 = b3.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if (!c((Size) it3.next(), size6)) {
                            arrayList5.add(size6);
                            break;
                        }
                    }
                }
                arrayList2 = arrayList5;
            }
            if (b3.isEmpty() || arrayList2.isEmpty()) {
                arrayList = new ArrayList();
            } else {
                ArrayList arrayList6 = arrayList2.isEmpty() ? arrayList2 : new ArrayList(new LinkedHashSet(arrayList2));
                arrayList = new ArrayList();
                int size7 = arrayList6.size();
                while (i3 < size7) {
                    Object obj3 = arrayList6.get(i3);
                    i3++;
                    Size size8 = (Size) obj3;
                    Iterator it4 = b3.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            arrayList.add(size8);
                            break;
                        }
                        if (c((Size) it4.next(), size8)) {
                            break;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            hashSet.retainAll(arrayList);
        }
    }
}
