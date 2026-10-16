package s3;

import androidx.recyclerview.widget.e1;
import java.util.List;
import n.m0;

/* loaded from: classes.dex */
public final class g implements w4.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18185a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f18186b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f18187c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f18188d;

    public /* synthetic */ g(h hVar, List list, List list2, int i3) {
        this.f18185a = i3;
        this.f18188d = hVar;
        this.f18186b = list;
        this.f18187c = list2;
    }

    @Override // w4.a
    public final void E(int i3) {
        switch (this.f18185a) {
            case 0:
                h hVar = this.f18188d;
                int i10 = i3 + hVar.f18197i;
                hVar.f18203o = i10;
                int currentItem = hVar.f18192c.getCurrentItem();
                int i11 = hVar.f18197i;
                int i12 = hVar.f18198j;
                if (i11 == i12) {
                    hVar.f18192c.setAdapter(new e1(hVar.f18199k, hVar.f18200l, 4));
                    if (currentItem > hVar.f18192c.getAdapter().z() - 1) {
                        currentItem = hVar.f18192c.getAdapter().z() - 1;
                        hVar.f18192c.setCurrentItem(currentItem);
                    }
                    h hVar2 = this.f18188d;
                    int i13 = hVar2.f18199k;
                    int i14 = currentItem + i13;
                    int i15 = hVar2.f18200l;
                    if (i13 == i15) {
                        h.a(hVar2, i10, i14, hVar2.f18201m, hVar2.f18202n, this.f18186b, this.f18187c);
                    } else if (i14 == i13) {
                        h.a(hVar2, i10, i14, hVar2.f18201m, 31, this.f18186b, this.f18187c);
                    } else if (i14 == i15) {
                        h.a(hVar2, i10, i14, 1, hVar2.f18202n, this.f18186b, this.f18187c);
                    } else {
                        h.a(hVar2, i10, i14, 1, 31, this.f18186b, this.f18187c);
                    }
                } else if (i10 == i11) {
                    hVar.f18192c.setAdapter(new e1(hVar.f18199k, 12, 4));
                    if (currentItem > hVar.f18192c.getAdapter().z() - 1) {
                        currentItem = hVar.f18192c.getAdapter().z() - 1;
                        hVar.f18192c.setCurrentItem(currentItem);
                    }
                    h hVar3 = this.f18188d;
                    int i16 = hVar3.f18199k;
                    int i17 = currentItem + i16;
                    if (i17 == i16) {
                        h.a(hVar3, i10, i17, hVar3.f18201m, 31, this.f18186b, this.f18187c);
                    } else {
                        h.a(hVar3, i10, i17, 1, 31, this.f18186b, this.f18187c);
                    }
                } else if (i10 == i12) {
                    hVar.f18192c.setAdapter(new e1(1, hVar.f18200l, 4));
                    if (currentItem > hVar.f18192c.getAdapter().z() - 1) {
                        currentItem = hVar.f18192c.getAdapter().z() - 1;
                        hVar.f18192c.setCurrentItem(currentItem);
                    }
                    int i18 = 1 + currentItem;
                    h hVar4 = this.f18188d;
                    if (i18 == hVar4.f18200l) {
                        h.a(hVar4, i10, i18, 1, hVar4.f18202n, this.f18186b, this.f18187c);
                    } else {
                        h.a(hVar4, i10, i18, 1, 31, this.f18186b, this.f18187c);
                    }
                } else {
                    hVar.f18192c.setAdapter(new e1(1, 12, 4));
                    h hVar5 = this.f18188d;
                    h.a(hVar5, i10, 1 + hVar5.f18192c.getCurrentItem(), 1, 31, this.f18186b, this.f18187c);
                }
                m0 m0Var = hVar.f18204p;
                if (m0Var != null) {
                    m0Var.D();
                    break;
                }
                break;
            default:
                int i19 = i3 + 1;
                h hVar6 = this.f18188d;
                int i20 = hVar6.f18197i;
                int i21 = hVar6.f18198j;
                h hVar7 = this.f18188d;
                if (i20 == i21) {
                    int i22 = hVar6.f18199k;
                    int i23 = (i19 + i22) - 1;
                    int i24 = hVar6.f18200l;
                    if (i22 == i24) {
                        h.a(hVar6, hVar6.f18203o, i23, hVar6.f18201m, hVar6.f18202n, this.f18186b, this.f18187c);
                    } else if (i22 == i23) {
                        h.a(hVar6, hVar6.f18203o, i23, hVar6.f18201m, 31, this.f18186b, this.f18187c);
                    } else if (i24 == i23) {
                        h.a(hVar6, hVar6.f18203o, i23, 1, hVar6.f18202n, this.f18186b, this.f18187c);
                    } else {
                        h.a(hVar6, hVar6.f18203o, i23, 1, 31, this.f18186b, this.f18187c);
                    }
                } else {
                    int i25 = hVar6.f18203o;
                    if (i25 == i20) {
                        int i26 = hVar6.f18199k;
                        int i27 = (i19 + i26) - 1;
                        if (i27 == i26) {
                            h.a(hVar6, i25, i27, hVar6.f18201m, 31, this.f18186b, this.f18187c);
                        } else {
                            h.a(hVar6, i25, i27, 1, 31, this.f18186b, this.f18187c);
                        }
                    } else if (i25 != i21) {
                        h.a(hVar6, i25, i19, 1, 31, this.f18186b, this.f18187c);
                    } else if (i19 == hVar6.f18200l) {
                        h.a(hVar6, i25, hVar6.f18192c.getCurrentItem() + 1, 1, hVar7.f18202n, this.f18186b, this.f18187c);
                    } else {
                        h.a(hVar6, i25, hVar6.f18192c.getCurrentItem() + 1, 1, 31, this.f18186b, this.f18187c);
                    }
                }
                m0 m0Var2 = hVar7.f18204p;
                if (m0Var2 != null) {
                    m0Var2.D();
                    break;
                }
                break;
        }
    }
}
