package com.alorma.github.sdk.services.notifications;

import com.alorma.github.sdk.bean.dto.request.LastDate;
import com.alorma.github.sdk.bean.dto.response.Notification;

import java.util.List;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PATCH;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Bernat on 18/02/2015.
 */
public interface NotificationsService {
	
	@GET("/notifications")
	void getNotifications(Callback<List<Notification>> notifications);

	@GET("/notifications")
	List<Notification> getNotifications();

	@GET("/notifications")
	void getNotifications(@Query("since") String since, Callback<List<Notification>> notifications);

	@GET("/notifications")
	List<Notification> getNotifications(@Query("since") String since);
	
	@PUT("/repos/{owner}/{repo}/notifications")
	void markAsReadRepo(@Path("owner") String owner, @Path("repo") String repo, @Body LastDate body, Callback<Response> responseCallback);
	
	@PATCH("/notifications/threads/{id}")
	void markThreadAsRead(@Path("id") String id, Callback<Response> callback);

	@PUT("/notifications/threads/{id}/subscription")
	void subscribeThread(@Path("id") String id, @Query("subscribed") boolean subscribed, @Query("ignored") boolean ignored, Callback<Response> callback);

	@PATCH("/notifications/threads/{id}/subscription")
	void unsubscribeThread(@Path("id") String id, Callback<Response> callback);
}
