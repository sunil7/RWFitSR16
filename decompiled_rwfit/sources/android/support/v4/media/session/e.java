package android.support.v4.media.session;

import android.graphics.Color;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.services.core.AMapException;
import com.bumptech.glide.i;
import com.example.test.service.d0;
import com.example.test.ui.device.activity.BreatheSettingActivity;
import com.example.test.ui.view.ActionItemView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.text.m;
import o7.k;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.json.JSONException;

/* loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static void A(Object[] objArr, int i3, String str, TextView textView) {
        textView.setText(String.format(str, Arrays.copyOf(objArr, i3)));
    }

    public static void B(Object[] objArr, int i3, Locale locale, String str, ActionItemView actionItemView) {
        actionItemView.setHintStr(String.format(locale, str, Arrays.copyOf(objArr, i3)));
    }

    public static boolean C(String str, Locale locale, String str2, String str3, boolean z5) {
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.e.e(lowerCase, str2);
        return m.x(lowerCase, str3, z5);
    }

    public static int a(k kVar, int i3, int i10, int i11) {
        kVar.getClass();
        kVar.f16839z = v7.h.c(1.8f);
        kVar.E = v7.h.c(4.0f);
        if (kVar.C == null) {
            kVar.C = new ArrayList();
        }
        kVar.C.clear();
        kVar.C.add(-1);
        return Color.rgb(i3, i10, i11);
    }

    public static AMapException b(JSONException jSONException, String str, String str2, String str3) {
        d6.a(jSONException, str, str2);
        return new AMapException(str3);
    }

    public static ClassCastException c(int i3, ArrayList arrayList) {
        arrayList.get(i3).getClass();
        return new ClassCastException();
    }

    public static ClassCastException d(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static Object e(BreatheSettingActivity breatheSettingActivity, int i3) {
        return breatheSettingActivity.S0().getBreatheTime().get(i3);
    }

    public static Object f(QueryBuilder queryBuilder, Property[] propertyArr, int i3) {
        return queryBuilder.orderDesc(propertyArr).limit(i3).build().unique();
    }

    public static String g(int i3, String str, int i10, String str2, String str3) {
        return str + i3 + str2 + i10 + str3;
    }

    public static String h(long j4, String str, String str2) {
        return j4 + str + str2;
    }

    public static String i(d0 d0Var, String str, int i3) {
        d0Var.getClass();
        return str + i3;
    }

    public static String j(File file, String str) {
        return file + str;
    }

    public static String k(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String l(String str, String str2) {
        return str + str2;
    }

    public static String m(StringBuilder sb2, int i3, char c9) {
        sb2.append(i3);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String n(StringBuilder sb2, long j4, String str) {
        sb2.append(j4);
        sb2.append(str);
        return sb2.toString();
    }

    public static String o(StringBuilder sb2, boolean z5, char c9) {
        sb2.append(z5);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String p(Throwable th2, StringBuilder sb2) {
        sb2.append(th2.getMessage());
        return sb2.toString();
    }

    public static StringBuilder q(int i3, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i3);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder r(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static ArrayList s(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str4);
        arrayList.add(str5);
        return arrayList;
    }

    public static ArrayList t(String str, List list) {
        kotlin.jvm.internal.e.f(list, str);
        return new ArrayList();
    }

    public static Calendar u(int i3, int i10, int i11, int i12) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i10);
        calendar.set(i11, i12);
        return calendar;
    }

    public static Date v(Calendar calendar, Date date, int i3, int i10, String str) {
        calendar.setTime(date);
        calendar.set(i10, calendar.getActualMinimum(i3));
        Date time = calendar.getTime();
        kotlin.jvm.internal.e.e(time, str);
        return time;
    }

    public static List w(QueryBuilder queryBuilder, Property[] propertyArr) {
        return queryBuilder.orderAsc(propertyArr).build().list();
    }

    public static p4.a x(i iVar, int i3) {
        return iVar.a(p4.e.t(new g4.i())).e(i3);
    }

    public static s5.a y(String str, String str2) {
        kotlin.jvm.internal.e.e(str, str2);
        return com.example.test.service.e.h().g();
    }

    public static void z(StringBuilder sb2, String str, String str2, String str3, String str4) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
    }
}
