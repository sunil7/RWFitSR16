package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Path;
import android.graphics.PointF;
import com.example.test.ui.model.chart.chart.LineEntry;
import com.example.test.ui.model.chart.chart.SleepItemData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class fc {
    public static ArrayList a(float f2, kotlin.collections.r rVar, float f10, float f11) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = rVar.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float y4 = ((LineEntry) next).getY();
                do {
                    Object next2 = it.next();
                    float y10 = ((LineEntry) next2).getY();
                    if (Float.compare(y4, y10) < 0) {
                        next = next2;
                        y4 = y10;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        LineEntry lineEntry = (LineEntry) next;
        float f12 = f11 - 10;
        if (lineEntry != null) {
            f12 = lineEntry.getY() - f2;
        }
        float size = f10 / (rVar.f15640a.size() - 1);
        int i3 = 0;
        for (Object obj : rVar) {
            int i10 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            PointF pointF = new PointF();
            pointF.x = i3 * size;
            pointF.y = f11 - (((((LineEntry) obj).getY() - f2) * f11) / f12);
            arrayList.add(pointF);
            i3 = i10;
        }
        return arrayList;
    }

    public static ArrayList b(kotlin.collections.r rVar, float f2, float f10, float f11) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = rVar.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float y4 = ((LineEntry) next).getY();
                do {
                    Object next2 = it.next();
                    float y10 = ((LineEntry) next2).getY();
                    if (Float.compare(y4, y10) < 0) {
                        next = next2;
                        y4 = y10;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        float f12 = f10 - 10;
        if (f11 <= 0.0f) {
            f11 = f12;
        }
        float f13 = f2 / 24;
        int i3 = 0;
        for (Object obj : rVar) {
            int i10 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            PointF pointF = new PointF();
            pointF.x = i3 * f13;
            pointF.y = (f10 - ((((LineEntry) obj).getY() * f10) / f11)) + 5;
            arrayList.add(pointF);
            i3 = i10;
        }
        return arrayList;
    }

    public static ArrayList c(List list, float f2, float f10) {
        float durationPercent;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        float f11 = 0.0f;
        while (it.hasNext()) {
            SleepItemData sleepItemData = (SleepItemData) it.next();
            x6.a aVar = new x6.a();
            aVar.f19813a = sleepItemData.getSleepType();
            aVar.f19815c = sleepItemData.getDuration();
            aVar.f19816d = sleepItemData.getStartTime();
            Path path = new Path();
            sleepItemData.getStartTime();
            sleepItemData.getDurationPercent();
            sleepItemData.getDurationPercent();
            aVar.e = f11;
            int i3 = aVar.f19813a;
            if (i3 != 0) {
                if (i3 == 1) {
                    float f12 = 3;
                    float f13 = f10 / f12;
                    path.moveTo(f11, f13);
                    float f14 = (2 * f10) / f12;
                    path.lineTo(f11, f14);
                    durationPercent = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                    path.lineTo(durationPercent, f14);
                    path.lineTo(durationPercent, f13);
                } else if (i3 != 2) {
                    path.moveTo(f11, 0.0f);
                    path.lineTo(f11, f10);
                    durationPercent = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                    path.lineTo(durationPercent, f10);
                    path.lineTo(durationPercent, 0.0f);
                } else {
                    path.moveTo(f11, 20.0f);
                    float f15 = f10 / 3;
                    path.lineTo(f11, f15);
                    float durationPercent2 = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                    path.lineTo(durationPercent2, f15);
                    path.lineTo(durationPercent2, 20.0f);
                    f11 = durationPercent2;
                }
                f11 = durationPercent;
            } else {
                float f16 = (2 * f10) / 3;
                path.moveTo(f11, f16);
                float f17 = f10 - 20.0f;
                path.lineTo(f11, f17);
                float durationPercent3 = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                path.lineTo(durationPercent3, f17);
                path.lineTo(durationPercent3, f16);
                f11 = durationPercent3;
            }
            aVar.f19817f = f11;
            sleepItemData.getDurationPercent();
            aVar.f19814b = path;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public static ArrayList d(List list, float f2, float f10) {
        float durationPercent;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        float f11 = 0.0f;
        while (it.hasNext()) {
            SleepItemData sleepItemData = (SleepItemData) it.next();
            x6.a aVar = new x6.a();
            aVar.f19813a = sleepItemData.getSleepType();
            Path path = new Path();
            int i3 = aVar.f19813a;
            if (i3 == 0) {
                path.moveTo(f11, 0.0f);
                path.lineTo(f11, f10);
                durationPercent = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                path.lineTo(durationPercent, f10);
                path.lineTo(durationPercent, 0.0f);
            } else if (i3 == 1) {
                path.moveTo(f11, 0.0f);
                path.lineTo(f11, f10);
                durationPercent = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                path.lineTo(durationPercent, f10);
                path.lineTo(durationPercent, 0.0f);
            } else if (i3 != 2) {
                path.moveTo(f11, 0.0f);
                path.lineTo(f11, f10);
                durationPercent = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                path.lineTo(durationPercent, f10);
                path.lineTo(durationPercent, 0.0f);
            } else {
                path.moveTo(f11, 0.0f);
                path.lineTo(f11, f10);
                durationPercent = (((float) sleepItemData.getDurationPercent()) * f2) + f11;
                path.lineTo(durationPercent, f10);
                path.lineTo(durationPercent, 0.0f);
            }
            f11 = durationPercent;
            aVar.f19814b = path;
            arrayList.add(aVar);
        }
        return arrayList;
    }
}
