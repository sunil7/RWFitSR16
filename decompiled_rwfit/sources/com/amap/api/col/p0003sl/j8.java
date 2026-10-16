package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class j8 implements IInputtipsSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f4330a;

    /* renamed from: b, reason: collision with root package name */
    private Inputtips.InputtipsListener f4331b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4332c;

    /* renamed from: d, reason: collision with root package name */
    private InputtipsQuery f4333d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.obj = j8.this.f4331b;
            obtainMessage.arg1 = 5;
            try {
                try {
                    j8 j8Var = j8.this;
                    ArrayList<? extends Parcelable> a3 = j8Var.a(j8Var.f4333d);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("result", a3);
                    obtainMessage.setData(bundle);
                    obtainMessage.what = 1000;
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                j8.this.f4332c.sendMessage(obtainMessage);
            }
        }
    }

    public j8(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4330a = context.getApplicationContext();
        this.f4331b = inputtipsListener;
        this.f4332c = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public InputtipsQuery getQuery() {
        return this.f4333d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.f4333d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtipsAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            d6.a(th2, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.f4331b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void setQuery(InputtipsQuery inputtipsQuery) {
        this.f4333d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            v6.a(this.f4330a);
            if (inputtipsQuery != null) {
                if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                    return new t6(this.f4330a, inputtipsQuery).c();
                }
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        } catch (Throwable th2) {
            d6.a(th2, "Inputtips", "requestInputtips");
            if (th2 instanceof AMapException) {
                throw th2;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str != null && !str.equals("")) {
            InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
            this.f4333d = inputtipsQuery;
            inputtipsQuery.setType(str3);
            try {
                u7.b().a(new a());
                return;
            } catch (Throwable th2) {
                d6.a(th2, "Inputtips", "requestInputtipsAsynThrowable");
                return;
            }
        }
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }

    public j8(Context context, InputtipsQuery inputtipsQuery) {
        this.f4330a = context.getApplicationContext();
        this.f4333d = inputtipsQuery;
        this.f4332c = x6.a();
    }
}
