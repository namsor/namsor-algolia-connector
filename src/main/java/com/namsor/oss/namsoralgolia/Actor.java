package com.namsor.oss.namsoralgolia;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
    "name",
    "rating",
    "image_path",
    "alternative_name",
    "objectID",
    "_highlightResult",
    "likelyGender"
})

public class Actor {

    /**
     * @return the realGender
     */
    @JsonProperty("realGender")
    public String getRealGender() {
        return realGender;
    }

    /**
     * @param realGender the realGender to set
     */
    @JsonProperty("realGender")
    public void setRealGender(String realGender) {
        this.realGender = realGender;
    }

    @JsonProperty("objectID")
    private String objectID;
    @JsonProperty("realGender")
    private String realGender;
    @JsonProperty("likelyGender")
    private String likelyGender;
    @JsonProperty("genderScale")
    private double genderScale;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("image_path")
    private String imagePath;
    @JsonProperty("alternative_name")
    private Object alternativeName;
    @JsonProperty("rankingGendered")
    private double rankingGendered;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonProperty("image_path")
    public String getImagePath() {
        return imagePath;
    }

    @JsonProperty("image_path")
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @JsonProperty("alternative_name")
    public Object getAlternativeName() {
        return alternativeName;
    }

    @JsonProperty("alternative_name")
    public void setAlternativeName(Object alternativeName) {
        this.alternativeName = alternativeName;
    }

    @Override
    public String toString() {
        return "Actor{" + "objectID=" + objectID + ", name=" + name + ", rating=" + rating + ", imagePath=" + imagePath + ", alternativeName=" + alternativeName + '}';
    }

    /**
     * @return the objectID
     */
    @JsonProperty("objectID")
    public String getObjectID() {
        return objectID;
    }

    /**
     * @param objectID the objectID to set
     */
    @JsonProperty("objectID")
    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    /**
     * @return the likelyGender
     */
    @JsonProperty("likelyGender")
    public String getLikelyGender() {
        return likelyGender;
    }

    /**
     * @param likelyGender the likelyGender to set
     */
    @JsonProperty("likelyGender")
    public void setLikelyGender(String likelyGender) {
        this.likelyGender = likelyGender;
    }

    /**
     * @return the genderScale
     */
    @JsonProperty("genderScale")
    public double getGenderScale() {
        return genderScale;
    }

    /**
     * @param genderScale the genderScale to set
     */
    @JsonProperty("genderScale")
    public void setGenderScale(double genderScale) {
        this.genderScale = genderScale;
    }

    /**
     * @return the rankingGendered
     */
    @JsonProperty("rankingGendered")
    public double getRankingGendered() {
        return rankingGendered;
    }

    /**
     * @param rankingGendered the rankingGendered to set
     */
    @JsonProperty("rankingGendered")
    public void setRankingGendered(double rankingGendered) {
        this.rankingGendered = rankingGendered;
    }
}
