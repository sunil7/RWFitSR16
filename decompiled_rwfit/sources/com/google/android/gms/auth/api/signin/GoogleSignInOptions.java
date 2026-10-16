package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.viewpager2.widget.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements b, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    public static final Scope zaa;
    public static final Scope zab;
    public static final Scope zac;
    public static final Scope zad;
    public static final Scope zae;
    private static final Comparator zag;

    /* renamed from: a, reason: collision with root package name */
    public final int f9068a;
    private final ArrayList zah;
    private Account zai;
    private boolean zaj;
    private final boolean zak;
    private final boolean zal;
    private String zam;
    private String zan;
    private ArrayList zao;
    private String zap;
    private Map zaq;

    static {
        Scope scope = new Scope(1, "profile");
        zaa = scope;
        zab = new Scope(1, "email");
        Scope scope2 = new Scope(1, "openid");
        zac = scope2;
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        zad = scope3;
        Scope scope4 = new Scope(1, "https://www.googleapis.com/auth/games");
        zae = scope4;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        DEFAULT_SIGN_IN = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, hashMap, null);
        HashSet hashSet2 = new HashSet();
        HashMap hashMap2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        DEFAULT_GAMES_SIGN_IN = new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, hashMap2, null);
        CREATOR = new d(4);
        zag = new a(10);
    }

    public GoogleSignInOptions(int i3, ArrayList arrayList, Account account, boolean z5, boolean z6, boolean z8, String str, String str2, HashMap hashMap, String str3) {
        this.f9068a = i3;
        this.zah = arrayList;
        this.zai = account;
        this.zaj = z5;
        this.zak = z6;
        this.zal = z8;
        this.zam = str;
        this.zan = str2;
        this.zao = new ArrayList(hashMap.values());
        this.zaq = hashMap;
        this.zap = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zao.isEmpty() && googleSignInOptions.zao.isEmpty() && this.zah.size() == new ArrayList(googleSignInOptions.zah).size() && this.zah.containsAll(new ArrayList(googleSignInOptions.zah))) {
                Account account = this.zai;
                if (account == null) {
                    if (googleSignInOptions.zai != null) {
                        return false;
                    }
                } else if (!account.equals(googleSignInOptions.zai)) {
                    return false;
                }
                if (TextUtils.isEmpty(this.zam)) {
                    if (!TextUtils.isEmpty(googleSignInOptions.zam)) {
                        return false;
                    }
                } else if (!this.zam.equals(googleSignInOptions.zam)) {
                    return false;
                }
                if (this.zal == googleSignInOptions.zal && this.zaj == googleSignInOptions.zaj && this.zak == googleSignInOptions.zak) {
                    return TextUtils.equals(this.zap, googleSignInOptions.zap);
                }
                return false;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.zah;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(((Scope) arrayList2.get(i3)).b());
        }
        Collections.sort(arrayList);
        int hashCode = arrayList.hashCode() + (1 * 31);
        Account account = this.zai;
        int hashCode2 = (hashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.zam;
        int hashCode3 = (((((((hashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.zal ? 1 : 0)) * 31) + (this.zaj ? 1 : 0)) * 31) + (this.zak ? 1 : 0);
        String str2 = this.zap;
        return (hashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9068a);
        u.h(parcel, 2, new ArrayList(this.zah));
        u.d(parcel, 3, this.zai, i3);
        boolean z5 = this.zaj;
        u.k(parcel, 4, 4);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zak;
        u.k(parcel, 5, 4);
        parcel.writeInt(z6 ? 1 : 0);
        boolean z8 = this.zal;
        u.k(parcel, 6, 4);
        parcel.writeInt(z8 ? 1 : 0);
        u.e(parcel, 7, this.zam);
        u.e(parcel, 8, this.zan);
        u.h(parcel, 9, this.zao);
        u.e(parcel, 10, this.zap);
        u.j(parcel, i10);
    }
}
