package c7;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.app.d;
import androidx.viewpager.widget.ViewPager;
import com.example.test.R$id;
import com.example.test.R$layout;
import f8.f;
import java.util.ArrayList;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public final class b extends n2.a {

    /* renamed from: c, reason: collision with root package name */
    public final f f3395c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f3396d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3397f;

    /* renamed from: g, reason: collision with root package name */
    public DateTime f3398g;

    /* renamed from: h, reason: collision with root package name */
    public DateTime f3399h;

    public b(Context context, int i3, DateTime dateTime) {
        f fVar = new f(4);
        fVar.f13517c = new View[0];
        fVar.f13518d = new int[0];
        this.f3395c = fVar;
        SparseArray[] sparseArrayArr = {new SparseArray()};
        fVar.f13516b = 1;
        fVar.f13519f = sparseArrayArr[0];
        fVar.e = sparseArrayArr;
        this.f3396d = context;
        this.e = i3;
        this.f3398g = dateTime;
        this.f3397f = i3 / 2;
        this.f3399h = new DateTime();
    }

    @Override // n2.a
    public final void a(ViewPager viewPager, int i3, Object obj) {
        View view = (View) obj;
        viewPager.removeView(view);
        f fVar = this.f3395c;
        if (fVar.f13516b == 1) {
            ((SparseArray) fVar.f13519f).put(i3, view);
        } else {
            ((SparseArray[]) fVar.e)[0].put(i3, view);
        }
        view.setAccessibilityDelegate(null);
    }

    @Override // n2.a
    public final int c() {
        return this.e;
    }

    @Override // n2.a
    public final int d(Object obj) {
        return -2;
    }

    @Override // n2.a
    public final Object f(ViewPager viewPager, int i3) {
        View d5;
        a aVar;
        f fVar = this.f3395c;
        if (fVar.f13516b == 1) {
            d5 = f.d((SparseArray) fVar.f13519f, i3);
        } else {
            SparseArray[] sparseArrayArr = (SparseArray[]) fVar.e;
            d5 = sparseArrayArr.length > 0 ? f.d(sparseArrayArr[0], i3) : null;
        }
        if (d5 == null) {
            d5 = LayoutInflater.from(this.f3396d).inflate(R$layout.item_calendar, (ViewGroup) viewPager, false);
            aVar = new a();
            aVar.f3394a = (GridView) d5.findViewById(R$id.grid_date);
            d5.setTag(aVar);
        } else {
            aVar = (a) d5.getTag();
        }
        DateTime plusWeeks = this.f3398g.plusWeeks(i3 - this.f3397f);
        DateTime dateTime = this.f3399h;
        c cVar = new c();
        cVar.f3401b = dateTime;
        cVar.f3400a = new ArrayList();
        for (int i10 = 0; i10 < 7; i10++) {
            cVar.f3400a.add(new DateTime(plusWeeks).plusDays(i10));
        }
        aVar.f3394a.setAdapter((ListAdapter) cVar);
        aVar.f3394a.setOnItemClickListener(new d(1, this, cVar));
        viewPager.addView(d5);
        return d5;
    }

    @Override // n2.a
    public final boolean g(View view, Object obj) {
        return view == obj;
    }

    @Override // n2.a
    public final void h() {
        f fVar = this.f3395c;
        boolean z5 = fVar.f13516b > 1;
        SparseArray sparseArray = (SparseArray) fVar.f13519f;
        View[] viewArr = (View[]) fVar.f13517c;
        for (int length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                int[] iArr = (int[]) fVar.f13518d;
                int i3 = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if (i3 >= 0) {
                    if (z5) {
                        sparseArray = ((SparseArray[]) fVar.e)[i3];
                    }
                    sparseArray.put(length, view);
                    view.setAccessibilityDelegate(null);
                }
            }
        }
        int length2 = viewArr.length;
        int i10 = fVar.f13516b;
        SparseArray[] sparseArrayArr = (SparseArray[]) fVar.e;
        for (int i11 = 0; i11 < i10; i11++) {
            SparseArray sparseArray2 = sparseArrayArr[i11];
            int size = sparseArray2.size();
            int i12 = size - length2;
            int i13 = size - 1;
            int i14 = 0;
            while (i14 < i12) {
                sparseArray2.remove(sparseArray2.keyAt(i13));
                i14++;
                i13--;
            }
        }
        super.h();
    }
}
