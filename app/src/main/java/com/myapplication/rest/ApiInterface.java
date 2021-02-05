package com.myapplication.rest;

import com.myapplication.model.ChecklistItemRequestDto;
import com.myapplication.model.ChecklistRequestDto;
import com.myapplication.model.LoginRequestDto;
import com.myapplication.model.UserAccountRequestDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/register")
    Call<UserAccountRequestDto> register(@Field("email") String email,
                                         @Field("username") String username,
                                         @Field("password") String password);

    @FormUrlEncoded
    @POST("/login")
    Call<LoginRequestDto> login(@Field("username") String username,
                                @Field("password") String password);

    @DELETE("/checklist/{id}")
    Call<ChecklistItemRequestDto> delete(@Path("id") int id);

    @FormUrlEncoded
    @POST("/checklist")
    Call<ChecklistRequestDto> save(@Field("name") String name);

    @GET("/checklist")
    Call<ChecklistRequestDto> getAll();

    @FormUrlEncoded
    @POST("/item")
    Call<ChecklistItemRequestDto> save(@Field("checklistsId") int id,
                                       @Field("itemName") String name);

    @GET("/item/{id}")
    Call<ChecklistItemRequestDto> getById(@Path("id") int id);

    @PUT("/item/{id}")
    Call<ChecklistItemRequestDto> updateItemStatus(@Path("id") int id);

    @PUT("item/rename/{id}")
    Call<ChecklistItemRequestDto> renameItem(@Path("id") int id);

    @DELETE("/item/{id}")
    Call<ChecklistItemRequestDto> deleteItem(@Path("id") int id);
}
