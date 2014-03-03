package edu.gac.mcs270.hvidsten.guslist.client;

import java.util.List;

import edu.gac.mcs270.hvidsten.guslist.shared.PostData;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GusList implements EntryPoint {
	private final GusListView glView = new GusListView();
	private final PostDataServiceAsync postDataService = GWT
			.create(PostDataService.class);

	public void onModuleLoad() {
	    // Wire controller to view
		//  Note: Model is on server side - can only
		//   communicate to Model through RPC calls
		//   Cannot wire it directly as a class attribute
		glView.setController(GusList.this);
		// Show welcome page
		glView.viewWelcomePage();
		//RootPanel rootPanel = RootPanel.get();
		//rootPanel.clear();
	}
	
	
	public GusListView getView() {
		return glView;
	}
	
	// TODO Make this actually post
	public void postAdToServer() {
		System.out.println("Message passed");
	}
	public void postAdToServer(PostData data) {
		System.out.println("Message succesfully passed");
		
	}
	
	public void viewAdDataFromServer(){
		System.out.println("got here- control - pre servlet");
		postDataService.getPostDataFromServer(
				new AsyncCallback<List<PostData>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<PostData> data) {
						glView.viewPostData(data);
					}
				});
	}
}
