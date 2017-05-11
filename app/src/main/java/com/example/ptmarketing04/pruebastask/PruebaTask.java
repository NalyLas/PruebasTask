package com.example.ptmarketing04.pruebastask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;

/**
 * Created by ptmarketing04 on 11/05/2017.
 */

public class PruebaTask{


    static Context context;
    static Connection con;
    static JSONArray jsonArray;
    static String url = "";
    static String sql = "";



    public PruebaTask(Context context, Connection con, JSONArray jsonArray, String url, String sql) {
        this.context = context;
        this.con = con;
        this.jsonArray = jsonArray;
        this.url = url;
        this.sql = sql;
    }

    static class ListTask extends AsyncTask<String, String, JSONArray> {
        private ProgressDialog pDialog;
        public static String pas;

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Cargando....");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        final protected JSONArray doInBackground(String... args) {

            try {
                HashMap<String, String> parametrosPost = new HashMap<>();
                parametrosPost.put("ins_sql", sql);

                jsonArray = con.sendRequest(url, parametrosPost);

                if (jsonArray != null) {
                    return jsonArray;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(JSONArray json) {
            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }
            if (json != null) {

                Log.e("pruebas","ok");
                try {
                     pas = json.getJSONObject(5).getString("Titulo_lista");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Log.e("pruebas","no funsiona");
                pas = "NAdaaaaaaaaaaa";


            }
        }
    }

}


/*



 */