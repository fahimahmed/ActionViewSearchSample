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

import android.app.SearchManager;
import android.content.Intent;
import android.provider.SearchRecentSuggestions;

import com.example.actionviewsearchsample.R;

public class SampleSearchActivity extends BaseSearchActivity {

	protected void handleIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);

			SearchRecentSuggestions suggestions = 
				new SearchRecentSuggestions(this, SampleRecentSuggestionsProvider.AUTHORITY, SampleRecentSuggestionsProvider.MODE);
			suggestions.saveRecentQuery(query, null);
			
			SearchFragment fragment = SearchFragment.newInstance(query);
			getSupportFragmentManager()
			      .beginTransaction()
			      .replace(R.id.demo_fragment_container, fragment)
			      .commit();
		}
	}    
}
