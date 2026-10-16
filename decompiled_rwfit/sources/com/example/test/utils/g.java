package com.example.test.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import com.example.test.ui.device.activity.CustomJLDialActivity;
import com.example.test.ui.model.dial.Element;
import com.google.android.gms.internal.mlkit_vision_barcode.e2;
import com.google.android.gms.internal.mlkit_vision_barcode.le;
import com.jieli.bmp_convert.BmpConvert;
import com.jieli.bmp_convert.ConvertParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static androidx.camera.core.impl.e f8729c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap f8730d;

    /* renamed from: a, reason: collision with root package name */
    public static int f8727a = Color.parseColor("#ffffff");

    /* renamed from: b, reason: collision with root package name */
    public static final BmpConvert f8728b = new BmpConvert();
    public static final ArrayList e = new ArrayList();

    public static final void a(Element element, Element element2, HashMap hashMap, String str, b bVar) {
        int i3;
        int i10 = 1;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    byte[] e10 = e(51, 2);
                    fileOutputStream2.write(new byte[]{e10[1], e10[0], (byte) 9, 2});
                    ArrayList arrayList = new ArrayList(51);
                    element.setOffset(388);
                    arrayList.add(Integer.valueOf(element.getSize()));
                    g(fileOutputStream2, element);
                    element2.setOffset((element.getSize() * element.getImageCount()) + element.getOffset());
                    arrayList.add(Integer.valueOf(element2.getSize()));
                    g(fileOutputStream2, element2);
                    Element element3 = (Element) hashMap.get(9);
                    if (element3 != null) {
                        element3.setOffset((element2.getSize() * element2.getImageCount()) + element2.getOffset());
                        element3.setIndex(2);
                        element3.setHasAlpha(1);
                        element3.setCompression(2);
                        byte imageCount = element3.getImageCount();
                        for (int i11 = 0; i11 < imageCount; i11++) {
                            arrayList.add(Integer.valueOf(element3.getDataList().get(i11).getSize()));
                        }
                        g(fileOutputStream2, element3);
                    }
                    Element element4 = (Element) hashMap.get(10);
                    if (element4 != null) {
                        if (element3 != null) {
                            element4.setOffset(element3.getOffset() + element3.getSize());
                        }
                        element4.setIndex(12);
                        element4.setHasAlpha(1);
                        element4.setCompression(2);
                        byte imageCount2 = element4.getImageCount();
                        for (int i12 = 0; i12 < imageCount2; i12++) {
                            arrayList.add(Integer.valueOf(element4.getDataList().get(i12).getSize()));
                        }
                        g(fileOutputStream2, element4);
                    }
                    Element element5 = (Element) hashMap.get(13);
                    if (element5 != null) {
                        if (element4 != null) {
                            element5.setOffset(element4.getOffset() + element4.getSize());
                        }
                        element5.setIndex(22);
                        element5.setHasAlpha(1);
                        element5.setCompression(2);
                        byte imageCount3 = element5.getImageCount();
                        for (int i13 = 0; i13 < imageCount3; i13++) {
                            arrayList.add(Integer.valueOf(element5.getDataList().get(i13).getSize()));
                        }
                        g(fileOutputStream2, element5);
                    }
                    Element element6 = (Element) hashMap.get(8);
                    if (element6 != null) {
                        if (element5 != null) {
                            element6.setOffset(element5.getOffset() + element5.getSize());
                        }
                        element6.setIndex(29);
                        element6.setHasAlpha(1);
                        element6.setCompression(2);
                        byte imageCount4 = element6.getImageCount();
                        for (int i14 = 0; i14 < imageCount4; i14++) {
                            arrayList.add(Integer.valueOf(element6.getDataList().get(i14).getSize()));
                        }
                        g(fileOutputStream2, element6);
                    }
                    Element element7 = (Element) hashMap.get(24);
                    if (element7 != null) {
                        if (element6 != null) {
                            element7.setOffset(element6.getOffset() + element6.getSize());
                        }
                        try {
                            element7.setIndex(39);
                            element7.setHasAlpha(1);
                            element7.setCompression(2);
                            byte imageCount5 = element7.getImageCount();
                            int i15 = 0;
                            while (i15 < imageCount5) {
                                int i16 = i10;
                                arrayList.add(Integer.valueOf(element7.getDataList().get(i15).getSize()));
                                i15++;
                                i10 = i16;
                            }
                            i3 = i10;
                            g(fileOutputStream2, element7);
                        } catch (FileNotFoundException e11) {
                            e = e11;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            Log.i("CustomDialUtils", "自定义表盘生成失败，" + e.getMessage());
                            bVar.c("", false);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            bVar.c(str, true);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            bVar.c(str, true);
                            throw th;
                        }
                    } else {
                        i3 = 1;
                    }
                    Element element8 = (Element) hashMap.get(7);
                    if (element8 != null) {
                        if (element7 != null) {
                            element8.setOffset(element7.getOffset() + element7.getSize());
                        }
                        element8.setIndex(40);
                        element8.setHasAlpha(i3);
                        element8.setCompression(2);
                        byte imageCount6 = element8.getImageCount();
                        for (int i17 = 0; i17 < imageCount6; i17++) {
                            arrayList.add(Integer.valueOf(element8.getDataList().get(i17).getSize()));
                        }
                        g(fileOutputStream2, element8);
                    }
                    Element element9 = (Element) hashMap.get(23);
                    if (element9 != null) {
                        if (element8 != null) {
                            element9.setOffset(element8.getOffset() + element8.getSize());
                        }
                        element9.setIndex(50);
                        element9.setHasAlpha(1);
                        element9.setCompression(2);
                        byte imageCount7 = element9.getImageCount();
                        for (int i18 = 0; i18 < imageCount7; i18++) {
                            arrayList.add(Integer.valueOf(element9.getDataList().get(i18).getSize()));
                        }
                        g(fileOutputStream2, element9);
                    }
                    h(fileOutputStream2, arrayList);
                    fileOutputStream2.write(element.getDataList().get(0).getData());
                    fileOutputStream2.write(element2.getDataList().get(0).getData());
                    if (element3 != null) {
                        byte imageCount8 = element3.getImageCount();
                        for (int i19 = 0; i19 < imageCount8; i19++) {
                            fileOutputStream2.write(element3.getDataList().get(i19).getData());
                        }
                    }
                    if (element4 != null) {
                        byte imageCount9 = element4.getImageCount();
                        for (int i20 = 0; i20 < imageCount9; i20++) {
                            fileOutputStream2.write(element4.getDataList().get(i20).getData());
                        }
                    }
                    if (element5 != null) {
                        byte imageCount10 = element5.getImageCount();
                        for (int i21 = 0; i21 < imageCount10; i21++) {
                            fileOutputStream2.write(element5.getDataList().get(i21).getData());
                        }
                    }
                    if (element6 != null) {
                        byte imageCount11 = element6.getImageCount();
                        for (int i22 = 0; i22 < imageCount11; i22++) {
                            fileOutputStream2.write(element6.getDataList().get(i22).getData());
                        }
                    }
                    if (element7 != null) {
                        fileOutputStream2.write(element7.getDataList().get(0).getData());
                    }
                    if (element8 != null) {
                        byte imageCount12 = element8.getImageCount();
                        for (int i23 = 0; i23 < imageCount12; i23++) {
                            fileOutputStream2.write(element8.getDataList().get(i23).getData());
                        }
                    }
                    if (element9 != null) {
                        fileOutputStream2.write(element9.getDataList().get(0).getData());
                    }
                    Log.i("CustomDialUtils", "自定义表盘生成完成，" + str);
                    fileOutputStream2.close();
                    bVar.c(str, true);
                } catch (FileNotFoundException e12) {
                    e = e12;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e13) {
                e = e13;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void b(int i3, ArrayList arrayList) {
        int length;
        List<Element.ImageData> dataList;
        int length2;
        List<Element.ImageData> dataList2;
        List<Element.ImageData> dataList3;
        List<Element.ImageData> dataList4;
        List<Element.ImageData> dataList5;
        List<Element.ImageData> dataList6;
        List<Element.ImageData> dataList7;
        List<Element.ImageData> dataList8;
        List<Element.ImageData> dataList9;
        List<Element.ImageData> dataList10;
        List<Element.ImageData> dataList11;
        List<Element.ImageData> dataList12;
        List<Element.ImageData> dataList13;
        List<Element.ImageData> dataList14;
        if (i3 < arrayList.size()) {
            Pair pair = (Pair) arrayList.get(i3);
            f8728b.bitmapConvert(4, (String) pair.getFirst(), (String) pair.getSecond(), new ConvertParam().setFormat(0), new o2.m((byte) 0, i3, 4));
            return;
        }
        r5.a.h(arrayList.size(), "convertBmpConvert 处理完成 ", "qob");
        if (i3 == 999) {
            androidx.camera.core.impl.e eVar = f8729c;
            if (eVar == null) {
                kotlin.jvm.internal.e.m("mSmallListener");
                throw null;
            }
            HashMap hashMap = f8730d;
            if (hashMap != null) {
                eVar.j(hashMap);
                return;
            } else {
                kotlin.jvm.internal.e.m("mSmallDataMap");
                throw null;
            }
        }
        HashMap hashMap2 = f8730d;
        if (hashMap2 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        Element element = (Element) hashMap2.get(9);
        HashMap hashMap3 = f8730d;
        if (hashMap3 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        Element element2 = (Element) hashMap3.get(10);
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            byte[] a3 = le.a(new File((String) ((Pair) arrayList.get(i11)).getSecond()));
            int length3 = a3.length;
            int i12 = (4 - (length3 % 4)) % 4;
            if (i12 > 0) {
                int i13 = i12 + length3;
                byte[] bArr = new byte[i13];
                System.arraycopy(a3, 0, bArr, 0, length3);
                i10 += i13;
                Element.ImageData imageData = new Element.ImageData(bArr, i13);
                if (element != null && (dataList14 = element.getDataList()) != null) {
                    dataList14.add(imageData);
                }
                if (element2 != null && (dataList13 = element2.getDataList()) != null) {
                    dataList13.add(imageData);
                }
            } else {
                i10 += a3.length;
                Element.ImageData imageData2 = new Element.ImageData(a3, a3.length);
                if (element != null && (dataList12 = element.getDataList()) != null) {
                    dataList12.add(imageData2);
                }
                if (element2 != null && (dataList11 = element2.getDataList()) != null) {
                    dataList11.add(imageData2);
                }
            }
        }
        if (element != null) {
            element.setSize(i10);
        }
        if (element2 != null) {
            element2.setSize(i10);
        }
        HashMap hashMap4 = f8730d;
        if (hashMap4 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        Element element3 = (Element) hashMap4.get(23);
        byte[] a10 = le.a(new File((String) ((Pair) arrayList.get(10)).getSecond()));
        int length4 = a10.length;
        int i14 = (4 - (length4 % 4)) % 4;
        if (i14 > 0) {
            length = i14 + length4;
            byte[] bArr2 = new byte[length];
            System.arraycopy(a10, 0, bArr2, 0, length4);
            Element.ImageData imageData3 = new Element.ImageData(bArr2, length);
            if (element3 != null && (dataList10 = element3.getDataList()) != null) {
                dataList10.add(imageData3);
            }
        } else {
            length = a10.length;
            Element.ImageData imageData4 = new Element.ImageData(a10, a10.length);
            if (element3 != null && (dataList = element3.getDataList()) != null) {
                dataList.add(imageData4);
            }
        }
        kotlin.jvm.internal.e.c(element3);
        element3.setSize(length);
        HashMap hashMap5 = f8730d;
        if (hashMap5 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        Element element4 = (Element) hashMap5.get(8);
        HashMap hashMap6 = f8730d;
        if (hashMap6 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        Element element5 = (Element) hashMap6.get(7);
        int i15 = 0;
        for (int i16 = 11; i16 < 21; i16++) {
            byte[] a11 = le.a(new File((String) ((Pair) arrayList.get(i16)).getSecond()));
            int length5 = a11.length;
            int i17 = (4 - (length5 % 4)) % 4;
            if (i17 > 0) {
                int i18 = i17 + length5;
                byte[] bArr3 = new byte[i18];
                System.arraycopy(a11, 0, bArr3, 0, length5);
                i15 += i18;
                Element.ImageData imageData5 = new Element.ImageData(bArr3, i18);
                if (element4 != null && (dataList9 = element4.getDataList()) != null) {
                    dataList9.add(imageData5);
                }
                if (element5 != null && (dataList8 = element5.getDataList()) != null) {
                    dataList8.add(imageData5);
                }
            } else {
                i15 += a11.length;
                Element.ImageData imageData6 = new Element.ImageData(a11, a11.length);
                if (element4 != null && (dataList7 = element4.getDataList()) != null) {
                    dataList7.add(imageData6);
                }
                if (element5 != null && (dataList6 = element5.getDataList()) != null) {
                    dataList6.add(imageData6);
                }
            }
        }
        if (element4 != null) {
            element4.setSize(i15);
        }
        if (element5 != null) {
            element5.setSize(i15);
        }
        HashMap hashMap7 = f8730d;
        if (hashMap7 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        Element element6 = (Element) hashMap7.get(24);
        byte[] a12 = le.a(new File((String) ((Pair) arrayList.get(21)).getSecond()));
        int length6 = a12.length;
        int i19 = (4 - (length6 % 4)) % 4;
        if (i19 > 0) {
            length2 = i19 + length6;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(a12, 0, bArr4, 0, length6);
            Element.ImageData imageData7 = new Element.ImageData(bArr4, length2);
            if (element6 != null && (dataList5 = element6.getDataList()) != null) {
                dataList5.add(imageData7);
            }
        } else {
            length2 = a12.length;
            Element.ImageData imageData8 = new Element.ImageData(a12, a12.length);
            if (element6 != null && (dataList2 = element6.getDataList()) != null) {
                dataList2.add(imageData8);
            }
        }
        kotlin.jvm.internal.e.c(element6);
        element6.setSize(length2);
        HashMap hashMap8 = f8730d;
        if (hashMap8 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        Element element7 = (Element) hashMap8.get(13);
        int i20 = 0;
        for (int i21 = 22; i21 < 29; i21++) {
            byte[] a13 = le.a(new File((String) ((Pair) arrayList.get(i21)).getSecond()));
            int length7 = a13.length;
            int i22 = (4 - (length7 % 4)) % 4;
            if (i22 > 0) {
                int i23 = i22 + length7;
                byte[] bArr5 = new byte[i23];
                System.arraycopy(a13, 0, bArr5, 0, length7);
                i20 += i23;
                Element.ImageData imageData9 = new Element.ImageData(bArr5, i23);
                if (element7 != null && (dataList4 = element7.getDataList()) != null) {
                    dataList4.add(imageData9);
                }
            } else {
                i20 += a13.length;
                Element.ImageData imageData10 = new Element.ImageData(a13, a13.length);
                if (element7 != null && (dataList3 = element7.getDataList()) != null) {
                    dataList3.add(imageData10);
                }
            }
        }
        if (element7 != null) {
            element7.setSize(i20);
        }
        androidx.camera.core.impl.e eVar2 = f8729c;
        if (eVar2 == null) {
            kotlin.jvm.internal.e.m("mSmallListener");
            throw null;
        }
        HashMap hashMap9 = f8730d;
        if (hashMap9 == null) {
            kotlin.jvm.internal.e.m("mSmallDataMap");
            throw null;
        }
        eVar2.j(hashMap9);
    }

    public static long c(byte[] bArr) {
        return (bArr[0] & 255) | ((((((bArr[3] & 255) << 24) | (bArr[2] & 255)) << 16) | (bArr[1] & 255)) << 8);
    }

    public static int d(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public static byte[] e(int i3, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = i10 - 1;
        int i12 = 0;
        while (i11 >= 0) {
            bArr[i12] = (byte) ((i3 >> (i11 * 8)) & 255);
            i11--;
            i12++;
        }
        return bArr;
    }

    public static void f(CustomJLDialActivity customJLDialActivity, String str, int i3, int i10, androidx.camera.core.impl.e eVar) {
        String str2;
        int i11;
        Element element;
        InputStream open = customJLDialActivity.getAssets().open(str);
        kotlin.jvm.internal.e.e(open, "open(...)");
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int read = open.read();
        File file = new File(android.support.v4.media.session.e.j(customJLDialActivity.getFilesDir(), "/dial"));
        if (!file.exists()) {
            file.mkdir();
        }
        int i12 = 0;
        while (i12 < read) {
            int read2 = open.read();
            Element element2 = new Element();
            Element element3 = new Element();
            int i13 = 9;
            element2.setType(9);
            int i14 = 10;
            element3.setType(10);
            element2.setFontType(read2);
            element3.setFontType(read2);
            open.read(bArr);
            element2.setWidth(d(bArr));
            element3.setWidth(d(bArr));
            open.read(bArr);
            element2.setHeight(d(bArr));
            element3.setHeight(d(bArr));
            element2.setDataList(new ArrayList());
            element3.setDataList(new ArrayList());
            element2.setImageCount((byte) 10);
            element3.setImageCount((byte) 10);
            ArrayList arrayList = e;
            arrayList.clear();
            int i15 = 0;
            while (true) {
                str2 = ".res";
                i11 = i13;
                if (i15 >= i14) {
                    break;
                }
                String str3 = file.getAbsolutePath() + "/base_hour_out_" + i15 + ".res";
                String str4 = file.getAbsolutePath() + "/base_hour_in_" + i15 + ".png";
                arrayList.add(new Pair(str4, str3));
                open.read(bArr2);
                int c9 = (int) c(bArr2);
                byte[] bArr3 = new byte[c9];
                open.read(bArr3);
                if (i15 == 0) {
                    element2.setRawData(bArr3);
                } else if (i15 == 7) {
                    element3.setRawData(bArr3);
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr3, 0, c9);
                if (decodeByteArray != null) {
                    e2.d(e2.b(f8727a, decodeByteArray), str4);
                    decodeByteArray.recycle();
                }
                i15++;
                i13 = i11;
                i14 = 10;
            }
            String l3 = android.support.v4.media.session.e.l(file.getAbsolutePath(), "/base_timeSeparator_out.res");
            String l5 = android.support.v4.media.session.e.l(file.getAbsolutePath(), "/base_timeSeparator_in.png");
            arrayList.add(new Pair(l5, l3));
            Element element4 = new Element();
            element4.setType(22);
            element4.setFontType(read2);
            open.read(bArr);
            element4.setWidth(d(bArr));
            open.read(bArr);
            element4.setHeight(d(bArr));
            open.read(bArr2);
            int c10 = (int) c(bArr2);
            element4.setDataList(new ArrayList());
            element4.setImageCount((byte) 1);
            byte[] bArr4 = new byte[c10];
            open.read(bArr4);
            element4.setRawData(bArr4);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr4, 0, c10);
            if (decodeByteArray2 != null) {
                e2.d(e2.b(f8727a, decodeByteArray2), l5);
                decodeByteArray2.recycle();
            }
            Element element5 = new Element();
            Element element6 = new Element();
            element5.setType(8);
            element6.setType(7);
            element5.setFontType(read2);
            element6.setFontType(read2);
            open.read(bArr);
            element5.setWidth(d(bArr));
            element6.setWidth(d(bArr));
            open.read(bArr);
            element5.setHeight(d(bArr));
            element6.setHeight(d(bArr));
            element5.setDataList(new ArrayList());
            element6.setDataList(new ArrayList());
            element5.setImageCount((byte) 10);
            element6.setImageCount((byte) 10);
            int i16 = read;
            int i17 = 0;
            for (int i18 = 10; i17 < i18; i18 = 10) {
                File file2 = file;
                String str5 = file.getAbsolutePath() + "/base_day_out_" + i17 + ".res";
                int i19 = i12;
                String str6 = file2.getAbsolutePath() + "/base_day_in_" + i17 + ".png";
                arrayList.add(new Pair(str6, str5));
                open.read(bArr2);
                Element element7 = element4;
                int c11 = (int) c(bArr2);
                byte[] bArr5 = new byte[c11];
                open.read(bArr5);
                if (i17 == 0) {
                    element6.setRawData(bArr5);
                } else if (i17 == 7) {
                    element5.setRawData(bArr5);
                }
                Bitmap decodeByteArray3 = BitmapFactory.decodeByteArray(bArr5, 0, c11);
                if (decodeByteArray3 != null) {
                    e2.d(e2.b(f8727a, decodeByteArray3), str6);
                    decodeByteArray3.recycle();
                }
                i17++;
                file = file2;
                i12 = i19;
                element4 = element7;
            }
            File file3 = file;
            Element element8 = element4;
            int i20 = i12;
            String l8 = android.support.v4.media.session.e.l(file3.getAbsolutePath(), "/base_dateSeparator_out.res");
            String l9 = android.support.v4.media.session.e.l(file3.getAbsolutePath(), "/base_dateSeparator_in.png");
            arrayList.add(new Pair(l9, l8));
            Element element9 = new Element();
            element9.setType(22);
            element9.setFontType(read2);
            open.read(bArr);
            element9.setWidth(d(bArr));
            open.read(bArr);
            element9.setHeight(d(bArr));
            open.read(bArr2);
            int c12 = (int) c(bArr2);
            element9.setDataList(new ArrayList());
            element9.setImageCount((byte) 1);
            byte[] bArr6 = new byte[c12];
            open.read(bArr6);
            element9.setRawData(bArr6);
            Bitmap decodeByteArray4 = BitmapFactory.decodeByteArray(bArr6, 0, c12);
            if (decodeByteArray4 != null) {
                e2.d(e2.b(f8727a, decodeByteArray4), l9);
                decodeByteArray4.recycle();
            }
            Element element10 = new Element();
            int i21 = 13;
            element10.setType(13);
            element10.setFontType(read2);
            open.read(bArr);
            element10.setWidth(d(bArr));
            open.read(bArr);
            element10.setHeight(d(bArr));
            element10.setDataList(new ArrayList());
            element10.setImageCount((byte) 7);
            int i22 = 0;
            for (int i23 = 7; i22 < i23; i23 = 7) {
                int i24 = i21;
                String str7 = file3.getAbsolutePath() + "/base_week_out_" + i22 + str2;
                String str8 = str2;
                String str9 = file3.getAbsolutePath() + "/base_week_in_" + i22 + ".png";
                arrayList.add(new Pair(str9, str7));
                open.read(bArr2);
                int i25 = i22;
                int c13 = (int) c(bArr2);
                byte[] bArr7 = new byte[c13];
                open.read(bArr7);
                if (i25 == 0) {
                    element10.setRawData(bArr7);
                }
                byte[] bArr8 = bArr2;
                Bitmap decodeByteArray5 = BitmapFactory.decodeByteArray(bArr7, 0, c13);
                if (decodeByteArray5 != null) {
                    e2.d(e2.b(f8727a, decodeByteArray5), str9);
                    decodeByteArray5.recycle();
                }
                i22 = i25 + 1;
                i21 = i24;
                str2 = str8;
                bArr2 = bArr8;
            }
            byte[] bArr9 = bArr2;
            int i26 = i21;
            int read3 = open.read();
            byte[] bArr10 = new byte[28];
            int i27 = 0;
            while (i27 < read3) {
                if (open.read() == i3) {
                    open.read(bArr);
                    element2.setX(d(bArr));
                    open.read(bArr);
                    element2.setY(d(bArr));
                    open.read(bArr);
                    element = element8;
                    element.setX(d(bArr));
                    open.read(bArr);
                    element.setY(d(bArr));
                    open.read(bArr);
                    element3.setX(d(bArr));
                    open.read(bArr);
                    element3.setY(d(bArr));
                    open.read(bArr);
                    element5.setX(d(bArr));
                    open.read(bArr);
                    element5.setY(d(bArr));
                    open.read(bArr);
                    element9.setX(d(bArr));
                    open.read(bArr);
                    element9.setY(d(bArr));
                    open.read(bArr);
                    element6.setX(d(bArr));
                    open.read(bArr);
                    element6.setY(d(bArr));
                    open.read(bArr);
                    element10.setX(d(bArr));
                    open.read(bArr);
                    element10.setY(d(bArr));
                } else {
                    element = element8;
                    open.read(bArr10);
                }
                i27++;
                element8 = element;
            }
            Element element11 = element8;
            if (read2 == i10) {
                open.close();
                HashMap hashMap = new HashMap();
                hashMap.put(Integer.valueOf(i11), element2);
                hashMap.put(10, element3);
                hashMap.put(23, element11);
                hashMap.put(8, element5);
                hashMap.put(7, element6);
                hashMap.put(24, element9);
                hashMap.put(Integer.valueOf(i26), element10);
                f8730d = hashMap;
                r5.a.h(arrayList.size(), "baseBinPaths ", "qob");
                f8729c = eVar;
                b(0, arrayList);
                return;
            }
            i12 = i20 + 1;
            read = i16;
            file = file3;
            bArr2 = bArr9;
        }
        open.close();
    }

    public static void g(FileOutputStream fileOutputStream, Element element) {
        byte[] e10 = e(element.getOffset(), 4);
        byte b3 = e10[3];
        byte b10 = e10[2];
        byte b11 = e10[1];
        byte b12 = e10[0];
        byte[] e11 = e(element.getIndex(), 2);
        byte b13 = e11[1];
        byte b14 = e11[0];
        byte[] e12 = e(element.getWidth(), 2);
        byte b15 = e12[1];
        byte b16 = e12[0];
        byte[] e13 = e(element.getHeight(), 2);
        byte b17 = e13[1];
        byte b18 = e13[0];
        byte[] e14 = e(element.getX(), 2);
        byte b19 = e14[1];
        byte b20 = e14[0];
        byte[] e15 = e(element.getY(), 2);
        fileOutputStream.write(new byte[]{b3, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, e15[1], e15[0], element.getImageCount(), (byte) (element.getType() | (element.getHasAlpha() << 7)), element.getAnchor(), (byte) (element.getBlackTransparent() | (element.getCompression() << 1)), 0, element.getLeftOffset()});
    }

    public static void h(FileOutputStream fileOutputStream, ArrayList arrayList) {
        int size = arrayList.size();
        byte[] bArr = new byte[size * 4];
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = arrayList.get(i10);
            kotlin.jvm.internal.e.e(obj, "get(...)");
            byte[] e10 = e(((Number) obj).intValue(), 4);
            bArr[i3] = e10[3];
            bArr[i3 + 1] = e10[2];
            int i11 = i3 + 3;
            bArr[i3 + 2] = e10[1];
            i3 += 4;
            bArr[i11] = e10[0];
        }
        fileOutputStream.write(bArr);
    }
}
