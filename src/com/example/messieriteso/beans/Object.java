package com.example.messieriteso.beans;


import android.os.Parcel;
import android.os.Parcelable;

public class Object implements Parcelable {
	private String messier;
	private String ngc;
	private String common;
	private int picture_id;
	private String type;
	private float distance;
	private String constellation;
	private float apparentm;
	
	public Object(){
		
	}
	
	public Object(Parcel in){
		readFromParcel(in);
	}
	
	
	public String getMessier() {
		return messier;
	}

	public void setMessier(String messier) {
		this.messier = messier;
	}

	public String getNgc() {
		return ngc;
	}

	public void setNgc(String ngc) {
		this.ngc = ngc;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public int getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public float getApparentm() {
		return apparentm;
	}

	public void setApparentm(float apparentm) {
		this.apparentm = apparentm;
	}


	public static final Parcelable.Creator<Object> CREATOR = new Parcelable.Creator<Object>() {

		@Override
		public Object createFromParcel(Parcel source) {
			return new Object(source);
		}

		@Override
		public Object[] newArray(int size) {
			return new Object[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.messier);
		dest.writeString(this.ngc);
		dest.writeString(this.common);
		dest.writeInt(this.picture_id);
		dest.writeString(this.type);
		dest.writeFloat(this.distance);
		dest.writeString(this.constellation);
		dest.writeFloat(this.apparentm);

	}

	public void readFromParcel(Parcel in) {
		
		this.messier = in.readString();
		this.ngc = in.readString();
		this.common = in.readString();
		this.picture_id = in.readInt();
		this.type = in.readString();
		this.distance = in.readFloat();
		this.constellation = in.readString();
		this.apparentm = in.readFloat();
		
	}

}
