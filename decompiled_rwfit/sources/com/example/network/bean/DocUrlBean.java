package com.example.network.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DocUrlBean implements Parcelable {
    public static final Parcelable.Creator<DocUrlBean> CREATOR = new Parcelable.Creator<DocUrlBean>() { // from class: com.example.network.bean.DocUrlBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocUrlBean createFromParcel(Parcel parcel) {
            return new DocUrlBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocUrlBean[] newArray(int i3) {
            return new DocUrlBean[i3];
        }
    };
    private String helpUrl;
    private String privacyPolicyUrl;
    private String userProtocolUrl;

    public DocUrlBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHelpUrl() {
        return this.helpUrl;
    }

    public String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public String getUserProtocolUrl() {
        return this.userProtocolUrl;
    }

    public void setHelpUrl(String str) {
        this.helpUrl = str;
    }

    public void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    public void setUserProtocolUrl(String str) {
        this.userProtocolUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.privacyPolicyUrl);
        parcel.writeString(this.userProtocolUrl);
        parcel.writeString(this.helpUrl);
    }

    public DocUrlBean(Parcel parcel) {
        this.privacyPolicyUrl = parcel.readString();
        this.userProtocolUrl = parcel.readString();
        this.helpUrl = parcel.readString();
    }
}
