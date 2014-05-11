
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
