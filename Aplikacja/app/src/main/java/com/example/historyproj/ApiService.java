package com.example.historyproj;

import java.util.List;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

// tutaj wywołuje czynność z linkiem, na razie jest get z people, tym sposobem dostaje dane dot. ludzi- juleczka
public interface ApiService {
    //tutaj pokazujeszs ludzików
    @GET("/people")
    Call<List<Person>> getData();
    @DELETE("/people/{id}")
    Call<Void> deletePerson(@Path("id") int personId);
    // ttuaj wysyłasz ludzików
    @POST("/people")
    Call<Void> postPerson(@Body RequestBody requestBody);


}
