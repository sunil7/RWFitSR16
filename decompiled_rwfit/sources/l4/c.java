package l4;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f15766a;

    public c(int i3) {
        switch (i3) {
            case 1:
                this.f15766a = new ArrayList();
                break;
            default:
                this.f15766a = new ArrayList();
                break;
        }
    }

    public List a(int i3, sf.b bVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f15766a;
        Collections.sort(arrayList2);
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            sf.a aVar = (sf.a) obj;
            arrayList.add(bVar.a(aVar.f18257a, aVar.f18258b));
        }
        return arrayList.subList(0, Math.min(i3, arrayList.size()));
    }

    public synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        ArrayList arrayList2 = this.f15766a;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            b bVar = (b) obj;
            if (bVar.f15763a.isAssignableFrom(cls) && cls2.isAssignableFrom(bVar.f15764b)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public c c(sf.b bVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f15766a;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            sf.a aVar = (sf.a) obj;
            aVar.getClass();
            RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
            PointF pointF = new PointF();
            RectF rectF2 = aVar.f18257a;
            pointF.set(rectF2.left, rectF2.top);
            PointF b3 = bVar.b(pointF);
            sf.a.a(rectF, b3);
            b3.set(rectF2.right, rectF2.top);
            PointF b10 = bVar.b(b3);
            sf.a.a(rectF, b10);
            b10.set(rectF2.right, rectF2.bottom);
            PointF b11 = bVar.b(b10);
            sf.a.a(rectF, b11);
            b11.set(rectF2.left, rectF2.bottom);
            sf.a.a(rectF, bVar.b(b11));
            arrayList.add(new sf.a(rectF, aVar.f18258b));
        }
        return new c(arrayList);
    }

    public c(ArrayList arrayList) {
        this.f15766a = arrayList;
    }
}
