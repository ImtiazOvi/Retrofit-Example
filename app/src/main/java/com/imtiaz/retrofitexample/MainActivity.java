package com.imtiaz.retrofitexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.imtiaz.retrofitexample.model.UserModel;
import com.imtiaz.retrofitexample.network.APIInterface;
import com.imtiaz.retrofitexample.network.ApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Fields ======================================================================================
    private Context mContext;
    @BindView(R.id.txt_hello)
    TextView txtHello;
    // =============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @OnClick(R.id.btn_ok)
    public void okClick() {
        // HashMap
        HashMap<String, String> paramsPost = new HashMap<>();

        String text = (String) txtHello.getText();

        // Put value into HashMap
        paramsPost.put("text", text);

        // POST method call
        //Passing HashMap params into web request
        webRequest(paramsPost);
        // GET method call
//        webRequest(paramsGet);

        //PUT method call
//        webRequest(paramsPut);

        // DELETE method call
//        webRequest(paramsDelete);

        // Query method call
//        webRequest(paramsQuery);
    }

    // Web request call
    public void webRequest(final HashMap<String, String> map) {
        APIInterface apiInterface = ApiClient.getClient().create(APIInterface.class);
        Call<UserModel> modelCall = apiInterface.signUp(
                mContext.getString(R.string.value_content),
                mContext.getString(R.string.value_accept),
                map);
        modelCall.enqueue(new Callback<UserModel>() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                // Logcat show response code
                // Log.d("responseCode","is :- "+response.code());

                if (response.isSuccessful()) {
                    // Getting model response
                    UserModel model = response.body();

                    // Toast
                    Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO :: Error handling following response
                    Toast.makeText(mContext, "Email or Mobile is already registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                // TODO :: Failure action do here
            }
        });
    }
}
