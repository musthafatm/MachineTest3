package com.whirlwind.iroid.machinetest3;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.whirlwind.iroid.machinetest3.adapter.JsoncyclerAdapter;
import com.whirlwind.iroid.machinetest3.model.JsoncyclerFeeder;
import com.whirlwind.iroid.machinetest3.model.Result;
import com.whirlwind.iroid.machinetest3.model.SomeInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewExample";
    private List<JsoncyclerFeeder> feedsList;
    private RecyclerView mRecyclerView;
    private JsoncyclerAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        String url = "http://iroidtech.com/test/details.php";
        new ThreetierTask().execute(url);
    }


    public class ThreetierTask extends AsyncTask<String, Void, SomeInfo> {

        private SomeInfo someInfo;

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected SomeInfo doInBackground(String... params) {
            Integer result = 0;
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    someInfo = parseResult(response.toString());
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                }
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return someInfo; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(SomeInfo result) {
            progressBar.setVisibility(View.GONE);

            if (result !=null) {
                adapter = new JsoncyclerAdapter(MainActivity.this, result.getResult());
                mRecyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(MainActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        }
    }





    private SomeInfo parseResult(String result) {

        Gson gson = new Gson();

        SomeInfo someInfo = gson.fromJson(result, SomeInfo.class);


//        SomeInfo someInfo = null;
//
//        try {
//
//             someInfo = new SomeInfo();
//            JSONObject mainObject = new JSONObject(result);
//
//            someInfo.setStatus(mainObject.has("status") ? mainObject.getString("status") : "");
//
//            JSONArray jsonArray = mainObject.getJSONArray("result");
//
//
//            Result resultArray [] = new Result[jsonArray.length()];
//
//
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//
//                Result resultObject = new Result();
//
//
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                resultObject.setTitle(jsonObject.getString("title"));
//                resultObject.setDescription(jsonObject.getString("description"));
//
//                JSONArray imageArray = jsonObject.getJSONArray("image_url");
//
//                String image[] = new String[imageArray.length()];
//
//                for (int i1 = 0; i1 < imageArray.length(); i1++) {
//                    image[i1] = (String) imageArray.get(i1);
//                }
//
//                resultObject.setImage_url(image);
//
//                resultArray[i] = resultObject;
//
//
//            }
//
//            someInfo.setResult(resultArray);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//////////////////////// MUSTHAFA
//        try {
//            JSONObject response = new JSONObject(result);
//            JSONArray posts = response.optJSONArray("posts");
//            feedsList = new ArrayList<>();
//
//            for (int i = 0; i < (posts.length() - 1); i++) {
//                JSONObject post = posts.optJSONObject(i);
//                JsoncyclerFeeder item = new JsoncyclerFeeder();
//                item.setTitle(post.optString("title"));
//                item.setDescription(post.optString("description"));
//
//                JSONObject images = post.getJSONObject("images");
//                item.setImg1(images.optString("img1"));
//                item.setImg2(images.optString("img2"));
//
//                feedsList.add(item);
//            }
//
//            int i = 3;
//            if (i == posts.length()) {
//                JSONObject post = posts.optJSONObject(i);
//                JsoncyclerFeeder item = new JsoncyclerFeeder();
//                item.setTitle(post.optString("title"));
//                item.setDescription(post.optString("description"));
//
//                JSONObject images = post.getJSONObject("images");
//                item.setImg1(images.optString("img1"));
//
//                feedsList.add(item);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        return someInfo;
    }


}
