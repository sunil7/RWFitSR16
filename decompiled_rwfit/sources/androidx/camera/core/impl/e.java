package androidx.camera.core.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.test.R$mipmap;
import com.example.test.ui.device.activity.CustomJLDialActivity;
import com.example.test.ui.model.dial.Element;
import com.example.test.ui.model.dial.PlacementSelectModel;
import com.google.android.gms.internal.mlkit_vision_barcode.e2;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.m6;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import com.jieli.bmp_convert.BmpConvert;
import com.jieli.bmp_convert.ConvertParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes.dex */
public final class e implements c8.b {

    /* renamed from: g, reason: collision with root package name */
    public static e f1375g;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1376a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1377b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1378c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1379d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f1380f;

    public /* synthetic */ e(int i3) {
        this.f1376a = i3;
    }

    public static e e() {
        int i3 = 2;
        if (f1375g == null) {
            e eVar = new e(i3);
            bi.a aVar = bi.a.e;
            bi.i iVar = bi.i.f3271d;
            bi.a aVar2 = bi.a.f3262c;
            bi.a aVar3 = bi.a.f3263d;
            bi.h hVar = bi.h.f3269b;
            bi.i iVar2 = bi.i.f3270c;
            eVar.f1378c = new bi.d(new bi.b[]{aVar, iVar, aVar2, aVar3, hVar, iVar2});
            eVar.f1379d = new bi.d(new bi.b[]{bi.n.f3275b, aVar, iVar, aVar2, aVar3, hVar, iVar2});
            bi.l lVar = bi.l.f3273b;
            bi.m mVar = bi.m.f3274b;
            eVar.e = new bi.d(new bi.b[]{lVar, mVar, iVar, hVar, iVar2});
            eVar.f1380f = new bi.d(new bi.b[]{lVar, bi.o.f3276b, mVar, iVar, iVar2});
            eVar.f1377b = new bi.d(new bi.b[]{mVar, iVar, iVar2});
            f1375g = eVar;
        }
        return f1375g;
    }

    public f a() {
        String str = ((g0) this.f1378c) == null ? " surface" : "";
        if (((List) this.f1379d) == null) {
            str = str.concat(" sharedSurfaces");
        }
        if (((Integer) this.e) == null) {
            str = android.support.v4.media.session.e.l(str, " mirrorMode");
        }
        if (((Integer) this.f1380f) == null) {
            str = android.support.v4.media.session.e.l(str, " surfaceGroupId");
        }
        if (((t.t) this.f1377b) == null) {
            str = android.support.v4.media.session.e.l(str, " dynamicRange");
        }
        if (str.isEmpty()) {
            return new f((g0) this.f1378c, (List) this.f1379d, ((Integer) this.e).intValue(), ((Integer) this.f1380f).intValue(), (t.t) this.f1377b);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public h b() {
        String str = ((Size) this.f1378c) == null ? " resolution" : "";
        if (((t.t) this.f1377b) == null) {
            str = str.concat(" dynamicRange");
        }
        if (((Range) this.f1379d) == null) {
            str = android.support.v4.media.session.e.l(str, " expectedFrameRateRange");
        }
        if (((Boolean) this.f1380f) == null) {
            str = android.support.v4.media.session.e.l(str, " zslDisabled");
        }
        if (str.isEmpty()) {
            return new h((Size) this.f1378c, (t.t) this.f1377b, (Range) this.f1379d, (m.b) this.e, ((Boolean) this.f1380f).booleanValue());
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public void c(v vVar, v vVar2, c0.n nVar, c0.n nVar2, Map.Entry entry) {
        c0.n nVar3 = (c0.n) entry.getValue();
        t.i iVar = new t.i(nVar.f3334g.f1405a, ((d0.a) entry.getKey()).f12176a.f12414d, nVar.f3331c ? vVar : null, ((d0.a) entry.getKey()).f12176a.f12415f, ((d0.a) entry.getKey()).f12176a.f12416g);
        t.i iVar2 = new t.i(nVar2.f3334g.f1405a, ((d0.a) entry.getKey()).f12177b.f12414d, nVar2.f3331c ? vVar2 : null, ((d0.a) entry.getKey()).f12177b.f12415f, ((d0.a) entry.getKey()).f12177b.f12416g);
        e0.b bVar = ((d0.a) entry.getKey()).f12176a;
        nVar3.getClass();
        y5.a();
        nVar3.a();
        pd.f("Consumer can only be linked once.", !nVar3.f3337j);
        nVar3.f3337j = true;
        c0.m mVar = nVar3.f3339l;
        x.b f2 = x.i.f(mVar.c(), new c0.l(nVar3, mVar, bVar.f12413c, iVar, iVar2), a6.d());
        f2.a(new x.h(0, f2, new com.example.test.utils.y(16, this, nVar3)), a6.d());
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.ViewGroup, ra.e] */
    public void d(Canvas canvas) {
        Canvas canvas2;
        ra.d dVar = (ra.d) this.f1380f;
        boolean z5 = dVar == null || dVar.f18108c == Float.MAX_VALUE;
        Paint paint = (Paint) this.e;
        ?? r12 = (ViewGroup) this.f1378c;
        View view = (View) this.f1379d;
        if (z5) {
            r12.d(canvas);
            if (Color.alpha(paint.getColor()) != 0) {
                float width = view.getWidth();
                float height = view.getHeight();
                canvas2 = canvas;
                canvas2.drawRect(0.0f, 0.0f, width, height, paint);
            }
            canvas2 = canvas;
        } else {
            r12.d(canvas);
            if (Color.alpha(paint.getColor()) != 0) {
                float width2 = view.getWidth();
                float height2 = view.getHeight();
                canvas2 = canvas;
                canvas2.drawRect(0.0f, 0.0f, width2, height2, paint);
            }
            canvas2 = canvas;
        }
        Drawable drawable = (Drawable) this.f1377b;
        if (drawable == null || ((ra.d) this.f1380f) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        float width3 = ((ra.d) this.f1380f).f18106a - (bounds.width() / 2.0f);
        float height3 = ((ra.d) this.f1380f).f18107b - (bounds.height() / 2.0f);
        canvas2.translate(width3, height3);
        ((Drawable) this.f1377b).draw(canvas2);
        canvas2.translate(-width3, -height3);
    }

    public bi.f f(Object obj) {
        bi.f fVar = (bi.f) ((bi.d) this.f1378c).b(obj == null ? null : obj.getClass());
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("No instant converter found for type: ".concat(obj == null ? "null" : obj.getClass().getName()));
    }

    public bi.j g(Object obj) {
        bi.j jVar = (bi.j) ((bi.d) this.f1379d).b(obj == null ? null : obj.getClass());
        if (jVar != null) {
            return jVar;
        }
        throw new IllegalArgumentException("No partial converter found for type: ".concat(obj == null ? "null" : obj.getClass().getName()));
    }

    @Override // dh.a
    public Object get() {
        return new e8.b((Executor) ((dh.a) this.f1378c).get(), (b8.f) ((dh.a) this.f1379d).get(), (f8.d) ((de.o) this.e).get(), (g8.c) ((dh.a) this.f1380f).get(), (h8.b) ((dh.a) this.f1377b).get());
    }

    public ra.d h() {
        ra.d dVar = (ra.d) this.f1380f;
        if (dVar == null) {
            return null;
        }
        ra.d dVar2 = new ra.d(dVar);
        if (dVar2.f18108c == Float.MAX_VALUE) {
            float f2 = dVar2.f18106a;
            float f10 = dVar2.f18107b;
            View view = (View) this.f1379d;
            dVar2.f18108c = m6.a(f2, f10, view.getWidth(), view.getHeight());
        }
        return dVar2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, ra.e] */
    public boolean i() {
        if (((ViewGroup) this.f1378c).h()) {
            ra.d dVar = (ra.d) this.f1380f;
            if (dVar == null || dVar.f18108c == Float.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    public void j(HashMap dataMap) {
        int i3;
        switch (this.f1376a) {
            case 4:
                kotlin.jvm.internal.e.f(dataMap, "dataMap");
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                int i10 = com.example.test.utils.g.f8727a;
                CustomJLDialActivity customJLDialActivity = (CustomJLDialActivity) this.f1378c;
                String str = (String) this.f1379d;
                String str2 = (String) this.e;
                de.i iVar = new de.i((ef.i) this.f1380f, ref$ObjectRef, customJLDialActivity, str, ref$ObjectRef2, dataMap, (String) this.f1377b, 1);
                Element element = new Element();
                element.setImageCount((byte) 1);
                element.setDataList(new ArrayList());
                PlacementSelectModel placementSelectModel = new PlacementSelectModel();
                placementSelectModel.setColor(str2);
                if (str == null || str.length() == 0) {
                    int i11 = R$mipmap.background;
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    DialInfoBean n4 = kVar != null ? kVar.n() : null;
                    kotlin.jvm.internal.e.c(n4);
                    if (n4.getWidth() == 240 && n4.getHeight() == 296) {
                        i11 = R$mipmap.dial_background296;
                    } else if (n4.getWidth() == 240 && n4.getHeight() == 320) {
                        i11 = R$mipmap.dial_background320;
                    }
                    placementSelectModel.setBackgroundResId(i11);
                } else {
                    placementSelectModel.setBackgroundUrl(str);
                }
                Element element2 = (Element) dataMap.get(9);
                if (element2 != null) {
                    placementSelectModel.setHourX(element2.getX());
                    placementSelectModel.setHourY(element2.getY());
                    placementSelectModel.setHourData(element2.getRawData());
                }
                Element element3 = (Element) dataMap.get(10);
                if (element3 != null) {
                    placementSelectModel.setMinuteX(element3.getX());
                    placementSelectModel.setMinuteY(element3.getY());
                    placementSelectModel.setMinuteData(element3.getRawData());
                }
                Element element4 = (Element) dataMap.get(13);
                if (element4 != null) {
                    placementSelectModel.setWeekX(element4.getX());
                    placementSelectModel.setWeekY(element4.getY());
                    placementSelectModel.setWeekData(element4.getRawData());
                }
                Element element5 = (Element) dataMap.get(8);
                if (element5 != null) {
                    placementSelectModel.setDayX(element5.getX());
                    placementSelectModel.setDayY(element5.getY());
                    placementSelectModel.setDayData(element5.getRawData());
                }
                Element element6 = (Element) dataMap.get(24);
                if (element6 != null) {
                    placementSelectModel.setDateSeparatorX(element6.getX());
                    placementSelectModel.setDateSeparatorY(element6.getY());
                    placementSelectModel.setDateSeparatorData(element6.getRawData());
                }
                Element element7 = (Element) dataMap.get(7);
                if (element7 != null) {
                    placementSelectModel.setMonthX(element7.getX());
                    placementSelectModel.setMonthY(element7.getY());
                    placementSelectModel.setMonthData(element7.getRawData());
                }
                Element element8 = (Element) dataMap.get(23);
                if (element8 != null) {
                    placementSelectModel.setTimeSeparatorX(element8.getX());
                    placementSelectModel.setTimeSeparatorY(element8.getY());
                    placementSelectModel.setTimeSeparatorData(element8.getRawData());
                }
                Bitmap a3 = e2.a(customJLDialActivity, placementSelectModel);
                if (a3 != null) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    DialInfoBean n8 = kVar2 != null ? kVar2.n() : null;
                    kotlin.jvm.internal.e.c(n8);
                    int i12 = 148;
                    if (n8.getHeight() == 296) {
                        i3 = 183;
                    } else if (n8.getHeight() == 320) {
                        i3 = 197;
                    } else {
                        i12 = 164;
                        i3 = 191;
                    }
                    Bitmap c9 = e2.c(a3, i12, i3);
                    element.setWidth(c9.getWidth());
                    element.setHeight(c9.getHeight());
                    File file = new File(android.support.v4.media.session.e.j(customJLDialActivity.getFilesDir(), "/dial"));
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    String l3 = android.support.v4.media.session.e.l(file.getAbsolutePath(), "/previewout.res");
                    String l5 = android.support.v4.media.session.e.l(file.getAbsolutePath(), "/previewin.png");
                    Log.e("qob", "inPath " + l5 + " outPath " + l3);
                    e2.d(c9, l5);
                    BmpConvert bmpConvert = new BmpConvert();
                    bmpConvert.bitmapConvert(3, l5, l3, new ConvertParam().setFormat(0), new com.example.test.utils.e(element, iVar));
                    bmpConvert.release();
                    a3.recycle();
                    c9.recycle();
                    return;
                }
                return;
            default:
                kotlin.jvm.internal.e.f(dataMap, "dataMap");
                Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                int i13 = com.example.test.utils.g.f8727a;
                CustomJLDialActivity customJLDialActivity2 = (CustomJLDialActivity) this.f1378c;
                String str3 = (String) this.f1379d;
                String str4 = (String) this.e;
                de.i iVar2 = new de.i((com.example.test.utils.y) this.f1380f, ref$ObjectRef3, customJLDialActivity2, str3, ref$ObjectRef4, dataMap, (String) this.f1377b, 2);
                Element element9 = new Element();
                element9.setImageCount((byte) 1);
                element9.setDataList(new ArrayList());
                PlacementSelectModel placementSelectModel2 = new PlacementSelectModel();
                placementSelectModel2.setColor(str4);
                if (str3 == null || str3.length() == 0) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                    DialInfoBean n10 = kVar3 != null ? kVar3.n() : null;
                    kotlin.jvm.internal.e.c(n10);
                    placementSelectModel2.setBackgroundResId(n10.getWidth() == 360 ? R$mipmap.dial_background_300 : n10.getWidth() == 416 ? R$mipmap.background_416 : R$mipmap.background_466);
                } else {
                    placementSelectModel2.setBackgroundUrl(str3);
                }
                Element element10 = (Element) dataMap.get(9);
                if (element10 != null) {
                    placementSelectModel2.setHourX(element10.getX());
                    placementSelectModel2.setHourY(element10.getY());
                    placementSelectModel2.setHourData(element10.getRawData());
                }
                Element element11 = (Element) dataMap.get(10);
                if (element11 != null) {
                    placementSelectModel2.setMinuteX(element11.getX());
                    placementSelectModel2.setMinuteY(element11.getY());
                    placementSelectModel2.setMinuteData(element11.getRawData());
                }
                Element element12 = (Element) dataMap.get(13);
                if (element12 != null) {
                    placementSelectModel2.setWeekX(element12.getX());
                    placementSelectModel2.setWeekY(element12.getY());
                    placementSelectModel2.setWeekData(element12.getRawData());
                }
                Element element13 = (Element) dataMap.get(8);
                if (element13 != null) {
                    placementSelectModel2.setDayX(element13.getX());
                    placementSelectModel2.setDayY(element13.getY());
                    placementSelectModel2.setDayData(element13.getRawData());
                }
                Element element14 = (Element) dataMap.get(24);
                if (element14 != null) {
                    placementSelectModel2.setDateSeparatorX(element14.getX());
                    placementSelectModel2.setDateSeparatorY(element14.getY());
                    placementSelectModel2.setDateSeparatorData(element14.getRawData());
                }
                Element element15 = (Element) dataMap.get(7);
                if (element15 != null) {
                    placementSelectModel2.setMonthX(element15.getX());
                    placementSelectModel2.setMonthY(element15.getY());
                    placementSelectModel2.setMonthData(element15.getRawData());
                }
                Element element16 = (Element) dataMap.get(23);
                if (element16 != null) {
                    placementSelectModel2.setTimeSeparatorX(element16.getX());
                    placementSelectModel2.setTimeSeparatorY(element16.getY());
                    placementSelectModel2.setTimeSeparatorData(element16.getRawData());
                }
                placementSelectModel2.setDialType(1);
                Bitmap a10 = e2.a(customJLDialActivity2, placementSelectModel2);
                if (a10 != null) {
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
                    kotlin.jvm.internal.e.c(kVar4 != null ? kVar4.n() : null);
                    Bitmap c10 = e2.c(a10, (int) (r18.getWidth() * 0.56d), (int) (r18.getWidth() * 0.56d));
                    element9.setWidth(c10.getWidth());
                    element9.setHeight(c10.getHeight());
                    File file2 = new File(android.support.v4.media.session.e.j(customJLDialActivity2.getFilesDir(), "/dial"));
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String l8 = android.support.v4.media.session.e.l(file2.getAbsolutePath(), "/previewout.res");
                    String l9 = android.support.v4.media.session.e.l(file2.getAbsolutePath(), "/previewin.png");
                    Log.e("qob", "inPath " + l9 + " outPath " + l8);
                    e2.d(c10, l9);
                    BmpConvert bmpConvert2 = new BmpConvert();
                    bmpConvert2.bitmapConvert(3, l9, l8, new ConvertParam().setFormat(0), new com.example.test.utils.f(element9, iVar2));
                    bmpConvert2.release();
                    a10.recycle();
                    c10.recycle();
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(boolean z5, Element element) {
        switch (this.f1376a) {
            case 3:
                if (z5) {
                    Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.f1379d;
                    ref$ObjectRef.element = element;
                    element.setType(2);
                    Element element2 = (Element) ref$ObjectRef.element;
                    Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) this.e;
                    element2.setOffset((((Element) ref$ObjectRef2.element).getImageCount() * ((Element) ref$ObjectRef2.element).getSize()) + ((Element) ref$ObjectRef2.element).getOffset());
                    ((Element) ref$ObjectRef.element).setIndex(1);
                    ((Element) ref$ObjectRef.element).setHasAlpha(0);
                    ((Element) ref$ObjectRef.element).setCompression(2);
                    int i3 = com.example.test.utils.g.f8727a;
                    com.example.test.utils.g.a((Element) ref$ObjectRef2.element, (Element) ref$ObjectRef.element, (HashMap) this.f1380f, (String) this.f1377b, (ef.i) this.f1378c);
                    break;
                }
                break;
            default:
                if (z5) {
                    Ref$ObjectRef ref$ObjectRef3 = (Ref$ObjectRef) this.f1379d;
                    ref$ObjectRef3.element = element;
                    element.setType(2);
                    Element element3 = (Element) ref$ObjectRef3.element;
                    Ref$ObjectRef ref$ObjectRef4 = (Ref$ObjectRef) this.e;
                    element3.setOffset((((Element) ref$ObjectRef4.element).getImageCount() * ((Element) ref$ObjectRef4.element).getSize()) + ((Element) ref$ObjectRef4.element).getOffset());
                    ((Element) ref$ObjectRef3.element).setIndex(1);
                    ((Element) ref$ObjectRef3.element).setHasAlpha(0);
                    ((Element) ref$ObjectRef3.element).setCompression(2);
                    int i10 = com.example.test.utils.g.f8727a;
                    com.example.test.utils.g.a((Element) ref$ObjectRef4.element, (Element) ref$ObjectRef3.element, (HashMap) this.f1380f, (String) this.f1377b, (com.example.test.utils.y) this.f1378c);
                    break;
                }
                break;
        }
    }

    public void l(Drawable drawable) {
        this.f1377b = drawable;
        ((View) this.f1379d).invalidate();
    }

    public void m(int i3) {
        ((Paint) this.e).setColor(i3);
        ((View) this.f1379d).invalidate();
    }

    public void n(ra.d dVar) {
        View view = (View) this.f1379d;
        if (dVar == null) {
            this.f1380f = null;
        } else {
            ra.d dVar2 = (ra.d) this.f1380f;
            if (dVar2 == null) {
                this.f1380f = new ra.d(dVar);
            } else {
                float f2 = dVar.f18106a;
                float f10 = dVar.f18107b;
                float f11 = dVar.f18108c;
                dVar2.f18106a = f2;
                dVar2.f18107b = f10;
                dVar2.f18108c = f11;
            }
            if (dVar.f18108c + 1.0E-4f >= m6.a(dVar.f18106a, dVar.f18107b, view.getWidth(), view.getHeight())) {
                ((ra.d) this.f1380f).f18108c = Float.MAX_VALUE;
            }
        }
        view.invalidate();
    }

    public String toString() {
        switch (this.f1376a) {
            case 2:
                StringBuilder sb2 = new StringBuilder("ConverterManager[");
                sb2.append(((bi.d) this.f1378c).f3267a.length);
                sb2.append(" instant,");
                sb2.append(((bi.d) this.f1379d).f3267a.length);
                sb2.append(" partial,");
                sb2.append(((bi.d) this.e).f3267a.length);
                sb2.append(" duration,");
                sb2.append(((bi.d) this.f1380f).f3267a.length);
                sb2.append(" period,");
                return r5.a.e(sb2, ((bi.d) this.f1377b).f3267a.length, " interval]");
            case 9:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("FontRequest {mProviderAuthority: " + ((String) this.f1378c) + ", mProviderPackage: " + ((String) this.e) + ", mQuery: " + ((String) this.f1380f) + ", mCertificates:");
                int i3 = 0;
                while (true) {
                    List list = (List) this.f1379d;
                    if (i3 >= list.size()) {
                        sb3.append("}mCertificatesArray: 0");
                        return sb3.toString();
                    }
                    sb3.append(" [");
                    List list2 = (List) list.get(i3);
                    for (int i10 = 0; i10 < list2.size(); i10++) {
                        sb3.append(" \"");
                        sb3.append(Base64.encodeToString((byte[]) list2.get(i10), 0));
                        sb3.append("\"");
                    }
                    sb3.append(" ]");
                    i3++;
                }
            default:
                return super.toString();
        }
    }

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i3) {
        this.f1376a = i3;
        this.f1378c = obj;
        this.f1379d = obj2;
        this.e = obj3;
        this.f1380f = obj4;
        this.f1377b = obj5;
    }

    public e(MotionLayout motionLayout) {
        this.f1376a = 11;
        this.f1379d = new ArrayList();
        this.f1377b = new ArrayList();
        this.f1378c = motionLayout;
    }

    public e(String str, String str2, String str3, List list) {
        this.f1376a = 9;
        str.getClass();
        this.f1378c = str;
        str2.getClass();
        this.e = str2;
        this.f1380f = str3;
        list.getClass();
        this.f1379d = list;
        this.f1377b = com.google.android.gms.internal.mlkit_vision_barcode.l0.q(str, "-", str2, "-", str3);
    }

    public e(v vVar, v vVar2, d0.e eVar) {
        this.f1376a = 7;
        this.f1379d = vVar;
        this.e = vVar2;
        this.f1378c = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(ra.e eVar) {
        this.f1376a = 10;
        this.f1378c = (ViewGroup) eVar;
        View view = (View) eVar;
        this.f1379d = view;
        view.setWillNotDraw(false);
        new Path();
        new Paint(7);
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setColor(0);
    }
}
