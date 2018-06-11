/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namsor.oss.namsoralgolia;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "URL",
    "Author",
    "Source",
    "Lieu",
    "Title",
    "Content",
    "MainPIC",
    "Date",
    "Year",
    "realGender",
    "likelyGender",
    "genderScale",
    "rankingGendered",
    "objectID"
})
public class JournalArticle {

    @JsonProperty("URL")
    private String uRL;
    @JsonProperty("Author")
    private String author;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("Lieu")
    private String lieu;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Content")
    private String content;
    @JsonProperty("MainPIC")
    private String mainPIC;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Year")
    private Integer year;
    @JsonProperty("realGender")
    private String realGender;
    @JsonProperty("likelyGender")
    private String likelyGender;
    @JsonProperty("genderScale")
    private Double genderScale;

    @JsonProperty("solutionRating")
    private Double solutionRating;

    @JsonProperty("problemRating")
    private Double problemRating;

    @JsonProperty("impactJournalismScore")
    private Double impactJournalismScore;
        
    @JsonProperty("rankingGendered")
    private Double rankingGendered;
    @JsonProperty("objectID")
    private String objectID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("URL")
    public String getURL() {
        return uRL;
    }

    @JsonProperty("URL")
    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    @JsonProperty("Author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("Author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("Lieu")
    public String getLieu() {
        return lieu;
    }

    @JsonProperty("Lieu")
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Content")
    public String getContent() {
        return content;
    }

    @JsonProperty("Content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("MainPIC")
    public String getMainPIC() {
        return mainPIC;
    }

    @JsonProperty("MainPIC")
    public void setMainPIC(String mainPIC) {
        this.mainPIC = mainPIC;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("Year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("realGender")
    public String getRealGender() {
        return realGender;
    }

    @JsonProperty("realGender")
    public void setRealGender(String realGender) {
        this.realGender = realGender;
    }

    @JsonProperty("likelyGender")
    public String getLikelyGender() {
        return likelyGender;
    }

    @JsonProperty("likelyGender")
    public void setLikelyGender(String likelyGender) {
        this.likelyGender = likelyGender;
    }

    @JsonProperty("genderScale")
    public Double getGenderScale() {
        return genderScale;
    }

    @JsonProperty("genderScale")
    public void setGenderScale(Double genderScale) {
        this.genderScale = genderScale;
    }

    @JsonProperty("rankingGendered")
    public Double getRankingGendered() {
        return rankingGendered;
    }

    @JsonProperty("rankingGendered")
    public void setRankingGendered(Double rankingGendered) {
        this.rankingGendered = rankingGendered;
    }

    @JsonProperty("objectID")
    public String getObjectID() {
        return objectID;
    }

    @JsonProperty("objectID")
    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    /**
     * @return the solutionRating
     */
    public Double getSolutionRating() {
        return solutionRating;
    }

    /**
     * @param solutionRating the solutionRating to set
     */
    public void setSolutionRating(Double solutionRating) {
        this.solutionRating = solutionRating;
    }

    /**
     * @return the problemRating
     */
    public Double getProblemRating() {
        return problemRating;
    }

    /**
     * @param problemRating the problemRating to set
     */
    public void setProblemRating(Double problemRating) {
        this.problemRating = problemRating;
    }

    /**
     * @return the impactJournalismScore
     */
    public Double getImpactJournalismScore() {
        return impactJournalismScore;
    }

    /**
     * @param impactJournalismScore the impactJournalismScore to set
     */
    public void setImpactJournalismScore(Double impactJournalismScore) {
        this.impactJournalismScore = impactJournalismScore;
    }

}
