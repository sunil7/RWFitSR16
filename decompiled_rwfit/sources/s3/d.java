package s3;

import android.view.View;
import com.contrarywind.view.WheelView;
import java.util.List;
import n.m0;

/* loaded from: classes.dex */
public final class d extends c implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name */
    public f f18176m;

    @Override // s3.c
    public final boolean c() {
        this.e.getClass();
        return false;
    }

    public final void e() {
        f fVar = this.f18176m;
        if (fVar != null) {
            q3.a aVar = this.e;
            int i3 = aVar.f17752d;
            int i10 = aVar.e;
            int i11 = aVar.f17753f;
            if (fVar.f18181d != null) {
                fVar.f18178a.setCurrentItem(i3);
            }
            List list = fVar.e;
            if (list != null) {
                n6.a aVar2 = new n6.a((List) list.get(i3), 2);
                WheelView wheelView = fVar.f18179b;
                wheelView.setAdapter(aVar2);
                wheelView.setCurrentItem(i10);
            }
            List list2 = fVar.f18182f;
            if (list2 != null) {
                n6.a aVar3 = new n6.a((List) ((List) list2.get(i3)).get(i10), 2);
                WheelView wheelView2 = fVar.f18180c;
                wheelView2.setAdapter(aVar3);
                wheelView2.setCurrentItem(i11);
            }
        }
    }

    public final void f(List list, List list2, List list3) {
        f fVar = this.f18176m;
        fVar.f18181d = list;
        fVar.e = list2;
        fVar.f18182f = list3;
        n6.a aVar = new n6.a(list, 2);
        WheelView wheelView = fVar.f18178a;
        wheelView.setAdapter(aVar);
        wheelView.setCurrentItem(0);
        List list4 = fVar.e;
        WheelView wheelView2 = fVar.f18179b;
        if (list4 != null) {
            wheelView2.setAdapter(new n6.a((List) list4.get(0), 2));
        }
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        List list5 = fVar.f18182f;
        WheelView wheelView3 = fVar.f18180c;
        if (list5 != null) {
            wheelView3.setAdapter(new n6.a((List) ((List) list5.get(0)).get(0), 2));
        }
        wheelView3.setCurrentItem(wheelView3.getCurrentItem());
        wheelView.setIsOptions(true);
        wheelView2.setIsOptions(true);
        wheelView3.setIsOptions(true);
        if (fVar.e == null) {
            wheelView2.setVisibility(8);
        } else {
            wheelView2.setVisibility(0);
        }
        if (fVar.f18182f == null) {
            wheelView3.setVisibility(8);
        } else {
            wheelView3.setVisibility(0);
        }
        mc.g gVar = new mc.g(fVar, 14);
        fVar.f18183g = new n6.a(fVar, 13);
        if (list != null) {
            wheelView.setOnItemSelectedListener(gVar);
        }
        if (list2 != null) {
            wheelView2.setOnItemSelectedListener(fVar.f18183g);
        }
        if (list3 != null && fVar.f18184h != null) {
            wheelView3.setOnItemSelectedListener(new m0(fVar, 16));
        }
        e();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            this.e.getClass();
        } else if (str.equals("cancel")) {
            this.e.getClass();
        }
        a();
    }
}
