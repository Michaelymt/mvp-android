package com.ymt.mvpapp.rest;

import com.ymt.mvpapp.entity.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MethodWs {

    @GET("categoria")
    @Headers("Content-Type:application/json")
    Call<List<Categoria>> listarTodasLasCategorias();
}
