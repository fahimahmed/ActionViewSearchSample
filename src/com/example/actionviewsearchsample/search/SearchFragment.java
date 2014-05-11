/*
 * Copyright (C) 2013 Wolfram Rittmeyer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.actionviewsearchsample.search;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.actionviewsearchsample.R;


public class SearchFragment extends ListFragment {

   private String[] searchTerms = {"one", "two", "three"};
   private static final String KEY_QUERY = "query"; 

   @Override
   public void onViewCreated(View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      if (getArguments().containsKey(KEY_QUERY)) {
         String query = getArguments().getString(KEY_QUERY);
         doSearch(query);
      }
   }

   protected void doSearch(String queryStr) {
      List<String> results = new ArrayList<String>(); 
      for (int i = 0; i < searchTerms.length; i++) {
         if (searchTerms[i].contains(queryStr)) {
            results.add(searchTerms[i]);
         }         
      }
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, results);
      setListAdapter(adapter);
      setEmptyText(getString(R.string.nothing_found, queryStr));
   }

   @Override
   public void onListItemClick(ListView l, View v, int position, long id) {
      Intent detailsIntent = new Intent(getActivity(),
            SearchDetailsActivity.class);
      String selectedResult = (String)getListAdapter().getItem(position);
      detailsIntent.putExtra(SearchDetailsActivity.KEY_WORD, selectedResult);
      startActivity(detailsIntent);
   }

   public static SearchFragment newInstance(String query) {
      SearchFragment fragment = new SearchFragment();
      Bundle bundle = new Bundle();
      bundle.putString(KEY_QUERY, query);
      fragment.setArguments(bundle);
      return fragment;
   }
}
