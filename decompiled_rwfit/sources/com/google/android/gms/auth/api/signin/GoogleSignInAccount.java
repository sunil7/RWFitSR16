package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import q9.n;
import z9.a;
import z9.b;

@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new d(3);
    public static final a zaa = b.f20384a;

    /* renamed from: a, reason: collision with root package name */
    public final int f9066a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f9067b;
    private final String zad;
    private final String zae;
    private final String zaf;
    private final String zag;
    private final Uri zah;
    private String zai;
    private final long zaj;
    private final String zak;
    private final String zal;
    private final String zam;
    private final Set zan = new HashSet();

    public GoogleSignInAccount(int i3, String str, String str2, String str3, String str4, Uri uri, String str5, long j4, String str6, ArrayList arrayList, String str7, String str8) {
        this.f9066a = i3;
        this.zad = str;
        this.zae = str2;
        this.zaf = str3;
        this.zag = str4;
        this.zah = uri;
        this.zai = str5;
        this.zaj = j4;
        this.zak = str6;
        this.f9067b = arrayList;
        this.zal = str7;
        this.zam = str8;
    }

    public static GoogleSignInAccount b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            hashSet.add(new Scope(1, jSONArray.getString(i3)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String optString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String optString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String optString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String optString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        n.c(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, parseLong, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.zai = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.zak.equals(this.zak)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.f9067b);
        hashSet.addAll(googleSignInAccount.zan);
        HashSet hashSet2 = new HashSet(this.f9067b);
        hashSet2.addAll(this.zan);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int hashCode = this.zak.hashCode() + 527;
        HashSet hashSet = new HashSet(this.f9067b);
        hashSet.addAll(this.zan);
        return (hashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9066a);
        u.e(parcel, 2, this.zad);
        u.e(parcel, 3, this.zae);
        u.e(parcel, 4, this.zaf);
        u.e(parcel, 5, this.zag);
        u.d(parcel, 6, this.zah, i3);
        u.e(parcel, 7, this.zai);
        long j4 = this.zaj;
        u.k(parcel, 8, 8);
        parcel.writeLong(j4);
        u.e(parcel, 9, this.zak);
        u.h(parcel, 10, this.f9067b);
        u.e(parcel, 11, this.zal);
        u.e(parcel, 12, this.zam);
        u.j(parcel, i10);
    }
}
