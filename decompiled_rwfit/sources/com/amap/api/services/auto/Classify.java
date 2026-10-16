package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class Classify implements Parcelable {
    public static final Parcelable.Creator<Classify> CREATOR = new a();
    public ItermData itermData;
    public RetainState retainState;

    public static class Category implements Parcelable {
        public static final Parcelable.Creator<Category> CREATOR = new a();
        public int checked;
        public String classifyItemType;
        public String componentType;
        public int defaultValue;
        public String img;
        public String name;
        public String params;
        public String showType;
        public String value;

        public static class a implements Parcelable.Creator<Category> {
            @Override // android.os.Parcelable.Creator
            public Category createFromParcel(Parcel parcel) {
                return new Category(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Category[] newArray(int i3) {
                return new Category[i3];
            }
        }

        public Category() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.checked);
            parcel.writeString(this.componentType);
            parcel.writeInt(this.defaultValue);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeString(this.value);
            parcel.writeString(this.classifyItemType);
            parcel.writeString(this.img);
            parcel.writeString(this.showType);
        }

        public Category(Parcel parcel) {
            this.checked = parcel.readInt();
            this.componentType = parcel.readString();
            this.defaultValue = parcel.readInt();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.value = parcel.readString();
            this.classifyItemType = parcel.readString();
            this.img = parcel.readString();
            this.showType = parcel.readString();
        }
    }

    public static class CheckedNode implements Parcelable {
        public static final Parcelable.Creator<CheckedNode> CREATOR = new a();

        /* renamed from: id, reason: collision with root package name */
        public String f5856id;
        public String name;
        public String value;

        public static class a implements Parcelable.Creator<CheckedNode> {
            @Override // android.os.Parcelable.Creator
            public CheckedNode createFromParcel(Parcel parcel) {
                return new CheckedNode(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CheckedNode[] newArray(int i3) {
                return new CheckedNode[i3];
            }
        }

        public CheckedNode() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f5856id);
            parcel.writeString(this.value);
            parcel.writeString(this.name);
        }

        public CheckedNode(Parcel parcel) {
            this.f5856id = parcel.readString();
            this.value = parcel.readString();
            this.name = parcel.readString();
        }
    }

    public static class CheckedValue implements Parcelable {
        public static final Parcelable.Creator<CheckedValue> CREATOR = new a();
        public String classifyV2Data;
        public String classifyV2Level2Data;
        public String classifyV2Level3Data;

        public static class a implements Parcelable.Creator<CheckedValue> {
            @Override // android.os.Parcelable.Creator
            public CheckedValue createFromParcel(Parcel parcel) {
                return new CheckedValue(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CheckedValue[] newArray(int i3) {
                return new CheckedValue[i3];
            }
        }

        public CheckedValue() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.classifyV2Data);
            parcel.writeString(this.classifyV2Level2Data);
            parcel.writeString(this.classifyV2Level3Data);
        }

        public CheckedValue(Parcel parcel) {
            this.classifyV2Data = parcel.readString();
            this.classifyV2Level2Data = parcel.readString();
            this.classifyV2Level3Data = parcel.readString();
        }
    }

    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new a();
        public List<DataCategory> categories;
        public int checked;
        public String classifyItemType;
        public int isCancelDefaultSelect;
        public int isNoBtn;
        public int multiSelect;
        public String name;
        public String params;
        public String separator;
        public String type;
        public int useCommonlyUsedConfig;
        public int useLocalConfig;
        public int useRemoteConfig;

        public static class a implements Parcelable.Creator<Data> {
            @Override // android.os.Parcelable.Creator
            public Data createFromParcel(Parcel parcel) {
                return new Data(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Data[] newArray(int i3) {
                return new Data[i3];
            }
        }

        public Data() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeTypedList(this.categories);
            parcel.writeInt(this.checked);
            parcel.writeString(this.classifyItemType);
            parcel.writeInt(this.isCancelDefaultSelect);
            parcel.writeInt(this.isNoBtn);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeString(this.separator);
            parcel.writeString(this.type);
            parcel.writeInt(this.useCommonlyUsedConfig);
            parcel.writeInt(this.useLocalConfig);
            parcel.writeInt(this.useRemoteConfig);
            parcel.writeInt(this.multiSelect);
        }

        public Data(Parcel parcel) {
            this.categories = parcel.createTypedArrayList(DataCategory.CREATOR);
            this.checked = parcel.readInt();
            this.classifyItemType = parcel.readString();
            this.isCancelDefaultSelect = parcel.readInt();
            this.isNoBtn = parcel.readInt();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.separator = parcel.readString();
            this.type = parcel.readString();
            this.useCommonlyUsedConfig = parcel.readInt();
            this.useLocalConfig = parcel.readInt();
            this.useRemoteConfig = parcel.readInt();
            this.multiSelect = parcel.readInt();
        }
    }

    public static class DataCategory implements Parcelable {
        public static final Parcelable.Creator<DataCategory> CREATOR = new a();
        public int areaSubwayMark;
        public List<Category> categories;
        public int checked;
        public String classifyItemType;
        public String componentType;
        public int defaultValue;
        public int hideTitle;
        public String img;
        public int maxShowNum;
        public int maxShowNumRow;
        public int multiSelect;
        public String name;
        public String params;
        public String showType;
        public String value;

        public static class a implements Parcelable.Creator<DataCategory> {
            @Override // android.os.Parcelable.Creator
            public DataCategory createFromParcel(Parcel parcel) {
                return new DataCategory(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DataCategory[] newArray(int i3) {
                return new DataCategory[i3];
            }
        }

        public DataCategory() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeTypedList(this.categories);
            parcel.writeInt(this.checked);
            parcel.writeInt(this.defaultValue);
            parcel.writeString(this.componentType);
            parcel.writeString(this.name);
            parcel.writeString(this.params);
            parcel.writeInt(this.areaSubwayMark);
            parcel.writeInt(this.hideTitle);
            parcel.writeInt(this.maxShowNum);
            parcel.writeInt(this.maxShowNumRow);
            parcel.writeInt(this.multiSelect);
            parcel.writeString(this.img);
            parcel.writeString(this.showType);
            parcel.writeString(this.value);
            parcel.writeString(this.classifyItemType);
        }

        public DataCategory(Parcel parcel) {
            this.categories = parcel.createTypedArrayList(Category.CREATOR);
            this.checked = parcel.readInt();
            this.defaultValue = parcel.readInt();
            this.componentType = parcel.readString();
            this.name = parcel.readString();
            this.params = parcel.readString();
            this.areaSubwayMark = parcel.readInt();
            this.hideTitle = parcel.readInt();
            this.maxShowNum = parcel.readInt();
            this.maxShowNumRow = parcel.readInt();
            this.multiSelect = parcel.readInt();
            this.img = parcel.readString();
            this.showType = parcel.readString();
            this.value = parcel.readString();
            this.classifyItemType = parcel.readString();
        }
    }

    public static class ItermData implements Parcelable {
        public static final Parcelable.Creator<ItermData> CREATOR = new a();
        public List<CheckedNode> checkedNodes;
        public CheckedValue checkedValue;
        public List<Data> datas;
        public List<Data> defaultPositionDatas;
        public List<Data> level2Datas;

        public static class a implements Parcelable.Creator<ItermData> {
            @Override // android.os.Parcelable.Creator
            public ItermData createFromParcel(Parcel parcel) {
                return new ItermData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ItermData[] newArray(int i3) {
                return new ItermData[i3];
            }
        }

        public ItermData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeTypedList(this.checkedNodes);
            parcel.writeParcelable(this.checkedValue, i3);
            parcel.writeTypedList(this.datas);
            parcel.writeTypedList(this.defaultPositionDatas);
            parcel.writeTypedList(this.level2Datas);
        }

        public ItermData(Parcel parcel) {
            this.checkedNodes = parcel.createTypedArrayList(CheckedNode.CREATOR);
            this.checkedValue = (CheckedValue) parcel.readParcelable(CheckedValue.class.getClassLoader());
            Parcelable.Creator<Data> creator = Data.CREATOR;
            this.datas = parcel.createTypedArrayList(creator);
            this.defaultPositionDatas = parcel.createTypedArrayList(creator);
            this.level2Datas = parcel.createTypedArrayList(creator);
        }
    }

    public static class RetainState implements Parcelable {
        public static final Parcelable.Creator<RetainState> CREATOR = new a();
        public String classifyBusinessType;
        public String classifyConf;
        public String classifyRetainLevel2;
        public String level2All;
        public String newClassifyCityadcode;
        public String newClassifyFlag;

        public static class a implements Parcelable.Creator<RetainState> {
            @Override // android.os.Parcelable.Creator
            public RetainState createFromParcel(Parcel parcel) {
                return new RetainState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public RetainState[] newArray(int i3) {
                return new RetainState[i3];
            }
        }

        public RetainState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.classifyBusinessType);
            parcel.writeString(this.classifyConf);
            parcel.writeString(this.classifyRetainLevel2);
            parcel.writeString(this.level2All);
            parcel.writeString(this.newClassifyCityadcode);
            parcel.writeString(this.newClassifyFlag);
        }

        public RetainState(Parcel parcel) {
            this.classifyBusinessType = parcel.readString();
            this.classifyConf = parcel.readString();
            this.classifyRetainLevel2 = parcel.readString();
            this.level2All = parcel.readString();
            this.newClassifyCityadcode = parcel.readString();
            this.newClassifyFlag = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<Classify> {
        @Override // android.os.Parcelable.Creator
        public Classify createFromParcel(Parcel parcel) {
            return new Classify(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Classify[] newArray(int i3) {
            return new Classify[i3];
        }
    }

    public Classify() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.itermData, i3);
        parcel.writeParcelable(this.retainState, i3);
    }

    public Classify(Parcel parcel) {
        this.itermData = (ItermData) parcel.readParcelable(ItermData.class.getClassLoader());
        this.retainState = (RetainState) parcel.readParcelable(RetainState.class.getClassLoader());
    }
}
