package com.example.historyproj;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
// tutaj wywołuje czynność z linkiem, na razie jest get z people, tym sposobem dostaje dane dot. ludzi- juleczka
public interface ApiService {
    @GET("/people")
    Call<List<Person>> getData();
}
