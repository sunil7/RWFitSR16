package com.example.test.ui.dialog;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b {
    public static a a(final Context context) {
        kotlin.jvm.internal.e.f(context, "context");
        return (a) kotlin.a.b(new oh.a() { // from class: com.example.test.ui.dialog.CustomDatePickerDialog$Companion$builder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final a invoke() {
                Context context2 = context;
                kotlin.jvm.internal.e.f(context2, "context");
                a aVar = new a();
                aVar.f7911a = context2;
                aVar.f7912b = true;
                aVar.f7913c = true;
                aVar.f7914d = true;
                aVar.e = "取消";
                aVar.f7915f = "确定";
                aVar.f7920k = new ArrayList();
                aVar.f7921l = true;
                aVar.f7924o = "年";
                aVar.f7925p = "月";
                aVar.f7926q = "日";
                aVar.r = "时";
                aVar.f7927s = "分";
                aVar.f7928t = "秒";
                return aVar;
            }
        }).getValue();
    }
}
