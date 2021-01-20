package com.example.retrofitput_patch;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface apis {
    //Put URL
    //https://httpbin.org/put
    @PUT("put")
    //Update The Whole Data
    Call<PutModal> userUpdaete(@Body PutModal putModal);

    //Patch update the selected data
    //https://httpbin.org/patch
    @PATCH("patch")
    Call<PutModal> userDataPatch(@Body PutModal putModal);
}
