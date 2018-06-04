/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namsor.oss.namsoralgolia;

import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.Index;
import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.iterators.IndexIterable;
import com.algolia.search.objects.Query;
import com.namsor.ApiException;
import com.namsor.api.GenderApi;
import com.namsor.api.ParseApi;
import com.namsor.model.OutputNameForGender;
import com.namsor.model.OutputParsedName;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This example builds on top of IMDB5000 film database, allowing to search
 * film directors and movies based on their name and ranking. We use NamSor API to infer the likely
 * gender of the movie director (if that gender is not already indexed in
 * 'realGender'). That allows the search to use a genderized ranking method, for
 * example to return female film directors first.
 *
 * @author NamSor SAS
 */
public class AlgoliaAPIClient_MovieDirectors {

    private final String NamSorAPI_xChannelSecret;
    private final String NamSorAPI_xChannelUser;
    private final String AlgoliaAPI_applicationID;
    private final String AlgoliaAPI_adminAPIKey;

    /**
     * Create both NamSor and Algolia API clients
     * @param NamSorAPI_xChannelSecret
     * @param NamSorAPI_xChannelUser
     * @param AlgoliaAPI_applicationID
     * @param AlgoliaAPI_adminAPIKey 
     */
    public AlgoliaAPIClient_MovieDirectors(String NamSorAPI_xChannelSecret, String NamSorAPI_xChannelUser, String AlgoliaAPI_applicationID, String AlgoliaAPI_adminAPIKey) {
        this.NamSorAPI_xChannelSecret = NamSorAPI_xChannelSecret;
        this.NamSorAPI_xChannelUser = NamSorAPI_xChannelUser;
        this.AlgoliaAPI_applicationID = AlgoliaAPI_applicationID;
        this.AlgoliaAPI_adminAPIKey = AlgoliaAPI_adminAPIKey;
    }

    /**
     * Genderize all Actor into Actors/Actresses using personal names (except those with a realGender attribute)
     * @throws AlgoliaException 
     */
    public void run() throws AlgoliaException {

        // create AL
        APIClient algoliaAPI = new ApacheAPIClientBuilder(AlgoliaAPI_applicationID, AlgoliaAPI_adminAPIKey).build();

        ParseApi namsorParseAPI = new ParseApi();
        GenderApi namsorGenderAPI = new GenderApi();

        Index<Movie> index = algoliaAPI.initIndex("film_directors", Movie.class);

        IndexIterable<Movie> iterable = index.browse(
                new Query()
        );
        int i = 0;
        for (Movie movie : iterable) {
            
            /*if( movie.getLikelyGender() != null || movie.getDirectorName() == null || movie.getDirectorName().trim().isEmpty()) {
                Logger.getLogger(getClass().getName()).info("Skip : "+movie.getDirectorName()+" - "+movie.getMovieTitle());
                continue;
            }*/
            i++;
            if(i<573) {
                continue;
            }
            Logger.getLogger(getClass().getName()).info("i="+i+" "+movie.getDirectorName()+" - "+movie.getMovieTitle());
            
            String fullName = movie.getDirectorName();
            try {
                OutputParsedName parsed = namsorParseAPI.parseName(fullName, NamSorAPI_xChannelSecret, NamSorAPI_xChannelUser);
                OutputNameForGender gendered = namsorGenderAPI.extractGender(parsed.getFirstName(), parsed.getLastName(), NamSorAPI_xChannelSecret, NamSorAPI_xChannelUser);
                long gross = 1;
                if(movie.getGross()!=null) {
                    gross = movie.getGross();
                }
                if (movie.getRealGender() != null && movie.getRealGender().equals(gendered.getGender())) {
                    // update based on real gender (not using name inferrence)
                    Logger.getLogger(getClass().getName()).info("Full name " + fullName + " using real gender (not using name inferrence)");
                    double genderScale = (movie.getRealGender().toLowerCase().startsWith("m") ? -1 : +1);
                    Movie movieUpdate = new Movie();
                    movieUpdate.setLikelyGender(movie.getRealGender());
                    movieUpdate.setGenderScale(genderScale);
                    movieUpdate.setRankingGendered(gross * genderScale);
                    index.partialUpdateObject(movie.getObjectID(), movieUpdate);
                } else {
                    // update inferred gender from NamSor API result
                    Logger.getLogger(getClass().getName()).info("Full name " + fullName + " parsed into " + parsed.getFirstName() + ", " + parsed.getLastName() + " inferred gender " + gendered.getGender());
                    Movie movieUpdate = new Movie();
                    movieUpdate.setLikelyGender(gendered.getGender());
                    movieUpdate.setGenderScale(gendered.getScale());
                    movieUpdate.setRankingGendered(gross * gendered.getScale());
                    index.partialUpdateObject(movie.getObjectID(), movieUpdate);
                }
            } catch (ApiException ex) {
                Logger.getLogger(AlgoliaAPIClient_MovieDirectors.class.getName()).log(Level.SEVERE, "Failed to parse " + fullName, ex);
            }
        }
    }

    public static final void main(String[] args) {
        try {
            // NamSor credentials
            String xChannelSecret = "<your xChannelSecret>";  // Your API Key (Secret)
            String xChannelUser = "<your xChannelUser>";  // Your API Channel (User)

            // Algolia credentials
            String applicationID="<your applicationID>"; // Your application ID
            String adminAPIKey="<your adminAPIKey>"; // your Admin API Key

            // Genderize all Actor into Actor/Actresses (except those with a realGender attribute)
            AlgoliaAPIClient_MovieDirectors main = new AlgoliaAPIClient_MovieDirectors(xChannelSecret,xChannelUser,applicationID, adminAPIKey );
            main.run();
        } catch (AlgoliaException ex) {
            Logger.getLogger(AlgoliaAPIClient_MovieDirectors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
