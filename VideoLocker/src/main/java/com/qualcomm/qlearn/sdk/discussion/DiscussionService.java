/**
 Copyright (c) 2015 Qualcomm Education, Inc.
 All rights reserved.


 Redistribution and use in source and binary forms, with or without modification, are permitted (subject to the limitations in the disclaimer below) provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

 * Neither the name of Qualcomm Education, Inc. nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

 NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 **/

package com.qualcomm.qlearn.sdk.discussion;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

class FlagBody {
    boolean abuseFlagged;
}

class VoteBody {
    boolean voted;
}

class FollowBody {
    boolean following;
}



public interface DiscussionService {

    @GET("/api/discussion/v1/course_topics/{courseId}")
    void getCourseTopics(@Path("courseId") String courseId, Callback<CourseTopics> callback);

    @GET("/api/discussion/v1/threads/")
    void getThreadList(@Query("course_id") String courseId, @Query("topic_id") String topicId, @Query("view") String view, @Query("order_by") String orderBy, Callback<TopicThreads> callback);

    @GET("/api/discussion/v1/threads/")
    void searchThreadList(@Query("course_id") String courseId, @Query("text_search") String text, Callback<TopicThreads> callback);

    @GET("/api/discussion/v1/comments/")
    void getCommentList(@Query("thread_id") String threadId, Callback<ThreadComments> callback);

    @PATCH("/api/discussion/v1/threads/{threadId}/")
    void flagThread(@Path("threadId") String threadId, @Body FlagBody flagBody, Callback<DiscussionThread> callback);

    @PATCH("/api/discussion/v1/comments/{commentId}/")
    void flagComment(@Path("commentId") String commentId, @Body FlagBody flagBody, Callback<DiscussionComment> callback);

    @PATCH("/api/discussion/v1/threads/{threadId}/")
    void voteThread(@Path("threadId") String threadId, @Body VoteBody voteBody, Callback<DiscussionThread> callback);

    @PATCH("/api/discussion/v1/comments/{commentId}/")
    void voteComment(@Path("commentId") String commentId, @Body VoteBody voteBody, Callback<DiscussionComment> callback);

    @PATCH("/api/discussion/v1/threads/{threadId}/")
    void followThread(@Path("threadId") String threadId, @Body FollowBody followBody, Callback<DiscussionThread> callback);

    @POST("/api/discussion/v1/threads/")
    void createThread(@Body ThreadBody threadBody, Callback<DiscussionThread> callback);

    @POST("/api/discussion/v1/comments/")
    void createResponse(@Body ResponseBody responseBody, Callback<DiscussionComment> callback);

    @POST("/api/discussion/v1/comments/")
    void createComment(@Body CommentBody commentBody, Callback<DiscussionComment> callback);
}
