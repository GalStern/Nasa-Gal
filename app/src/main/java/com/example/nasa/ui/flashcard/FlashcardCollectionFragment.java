package com.example.nasa.ui.flashcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nasa.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FlashcardCollectionFragment extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flashcard_collection, container, false);
        recyclerView = view.findViewById(R.id.flashcard_rv);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        final FlashcardCollectionAdapter flashcardCollectionAdapter = new FlashcardCollectionAdapter();
        recyclerView.setAdapter(flashcardCollectionAdapter);

        final RequestQueue requestQueue =  Volley.newRequestQueue(getActivity());
        String url = "https://api.le-systeme-solaire.net/rest/bodies?data=englishName,isPlanet,density,gravity,discoveredBy,discoveryDate";


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SolarSystem solarSystem = gson.fromJson(response, SolarSystem.class);
                List<Bodies> solarSBodies = solarSystem.getBodies();
                // I save my results to the database so I can retrieve it later in my other activities.
                Database db = Database.getInstance(getContext());
                // Keep in mind that this insertAll query will be blocking the main thread, so the
                // program will be stuck at this line of code until the query finishes.
                db.ssBodiesDao().insertAll(solarSBodies);

                // After inserting, I want to get what's in the database now.
                List<Bodies> listBooksFromDatabase = db.ssBodiesDao().getAll();

                // Convert list to arraylist
                ArrayList<Bodies> bodiesFromDatabase = new ArrayList<Bodies>(listBooksFromDatabase);

                flashcardCollectionAdapter.setData(bodiesFromDatabase);
                flashcardCollectionAdapter.notifyDataSetChanged();
                requestQueue.stop();
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Failed");
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);
        requestQueue.add(stringRequest);
        return view;

    }

}
