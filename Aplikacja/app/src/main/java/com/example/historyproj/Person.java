package com.example.historyproj;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class Person {
    public static class Badge {
        @SerializedName("name")
        private String name;

        @SerializedName("sub_badges")
        private List<String> subBadges;

        // Getters and setters for name and sub_badges

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getSubBadges() {
            return subBadges;
        }

        public void setSubBadges(List<String> subBadges) {
            this.subBadges = subBadges;
        }
    }
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("inscription")
    private String inscription;

    @SerializedName("other_names")
    private List<String> otherNames;

    @SerializedName("code_names")
    private List<String> codeNames;

    @SerializedName("birth_date")
    private String birthDate;

    @SerializedName("birth_place")
    private String birthPlace;

    @SerializedName("death_date")
    private String deathDate;

    @SerializedName("death_place")
    private String deathPlace;

    @SerializedName("burial_place")
    private String burialPlace;

    @SerializedName("cemetery")
    private String cemetery;

    @SerializedName("quarter")
    private String quarter;

    @SerializedName("row")
    private String row;

    @SerializedName("grave")
    private String grave;

    @SerializedName("ranks")
    private List<String> ranks;

    @SerializedName("badges")
    private List<Badge> badges;

    @SerializedName("activity")
    private List<Activity> activity;

    @SerializedName("description")
    private String description;

    @SerializedName("sources")
    private String sources;

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInscription() {
        return inscription;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public List<String> getCodeNames() {
        return codeNames;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public String getBurialPlace() {
        return burialPlace;
    }

    public String getCemetery() {
        return cemetery;
    }

    public String getQuarter() {
        return quarter;
    }

    public String getRow() {
        return row;
    }

    public String getGrave() {
        return grave;
    }

    public List<String> getRanks() {
        return ranks;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public String getDescription() {
        return description;
    }

    public String getSources() {
        return sources;
    }
    public void setName(String val) {
        this.name = val;
    }
    public void setOtherNames(List<String> val) {
        this.otherNames = val;
    }
    public void setCodeNames(List<String> val) {
        this.codeNames = val;
    }
    public void setInscription(String val) {
        this.inscription = val;
    }
    public void setBirthDate(String val) {
        this.birthDate = val;
    }
    public void setDeathDate(String val) {
        this.deathDate = val;
    }
    public void setBirthPlace(String val) {
        this.birthPlace = val;
    }
    public void setDeathPlace(String val) {
        this.deathPlace = val;
    }
    public void setBurialPlace(String val) {
        this.burialPlace = val;
    }
    public void setCemetery(String val) {
        this.cemetery = val;
    }
    public void setQuarter(String val) {
        this.quarter = val;
    }
    public void setRow(String val) {
        this.row = val;
    }
    public void setGrave(String val) {
        this.grave = val;
    }
    public void setRanks(List<String> val) {
        this.ranks = Collections.singletonList(val.toString());
    }
    public void setBadges(List<Badge> val) {
        this.badges = val;
    }
    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }
    public void setDescription(String val) {
        this.description= val;
    }
    public void setSources(String val) {
        this.sources= val;
    }
}
