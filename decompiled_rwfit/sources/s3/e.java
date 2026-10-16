package s3;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.e1;
import com.contrarywind.view.WheelView;
import com.example.baselibrary.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends c implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name */
    public h f18177m;

    @Override // s3.c
    public final boolean c() {
        this.e.getClass();
        return false;
    }

    public final void e() {
        h hVar = this.f18177m;
        q3.a aVar = this.e;
        Calendar calendar = aVar.f17756i;
        Calendar calendar2 = aVar.f17757j;
        hVar.getClass();
        if (calendar == null && calendar2 != null) {
            int i3 = calendar2.get(1);
            int i10 = calendar2.get(2) + 1;
            int i11 = calendar2.get(5);
            int i12 = hVar.f18197i;
            if (i3 > i12) {
                hVar.f18198j = i3;
                hVar.f18200l = i10;
                hVar.f18202n = i11;
            } else if (i3 == i12) {
                int i13 = hVar.f18199k;
                if (i10 > i13) {
                    hVar.f18198j = i3;
                    hVar.f18200l = i10;
                    hVar.f18202n = i11;
                } else if (i10 == i13 && i11 > hVar.f18201m) {
                    hVar.f18198j = i3;
                    hVar.f18200l = i10;
                    hVar.f18202n = i11;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i14 = calendar.get(1);
            int i15 = calendar.get(2) + 1;
            int i16 = calendar.get(5);
            int i17 = hVar.f18198j;
            if (i14 < i17) {
                hVar.f18199k = i15;
                hVar.f18201m = i16;
                hVar.f18197i = i14;
            } else if (i14 == i17) {
                int i18 = hVar.f18200l;
                if (i15 < i18) {
                    hVar.f18199k = i15;
                    hVar.f18201m = i16;
                    hVar.f18197i = i14;
                } else if (i15 == i18 && i16 < hVar.f18202n) {
                    hVar.f18199k = i15;
                    hVar.f18201m = i16;
                    hVar.f18197i = i14;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            hVar.f18197i = calendar.get(1);
            hVar.f18198j = calendar2.get(1);
            hVar.f18199k = calendar.get(2) + 1;
            hVar.f18200l = calendar2.get(2) + 1;
            hVar.f18201m = calendar.get(5);
            hVar.f18202n = calendar2.get(5);
        }
        q3.a aVar2 = this.e;
        Calendar calendar3 = aVar2.f17756i;
        if (calendar3 == null || aVar2.f17757j == null) {
            if (calendar3 != null) {
                aVar2.f17755h = calendar3;
                return;
            }
            Calendar calendar4 = aVar2.f17757j;
            if (calendar4 != null) {
                aVar2.f17755h = calendar4;
                return;
            }
            return;
        }
        Calendar calendar5 = aVar2.f17755h;
        if (calendar5 == null || calendar5.getTimeInMillis() < this.e.f17756i.getTimeInMillis() || this.e.f17755h.getTimeInMillis() > this.e.f17757j.getTimeInMillis()) {
            q3.a aVar3 = this.e;
            aVar3.f17755h = aVar3.f17756i;
        }
    }

    public final void f() {
        int i3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.e.f17755h;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i3 = calendar.get(1);
            i10 = calendar.get(2);
            i11 = calendar.get(5);
            i12 = calendar.get(11);
            i13 = calendar.get(12);
            i14 = calendar.get(13);
        } else {
            i3 = calendar2.get(1);
            i10 = this.e.f17755h.get(2);
            i11 = this.e.f17755h.get(5);
            i12 = this.e.f17755h.get(11);
            i13 = this.e.f17755h.get(12);
            i14 = this.e.f17755h.get(13);
            StringBuilder s7 = l0.s(i3, " year ", i10, " month ", " day ");
            s7.append(i11);
            Log.e("qob", s7.toString());
        }
        h hVar = this.f18177m;
        hVar.getClass();
        boolean[] zArr = hVar.f18196h;
        LinearLayout linearLayout = hVar.f18190a;
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {Constants.VIA_TO_TYPE_QZONE, Constants.VIA_SHARE_TYPE_INFO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        List asList = Arrays.asList(strArr);
        List asList2 = Arrays.asList(strArr2);
        hVar.f18203o = i3;
        WheelView wheelView = (WheelView) linearLayout.findViewById(R$id.year);
        hVar.f18191b = wheelView;
        wheelView.setAdapter(new e1(hVar.f18197i, hVar.f18198j, 4));
        hVar.f18191b.setCurrentItem(i3 - hVar.f18197i);
        hVar.f18191b.setGravity(17);
        WheelView wheelView2 = (WheelView) linearLayout.findViewById(R$id.month);
        hVar.f18192c = wheelView2;
        int i18 = hVar.f18197i;
        int i19 = hVar.f18198j;
        if (i18 == i19) {
            wheelView2.setAdapter(new e1(hVar.f18199k, hVar.f18200l, 4));
            hVar.f18192c.setCurrentItem((i10 + 1) - hVar.f18199k);
        } else if (i3 == i18) {
            wheelView2.setAdapter(new e1(hVar.f18199k, 12, 4));
            hVar.f18192c.setCurrentItem((i10 + 1) - hVar.f18199k);
        } else if (i3 == i19) {
            wheelView2.setAdapter(new e1(1, hVar.f18200l, 4));
            hVar.f18192c.setCurrentItem(i10);
        } else {
            wheelView2.setAdapter(new e1(1, 12, 4));
            hVar.f18192c.setCurrentItem(i10);
        }
        hVar.f18192c.setGravity(17);
        hVar.f18193d = (WheelView) linearLayout.findViewById(R$id.day);
        boolean z5 = (i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0;
        int i20 = hVar.f18197i;
        int i21 = hVar.f18198j;
        if (i20 == i21 && hVar.f18199k == hVar.f18200l) {
            int i22 = i10 + 1;
            if (asList.contains(String.valueOf(i22))) {
                if (hVar.f18202n > 31) {
                    hVar.f18202n = 31;
                }
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, hVar.f18202n, 4));
            } else if (asList2.contains(String.valueOf(i22))) {
                if (hVar.f18202n > 30) {
                    hVar.f18202n = 30;
                }
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, hVar.f18202n, 4));
            } else if (z5) {
                if (hVar.f18202n > 29) {
                    hVar.f18202n = 29;
                }
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, hVar.f18202n, 4));
            } else {
                if (hVar.f18202n > 28) {
                    hVar.f18202n = 28;
                }
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, hVar.f18202n, 4));
            }
            hVar.f18193d.setCurrentItem(i11 - hVar.f18201m);
        } else if (i3 == i20 && (i17 = i10 + 1) == hVar.f18199k) {
            if (asList.contains(String.valueOf(i17))) {
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, 31, 4));
            } else if (asList2.contains(String.valueOf(i17))) {
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, 30, 4));
            } else {
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, z5 ? 29 : 28, 4));
            }
            hVar.f18193d.setCurrentItem(i11 - hVar.f18201m);
        } else if (i3 == i21 && (i15 = i10 + 1) == hVar.f18200l) {
            if (asList.contains(String.valueOf(i15))) {
                if (hVar.f18202n > 31) {
                    hVar.f18202n = 31;
                }
                hVar.f18193d.setAdapter(new e1(1, hVar.f18202n, 4));
            } else if (asList2.contains(String.valueOf(i15))) {
                if (hVar.f18202n > 30) {
                    hVar.f18202n = 30;
                }
                hVar.f18193d.setAdapter(new e1(1, hVar.f18202n, 4));
            } else if (z5) {
                if (hVar.f18202n > 29) {
                    hVar.f18202n = 29;
                }
                hVar.f18193d.setAdapter(new e1(1, hVar.f18202n, 4));
            } else {
                if (hVar.f18202n > 28) {
                    hVar.f18202n = 28;
                }
                i16 = 1;
                hVar.f18193d.setAdapter(new e1(1, hVar.f18202n, 4));
                hVar.f18193d.setCurrentItem(i11 - i16);
            }
            i16 = 1;
            hVar.f18193d.setCurrentItem(i11 - i16);
        } else {
            int i23 = i10 + 1;
            if (asList.contains(String.valueOf(i23))) {
                hVar.f18193d.setAdapter(new e1(1, 31, 4));
            } else if (asList2.contains(String.valueOf(i23))) {
                hVar.f18193d.setAdapter(new e1(1, 30, 4));
            } else {
                hVar.f18193d.setAdapter(new e1(hVar.f18201m, z5 ? 29 : 28, 4));
            }
            hVar.f18193d.setCurrentItem(i11 - 1);
        }
        hVar.f18193d.setGravity(17);
        WheelView wheelView3 = (WheelView) linearLayout.findViewById(R$id.hour);
        hVar.e = wheelView3;
        wheelView3.setAdapter(new e1(0, 23, 4));
        hVar.e.setCurrentItem(i12);
        hVar.e.setGravity(17);
        WheelView wheelView4 = (WheelView) linearLayout.findViewById(R$id.min);
        hVar.f18194f = wheelView4;
        wheelView4.setAdapter(new e1(0, 59, 4));
        hVar.f18194f.setCurrentItem(i13);
        hVar.f18194f.setGravity(17);
        WheelView wheelView5 = (WheelView) linearLayout.findViewById(R$id.second);
        hVar.f18195g = wheelView5;
        wheelView5.setAdapter(new e1(0, 59, 4));
        hVar.f18195g.setCurrentItem(i14);
        hVar.f18195g.setGravity(17);
        hVar.f18191b.setOnItemSelectedListener(new g(hVar, asList, asList2, 0));
        hVar.f18192c.setOnItemSelectedListener(new g(hVar, asList, asList2, 1));
        hVar.c(hVar.f18193d);
        hVar.c(hVar.e);
        hVar.c(hVar.f18194f);
        hVar.c(hVar.f18195g);
        if (zArr.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        hVar.f18191b.setVisibility(zArr[0] ? 0 : 8);
        hVar.f18192c.setVisibility(zArr[1] ? 0 : 8);
        hVar.f18193d.setVisibility(zArr[2] ? 0 : 8);
        hVar.e.setVisibility(zArr[3] ? 0 : 8);
        hVar.f18194f.setVisibility(zArr[4] ? 0 : 8);
        hVar.f18195g.setVisibility(zArr[5] ? 0 : 8);
        float f2 = 18;
        hVar.f18193d.setTextSize(f2);
        hVar.f18192c.setTextSize(f2);
        hVar.f18191b.setTextSize(f2);
        hVar.e.setTextSize(f2);
        hVar.f18194f.setTextSize(f2);
        hVar.f18195g.setTextSize(f2);
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
