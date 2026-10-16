package com.example.test.ui.device.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.network.bean.DialBean;

/* loaded from: classes.dex */
public class DialModel implements Parcelable {
    public static final Parcelable.Creator<DialModel> CREATOR = new Parcelable.Creator<DialModel>() { // from class: com.example.test.ui.device.model.DialModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialModel createFromParcel(Parcel parcel) {
            return new DialModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DialModel[] newArray(int i3) {
            return new DialModel[i3];
        }
    };
    private DialBean dialBean;
    private DialInfoBean dialInfoBean;

    public DialModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DialBean getDialBean() {
        return this.dialBean;
    }

    public DialInfoBean getDialInfoBean() {
        return this.dialInfoBean;
    }

    public void setDialBean(DialBean dialBean) {
        this.dialBean = dialBean;
    }

    public void setDialInfoBean(DialInfoBean dialInfoBean) {
        this.dialInfoBean = dialInfoBean;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.dialInfoBean, i3);
        parcel.writeParcelable(this.dialBean, i3);
    }

    public DialModel(Parcel parcel) {
        this.dialInfoBean = (DialInfoBean) parcel.readParcelable(DialInfoBean.class.getClassLoader());
        this.dialBean = (DialBean) parcel.readParcelable(DialBean.class.getClassLoader());
    }
}
