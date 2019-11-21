package com.example.nasa.ui.flashcard;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Bodies {

    @NonNull
    @PrimaryKey
    @SerializedName("englishName")
    private String name;
    private boolean isPlanet;
    private double density;
    private double gravity;
    private String discoveredBy;
    private String discoveryDate;

    public String getDiscoveredBy() {
        return discoveredBy;
    }

    public void setDiscoveredBy(String discoveredBy) {
        this.discoveredBy = discoveredBy;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getName() {
                return name;
    }

    public void setName(String name) {
                this.name = name;
            }

            public boolean isPlanet() {
                return isPlanet;
            }

            public void setPlanet(boolean planet) {
                isPlanet = planet;
            }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
}
