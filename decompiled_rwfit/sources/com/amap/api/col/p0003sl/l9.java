package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.k9;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public class l9 {

    /* renamed from: a, reason: collision with root package name */
    public final k9.e f4490a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4491b;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4492a;

        static {
            k9.e.values();
            int[] iArr = new int[9];
            f4492a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4492a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4492a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4492a[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4492a[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4492a[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4492a[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4492a[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4492a[0] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public l9(k9.e eVar, m9 m9Var) {
        String o3;
        this.f4490a = eVar;
        switch (a.f4492a[eVar.ordinal()]) {
            case 1:
                o3 = l0.o("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用", m9Var.d(), " SDK 功能前请设置隐私权政策是否弹窗告知用户");
                break;
            case 2:
                o3 = l0.o("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用", m9Var.d(), " SDK 功能前请确保隐私权政策已弹窗告知用户");
                break;
            case 3:
                o3 = l0.o("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用", m9Var.d(), " SDK 功能前请确保设置隐私权政策是否包含高德开平隐私权政策");
                break;
            case 4:
                o3 = l0.o("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用", m9Var.d(), " SDK 功能前请确保隐私权政策已经包含高德开平隐私权政策");
                break;
            case 5:
                o3 = l0.o("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用", m9Var.d(), " SDK 功能前请确保设置隐私权政策是否取得用户同意");
                break;
            case 6:
                o3 = l0.o("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用", m9Var.d(), " SDK 功能前请确保隐私权政策已取得用户同意");
                break;
            case 7:
                o3 = l0.o("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用", m9Var.d(), " SDK 功能使用前请确保已经正确设置apiKey，如有疑问请在高德开放平台官网中搜索【INVALID_USER_KEY】相关内容进行解决。");
                break;
            case 8:
                o3 = "***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n参数非法，context 或 sdkInfo为空";
                break;
            case 9:
                o3 = "设置隐私政策成功";
                break;
            default:
                o3 = "";
                break;
        }
        this.f4491b = o3;
    }
}
