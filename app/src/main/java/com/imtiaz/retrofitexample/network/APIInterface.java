package com.imtiaz.retrofitexample.network;

import com.imtiaz.retrofitexample.helper.AllUrl;
import com.imtiaz.retrofitexample.model.UserDeleteModel;
import com.imtiaz.retrofitexample.model.UserSearchModel;
import com.imtiaz.retrofitexample.model.UserListModel;
import com.imtiaz.retrofitexample.model.UserModel;
import com.imtiaz.retrofitexample.model.UserUpdateModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {


    // POST
    // Must have body
    @POST(AllUrl.SIGN_UP)
    Call<UserModel> signUp(
            @Header(AllUrl.CONTENT_TYPE) String he_clint,
            @Header(AllUrl.ACCEPT) String he_token,
            @Body HashMap<String, String> user);


    // GET
    @GET(AllUrl.USER_LIST)
    Call<UserListModel> getUserList(
            @Header(AllUrl.CONTENT_TYPE) String he_clint,
            @Header(AllUrl.ACCEPT) String he_token);


    // PUT
    @PUT(AllUrl.UPDATE_USER)
    Call<UserUpdateModel> updateUser(
            @Header(AllUrl.CONTENT_TYPE) String he_clint,
            @Header(AllUrl.ACCEPT) String he_token,
            @Body HashMap<String, Object> map,
            @Path("user_id") int user_id);


    // QUERY
    @GET(AllUrl.SEARCH_USER)
    Call<UserSearchModel> keyword(
            @Header(AllUrl.CONTENT_TYPE) String he_clint,
            @Header(AllUrl.ACCEPT) String he_token,
            @Query("keyword") String keyword);


    // DELETE
    @DELETE(AllUrl.DELETE_USER)
    Call<UserDeleteModel> deleteUser(
            @Header(AllUrl.CONTENT_TYPE) String he_clint,
            @Header(AllUrl.ACCEPT) String he_token,
            @Path("user_id") int user_id);
}
