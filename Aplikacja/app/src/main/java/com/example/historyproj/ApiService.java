package com.example.historyproj;

import java.util.List;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
// tutaj wywołuje czynność z linkiem, na razie jest get z people, tym sposobem dostaje dane dot. ludzi- juleczka
public interface ApiService {
    //tutaj pokazujeszs ludzików
    @GET("/people")
    Call<List<Person>> getData();
    // ttuaj wysyłasz ludzików
    @POST("/people")
    Call<Void> postPerson(@Body RequestBody requestBody);


}
