package af;

import com.google.android.gms.internal.mlkit_vision_barcode.z0;
import com.loper7.date_time_picker.number_picker.NumberPicker;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.jvm.internal.e;
import oh.l;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public NumberPicker f278a;

    /* renamed from: b, reason: collision with root package name */
    public NumberPicker f279b;

    /* renamed from: c, reason: collision with root package name */
    public NumberPicker f280c;

    /* renamed from: d, reason: collision with root package name */
    public NumberPicker f281d;
    public NumberPicker e;

    /* renamed from: f, reason: collision with root package name */
    public NumberPicker f282f;

    /* renamed from: g, reason: collision with root package name */
    public Calendar f283g;

    /* renamed from: h, reason: collision with root package name */
    public Calendar f284h;

    /* renamed from: i, reason: collision with root package name */
    public Calendar f285i;

    /* renamed from: j, reason: collision with root package name */
    public int f286j;

    /* renamed from: k, reason: collision with root package name */
    public l f287k;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f289m;

    /* renamed from: l, reason: collision with root package name */
    public boolean f288l = true;

    /* renamed from: n, reason: collision with root package name */
    public final a f290n = new a(this, 0);

    public static int b(Integer num, Integer num2) {
        if (num == null || num.intValue() <= 0 || num2.intValue() < 0) {
            return 0;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            e.e(calendar, "getInstance()");
            calendar.clear();
            calendar.set(1, num.intValue());
            calendar.set(2, num2.intValue());
            return calendar.getActualMaximum(5);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final void a(int i3, NumberPicker numberPicker) {
        if (i3 == 0) {
            this.f278a = numberPicker;
            return;
        }
        if (i3 == 1) {
            this.f279b = numberPicker;
            return;
        }
        if (i3 == 2) {
            this.f280c = numberPicker;
            return;
        }
        if (i3 == 3) {
            this.f281d = numberPicker;
        } else if (i3 == 4) {
            this.e = numberPicker;
        } else {
            if (i3 != 5) {
                return;
            }
            this.f282f = numberPicker;
        }
    }

    public final void c() {
        Throwable th2;
        int i3;
        NumberPicker numberPicker;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Calendar calendar = this.f283g;
        if (calendar == null) {
            e.m("calendar");
            throw null;
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = this.f284h;
        if (calendar2 == null) {
            e.m("minCalendar");
            throw null;
        }
        if (timeInMillis < calendar2.getTimeInMillis()) {
            Calendar calendar3 = this.f283g;
            if (calendar3 == null) {
                e.m("calendar");
                throw null;
            }
            calendar3.clear();
            Calendar calendar4 = this.f283g;
            if (calendar4 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar5 = this.f284h;
            if (calendar5 == null) {
                e.m("minCalendar");
                throw null;
            }
            calendar4.setTimeInMillis(calendar5.getTimeInMillis());
        }
        Calendar calendar6 = this.f283g;
        if (calendar6 == null) {
            e.m("calendar");
            throw null;
        }
        long timeInMillis2 = calendar6.getTimeInMillis();
        Calendar calendar7 = this.f285i;
        if (calendar7 == null) {
            e.m("maxCalendar");
            throw null;
        }
        if (timeInMillis2 > calendar7.getTimeInMillis()) {
            Calendar calendar8 = this.f283g;
            if (calendar8 == null) {
                e.m("calendar");
                throw null;
            }
            calendar8.clear();
            Calendar calendar9 = this.f283g;
            if (calendar9 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar10 = this.f285i;
            if (calendar10 == null) {
                e.m("maxCalendar");
                throw null;
            }
            calendar9.setTimeInMillis(calendar10.getTimeInMillis());
        }
        Calendar calendar11 = this.f283g;
        if (calendar11 == null) {
            e.m("calendar");
            throw null;
        }
        Integer valueOf = Integer.valueOf(calendar11.get(1));
        Calendar calendar12 = this.f283g;
        if (calendar12 == null) {
            e.m("calendar");
            throw null;
        }
        int b3 = b(valueOf, Integer.valueOf(calendar12.get(2)));
        NumberPicker numberPicker2 = this.f279b;
        if (numberPicker2 != null) {
            Calendar calendar13 = this.f283g;
            if (calendar13 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar14 = this.f284h;
            if (calendar14 == null) {
                e.m("minCalendar");
                throw null;
            }
            if (z0.e(calendar13, calendar14)) {
                Calendar calendar15 = this.f284h;
                if (calendar15 == null) {
                    e.m("minCalendar");
                    throw null;
                }
                i16 = calendar15.get(2) + 1;
            } else {
                i16 = 1;
            }
            numberPicker2.setMinValue(i16);
            Calendar calendar16 = this.f283g;
            if (calendar16 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar17 = this.f285i;
            if (calendar17 == null) {
                e.m("maxCalendar");
                throw null;
            }
            if (z0.e(calendar16, calendar17)) {
                Calendar calendar18 = this.f285i;
                if (calendar18 == null) {
                    e.m("maxCalendar");
                    throw null;
                }
                i17 = calendar18.get(2) + 1;
            } else {
                i17 = 12;
            }
            numberPicker2.setMaxValue(i17);
        }
        NumberPicker numberPicker3 = this.f280c;
        if (numberPicker3 != null) {
            Calendar calendar19 = this.f283g;
            if (calendar19 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar20 = this.f284h;
            if (calendar20 == null) {
                e.m("minCalendar");
                throw null;
            }
            if (z0.d(calendar19, calendar20)) {
                Calendar calendar21 = this.f284h;
                if (calendar21 == null) {
                    e.m("minCalendar");
                    throw null;
                }
                i14 = calendar21.get(5);
            } else {
                i14 = 1;
            }
            numberPicker3.setMinValue(i14);
            Calendar calendar22 = this.f283g;
            if (calendar22 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar23 = this.f285i;
            if (calendar23 == null) {
                e.m("maxCalendar");
                throw null;
            }
            if (z0.d(calendar22, calendar23)) {
                Calendar calendar24 = this.f285i;
                if (calendar24 == null) {
                    e.m("maxCalendar");
                    throw null;
                }
                i15 = calendar24.get(5);
            } else {
                i15 = b3;
            }
            numberPicker3.setMaxValue(i15);
        }
        NumberPicker numberPicker4 = this.f281d;
        if (numberPicker4 != null) {
            Calendar calendar25 = this.f283g;
            if (calendar25 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar26 = this.f284h;
            if (calendar26 == null) {
                e.m("minCalendar");
                throw null;
            }
            if (z0.a(calendar25, calendar26)) {
                Calendar calendar27 = this.f284h;
                if (calendar27 == null) {
                    e.m("minCalendar");
                    throw null;
                }
                i12 = calendar27.get(11);
            } else {
                i12 = 0;
            }
            numberPicker4.setMinValue(i12);
            Calendar calendar28 = this.f283g;
            if (calendar28 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar29 = this.f285i;
            if (calendar29 == null) {
                e.m("maxCalendar");
                throw null;
            }
            if (z0.a(calendar28, calendar29)) {
                Calendar calendar30 = this.f285i;
                if (calendar30 == null) {
                    e.m("maxCalendar");
                    throw null;
                }
                i13 = calendar30.get(11);
            } else {
                i13 = 23;
            }
            numberPicker4.setMaxValue(i13);
        }
        NumberPicker numberPicker5 = this.e;
        int i18 = 59;
        if (numberPicker5 != null) {
            Calendar calendar31 = this.f283g;
            if (calendar31 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar32 = this.f284h;
            if (calendar32 == null) {
                e.m("minCalendar");
                throw null;
            }
            if (z0.b(calendar31, calendar32)) {
                Calendar calendar33 = this.f284h;
                if (calendar33 == null) {
                    e.m("minCalendar");
                    throw null;
                }
                i10 = calendar33.get(12);
            } else {
                i10 = 0;
            }
            numberPicker5.setMinValue(i10);
            Calendar calendar34 = this.f283g;
            if (calendar34 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar35 = this.f285i;
            if (calendar35 == null) {
                e.m("maxCalendar");
                throw null;
            }
            if (z0.b(calendar34, calendar35)) {
                Calendar calendar36 = this.f285i;
                if (calendar36 == null) {
                    e.m("maxCalendar");
                    throw null;
                }
                i11 = calendar36.get(12);
            } else {
                i11 = 59;
            }
            numberPicker5.setMaxValue(i11);
        }
        NumberPicker numberPicker6 = this.f282f;
        if (numberPicker6 == null) {
            th2 = null;
        } else {
            Calendar calendar37 = this.f283g;
            th2 = null;
            if (calendar37 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar38 = this.f284h;
            if (calendar38 == null) {
                e.m("minCalendar");
                throw null;
            }
            if (z0.c(calendar37, calendar38)) {
                Calendar calendar39 = this.f284h;
                if (calendar39 == null) {
                    e.m("minCalendar");
                    throw null;
                }
                i3 = calendar39.get(13);
            } else {
                i3 = 0;
            }
            numberPicker6.setMinValue(i3);
            Calendar calendar40 = this.f283g;
            if (calendar40 == null) {
                e.m("calendar");
                throw null;
            }
            Calendar calendar41 = this.f285i;
            if (calendar41 == null) {
                e.m("maxCalendar");
                throw null;
            }
            if (z0.c(calendar40, calendar41)) {
                Calendar calendar42 = this.f285i;
                if (calendar42 == null) {
                    e.m("maxCalendar");
                    throw null;
                }
                i18 = calendar42.get(13);
            }
            numberPicker6.setMaxValue(i18);
        }
        NumberPicker numberPicker7 = this.f278a;
        if (numberPicker7 != null) {
            Calendar calendar43 = this.f283g;
            if (calendar43 == null) {
                e.m("calendar");
                throw th2;
            }
            numberPicker7.setValue(calendar43.get(1));
        }
        NumberPicker numberPicker8 = this.f279b;
        if (numberPicker8 != null) {
            Calendar calendar44 = this.f283g;
            if (calendar44 == null) {
                e.m("calendar");
                throw th2;
            }
            numberPicker8.setValue(calendar44.get(2) + 1);
        }
        NumberPicker numberPicker9 = this.f280c;
        if (numberPicker9 != null) {
            Calendar calendar45 = this.f283g;
            if (calendar45 == null) {
                e.m("calendar");
                throw th2;
            }
            numberPicker9.setValue(calendar45.get(5));
        }
        NumberPicker numberPicker10 = this.f281d;
        if (numberPicker10 != null) {
            Calendar calendar46 = this.f283g;
            if (calendar46 == null) {
                e.m("calendar");
                throw th2;
            }
            numberPicker10.setValue(calendar46.get(11));
        }
        NumberPicker numberPicker11 = this.e;
        if (numberPicker11 != null) {
            Calendar calendar47 = this.f283g;
            if (calendar47 == null) {
                e.m("calendar");
                throw th2;
            }
            numberPicker11.setValue(calendar47.get(12));
        }
        NumberPicker numberPicker12 = this.f282f;
        if (numberPicker12 != null) {
            Calendar calendar48 = this.f283g;
            if (calendar48 == null) {
                e.m("calendar");
                throw th2;
            }
            numberPicker12.setValue(calendar48.get(13));
        }
        NumberPicker numberPicker13 = this.f280c;
        if ((numberPicker13 != null ? numberPicker13.getValue() : 0) >= b3 && (numberPicker = this.f280c) != null) {
            numberPicker.setValue(b3);
        }
        f(this.f289m, this.f288l);
    }

    public final void d() {
        l lVar = this.f287k;
        if (lVar == null || lVar == null) {
            return;
        }
        Calendar calendar = this.f283g;
        if (calendar != null) {
            lVar.invoke(Long.valueOf(calendar.getTimeInMillis()));
        } else {
            e.m("calendar");
            throw null;
        }
    }

    public final void e(long j4) {
        if (j4 == 0) {
            return;
        }
        Calendar calendar = this.f283g;
        if (calendar == null) {
            e.m("calendar");
            throw null;
        }
        calendar.clear();
        Calendar calendar2 = this.f283g;
        if (calendar2 == null) {
            e.m("calendar");
            throw null;
        }
        calendar2.setTimeInMillis(j4);
        c();
        d();
    }

    public final void f(ArrayList arrayList, boolean z5) {
        NumberPicker numberPicker;
        this.f289m = arrayList;
        this.f288l = z5;
        int i3 = 0;
        if (arrayList == null || arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            this.f289m = arrayList2;
            arrayList2.add(0);
            ArrayList arrayList3 = this.f289m;
            e.c(arrayList3);
            arrayList3.add(1);
            ArrayList arrayList4 = this.f289m;
            e.c(arrayList4);
            arrayList4.add(2);
            ArrayList arrayList5 = this.f289m;
            e.c(arrayList5);
            arrayList5.add(3);
            ArrayList arrayList6 = this.f289m;
            e.c(arrayList6);
            arrayList6.add(4);
            ArrayList arrayList7 = this.f289m;
            e.c(arrayList7);
            arrayList7.add(5);
        }
        ArrayList arrayList8 = this.f289m;
        e.c(arrayList8);
        int size = arrayList8.size();
        while (i3 < size) {
            Object obj = arrayList8.get(i3);
            i3++;
            int intValue = ((Number) obj).intValue();
            if (intValue == 0) {
                NumberPicker numberPicker2 = this.f278a;
                if (numberPicker2 != null) {
                    numberPicker2.setWrapSelectorWheel(z5);
                }
            } else if (intValue == 1) {
                NumberPicker numberPicker3 = this.f279b;
                if (numberPicker3 != null) {
                    numberPicker3.setWrapSelectorWheel(z5);
                }
            } else if (intValue == 2) {
                NumberPicker numberPicker4 = this.f280c;
                if (numberPicker4 != null) {
                    numberPicker4.setWrapSelectorWheel(z5);
                }
            } else if (intValue == 3) {
                NumberPicker numberPicker5 = this.f281d;
                if (numberPicker5 != null) {
                    numberPicker5.setWrapSelectorWheel(z5);
                }
            } else if (intValue == 4) {
                NumberPicker numberPicker6 = this.e;
                if (numberPicker6 != null) {
                    numberPicker6.setWrapSelectorWheel(z5);
                }
            } else if (intValue == 5 && (numberPicker = this.f282f) != null) {
                numberPicker.setWrapSelectorWheel(z5);
            }
        }
    }
}
