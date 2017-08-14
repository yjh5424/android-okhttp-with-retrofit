package yjh.test.android_okhttp_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Service service;
    private Button allFoodButton;
    private Button categoryFoodButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        allFoodButton = (Button) findViewById(R.id.allData);
        categoryFoodButton = (Button) findViewById(R.id.categoryData);
        service = HttpManager.getInstance();

        allFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFood(service);

            }
        });

        categoryFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //put category Num
                loadFoodCategory(service, 2);
            }
        });


    }


    public void loadFood(Service service) {

        Call<JsonArray> call = service.loadAllFood();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("Hello",t.getMessage());
            }
        });

    }

    public void loadFoodCategory(Service service,int num) {
        Call<JsonArray> call = service.loadFoodCategory(num);
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("Hello",t.getMessage());
            }
        });
    }

}
