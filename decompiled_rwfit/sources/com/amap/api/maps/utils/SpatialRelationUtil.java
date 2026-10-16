package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f2, double d5) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i3), latLng);
                        }
                        i3++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f2);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (AMapUtils.calculateLineDistance(new LatLng(dPoint.f6570x, dPoint.f6571y), latLng) < d5) {
                            Object obj = calShortestDistancePoint.first;
                            Object obj2 = calShortestDistancePoint.second;
                            return new Pair<>(obj, new LatLng(((DPoint) obj2).f6570x, ((DPoint) obj2).f6571y));
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f2) {
        if (f2 == -1.0f) {
            return true;
        }
        if (dPoint != null && dPoint2 != null) {
            int i3 = v4.f5181b;
            double d5 = dPoint.f6570x;
            double d8 = dPoint2.f6570x;
            float abs = Math.abs((((float) ((Math.atan2(dPoint2.f6571y - dPoint.f6571y, d8 - d5) / 3.141592653589793d) * 180.0d)) + 360.0f) - f2) % 360.0f;
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            if (abs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d5, double d8, double d10, double d11, double d12, double d13) {
        double d14 = d12 - d10;
        double d15 = d5 - d10;
        double d16 = d13 - d11;
        double d17 = d8 - d11;
        double d18 = (d16 * d17) + (d14 * d15);
        if (d18 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d17 * d17) + (d15 * d15))), new DPoint(d10, d11));
        }
        double d19 = (d16 * d16) + (d14 * d14);
        if (d18 >= d19) {
            double d20 = d5 - d12;
            double d21 = d8 - d13;
            return new Pair<>(Double.valueOf(Math.sqrt((d21 * d21) + (d20 * d20))), new DPoint(d12, d13));
        }
        double d22 = d18 / d19;
        double d23 = (d14 * d22) + d10;
        double d24 = (d16 * d22) + d11;
        double d25 = d5 - d23;
        double d26 = d24 - d8;
        return new Pair<>(Double.valueOf(Math.sqrt((d26 * d26) + (d25 * d25))), new DPoint(d23, d24));
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i3), latLng);
                        }
                        i3++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        Object obj = calShortestDistancePoint.first;
                        Object obj2 = calShortestDistancePoint.second;
                        return new Pair<>(obj, new LatLng(((DPoint) obj2).f6570x, ((DPoint) obj2).f6571y));
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f2) {
        double d5;
        int i3;
        double doubleValue;
        Pair<Integer, DPoint> pair;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair2 = null;
        if (list2 != null && dPoint2 != null && list2.size() != 0) {
            if (list2.size() >= 2) {
                DPoint dPoint3 = list2.get(0);
                int size = list2.size();
                int i10 = 1;
                double d8 = 0.0d;
                int i11 = 1;
                while (true) {
                    int i12 = size - 1;
                    if (i11 > i12) {
                        break;
                    }
                    DPoint dPoint4 = list2.get(i11);
                    if (i11 == i12 && dPoint4.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i11), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f2)) {
                        d5 = d8;
                        i3 = i11;
                    } else {
                        if (dPoint3.equals(dPoint2)) {
                            return new Pair<>(Integer.valueOf(i11 - i10), dPoint2);
                        }
                        d5 = d8;
                        i3 = i11;
                        Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.f6570x, dPoint2.f6571y, dPoint3.f6570x, dPoint3.f6571y, dPoint4.f6570x, dPoint4.f6571y);
                        if (pair2 == null) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i3 - 1), pointToSegDist.second);
                        } else if (d5 > ((Double) pointToSegDist.first).doubleValue()) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i3 - 1), pointToSegDist.second);
                        }
                        d8 = doubleValue;
                        pair2 = pair;
                        i11 = i3 + 1;
                        list2 = list;
                        dPoint2 = dPoint;
                        dPoint3 = dPoint4;
                        i10 = 1;
                    }
                    d8 = d5;
                    i11 = i3 + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    i10 = 1;
                }
            } else {
                return null;
            }
        }
        return pair2;
    }
}
