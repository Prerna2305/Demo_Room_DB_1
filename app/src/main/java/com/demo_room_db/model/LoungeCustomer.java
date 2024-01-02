package com.demo_room_db.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "loungecustomer")
public class LoungeCustomer implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String email;
    String number;
    String city;


    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    protected LoungeCustomer(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        number = in.readString();
        city = in.readString();
        image = in.readBlob();
        date = in.readString();
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(number);
        dest.writeString(city);
        dest.writeBlob(image);
        dest.writeString(date);
    }

    public static final Creator<LoungeCustomer> CREATOR = new Creator<LoungeCustomer>() {
        @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
        @Override
        public LoungeCustomer createFromParcel(Parcel in) {
            return new LoungeCustomer(in);
        }

        @Override
        public LoungeCustomer[] newArray(int size) {
            return new LoungeCustomer[size];
        }
    };

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

  /*  protected LoungeCustomer(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        number = in.readString();
        city = in.readString();
        date = in.readString();
        image = in.readBlob();
    }*/

 /*   public static final Creator<LoungeCustomer> CREATOR = new Creator<LoungeCustomer>() {
        @Override
        public LoungeCustomer createFromParcel(Parcel in) {
            return new LoungeCustomer(in);
        }

        @Override
        public LoungeCustomer[] newArray(int size) {
            return new LoungeCustomer[size];
        }
    };*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    @Ignore
    public LoungeCustomer(String name, String email, String number, String city,String date,byte[] image) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.city = city;
        this.date = date;
        this.image=image;
    }

    public LoungeCustomer(int id, String name, String email, String number, String city,String date,byte[] image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.city = city;
        this.date = date;
        this.image=image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

   /* @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(number);
        dest.writeString(city);
        dest.writeString(date);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            dest.writeBlob(image);
        }
    }*/
}
