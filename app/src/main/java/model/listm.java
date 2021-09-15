package model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class listm implements Parcelable {
    private String nama, why, when;

    public String getNama() {
        return nama;
    }

    public String getWhy() {
        return why;
    }

    public String getWhen() {
        return when;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public listm (String nama, String why, String when){
        this.nama=nama;
        this.why=why;
        this.when=when;
    }

    public listm(){
        this.nama="";
        this.why="";
        this.when="";
    }

    protected listm(Parcel in) {
        nama = in.readString();
        why = in.readString();
        when = in.readString();
    }

    public static final Creator<listm> CREATOR = new Creator<listm>() {
        @Override
        public listm createFromParcel(Parcel in) {
            return new listm(in);
        }

        @Override
        public listm[] newArray(int size) {
            return new listm[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(why);
        dest.writeString(when);
    }

    public void delete(){

    }
}
