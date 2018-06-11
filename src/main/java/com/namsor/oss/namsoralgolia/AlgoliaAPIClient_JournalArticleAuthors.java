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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This example built for Reporter d'Espoirs hackathon on Impact Journalism
 *
 * @author NamSor SAS
 */
public class AlgoliaAPIClient_JournalArticleAuthors {

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
    public AlgoliaAPIClient_JournalArticleAuthors(String NamSorAPI_xChannelSecret, String NamSorAPI_xChannelUser, String AlgoliaAPI_applicationID, String AlgoliaAPI_adminAPIKey) {
        this.NamSorAPI_xChannelSecret = NamSorAPI_xChannelSecret;
        this.NamSorAPI_xChannelUser = NamSorAPI_xChannelUser;
        this.AlgoliaAPI_applicationID = AlgoliaAPI_applicationID;
        this.AlgoliaAPI_adminAPIKey = AlgoliaAPI_adminAPIKey;
    }

    private static final int MAX_LEN=1000;
    /**
     * Genderize all Actor into Actors/Actresses using personal names (except those with a realGender attribute)
     * @throws AlgoliaException 
     */
    public void run() throws AlgoliaException {

        // create AL
        APIClient algoliaAPI = new ApacheAPIClientBuilder(AlgoliaAPI_applicationID, AlgoliaAPI_adminAPIKey).build();

        Random r = new Random();
        
        ParseApi namsorParseAPI = new ParseApi();
        GenderApi namsorGenderAPI = new GenderApi();

        Index<JournalArticle> index = algoliaAPI.initIndex("reportersdespoirs", JournalArticle.class);

        IndexIterable<JournalArticle> iterable = index.browse(
                new Query()
        );
        int i = 0;
        for (JournalArticle movie : iterable) {            
            /*if( movie.getLikelyGender() != null || movie.getAuthor() == null || movie.getAuthor().trim().isEmpty()) {
                Logger.getLogger(getClass().getName()).info("Skip : "+movie.getAuthor()+" - "+movie.getJournalArticleTitle());
                continue;
            }*/
            i++;
            Logger.getLogger(getClass().getName()).info("i="+i+" "+movie.getAuthor()+" - "+movie.getTitle());
            
            String fullName = movie.getAuthor();
            try {
                OutputParsedName parsed = namsorParseAPI.parseName(fullName, NamSorAPI_xChannelSecret, NamSorAPI_xChannelUser);
                OutputNameForGender gendered = namsorGenderAPI.extractGender(parsed.getFirstName(), parsed.getLastName(), NamSorAPI_xChannelSecret, NamSorAPI_xChannelUser);
                // MOCKUP: should be the output of the bayes classifier probability
                double impactSolutionScore = r.nextDouble();
                if (movie.getRealGender() != null && movie.getRealGender().equals(gendered.getGender())) {
                    // update based on real gender (not using name inferrence)
                    Logger.getLogger(getClass().getName()).info("Full name " + fullName + " using real gender (not using name inferrence)");
                    double genderScale = (movie.getRealGender().toLowerCase().startsWith("m") ? -1 : +1);
                    JournalArticle movieUpdate = new JournalArticle();
                    movieUpdate.setLikelyGender(movie.getRealGender());
                    movieUpdate.setGenderScale(genderScale);
                    movieUpdate.setRankingGendered(impactSolutionScore * genderScale);                    
                // MOCKUP: should be the output of the bayes classifier probability
                    movieUpdate.setImpactJournalismScore(impactSolutionScore);
                    movieUpdate.setProblemRating(r.nextDouble());
                    movieUpdate.setSolutionRating(r.nextDouble());
                    if(movie.getContent().length()>MAX_LEN) {
                        movieUpdate.setContent(movie.getContent().substring(0,MAX_LEN));
                    }
                    index.partialUpdateObject(movie.getObjectID(), movieUpdate);
                } else {
                    // update inferred gender from NamSor API result
                    Logger.getLogger(getClass().getName()).info("Full name " + fullName + " parsed into " + parsed.getFirstName() + ", " + parsed.getLastName() + " inferred gender " + gendered.getGender());
                    JournalArticle movieUpdate = new JournalArticle();
                    movieUpdate.setLikelyGender(gendered.getGender());
                    movieUpdate.setGenderScale((double)gendered.getScale());
                    movieUpdate.setRankingGendered(impactSolutionScore * (double)gendered.getScale());
                // MOCKUP: should be the output of the bayes classifier probability
                    movieUpdate.setImpactJournalismScore(impactSolutionScore);
                    movieUpdate.setProblemRating(r.nextDouble());
                    movieUpdate.setSolutionRating(r.nextDouble());
                    if(movie.getContent().length()>MAX_LEN) {
                        movieUpdate.setContent(movie.getContent().substring(0,MAX_LEN));
                    }
                    index.partialUpdateObject(movie.getObjectID(), movieUpdate);
                }
            } catch (ApiException ex) {
                Logger.getLogger(AlgoliaAPIClient_JournalArticleAuthors.class.getName()).log(Level.SEVERE, "Failed to parse " + fullName, ex);
            }
        }
    }

    public static final void main(String[] args) {
        try {
            // NamSor credentials
            String xChannelSecret = "";  // Your API Key (Secret)
            String xChannelUser = "";  // Your API Channel (User)

            // Algolia credentials
            String applicationID=""; // Your application ID
            String adminAPIKey=""; // your Admin API Key

            // Genderize all Actor into Actor/Actresses (except those with a realGender attribute)
            AlgoliaAPIClient_JournalArticleAuthors main = new AlgoliaAPIClient_JournalArticleAuthors(xChannelSecret,xChannelUser,applicationID, adminAPIKey );
            main.run();
        } catch (AlgoliaException ex) {
            Logger.getLogger(AlgoliaAPIClient_JournalArticleAuthors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
