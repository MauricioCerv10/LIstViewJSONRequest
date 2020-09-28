package com.example.volley;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class Usuario implements Parcelable {
    private int userId;
    private int id;
    private String title;
    private boolean completado;

    public Usuario(JSONObject user) {
        try {
            this.userId = user.getInt("userId");
            this.id = user.getInt("id");
            this.title = user.getString("title");
            this.completado = user.getBoolean("completed");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    protected Usuario(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        completado = in.readByte() != 0;
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completado=" + completado +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeByte((byte) (completado ? 1 : 0));
    }
}
