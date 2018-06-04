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
    "color",
    "director_name",
    "num_critic_for_reviews",
    "duration",
    "director_facebook_likes",
    "actor_3_facebook_likes",
    "actor_2_name",
    "actor_1_facebook_likes",
    "gross",
    "genres",
    "actor_1_name",
    "movie_title",
    "num_voted_users",
    "cast_total_facebook_likes",
    "actor_3_name",
    "facenumber_in_poster",
    "plot_keywords",
    "movie_imdb_link",
    "num_user_for_reviews",
    "language",
    "country",
    "content_rating",
    "budget",
    "title_year",
    "actor_2_facebook_likes",
    "imdb_score",
    "aspect_ratio",
    "movie_facebook_likes",
    "genre1",
    "genre2",
    "genre3",
    "genre4",
    "genre5",
    "objectID"
})
public class Movie {

    @JsonProperty("color")
    private String color;
    @JsonProperty("director_name")
    private String directorName;
    @JsonProperty("num_critic_for_reviews")
    private Long numCriticForReviews;
    @JsonProperty("duration")
    private Long duration;
    @JsonProperty("director_facebook_likes")
    private Long directorFacebookLikes;
    @JsonProperty("actor_3_facebook_likes")
    private Long actor3FacebookLikes;
    @JsonProperty("actor_2_name")
    private String actor2Name;
    @JsonProperty("actor_1_facebook_likes")
    private Long actor1FacebookLikes;
    @JsonProperty("gross")
    private Long gross;
    @JsonProperty("genres")
    private String genres;
    @JsonProperty("actor_1_name")
    private String actor1Name;
    @JsonProperty("movie_title")
    private String movieTitle;
    @JsonProperty("num_voted_users")
    private Long numVotedUsers;
    @JsonProperty("cast_total_facebook_likes")
    private Long castTotalFacebookLikes;
    @JsonProperty("actor_3_name")
    private String actor3Name;
    @JsonProperty("facenumber_in_poster")
    private Long facenumberInPoster;
    @JsonProperty("plot_keywords")
    private String plotKeywords;
    @JsonProperty("movie_imdb_link")
    private String movieImdbLink;
    @JsonProperty("num_user_for_reviews")
    private Long numUserForReviews;
    @JsonProperty("language")
    private String language;
    @JsonProperty("country")
    private String country;
    @JsonProperty("content_rating")
    private String contentRating;
    @JsonProperty("budget")
    private Long budget;
    @JsonProperty("title_year")
    private Long titleYear;
    @JsonProperty("actor_2_facebook_likes")
    private Long actor2FacebookLikes;
    @JsonProperty("imdb_score")
    private Double imdbScore;
    @JsonProperty("aspect_ratio")
    private Double aspectRatio;
    @JsonProperty("movie_facebook_likes")
    private Long movieFacebookLikes;
    @JsonProperty("genre1")
    private String genre1;
    @JsonProperty("genre2")
    private String genre2;
    @JsonProperty("genre3")
    private String genre3;
    @JsonProperty("genre4")
    private String genre4;
    @JsonProperty("genre5")
    private String genre5;
    @JsonProperty("objectID")
    private String objectID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("director_name")
    public String getDirectorName() {
        return directorName;
    }

    @JsonProperty("director_name")
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @JsonProperty("num_critic_for_reviews")
    public Long getNumCriticForReviews() {
        return numCriticForReviews;
    }

    @JsonProperty("num_critic_for_reviews")
    public void setNumCriticForReviews(Long numCriticForReviews) {
        this.numCriticForReviews = numCriticForReviews;
    }

    @JsonProperty("duration")
    public Long getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @JsonProperty("director_facebook_likes")
    public Long getDirectorFacebookLikes() {
        return directorFacebookLikes;
    }

    @JsonProperty("director_facebook_likes")
    public void setDirectorFacebookLikes(Long directorFacebookLikes) {
        this.directorFacebookLikes = directorFacebookLikes;
    }

    @JsonProperty("actor_3_facebook_likes")
    public Long getActor3FacebookLikes() {
        return actor3FacebookLikes;
    }

    @JsonProperty("actor_3_facebook_likes")
    public void setActor3FacebookLikes(Long actor3FacebookLikes) {
        this.actor3FacebookLikes = actor3FacebookLikes;
    }

    @JsonProperty("actor_2_name")
    public String getActor2Name() {
        return actor2Name;
    }

    @JsonProperty("actor_2_name")
    public void setActor2Name(String actor2Name) {
        this.actor2Name = actor2Name;
    }

    @JsonProperty("actor_1_facebook_likes")
    public Long getActor1FacebookLikes() {
        return actor1FacebookLikes;
    }

    @JsonProperty("actor_1_facebook_likes")
    public void setActor1FacebookLikes(Long actor1FacebookLikes) {
        this.actor1FacebookLikes = actor1FacebookLikes;
    }

    @JsonProperty("gross")
    public Long getGross() {
        return gross;
    }

    @JsonProperty("gross")
    public void setGross(Long gross) {
        this.gross = gross;
    }

    @JsonProperty("genres")
    public String getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(String genres) {
        this.genres = genres;
    }

    @JsonProperty("actor_1_name")
    public String getActor1Name() {
        return actor1Name;
    }

    @JsonProperty("actor_1_name")
    public void setActor1Name(String actor1Name) {
        this.actor1Name = actor1Name;
    }

    @JsonProperty("movie_title")
    public String getMovieTitle() {
        return movieTitle;
    }

    @JsonProperty("movie_title")
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @JsonProperty("num_voted_users")
    public Long getNumVotedUsers() {
        return numVotedUsers;
    }

    @JsonProperty("num_voted_users")
    public void setNumVotedUsers(Long numVotedUsers) {
        this.numVotedUsers = numVotedUsers;
    }

    @JsonProperty("cast_total_facebook_likes")
    public Long getCastTotalFacebookLikes() {
        return castTotalFacebookLikes;
    }

    @JsonProperty("cast_total_facebook_likes")
    public void setCastTotalFacebookLikes(Long castTotalFacebookLikes) {
        this.castTotalFacebookLikes = castTotalFacebookLikes;
    }

    @JsonProperty("actor_3_name")
    public String getActor3Name() {
        return actor3Name;
    }

    @JsonProperty("actor_3_name")
    public void setActor3Name(String actor3Name) {
        this.actor3Name = actor3Name;
    }

    @JsonProperty("facenumber_in_poster")
    public Long getFacenumberInPoster() {
        return facenumberInPoster;
    }

    @JsonProperty("facenumber_in_poster")
    public void setFacenumberInPoster(Long facenumberInPoster) {
        this.facenumberInPoster = facenumberInPoster;
    }

    @JsonProperty("plot_keywords")
    public String getPlotKeywords() {
        return plotKeywords;
    }

    @JsonProperty("plot_keywords")
    public void setPlotKeywords(String plotKeywords) {
        this.plotKeywords = plotKeywords;
    }

    @JsonProperty("movie_imdb_link")
    public String getMovieImdbLink() {
        return movieImdbLink;
    }

    @JsonProperty("movie_imdb_link")
    public void setMovieImdbLink(String movieImdbLink) {
        this.movieImdbLink = movieImdbLink;
    }

    @JsonProperty("num_user_for_reviews")
    public Long getNumUserForReviews() {
        return numUserForReviews;
    }

    @JsonProperty("num_user_for_reviews")
    public void setNumUserForReviews(Long numUserForReviews) {
        this.numUserForReviews = numUserForReviews;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("content_rating")
    public String getContentRating() {
        return contentRating;
    }

    @JsonProperty("content_rating")
    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    @JsonProperty("budget")
    public Long getBudget() {
        return budget;
    }

    @JsonProperty("budget")
    public void setBudget(Long budget) {
        this.budget = budget;
    }

    @JsonProperty("title_year")
    public Long getTitleYear() {
        return titleYear;
    }

    @JsonProperty("title_year")
    public void setTitleYear(Long titleYear) {
        this.titleYear = titleYear;
    }

    @JsonProperty("actor_2_facebook_likes")
    public Long getActor2FacebookLikes() {
        return actor2FacebookLikes;
    }

    @JsonProperty("actor_2_facebook_likes")
    public void setActor2FacebookLikes(Long actor2FacebookLikes) {
        this.actor2FacebookLikes = actor2FacebookLikes;
    }

    @JsonProperty("imdb_score")
    public Double getImdbScore() {
        return imdbScore;
    }

    @JsonProperty("imdb_score")
    public void setImdbScore(Double imdbScore) {
        this.imdbScore = imdbScore;
    }

    @JsonProperty("aspect_ratio")
    public Double getAspectRatio() {
        return aspectRatio;
    }

    @JsonProperty("aspect_ratio")
    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @JsonProperty("movie_facebook_likes")
    public Long getMovieFacebookLikes() {
        return movieFacebookLikes;
    }

    @JsonProperty("movie_facebook_likes")
    public void setMovieFacebookLikes(Long movieFacebookLikes) {
        this.movieFacebookLikes = movieFacebookLikes;
    }

    @JsonProperty("genre1")
    public String getGenre1() {
        return genre1;
    }

    @JsonProperty("genre1")
    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    @JsonProperty("genre2")
    public String getGenre2() {
        return genre2;
    }

    @JsonProperty("genre2")
    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    @JsonProperty("genre3")
    public String getGenre3() {
        return genre3;
    }

    @JsonProperty("genre3")
    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    @JsonProperty("genre4")
    public String getGenre4() {
        return genre4;
    }

    @JsonProperty("genre4")
    public void setGenre4(String genre4) {
        this.genre4 = genre4;
    }

    @JsonProperty("genre5")
    public String getGenre5() {
        return genre5;
    }

    @JsonProperty("genre5")
    public void setGenre5(String genre5) {
        this.genre5 = genre5;
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

    @JsonProperty("realGender")
    private String realGender;
    @JsonProperty("likelyGender")
    private String likelyGender;
    @JsonProperty("genderScale")
    private double genderScale;

    
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
    
    @JsonProperty("rankingGendered")
    private double rankingGendered;
    
}
