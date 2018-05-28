# About NamSor Algolia Connector
Algolia is a SaaS search engine for any business or website. You can easily create an account with a live demo : the sandbox will allow you to search actors names and ranking. 

This connector is an example of using NamSor API to enrich the Algolia search with gender information : break down your search by gender (actors, actresses). NamSor Gender API will be called to set a 'likelyGender' attribute to all actors (except those whose gender is manually defined in a 'realGender' attribute).

This information can then be used to create facets or customize the search ranking (for example, to display actresses first).

## Using the Connector

1. Create an account on algolia.com with a demo application and obtain an API Key
2. Create an account on namsor.com and obtain an API Key
3. Update AlgoliaAPIClient.java with the API Key and run it with AlgoliaAPIClient main = new AlgoliaAPIClient(xChannelSecret,xChannelUser,applicationID, adminAPIKey); main.run();
4. Customize your search ranking, create facets etc. in Algolia

